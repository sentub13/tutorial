import React, { useEffect, useState } from 'react';
import DashboardLayout from '../components/DashboardLayout';
import { fetchCountries } from '../services/FormService';

const FullFormPage = () => {
  const [formData, setFormData] = useState({
    name: '',
    password: '',
    email: '',
    age: '',
    dob: '',
    time: '',
    gender: '',
    hobbies: [],
    country: '',
    bio: '',
    profilePic: null,
    terms: false,
  });

  // const countries = ['USA', 'India', 'Germany', 'Australia'];
  const [countries, setCountries] = useState([]);

  const handleChange = (e) => {
    const { name, value, type, checked, files } = e.target;

    if (type === 'checkbox' && name === 'hobbies') {
      setFormData((prev) => {
        const updated = checked
          ? [...prev.hobbies, value]
          : prev.hobbies.filter((h) => h !== value);
        return { ...prev, hobbies: updated };
      });
    } else if (type === 'checkbox') {
      setFormData((prev) => ({ ...prev, [name]: checked }));
    } else if (type === 'file') {
      setFormData((prev) => ({ ...prev, [name]: files[0] }));
    } else {
      setFormData((prev) => ({ ...prev, [name]: value }));
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Submitted:', formData);
    alert('Form submitted. Check console for data.');
  };

  useEffect(()=> {
    console.log('Form Data:', formData);
    const loadCountries = async () => {
      try {
        const data = await fetchCountries();
        setCountries(data);
        console.log('Fetched Countries:', data);
      } catch (error) {
        console.error('Failed to fetch countries', error);
      }
    };
    loadCountries();

  }, [formData])
 

  return (
    <DashboardLayout>
    <h2>Full Form Overview</h2>
    <div className="container mt-2">
      <form onSubmit={handleSubmit}>

        <div className="mb-3">
          <label className="form-label">Name</label>
          <input type="text" className="form-control" name="name" value={formData.name} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Password</label>
          <input type="password" className="form-control" name="password" value={formData.password} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Email</label>
          <input type="email" className="form-control" name="email" value={formData.email} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Age</label>
          <input type="number" className="form-control" name="age" value={formData.age} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label className="form-label">Date of Birth</label>
          <input type="date" className="form-control" name="dob" value={formData.dob} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label className="form-label">Preferred Time</label>
          <input type="time" className="form-control" name="time" value={formData.time} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label className="form-label">Gender</label>
          <div>
            <div className="form-check form-check-inline">
              <input type="radio" className="form-check-input" name="gender" value="male" checked={formData.gender === 'male'} onChange={handleChange} />
              <label className="form-check-label">Male</label>
            </div>
            <div className="form-check form-check-inline">
              <input type="radio" className="form-check-input" name="gender" value="female" checked={formData.gender === 'female'} onChange={handleChange} />
              <label className="form-check-label">Female</label>
            </div>
          </div>
        </div>

        <div className="mb-3">
          <label className="form-label">Hobbies</label>
          <div className="form-check">
            <input className="form-check-input" type="checkbox" name="hobbies" value="reading" checked={formData.hobbies.includes('reading')} onChange={handleChange} />
            <label className="form-check-label">Reading</label>
          </div>
          <div className="form-check">
            <input className="form-check-input" type="checkbox" name="hobbies" value="sports" checked={formData.hobbies.includes('sports')} onChange={handleChange} />
            <label className="form-check-label">Sports</label>
          </div>
          <div className="form-check">
            <input className="form-check-input" type="checkbox" name="hobbies" value="music" checked={formData.hobbies.includes('music')} onChange={handleChange} />
            <label className="form-check-label">Music</label>
          </div>
        </div>

        <div className="mb-3">
          <label className="form-label">Country</label>
          <select className="form-select" name="country" value={formData.country} onChange={handleChange}>
            <option value="">Select a country</option>
            {countries.map((c) => (
              <option key={c} value={c}>{c}</option>
            ))}
          </select>
        </div>

        <div className="mb-3">
          <label className="form-label">Bio</label>
          <textarea className="form-control" name="bio" rows="3" value={formData.bio} onChange={handleChange} />
        </div>

        <div className="mb-3">
          <label className="form-label">Profile Picture</label>
          <input className="form-control" type="file" name="profilePic" onChange={handleChange} />
        </div>

        <div className="form-check form-switch mb-3">
          <input className="form-check-input" type="checkbox" name="terms" checked={formData.terms} onChange={handleChange} />
          <label className="form-check-label">Accept Terms & Conditions</label>
        </div>

        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
    </DashboardLayout>
  );
};

export default FullFormPage;
