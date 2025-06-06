import React from 'react';
import { Link } from 'react-router-dom';

const Sidebar = () => {
  return (
    <div className="bg-dark text-white p-3" style={{ width: '250px', minHeight: '100vh' }}>
      <h4 className="mb-4">Dashboard</h4>
      <ul className="nav flex-column">
        <li className="nav-item"><Link className="nav-link text-white" to="/">Home</Link></li>
        <li className="nav-item"><Link className="nav-link text-white" to="/form">Full Form</Link></li>
        <li className="nav-item"><Link className="nav-link text-white" to="/analytics">Analytics</Link></li>
        <li className="nav-item"><Link className="nav-link text-white" to="/products">Products</Link></li>
        <li className="nav-item"><Link className="nav-link text-white" to="/settings">Settings</Link></li>
      </ul>
    </div>
  );
};

export default Sidebar;