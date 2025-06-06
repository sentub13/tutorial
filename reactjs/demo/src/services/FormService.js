import axios from 'axios';

export const fetchCountries = async () => {
  const response = await axios.get('http://localhost:3001/countries');
  console.log('API Response:', response.data);
  // return response.data;
  return response.data.map(country => country.name).sort();
};
