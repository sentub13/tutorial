import React from 'react';
import Sidebar from './Sidebar';
import TopNavbar from './TopNavbar';

const DashboardLayout = ({ children }) => {
  return (
    <div className="d-flex">
      <Sidebar />
      <div className="flex-grow-1">
        <TopNavbar />
        <div className="p-4">
          {children}
        </div>
      </div>
    </div>
  );
};

export default DashboardLayout;
