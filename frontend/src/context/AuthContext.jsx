import { createContext, useContext, useState } from "react";

export const AuthContext = createContext()

export const useAuth = () => {
    const context = useContext(AuthContext);
    if(!context){
        throw new Error("useAuth must be used within an AuthProvider");
    }
    return context;
}

export const AuthProvider = ({children}) => {
    
    const [userInfo, setUserInfo] = useState(null);

    const [user, setUser] = useState(null)

    const [role, setRole] = useState(null)

    const authority = (userData) => {
        setRole(userData)
    }

    const login = (userData) => {
        setUser(userData);
        setIsAuthenticated(true);
    }

    const personInfo = (userData) => {
        setUserInfo(userData);
    }

    const logout = () => {
        setUser(null);
        setIsAuthenticated(false);
        setUserInfo(null);
    }

    

    const [isAuthenticated, setIsAuthenticated] = useState(false);
    return (
        <AuthContext.Provider value={{

            user,
            isAuthenticated,
            login,
            logout,
            userInfo,
            personInfo,
            setIsAuthenticated,
            authority,
            role

        }}>
            {children}
        </AuthContext.Provider>
    )

}