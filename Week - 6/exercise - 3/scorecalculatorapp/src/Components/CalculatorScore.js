import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculatorScore({ name, school, total, goal }) {
  const score = ((total / goal) * 100).toFixed(2);

  return (
    <section className="student-details">
      <h1>Student Details:</h1>
      <p><strong style={{ color: 'blue' }}>Name:</strong> <span style={{ color: 'blue' }}>{name}</span></p>
      <p><strong style={{ color: 'red' }}>School:</strong> <span style={{ color: 'red' }}>{school}</span></p>
      <p><strong style={{ color: 'purple' }}>Total:</strong> <span style={{ color: 'purple' }}>{total}Marks</span></p>
      <p><strong style={{ color: 'green' }}>Score:</strong> <span style={{ color: 'green' }}>{score}%</span></p>
    </section>
  );
}

export default CalculatorScore;
