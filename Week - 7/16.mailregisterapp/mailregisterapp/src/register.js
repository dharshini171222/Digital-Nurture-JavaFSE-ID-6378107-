import React, { useState } from 'react';

function Register() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState({});

  const validate = () => {
    const newErrors = {};

    if (name.length < 5) {
      newErrors.name = 'Name must be at least 5 characters';
    }

    if (!email.includes('@') || !email.includes('.')) {
      newErrors.email = 'Email must include "@" and "."';
    }

    if (password.length < 8) {
      newErrors.password = 'Password must be at least 8 characters';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert('Registration successful!');
      // Optionally reset form
      setName('');
      setEmail('');
      setPassword('');
      setErrors({});
    }
  };

  return (
    <div>
      <h2>Mail Registration Form</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Name:
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </label>
        <div style={{ color: 'red' }}>{errors.name}</div>

        <br /><br />

        <label>
          Email:
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </label>
        <div style={{ color: 'red' }}>{errors.email}</div>

        <br /><br />

        <label>
          Password:
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </label>
        <div style={{ color: 'red' }}>{errors.password}</div>

        <br /><br />

        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
