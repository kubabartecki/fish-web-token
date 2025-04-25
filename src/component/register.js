import { useState } from "react";
import "./register.css"

const Register = () => {
  const [message, setMessage] = useState("");

  const handleRegister = async (form) => {
    form.preventDefault();
    
    const login = form.target.login.value;
    const password = form.target.password.value;

    const response = await fetch("https://jsonplaceholder.typicode.com/", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ login, password }),
    });

    if (response.ok) {
      setMessage("Rejestracja zakończona sukcesem!");
    } else {
      setMessage("Błąd podczas rejestracji");
    }
    form.target.reset();
  };

  return (
    <div>
      <h2>Rejestracja</h2>
      <form className="register-elements" onSubmit={handleRegister}>
        <input type="login" placeholder="Login" name="login" required />
        <input
          type="password"
          placeholder="Password"
          name="password"
          required
        />
        <button type="submit">Zarejestruj</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default Register;