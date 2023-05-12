package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
    //Declaro la conexion a MySQL
    public static Connection con;
    //Declaro los datos de conexión a la BD
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url ="jdbc:mysql://localhost/estacionamientonuevaera";
    //Función que se conecta a la base de datos
    public Connection conectar(){
        con = null;
        try {
            con = (Connection) DriverManager.getConnection(url, user, pass);
            if(con!=null){
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
        return con;
    }
    
}
