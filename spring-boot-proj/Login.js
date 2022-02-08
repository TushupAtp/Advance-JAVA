import logo from './logo.svg';
import './Login.css';
import { useEffect, useState } from "react";
import axios from 'axios';

function Login() {

    const [loginData, setLoginData] = useState({email : '', password : ''});
    const [loginResult, setLoginResult] = useState({});

  function login(e) {
    e.preventDefault();
    //alert(JSON.stringify(loginData));
    axios.post("http://localhost:8080/login", loginData).then((response) => {
        //alert(response.data);
        //alert(JSON.stringify(response.data));
       setLoginResult(response.data);
       if(response.data.status) {
           alert(response.data.message);
           sessionStorage.setItem('customerId' , response.data.customerId);
           sessionStorage.setItem('customerName' , response.data.customerName);
       }
    })  
  }

  function change(e) {
      let name = e.target.name;
      let val = e.target.value;
      setLoginData({ ...loginData, [name] : val});
  }

  return (
    <div>
        <h2>{loginResult.message}</h2>
        <form onSubmit={login}>
            Enter email : <input name="email" type="email" value={loginData.email} onChange={change} /> <br />
            Enter password : <input name="password" type="password" value={loginData.password} onChange={change} /> <br />
            <button type="submit">Login</button>
        </form>
    </div>
  );
}

export default Login;
