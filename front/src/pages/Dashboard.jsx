import { useAuth } from "../context/AuthContext"
import { useEffect } from 'react';

const Dashboard = () => {

  const {user,personInfo, userInfo} = useAuth()


  useEffect(() => {
    // Función para realizar la solicitud GET
    const fetchData = async () => {
      try {
        const token = localStorage.getItem('accessToken');
        // Realizar la solicitud GET
        const response = await fetch('http://localhost:8080/example',{
          method: "GET",
          headers: {
            "Authorization":`Bearer ${token}`,
            "username": `${user}`
          }
        });

        // Verificar si la respuesta es exitosa (código de estado HTTP 200)
        if (!response.ok) {
          throw new Error('Error al obtener los datos');
        }

        // Convertir la respuesta a texto
        const textData = await response.text();

        // Actualizar el estado con la cadena de caracteres obtenida
        personInfo(textData);
      } catch (error) {
        console.error('Error de solicitud:', error);
      }
    };
    if (user) {
      fetchData();
    }

    // Llamar a la función para realizar la solicitud GET cuando el componente se monta
    fetchData();
  }, [user,personInfo]);


  return (
    <div>
       Holiiii {userInfo} 
    </div>
  )
}

export default Dashboard
