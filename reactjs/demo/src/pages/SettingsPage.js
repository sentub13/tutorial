import React from 'react';
import DashboardLayout from '../components/DashboardLayout';

const SettingsPage = () => {
  return (
    <DashboardLayout>
      <h2>SettingsPage Overview</h2>
      <div className="row">
        <div className="col-md-4 mb-4">
          <div className="card text-white bg-primary">
            <div className="card-body">
              <h5 className="card-title">Users</h5>
              <p className="card-text">1,234</p>
            </div>
          </div>
        </div>
        <div className="col-md-4 mb-4">
          <div className="card text-white bg-success">
            <div className="card-body">
              <h5 className="card-title">Revenue</h5>
              <p className="card-text">$12,345</p>
            </div>
          </div>
        </div>
        <div className="col-md-4 mb-4">
          <div className="card text-white bg-warning">
            <div className="card-body">
              <h5 className="card-title">Orders</h5>
              <p className="card-text">567</p>
            </div>
          </div>
        </div>
      </div>
    </DashboardLayout>
  );
};

export default SettingsPage;
