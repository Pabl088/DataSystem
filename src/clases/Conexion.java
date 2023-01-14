package clases;

import java.sql.*;

public class Conexion {
    
    public static Connection conectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bd_ds", "root", "9536");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexion a base de datos" + e);
        }
        return(null);
    }
    
}
