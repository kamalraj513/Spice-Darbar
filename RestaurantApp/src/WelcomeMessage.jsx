import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import Logo from './assets/Logo.png';
import './WelcomeMessage.css';

function WelcomeMessage({ cartCount }) {
  const [name, setName] = useState("");

  useEffect(() => {
    const storedUser = localStorage.getItem("user");
    if (storedUser) {
      const userObj = JSON.parse(storedUser);
      setName(userObj.username || userObj.name); 
    }
  }, []);

  return (
    <div className="welcome-container">
      <div className="welcome-left">
        <div className="welcome-text">
          <h1>
            Hi {name ? name : "Guest"} 👋 <br />
            Ready to order your favorite dish?
          </h1>
        </div>
      </div>

      <div className="welcome-right">
        {/* Cart Icon */}
        <Link to="/cart" className="cart-link">
          🛒 Cart
        </Link>

        {/* Cart Icon */}
        <Link to="/orders" className="cart-link">
          🧾 Orders
        </Link>

        {/* Logo */}
        <div className="welcome-logo">
          <img src={Logo} alt="Spice Darbar Logo" />
        </div>
      </div>
    </div>
  );
}

export default WelcomeMessage;
