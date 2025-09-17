import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "./Signup.css"; // Make sure your CSS path is correct

function Signup() {
  const [formData, setFormData] = useState({ username: "", email: "", password: "" });
  const [confirmPassword, setConfirmPassword] = useState("");
  const navigate = useNavigate();

  const handleChange = (e) => setFormData({ ...formData, [e.target.name]: e.target.value });
  const handlePassword = (e) => setConfirmPassword(e.target.value);

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (formData.password !== confirmPassword) {
      alert("Passwords do not match");
      return;
    }

    const res = await fetch("http://localhost:8080/api/signup", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    });
    const data = await res.json();

    if (data.message === "Signup successful") {
      navigate("/signin");
    } else {
      alert(data.message);
    }
  };

  return (
    <div className="auth-container">
      <h2 className="auth-title">Register</h2>
      <form className="auth-form" onSubmit={handleSubmit}>
        <input
          type="text"
          name="username"
          value={formData.username}
          onChange={handleChange}
          placeholder="Enter Name"
          className="auth-input"
          required
        />
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
        <input
          type="password"
          name="confirmpassword"
          value={confirmPassword}
          onChange={handlePassword}
          placeholder="Re-enter Password"
          className="auth-input"
          required
        />
        <button type="submit" className="auth-button">Register</button>
      </form>

      <p className="auth-link">
        Already have an account? <Link to="/signin">Login</Link>
      </p>
    </div>
  );
}

export default Signup;
