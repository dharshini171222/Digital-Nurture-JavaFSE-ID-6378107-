import React from 'react';
import './App.css';
import CalculatorScore from './Components/CalculatorScore';

function App() {
  return (
    <div className="App">
      <CalculatorScore 
        name="Dharshini"
        school="St.charles matric higher secondary school"
        total={484}
        goal={600}
      />
    </div>
  );
}

export default App;
