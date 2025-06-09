import React from "react";
import "./Warehouse.css"

function Warehouse() {
  const token = localStorage.getItem("jwt");

  return (
    <div className="warehouse-container">
      {token ? (
        <p>Work in progress! //TODO make request for warehouse data</p>
      ) : (
        <p>Please log in first</p>
      )}
    </div>
  );
}

export default Warehouse;