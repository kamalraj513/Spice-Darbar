import React, { useEffect, useState} from 'react'
import './MenuList.css'  // Import CSS file


function MenuList({menuItems}) {

  return (
    <div className="menu-container">
      {menuItems.map((product) => (
        <div className="menu-card" key={product.id}>
          <img
            src={product.imgURL}
            alt={product.name}
            className="menu-card-img"
          />
          <div className="menu-card-body">
            <h3 className="menu-card-title">{product.name}</h3>
            <p className="menu-card-price">₹{product.price}</p>
          </div>
        </div>
      ))}
    </div>
  )
}

export default MenuList;
