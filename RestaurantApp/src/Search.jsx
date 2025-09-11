import React from 'react';
import './Search.css';

function Search({ onchange }) {
  return (
    <div className="search-container">
      <input
        type="text"
        className="search-input"
        placeholder="Search here"
        onChange={onchange}
      />
    </div>
  );
}

export default Search;
