import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Order.css";

function Order() {
  const [orders, setOrders] = useState([]);
  const user = JSON.parse(localStorage.getItem("user"));
  const userId = user?.id;
  const navigate = useNavigate();

  useEffect(() => {
    fetch(`http://localhost:8080/api/orders/${userId}`)
      .then((res) => res.json())
      .then((data) => setOrders(data))
      .catch((err) => console.error(err));
  }, [userId]);

  return (
    <div className="orders-container">
      <h2 className="orders-title">Your Royal Orders 👑</h2>
      {orders.length === 0 ? (
        <p className="no-orders">No orders yet. Start shopping!</p>
      ) : (
        orders.map((order) => (
          <div key={order.id} className="order-card">
            <h3 className="order-id">Order #{order.id}</h3>
            <p className="order-address">
              {order.address1}, {order.city}, {order.state} - {order.pincode}
            </p>
            <p className="order-payment">💳 Payment: {order.paymentMode}</p>
            <div className="order-items">
              <img
                src={order.menuItem.imgURL}
                alt={order.menuItem.name}
                className="order-img"
              />
              <p className="order-item">
                {order.menuItem.name} × {order.quantity}{" "}
                <span className="order-price">₹{order.price}</span>
              </p>
            </div>
          </div>
        ))
      )}
      <button className="back-btn" onClick={() => navigate("/menu")}>
        ⬅ Back to Menu
      </button>
    </div>
  );
}

export default Order;
