import { useState } from "react";
import "./login.css"

const Login = () => {
    const [message, setMessage] = useState("");
  
    const handleLogin = async (form) => {
      form.preventDefault();
      
      const login = form.target.login.value;
      const password = form.target.password.value;
  
      const response = await fetch("https://jsonplaceholder.typicode.com/", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ login, password }),
      });
  
      if (response.ok) {
        const data = await response.json();
        const token = data.token;
        if (token){
            document.cookie = `jwt=${token};path=/;max-age=3600`;
        }
        setMessage("Zalogowano poprawnie!");
      } else {
        setMessage("Błąd podczas logowania");
      }
      form.target.reset();
    };


return (
    <div>
      <h2>Logowanie</h2>
      <form className="login-elements" onSubmit={handleLogin}>
        <input type="login" placeholder="Login" name="login" required />
        <input
          type="password"
          placeholder="Password"
          name="password"
          required
        />
        <button type="submit">Zaloguj</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default Login;