package Modelo;

import javax.swing.JOptionPane;

/**
  * @author Diego Ortega
 * @Email: draco_9431@hotmail.com
 * @fecha creacion 24/04/2023
 */

import jakarta.persistence.*;
@Entity
@Table(name = "empleado")
public class Encargado extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Empleado")
    private Integer id_Empleado ;
    private String clave;
    private String email;
    private String cargo;
    
    public Encargado(String nombre, String rut, String apellido){
        super(nombre, rut, apellido);
        this.email = email;
        this.clave = clave;
        this.cargo = cargo;
    }
   
    
    @Override
    public void saludo(){
        JOptionPane.showMessageDialog(null, "Hola, Bienvenido", "Saludo", JOptionPane.INFORMATION_MESSAGE);
    }

    public Integer getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(Integer id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
