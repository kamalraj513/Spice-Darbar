import React, { useEffect, useState } from 'react';
import Categories from './Categories';
import MenuList from './MenuList';
import Search from './Search';
import './Homepage.css';

function Homepage() {
  const [menuItems, setMenuItems] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [search, setSearch] = useState("");

  // Fetch MenuItems and Categories
  useEffect(() => {
    // Fetch all menu items
    fetch('http://localhost:8080/api/MenuItems')
      .then(response => response.json())
      .then(data => {
        console.log("MenuItems fetched:", data);
        setMenuItems(data);
      })
      .catch(err => console.error("Error fetching menu items:", err));

    // Fetch categories
    fetch('http://localhost:8080/api/categories')
      .then(response => response.json())
      .then(data => {
        console.log("Categories fetched:", data);
        setCategories(data);
      })
      .catch(err => console.error("Error fetching categories:", err));
  }, []);

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

  // Debugging
  console.log("Selected Category:", selectedCategory);
  console.log("Search Term:", search);
  console.log("Filtered Products:", filteredProducts);

  return (
    <div style={{ padding: "20px" }}>
      <div className="top-controls">
        <Search onchange={handleOnChange} />
        <Categories categories={categories} onSelect={handleCategorySelect} />
      </div>

      {/* Menu List or Empty Message */}
      <div>
        {filteredProducts.length ? (
          <MenuList menuItems={filteredProducts} />
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
