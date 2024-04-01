import { useNavigate } from "react-router-dom";
import { useForm } from "../hook/UseForm.js"
import { useState } from "react";
import { useAuth } from "../context/AuthContext.jsx";

const LoginPage = () => {

    const navigate = useNavigate();
    
    const {login} = useAuth()
    const {username, password,onInputChange, onResetForm} = 
    useForm({
        username: "",
        password: "",
    });
    const [token, setToken] = useState('');
    const onLogin = async (e) => {
        e.preventDefault();
        
        
        try {
          const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({username:username,
              password:password})
          });
    
          if (response.ok) {
            // El inicio de sesión fue exitoso
            
            const user = await response.json();
            login(user.Username);
            console.log(user.Username);
            console.log('Inicio de sesión exitoso');
           
           
          const data = user;
          const accessToken = data.token;

          setToken(accessToken);

          localStorage.setItem("accessToken", accessToken);
          navigate("/dashboard");
          
          
          } else {
            // El inicio de sesión falló
            console.error('Inicio de sesión fallido');
            onResetForm();
            // Manejar el error (por ejemplo, mostrar un mensaje de error)
          }
        } catch (error) {
          console.error('Error al enviar la solicitud:', error);
        }
        
    }
  return (
    <div className="wrapper">
      <form onSubmit={onLogin}>
        <h1>Iniciar Sesión</h1>
        <div className="input-group">
            <input type="text" 
            name="username"
            id="username"
            value={username}
            onChange={onInputChange}
            required
            autoComplete="off"/>
        
            <label htmlFor="userName">Nombre de Usuario: </label>
        </div>
        <div className="input-group">
            <input type="password" 
            name="password"
            id="password"
            value={password}
            onChange={onInputChange}
            required
            autoComplete="off"/>
      
            <label htmlFor="email">Contraseña: </label>
        </div>
        <button>Entrar</button>
      </form>
    </div>
  )
}

export default LoginPage
