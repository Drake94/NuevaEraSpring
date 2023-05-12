/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Encargado;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author draco
 */
public class Consultas {
    private int codigo ;
    
    public Consultas(){
    this.codigo = codigo;
    
    }
            
    
    public void guardarUsuario(String nombre, String apellido, String rut, String email, String clave, String cargo ){
        ConexionDB db = new ConexionDB();
        String sql = "INSERT INTO empleado(nombre, apellido, rut, email, clave, cargo) values ('"+ nombre +"','"+ apellido+"','"+ rut +"','"+ email +"','"+ clave + "','"+ cargo + "');";
        Statement st;
        Connection conexion = db.conectar();
        try {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (SQLException e) {
            //System.out.println(e);
        }
    
    }
    public void accesoUsuario(String email, String clave ){
        ConexionDB db = new ConexionDB();
        //Se inicializa el validador en null
        String correoCorrecto = null;
        String claveCorrecto = null;
        String nombreAsignado = null;
        
        try {
            Connection cn = db.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT nombre, email, clave FROM empleado");
            ResultSet rs = pst.executeQuery();
            //System.out.println(rs);
            if(rs.next()){
                nombreAsignado = rs.getString(1);
                correoCorrecto = rs.getString(2);
                claveCorrecto = rs.getString(3);
                
            }
            if (email.equals(correoCorrecto) && clave.equals(claveCorrecto)){
                JOptionPane.showMessageDialog(null, "Login Correcto Bienvenido " + nombreAsignado );
                setCodigo(200);
            }else if(!email.equals(correoCorrecto) || clave.equals(claveCorrecto)){
                JOptionPane.showMessageDialog(null, "Email invalido! Reintente");
                setCodigo(400);
            }else{
                JOptionPane.showMessageDialog(null, " clave invalida! Reintente");
                setCodigo(401);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
    }    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
