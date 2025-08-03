import React, { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    // Generate a random reference number
    const referenceNumber = Math.floor(100000 + Math.random() * 900000);

    alert(`Complaint submitted!\nReference Number: ${referenceNumber}`);
    
    // Optionally reset form
    setEmployeeName('');
    setComplaint('');
  };

  return (
    <div>
      <h2>Raise a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Employee Name:
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            required
          />
        </label>
        <br /><br />
        <label>
          Complaint:
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            required
          />
        </label>
        <br /><br />
        <button type="submit">Submit Complaint</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
