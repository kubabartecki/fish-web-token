import React, { useState, useEffect } from "react";
import "./Aquariumlist.css";

function Aquariumlist() {
  const [aquariums, setAquariums] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [showAddAquarium, setShowAddAquarium] = useState(false);
  const [showAddFish, setShowAddFish] = useState(false);
  const [selectedAquarium, setSelectedAquarium] = useState(null);
  
  // Form states
  const [aquariumForm, setAquariumForm] = useState({
    name: "",
    volume: "",
    isFreshwater: true
  });
  
  const [fishForm, setFishForm] = useState({
    name: "",
    weight: "",
    speciesId: "",
    aquariumId: ""
  });
  
  const token = localStorage.getItem("jwt");

  const fetchAquariums = async () => {
    if (!token) return;
    
    setLoading(true);
    setError(null);
    
    try {
      const response = await fetch(`${process.env.REACT_APP_API_URL}/api/v1/aquariums`, {
        method: "GET",
        headers: { 
          "Authorization": `Bearer ${token}`,
          "Content-Type": "application/json"
        }
      });
      
      if (response.ok) {
        const data = await response.json();
        setAquariums(data);
        console.log("Aquariums fetched:", data);
      } else {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
    } catch (err) {
      setError(err.message);
      console.error("Error fetching aquariums:", err);
    } finally {
      setLoading(false);
    }
  };

  const addAquarium = async (e) => {
    e.preventDefault();
    
    if (!aquariumForm.name.trim() || !aquariumForm.volume) {
      setError("Please fill in all required fields");
      return;
    }
    
    setLoading(true);
    setError(null);
    
    try {
      const response = await fetch(`${process.env.REACT_APP_API_URL}/api/v1/aquariums`, {
        method: "POST",
        headers: {
          "Authorization": `Bearer ${token}`,
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          name: aquariumForm.name,
          volume: parseFloat(aquariumForm.volume),
          isFreshwater: aquariumForm.isFreshwater
        })
      });
      
      if (response.ok) {
        const newAquarium = await response.json();
        console.log("Aquarium added:", newAquarium);
        
        // Reset form and close modal
        setAquariumForm({ name: "", volume: "", isFreshwater: true });
        setShowAddAquarium(false);
        
        // Refresh the list
        fetchAquariums();
      } else {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
    } catch (err) {
      setError(err.message);
      console.error("Error adding aquarium:", err);
    } finally {
      setLoading(false);
    }
  };

  const addFish = async (e) => {
    e.preventDefault();
    
    if (!fishForm.name.trim() || !fishForm.weight || !fishForm.speciesId || !fishForm.aquariumId) {
      setError("Please fill in all required fields");
      return;
    }
    
    setLoading(true);
    setError(null);
    
    try {
      // Generate a temporary ID (in real app, this might be handled differently)
      const tempId = Date.now();
      
      const response = await fetch(`${process.env.REACT_APP_API_URL}/api/v1/fishes/${tempId}`, {
        method: "PUT",
        headers: {
          "Authorization": `Bearer ${token}`,
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          name: fishForm.name,
          weight: parseFloat(fishForm.weight),
          speciesId: parseInt(fishForm.speciesId),
          aquariumId: parseInt(fishForm.aquariumId)
        })
      });
      
      if (response.ok) {
        const result = await response.text();
        console.log("Fish added:", result);
        
        // Reset form and close modal
        setFishForm({ name: "", weight: "", speciesId: "", aquariumId: "" });
        setShowAddFish(false);
        setSelectedAquarium(null);
        
        // Optionally refresh aquariums if they contain fish data
        // fetchAquariums();
      } else {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
    } catch (err) {
      setError(err.message);
      console.error("Error adding fish:", err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchAquariums();
  }, [token]);

  return (
    <div className="aquariumlist-container">
      {token ? (
        <div>
          <div className="header-section">
            <h2>My Aquariums</h2>
            <div className="action-buttons">
              <button 
                className="btn-primary" 
                onClick={() => setShowAddAquarium(true)}
                disabled={loading}
              >
                Add Aquarium
              </button>
              <button 
                className="btn-secondary" 
                onClick={() => setShowAddFish(true)}
                disabled={loading || aquariums.length === 0}
              >
                Add Fish
              </button>
            </div>
          </div>
          
          {loading && <p>Loading...</p>}
          
          {error && (
            <div className="error-message">
              <p>Error: {error}</p>
              <button onClick={fetchAquariums}>Retry</button>
            </div>
          )}
          
          {!loading && !error && aquariums.length === 0 && (
            <p>No aquariums found. Create your first aquarium!</p>
          )}
          
          {!loading && !error && aquariums.length > 0 && (
            <div className="aquariums-grid">
              {aquariums.map((aquarium) => (
                <div key={aquarium.id} className="aquarium-card">
                  <h3>{aquarium.name}</h3>
                  <p>ID: {aquarium.id}</p>
                </div>
              ))}
            </div>
          )}

          {/* Add Aquarium Modal */}
          {showAddAquarium && (
            <div className="modal-overlay">
              <div className="modal-content">
                <h3>Add New Aquarium</h3>
                <form onSubmit={addAquarium}>
                  <div className="form-group">
                    <label htmlFor="aquarium-name">Name *</label>
                    <input
                      id="aquarium-name"
                      type="text"
                      value={aquariumForm.name}
                      onChange={(e) => setAquariumForm({...aquariumForm, name: e.target.value})}
                      placeholder="Enter aquarium name"
                      required
                    />
                  </div>
                  
                  <div className="form-group">
                    <label htmlFor="aquarium-volume">Volume (L) *</label>
                    <input
                      id="aquarium-volume"
                      type="number"
                      min="0.1"
                      step="0.1"
                      value={aquariumForm.volume}
                      onChange={(e) => setAquariumForm({...aquariumForm, volume: e.target.value})}
                      placeholder="Enter volume in liters"
                      required
                    />
                  </div>
                  
                  <div className="form-group">
                    <label className="checkbox-label">
                      <input
                        type="checkbox"
                        checked={aquariumForm.isFreshwater}
                        onChange={(e) => setAquariumForm({...aquariumForm, isFreshwater: e.target.checked})}
                      />
                      Freshwater
                    </label>
                  </div>
                  
                  <div className="modal-actions">
                    <button type="button" onClick={() => setShowAddAquarium(false)}>Cancel</button>
                    <button type="submit" disabled={loading}>
                      {loading ? 'Adding...' : 'Add Aquarium'}
                    </button>
                  </div>
                </form>
              </div>
            </div>
          )}

          {/* Add Fish Modal */}
          {showAddFish && (
            <div className="modal-overlay">
              <div className="modal-content">
                <h3>Add New Fish</h3>
                <form onSubmit={addFish}>
                  <div className="form-group">
                    <label htmlFor="fish-name">Name *</label>
                    <input
                      id="fish-name"
                      type="text"
                      value={fishForm.name}
                      onChange={(e) => setFishForm({...fishForm, name: e.target.value})}
                      placeholder="Enter fish name"
                      required
                    />
                  </div>
                  
                  <div className="form-group">
                    <label htmlFor="fish-weight">Weight (kg) *</label>
                    <input
                      id="fish-weight"
                      type="number"
                      min="0.1"
                      step="0.1"
                      value={fishForm.weight}
                      onChange={(e) => setFishForm({...fishForm, weight: e.target.value})}
                      placeholder="Enter weight in kg"
                      required
                    />
                  </div>
                  
                  <div className="form-group">
                    <label htmlFor="fish-species">Species ID *</label>
                    <input
                      id="fish-species"
                      type="number"
                      min="0"
                      value={fishForm.speciesId}
                      onChange={(e) => setFishForm({...fishForm, speciesId: e.target.value})}
                      placeholder="Enter species ID"
                      required
                    />
                  </div>
                  
                  <div className="form-group">
                    <label htmlFor="fish-aquarium">Aquarium *</label>
                    <select
                      id="fish-aquarium"
                      value={fishForm.aquariumId}
                      onChange={(e) => setFishForm({...fishForm, aquariumId: e.target.value})}
                      required
                    >
                      <option value="">Select an aquarium</option>
                      {aquariums.map((aquarium) => (
                        <option key={aquarium.id} value={aquarium.id}>
                          {aquarium.name}
                        </option>
                      ))}
                    </select>
                  </div>
                  
                  <div className="modal-actions">
                    <button type="button" onClick={() => setShowAddFish(false)}>Cancel</button>
                    <button type="submit" disabled={loading}>
                      {loading ? 'Adding...' : 'Add Fish'}
                    </button>
                  </div>
                </form>
              </div>
            </div>
          )}
        </div>
      ) : (
        <p>Please log in first!</p>
      )}
    </div>
  );
}

export default Aquariumlist;