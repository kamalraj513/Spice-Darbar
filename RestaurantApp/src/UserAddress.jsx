import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./UserAddress.css";

function UserAddress() {
  const [formData, setFormData] = useState({
    address1: "",
    address2: "",
    city: "",
    state: "",
    pincode: "",
    paymentMode: "Cash on Delivery",
  });

  const user = JSON.parse(localStorage.getItem("user"));
  const userId = user?.id;
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await fetch(`http://localhost:8080/api/orders/${userId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      });

      if (res.ok) {
        const saved = await res.json();
        console.log("Order saved:", saved);
        alert("Order placed successfully ✅");
        navigate("/orders"); // go to order page
      } else {
        alert("Failed to place order ❌");
      }
    } catch (err) {
      console.error(err);
      alert("Something went wrong!");
    }
  };

  return (
    <div className="address-container">
      <h1 className="address-title">Delivery Details</h1>
      <form className="address-form" onSubmit={handleSubmit}>
        <input
          type="text"
          name="address1"
          placeholder="Address Line 1"
          value={formData.address1}
          onChange={handleChange}
          className="form-input"
          required
        />
        <input
          type="text"
          name="address2"
          placeholder="Address Line 2"
          value={formData.address2}
          onChange={handleChange}
          className="form-input"
        />
        <input
          type="text"
          name="city"
          placeholder="City"
          value={formData.city}
          onChange={handleChange}
          className="form-input"
          required
        />
        <input
          type="text"
          name="state"
          placeholder="State"
          value={formData.state}
          onChange={handleChange}
          className="form-input"
          required
        />
        <input
          type="text"
          name="pincode"
          placeholder="Pin code"
          value={formData.pincode}
          onChange={handleChange}
          className="form-input"
          required
        />

        <div className="payment-section">
          <label className="payment-label">Mode of Payment:</label>
          <select
            name="paymentMode"
            value={formData.paymentMode}
            onChange={handleChange}
            className="form-select"
          >
            <option>Cash on Delivery</option>
            <option>PhonePe</option>
            <option>Google Pay</option>
          </select>
        </div>

        <button type="submit" className="order-btn">
          Place Order
        </button>
      </form>
    </div>
  );
}

export default UserAddress;
