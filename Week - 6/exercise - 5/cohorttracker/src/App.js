import React from 'react';
import CohortDetails from './CohortDetails';

const cohorts = [
  {
    name: "React Fundamentals",
    status: "ongoing",
    startDate: "22-July-2025",
    endDate: "31-July-2025",
    mentor: "Arun"
  },
  {
    name: "Java Basics",
    status: "completed",
    startDate: "11-Jun-2025",
    endDate: "20-Jun-2025",
    mentor: "Kiran"
  },
  {
    name: "SpringBoot Basics",
    status: "completed",
    startDate: "03-Jun-2025",
    endDate: "10-Jun-2025",
    mentor: "Sanjay"
  }
  
];

function App() {
  return (
    <div>
      <h2>Cohorts Dashboard</h2>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;

