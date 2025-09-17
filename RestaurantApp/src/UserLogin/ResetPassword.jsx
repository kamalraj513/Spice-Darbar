import React, { useState } from "react";
import { useParams, useNavigate, Link } from "react-router-dom";
import "./ResetPassword.css"; // adjust path according to your folder

function ResetPassword() {
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const { userId } = useParams();
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
      alert("Passwords do not match");
      return;
    }

    try {
      const response = await fetch(`http://localhost:8080/api/reset-password/${userId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ password }),
      });

      const data = await response.json();
      alert(data.message);

      if (response.ok) {
        navigate("/signin"); // redirect to login after reset
      }
    } catch (err) {
      console.error(err);
      alert("Something went wrong!");
    }
  };

  return (
    <div className="auth-container">
      <h2 className="auth-title">Reset Password</h2>
      <form className="auth-form" onSubmit={handleSubmit}>
        <input
          type="password"
          placeholder="New Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="auth-input"
          required
        />
        <input
          type="password"
          placeholder="Confirm Password"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
          className="auth-input"
          required
        />
        <button type="submit" className="auth-button">Reset Password</button>
      </form>

      <p className="auth-link">
        Remembered password? <Link to="/signin">Login</Link>
      </p>
      <p className="auth-link">
        Don't have an account? <Link to="/signup">Register</Link>
      </p>
    </div>
  );
}

export default ResetPassword;
