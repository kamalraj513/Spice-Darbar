import React from 'react';
import './MenuList.css';  // Import CSS file
import AddCart from './AddCart';

function MenuList({ menuItems, userId, onCartUpdate }) {
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

            {/* AddCart button with quantity */}
            <AddCart
              product={product}
              userId={userId}
              onCartUpdate={onCartUpdate} // callback from Homepage
            />
          </div>
        </div>
      ))}
    </div>
  );
}

export default MenuList;
