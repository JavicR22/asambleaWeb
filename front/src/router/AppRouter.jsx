import {Route, Routes} from "react-router-dom"

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
            <Route path="/dashboard" element={<Dashboard/>}/>
            </Route>

        </Route>
    </Routes>
    </AuthProvider>
    </>
}

export default AppRouter
