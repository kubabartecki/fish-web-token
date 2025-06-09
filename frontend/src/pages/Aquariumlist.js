import React from "react";
import "./Aquariumlist.css";

function Aquariumlist(){
    const token = localStorage.getItem("jwt");

    return(
        <div className="aquariumlist-container">
            {token? (
                <p>Work in progress</p> //TODO make request and subpage for aquariumlist
            ):(
                <p>Please log in first!</p>
            )
            
}</div>
)}

export default Aquariumlist;
