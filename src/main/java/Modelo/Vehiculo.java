/**
 * @author Diego Ortega
 * @Email: draco_9431@hotmail.com
 * @fecha creacion 19/04/2023
 */
package Modelo;

import javax.swing.JOptionPane;
import jakarta.persistence.*;
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vehiculo")
    private Integer id_Vehiculo;
    
    private String patente;   
    private String marca;
    private String tipo_Vehiculo;
    private String propietario;
    private String estado;
    private String hora_Entrada;
    private String hora_Salida;
    private String valor_Pagado;
    
    
    public Vehiculo(){
        this.marca = marca;
        this.patente = patente;
        this.tipo_Vehiculo = tipo_Vehiculo;
        this.id_Vehiculo = id_Vehiculo;
        this.estado = estado;
        this.propietario = propietario;
        this.hora_Entrada = hora_Entrada;
        this.hora_Salida = hora_Salida;
        this.valor_Pagado = valor_Pagado;
    }
    
    public void validarPatente(){
        if(patente.length() > 6){
            JOptionPane.showMessageDialog(null, "Patente no puede tener mas de 6 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
        } else if(patente.length()<= 0){
            JOptionPane.showMessageDialog(null, "Patente no ingresada, reintente", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void validarMarca(){
        if(marca.length() > 15){
            JOptionPane.showMessageDialog(null, "Marca no puede tener mas de 15 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
        } else if(marca.length()<= 0){
            JOptionPane.showMessageDialog(null, "Marca no ingresada, reintente", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    public String getMarca() {
        return marca;
    }
  
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getPatente() {
        return patente;
    }
    
    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getTipo_Vehiculo() {
        return tipo_Vehiculo;
    }

    public void setTipo_Vehiculo(String tipo_Vehiculo) {
        this.tipo_Vehiculo = tipo_Vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getId_Vehiculo() {
        return id_Vehiculo;
    }

    public void setId_Vehiculo(int id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public String getHora_Entrada() {
        return hora_Entrada;
    }

    public void setHora_Entrada(String hora_Entrada) {
        this.hora_Entrada = hora_Entrada;
    }

    public String getHora_Salida() {
        return hora_Salida;
    }

    public void setHora_Salida(String hora_Salida) {
        this.hora_Salida = hora_Salida;
    }

    public String getValor_Pagado() {
        return valor_Pagado;
    }

    public void setValor_Pagado(String valor_Pagado) {
        this.valor_Pagado = valor_Pagado;
    }
    
}

