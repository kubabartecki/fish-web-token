import React from "react";
import LogoutIcon from "@mui/icons-material/Logout";
import "../../App.css";

function LogOutButton() {
  return (
    <div className="LogOutButton">
      <button
        className="logout-btn"
        onClick={() => {
          localStorage.removeItem("jwt");
          alert("You have been logged out!");
          window.location.pathname = "/login";
        }}
      >
        <div id="icon">
          <LogoutIcon />
        </div>
        <div id="title">Logout</div>
      </button>
    </div>
  );
}

export default LogOutButton;
