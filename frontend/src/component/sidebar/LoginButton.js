import React from "react";
import LoginIcon from "@mui/icons-material/Login";
import "../../App.css";

function LoginButton() {
  return (
    <div className="LoginButton">
      <button
        className="login-btn"
        onClick={() => {
          window.location.pathname = "/login";
        }}
      >
        <div id="icon">
          <LoginIcon />
        </div>
        <div id="title">Login/Signup</div>
      </button>
    </div>
  );
}

export default LoginButton;
