import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Signup from "./UserLogin/Signup.jsx";
import Signin from "./UserLogin/Signin.jsx";
import ForgotPassword from "./UserLogin/ForgotPassword.jsx";
import ResetPassword from "./UserLogin/ResetPassword.jsx";
import { useEffect, useState } from 'react'
import MenuList from './MenuList';
//import Categories from './Categories';
import Homepage from './Homepage';
import Cart from './Cart';
import Order from "./Order.jsx";
import UserAddress from "./UserAddress.jsx";

function App() {
  
  const[total,setTotal]= useState(0);
  const handleTotal = (data)=>
  {
    setTotal(data);
  }


  return (
    <div className='container'>
       <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/signin" />} /> 
        <Route path="/signup" element={<Signup />} />
        <Route path="/signin" element={<Signin />} />
        <Route path="/forgot" element={<ForgotPassword />} />
        <Route path="/reset-password/:userId" element={<ResetPassword />} />
        <Route path="/menu" element={<Homepage />} />
        <Route path="/cart" element={<Cart/>} />
         <Route path="/orders" element={<Order/>} />
         <Route path="/useraddress" element={<UserAddress></UserAddress>}/>
      </Routes>
    </Router>
    </div>
  )
}

export default App
