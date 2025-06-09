import { useState } from "react";
import "./login.css";

const Login = () => {
  const [message, setMessage] = useState("");

  const handleLogin = async (form) => {
    form.preventDefault();

    const username = form.target.username.value;
    const password = form.target.password.value;

    const response = await fetch(`${process.env.REACT_APP_API_URL}/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, password }),
      credentials: "include",
    });

    if (response.ok) {
      console.log(response);
      response.headers.forEach((value, key) => {
        console.log(key, value); // 'key' to nazwa nagłówka, 'value' to jego wartość
      });
      const authHeader = response.headers.get("Authorization");
      console.log(authHeader);
      const token =
        authHeader && authHeader.startsWith("Bearer ")
          ? authHeader.substring(7)
          : null;

      console.log(token);

      if (token) {
        localStorage.setItem("jwt", token);
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
        <input type="login" placeholder="Login" name="username" required />
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
