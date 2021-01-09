import React from "react";
import './styles.css';
import { ReactComponent as Logo } from "./logo.svg";

function Navbar() {
    return (
        <nav className="main-navbar">
            <Logo />
            <a href="#link" className="logo-text">DS Delivery</a>
        </nav>
    );
}

export default Navbar;