import { Link, Outlet, useLocation, useNavigate } from "react-router-dom"
import { useAuth } from "./context/AuthContext"

const NavBar = () => {

    const {state}=useLocation()
    const navigate = useNavigate()
    const {userInfo}= useAuth
    console.log(state);

    const onLogout = () => {
        navigate("/login",
        {replace: true,
        }
        );
    }

  return <>
  
  <header>
        <h1>
            <Link to ="/">Loguito</Link>
        </h1>
       
    

        {
            state?.logged ? (
            <div className="user">
            <span className="username">{state.username}</span>
            <button className="btn-logut" onClick={onLogout}>Cerrar Sesion</button>
            </div>
            ) : (
                <nav>
                <Link to="/login">Iniciar Sesión</Link>
                <span>{userInfo}</span>
                </nav>
            )
        }
        
  </header>
  <Outlet/>
  </>
}

export default NavBar
