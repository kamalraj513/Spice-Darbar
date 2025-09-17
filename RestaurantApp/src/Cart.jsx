import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom"; 
import './Cart.css';

function Cart() {
  const [cartItems, setCartItems] = useState([]);
  const user = JSON.parse(localStorage.getItem("user"));
  const userId = user?.id;
  const navigate = useNavigate();

  const fetchCart = () => {
    if (!userId) return;
    fetch(`http://localhost:8080/api/cart/${userId}`)
      .then(res => res.json())
      .then(data => setCartItems(data))
      .catch(err => console.log(err));
  };

  useEffect(() => {
    fetchCart();
  }, [userId]);

  const handleIncrement = async (menuItemId, currentQty) => {
    try {
      await fetch(`http://localhost:8080/api/cart/${userId}/add`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ menuItemId, quantity: currentQty + 1 }),
      });
      fetchCart();
    } catch (err) {
      console.log(err);
    }
  };

  const handleDecrement = async (menuItemId, currentQty) => {
    try {
      if (currentQty - 1 <= 0) {
        await fetch(`http://localhost:8080/api/cart/${userId}/remove/${menuItemId}`, {
          method: "DELETE",
        });
      } else {
        await fetch(`http://localhost:8080/api/cart/${userId}/add`, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ menuItemId, quantity: currentQty - 1 }),
        });
      }
      fetchCart();
    } catch (err) {
      console.log(err);
    }
  };

  const handleRemove = async (menuItemId) => {
    try {
      await fetch(`http://localhost:8080/api/cart/${userId}/remove/${menuItemId}`, {
        method: "DELETE",
      });
      fetchCart();
    } catch (err) {
      console.log(err);
    }
  };

  // Calculate total price
  const totalPrice = cartItems.reduce(
    (acc, item) => acc + item.menuItem.price * item.quantity,
    0
  );

  if (!cartItems.length) {
    return (
      <div className="cart-page">
        <h2>Your cart is empty 😢</h2>
        <div className="cart-actions">
          <button className="back-btn" onClick={() => navigate("/menu")}>
            Back to Home
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="cart-page">
      <h2>Items</h2>
      {cartItems.map(item => (
        <div key={item.menuItem.id} className="cart-card">
          <img src={item.menuItem.imgURL} alt={item.menuItem.name} width="100" />
          <div className="cart-info">
            <h4>{item.menuItem.name}</h4>
            <p>Price: ₹{item.menuItem.price}</p>
            <div className="cart-quantity-controls">
              <button onClick={() => handleDecrement(item.menuItem.id, item.quantity)}>-</button>
              <span>{item.quantity}</span>
              <button onClick={() => handleIncrement(item.menuItem.id, item.quantity)}>+</button>
            </div>
            <button onClick={() => handleRemove(item.menuItem.id)} className="remove-btn">
              Remove
            </button>
          </div>
        </div>
      ))}
      <h3>Total: ₹{totalPrice}</h3>

      {/* ✅ Action Buttons */}
      <div className="cart-actions">
        <button className="back-btn" onClick={() => navigate("/menu")}>
          Back to Home
        </button>
        <button className="buy-btn" onClick={() => navigate("/checkout")}>
          Proceed to Order
        </button>
      </div>
    </div>
  );
}

export default Cart;
