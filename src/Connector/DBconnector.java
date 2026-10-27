package Connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {
    public static Connection conexion() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://10.0.9.226:5432/postgres";
            String user = "postgres";
            String pass = "admin";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Erro na conexión: "+ e.getMessage());
        }
        return conn;
    }
}
