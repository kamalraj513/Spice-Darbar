import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "./Signin.css"; // adjust path according to your folder

function Signin() {
  const [formData, setFormData] = useState({ email: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      });

      const data = await res.json();

      if (data.message === "Login successful") {
        localStorage.setItem("user", JSON.stringify(data.user));
        navigate("/menu"); // after login go to menu
      } else {
        alert(data.message);
      }
    } catch (err) {
      console.error("Error:", err);
      alert("Server error. Try again later.");
    }
  };

  return (
    <div className="auth-container">
      <h2 className="auth-title">Login</h2>
      <form className="auth-form" onSubmit={handleSubmit}>
        <input
          type="text"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Enter Email"
          className="auth-input"
          required
        />
        <input
          type="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          placeholder="Enter Password"
          className="auth-input"
          required
        />
        <button type="submit" className="auth-button">Login</button>
      </form>

      <p className="auth-link">
        Don’t have an account? <Link to="/signup">Register</Link>
      </p>
      <p className="auth-link">
        <Link to="/forgot">Forgot Password?</Link>
      </p>
    </div>
  );
}

export default Signin;
