import React from 'react';
import './Categories.css';

function Categories({ categories, onSelect }) {
  return (
    <div className="categories-container">
      <select
        className="categories-select"
        onChange={(e) => onSelect(e.target.value)}
      >
        <option value="">All categories</option>
        {categories.map(category => (
          <option key={category.id} value={category.id}>
            {category.name}
          </option>
        ))}
      </select>
    </div>
  );
}

export default Categories;
