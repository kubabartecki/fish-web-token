import "./SignUpPage.css"
import Register from "../component/register"
import Login from "../component/login";

function SignUpPage(){
    const token = localStorage.getItem("jwt");
return(
    <div>
        {token ? (
            <p>You are logged in!</p>
        ) : (
            <div>
    <Register/>
    <Login/>
    </div>)}
    </div>
)
}

export default SignUpPage;