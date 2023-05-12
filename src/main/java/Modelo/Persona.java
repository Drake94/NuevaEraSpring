
package Modelo;

/**
 * @author Diego Ortega
 * @Email: draco_9431@hotmail.com
 * @fecha creacion 24/04/2023
 */
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String rut;
    
    public Persona (String nombre, String rut, String apellido){
        super();
        this.nombre = nombre;
        this.rut = rut;
        this.apellido = apellido;
    }
    public abstract void saludo();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}

