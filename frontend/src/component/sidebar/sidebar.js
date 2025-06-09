import React from "react";
import "../../App.css";
import { SidebarData } from "./sidebardata";
import LoginButton from "./LoginButton";
import LogOutButton from "./LogOutButton"

function Sidebar() {
    const token = localStorage.getItem("jwt");
  return (
    <div className="Sidebar">
      <ul className="SidebarList">
        {SidebarData.map((val, key) => {
          return (
            <li
              key={key}
              className="row"
              id={window.location.pathname === val.link ? "active" : ""}
              onClick={() => {
                window.location.pathname = val.link;
              }}
            >
              <div id="icon">{val.icon}</div> <div id="title">{val.title}</div>
            </li>
          );
        })}
      </ul>
      {token ? 
        <LogOutButton/> : 
        <LoginButton/>
      }
        </div>
  );
}

export default Sidebar;
