import Sidebar from "./component/sidebar/sidebar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import SignUpPage from "./pages/SignUpPage";

function App() {
  return (
  <Router>
      <div className="App" style={{ display: "flex" }}>
        <Sidebar />
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/login" element={<SignUpPage/>} />
          {//kolejne strony
          }
        </Routes>
      </div>
    </Router>
  );
}

export default App;
