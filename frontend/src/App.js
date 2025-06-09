import Sidebar from "./component/sidebar/sidebar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import SignUpPage from "./pages/SignUpPage";
import Warehouse from "./pages/Warehouse";
import Aquariumlist from "./pages/Aquariumlist";

function App() {
  return (
    <Router>
      <div
        className="App"
        style={{ display: "flex", backgroundColor: "#595959" }}
      >
        <Sidebar />
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/login" element={<SignUpPage />} />
          <Route path="/warehouse" element={<Warehouse />} />
          <Route path="/aquariumlist" element={<Aquariumlist />} />

        </Routes>
      </div>
    </Router>
  );
}

export default App;
