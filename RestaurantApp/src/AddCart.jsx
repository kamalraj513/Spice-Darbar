import React, { useState, useEffect } from "react";
import './AddCart.css'

function AddCart({ product, userId, onCartUpdate }) {
  const [quantity, setQuantity] = useState(0);
  const [showControls, setShowControls] = useState(false);

  // Fetch initial quantity from backend
  useEffect(() => {
    if (!userId) return;

    fetch(`http://localhost:8080/api/cart/${userId}`)
      .then(res => res.json())
      .then(data => {
        const item = data.find(i => i.menuItem.id === product.id);
        if (item) {
          setQuantity(item.quantity);
          setShowControls(item.quantity > 0);
        }
      })
      .catch(err => console.log(err));
  }, [product.id, userId]);

  // Add 1 to cart
  const handleIncrement = async () => {
    if (!userId) {
      alert("Please login first");
      return;
    }

    const newQuantity = quantity + 1;

    try {
      await fetch(`http://localhost:8080/api/cart/${userId}/add`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ menuItemId: product.id, quantity: newQuantity }),
      });

      setQuantity(newQuantity);
      setShowControls(true);

      if (onCartUpdate) onCartUpdate();
    } catch (err) {
      console.error(err);
      alert("Failed to update cart");
    }
  };

  // Decrease 1 from cart
  const handleDecrement = async () => {
    if (!userId) return;

    const newQuantity = quantity - 1;

    try {
      if (newQuantity <= 0) {
        // Remove item from cart
        await fetch(`http://localhost:8080/api/cart/${userId}/remove/${product.id}`, {
          method: "DELETE",
        });
        setQuantity(0);
        setShowControls(false);
      } else {
        // Update quantity
        await fetch(`http://localhost:8080/api/cart/${userId}/add`, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ menuItemId: product.id, quantity: newQuantity }),
        });
        setQuantity(newQuantity);
      }

      if (onCartUpdate) onCartUpdate();
    } catch (err) {
      console.error(err);
      alert("Failed to update cart");
    }
  };

  // Initial Add button click
  const handleAddClick = () => {
    handleIncrement();
  };

  return (
    <div className="add-cart-container">
      {!showControls ? (
        <button className="add-cart-btn" onClick={handleAddClick}>
          Add to Cart
        </button>
      ) : (
        <div className="quantity-controls">
          <button onClick={handleDecrement} className="quantity-btn">-</button>
          <span className="quantity-display">{quantity}</span>
          <button onClick={handleIncrement} className="quantity-btn">+</button>
        </div>
      )}
    </div>
  );
}

export default AddCart;
