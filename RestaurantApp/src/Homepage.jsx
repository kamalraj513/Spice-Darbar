import React, { useEffect, useState } from 'react';
import Categories from './Categories';
import MenuList from './MenuList';
import Search from './Search';
import './Homepage.css';
import WelcomeMessage from './WelcomeMessage';

function Homepage() {
  const [menuItems, setMenuItems] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [search, setSearch] = useState("");
  const [cartCount, setCartCount] = useState(0); // track cart items count

  const user = JSON.parse(localStorage.getItem("user")); // logged-in user
  const userId = user?.id;

  // Fetch MenuItems and Categories
  useEffect(() => {
    fetch('http://localhost:8080/api/MenuItems')
      .then(response => response.json())
      .then(data => setMenuItems(data))
      .catch(err => console.error("Error fetching menu items:", err));

    fetch('http://localhost:8080/api/categories')
      .then(response => response.json())
      .then(data => setCategories(data))
      .catch(err => console.error("Error fetching categories:", err));

    // Fetch initial cart count
    if (userId) {
      fetch(`http://localhost:8080/api/cart/${userId}`)
        .then(res => res.json())
        .then(data => setCartCount(data.length))
        .catch(err => console.log(err));
    }
  }, [userId]);

  // Callback when cart is updated
  const handleCartUpdate = () => {
    if (userId) {
      fetch(`http://localhost:8080/api/cart/${userId}`)
        .then(res => res.json())
        .then(data => setCartCount(data.length))
        .catch(err => console.log(err));
    }
  };

  // Handle category selection
  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  // Handle search input
  const handleOnChange = (event) => {
    setSearch(event.target.value);
  };

  // Filter menu items based on selected category and search
  const filteredProducts = menuItems.filter(menuItem => {
    const matchesCategory = selectedCategory ? menuItem.category?.id === selectedCategory : true;
    const matchesSearch = search
      ? menuItem.name.toLowerCase().includes(search.toLowerCase())
      : true;
    return matchesCategory && matchesSearch;
  });

  return (
    <div style={{ padding: "20px" }}>
      <WelcomeMessage/>
      <div className="top-controls">
        <Search onchange={handleOnChange} />
        <div className="cart-count">Cart Items: {cartCount}</div>
        <Categories categories={categories} onSelect={handleCategorySelect} />
        
      </div>

      {/* Menu List or Empty Message */}
      <div>
        {filteredProducts.length ? (
          <MenuList
            menuItems={filteredProducts}
            userId={userId}
            onCartUpdate={handleCartUpdate} // pass callback to MenuList
          />
        ) : (
          <div className="no-menu-message">
            <h2>Oops! No food items here 🍴</h2>
            <p>Looks like our chef is taking a short break. Please check back soon!</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default Homepage;
