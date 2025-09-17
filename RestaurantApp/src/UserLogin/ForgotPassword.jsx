import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "./ForgetPassword.css"; // adjust path according to your folder

function ForgotPassword() {
  const [email, setEmail] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch("http://localhost:8080/api/forgot-password", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email }),
      });

      const data = await response.json();
      alert(data.message);

      if (response.ok && data.userId) {
        navigate(`/reset-password/${data.userId}`); // navigate to reset page
      }
    } catch (err) {
      console.error(err);
      alert("Something went wrong!");
    }
  };

  return (
    <div className="auth-container">
      <h2 className="auth-title">Forgot Password</h2>
      <form className="auth-form" onSubmit={handleSubmit}>
        <input
          type="email"
          name="email"
          placeholder="Enter your registered email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          className="auth-input"
          required
        />
        <button type="submit" className="auth-button">Send Reset Link</button>
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

export default ForgotPassword;
