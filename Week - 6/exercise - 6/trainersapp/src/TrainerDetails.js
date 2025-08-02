import { useParams } from "react-router-dom";
import trainers from "./TrainersMock";

function TrainerDetails() {
  const { id } = useParams();
  const trainer = trainers.find(t => t.trainerId === id);

  return trainer ? (
    <div>
      <h2>{trainer.name}</h2>
      <p>Email: {trainer.email}</p>
      <p>Phone: {trainer.phone}</p>
      <p>Technology: {trainer.technology}</p>
      <p>Skills: {trainer.skills.join(", ")}</p>
    </div>
  ) : (
    <p>Trainer not found</p>
  );
}

export default TrainerDetails;
