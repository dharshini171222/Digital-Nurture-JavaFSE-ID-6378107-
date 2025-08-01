import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import TrainersList from "./TrainerList";
import TrainerDetails from "./TrainerDetails";
import trainers from "./TrainersMock";

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">Home</Link> | <Link to="/trainers">Trainers</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList trainers={trainers} />} />
        <Route path="/trainer/:id" element={<TrainerDetails />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
