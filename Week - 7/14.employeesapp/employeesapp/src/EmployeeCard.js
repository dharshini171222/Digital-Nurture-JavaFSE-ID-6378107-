// EmployeeCard.js
import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard() {
  const theme = useContext(ThemeContext); // 'light' or 'dark'

  return (
    <div className="employee-card">
      <button className={`btn-${theme}`}>View Profile</button>
    </div>
  );
}

export default EmployeeCard;


