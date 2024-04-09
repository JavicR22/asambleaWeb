import {Route, Routes} from "react-router-dom"
import DashboardUser from "../pages/DashboardUser"
import NavBar from "../NavBar"
import HomePage from "../pages/HomePage"
import LoginPage from "../pages/LoginPage"
import Dashboard from "../pages/Dashboard"
import { AuthProvider } from "../context/AuthContext"
import PrivateRouter from "./PrivateRouter"
const AppRouter = () => {
  return <>
  <AuthProvider>
  <Routes>
        <Route path="/" element={<NavBar/>}>
            <Route index element={<HomePage/>}/>
            <Route path="/login" element ={<LoginPage/>}/>
            <Route element={<PrivateRouter/>}>
            <Route path="/homeAdmin" element={<Dashboard/>}/>
            <Route path="/homeOwner" element={<DashboardUser/>}/>
            </Route>

        </Route>
    </Routes>
    </AuthProvider>
    </>
}

export default AppRouter
