package Vistas;

import Modelo.Vehiculo;
import Vistas.listarVehiculos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 * @author Diego Ortega
 * @Email: draco_9431@hotmail.com
 * @fecha creacion 02/05/2023
 */
public class EditarDatos extends javax.swing.JPanel {
    
    HttpClient cliente = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    
    String consulta;
    String url ="";
    ObjectMapper mapper = new ObjectMapper();
    Vehiculo cars = new Vehiculo();
    public EditarDatos() {
        
        initComponents();
        this.url = url;
        Listars();
        AutoCompleteDecorator.decorate(JCBPatente);
        JTFdueno.setEnabled(false);
        JTFmarca.setEnabled(false);
        JCBPatente.setEditable(true);
        
        
    }
    
    public void Listars(){        
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/estacionamientonuevaera","root", "");
            Statement stat = conexion.createStatement();
            consulta = "SELECT * FROM vehiculo ";
              //System.out.println(consulta);
            ResultSet rs = stat.executeQuery(consulta);
            while(rs.next()){
                JCBPatente.addItem(rs.getString(2));
            }            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra en el Estacionamiento, por favor revise la placa ingresada");
            
            Logger.getLogger(listarVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    private void most(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> respue = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("estos son"+respue.body());
            
            
            ArrayList<Vehiculo> vehiculoLista = getData(respue.body(),new TypeReference<ArrayList<Vehiculo>>(){
            });
            for (Vehiculo vehiculo:vehiculoLista){
                Object datos[] = {vehiculo.getId_Vehiculo(),vehiculo.getPatente(),vehiculo.getMarca(),
                    vehiculo.getTipo_Vehiculo(), vehiculo.getPropietario(), vehiculo.getEstado(),
                    vehiculo.getHora_Entrada(),vehiculo.getHora_Salida(),vehiculo.getValor_Pagado()};
                JTFdueno.setText(vehiculo.getPropietario());
                JTFmarca.setText(vehiculo.getMarca());
                
                cars.setId_Vehiculo(vehiculo.getId_Vehiculo());
                cars.setPatente(vehiculo.getPatente());
                cars.setMarca(vehiculo.getMarca());
                cars.setTipo_Vehiculo(vehiculo.getTipo_Vehiculo());
                cars.setPropietario(vehiculo.getPropietario());
                cars.setEstado(vehiculo.getEstado());
                cars.setHora_Entrada(vehiculo.getHora_Entrada());
                cars.setHora_Salida(vehiculo.getHora_Salida());
                cars.setValor_Pagado(vehiculo.getValor_Pagado());
                                
            }
            
        } catch (Exception e) {
        }
    }
    private <T> T getData(String json, TypeReference<T> referencia){
        try {
            return mapper.readValue(json, referencia);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }   
    
    
    public void habilitarBoton(){
        if(!JTFdueno.getText().isEmpty() || !JTFmarca.getText().isEmpty()){
            JTFdueno.setEnabled(true);
            JTFmarca.setEnabled(true);
        }else{
            JTFdueno.setEnabled(false);
            JTFmarca.setEnabled(false);
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        JLTitulo = new javax.swing.JLabel();
        JLPatente = new javax.swing.JLabel();
        JLDueno = new javax.swing.JLabel();
        JLMarca = new javax.swing.JLabel();
        JTFmarca = new javax.swing.JTextField();
        JTFdueno = new javax.swing.JTextField();
        jBActualizar = new javax.swing.JButton();
        jBVolver = new javax.swing.JButton();
        JCBPatente = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(51, 153, 255));
        setPreferredSize(new java.awt.Dimension(736, 620));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vehiculo estacionado.png"))); // NOI18N

        jBBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jBBuscar.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jBBuscar.setForeground(new java.awt.Color(51, 153, 255));
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jBEliminar.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(51, 153, 255));
        jBEliminar.setText("Eliminar");

        JLTitulo.setFont(new java.awt.Font("Perpetua", 1, 68)); // NOI18N
        JLTitulo.setText("Editor de datos");

        JLPatente.setFont(new java.awt.Font("Perpetua", 0, 48)); // NOI18N
        JLPatente.setText("Patente");

        JLDueno.setFont(new java.awt.Font("Perpetua", 0, 48)); // NOI18N
        JLDueno.setText("Dueño");

        JLMarca.setFont(new java.awt.Font("Perpetua", 0, 48)); // NOI18N
        JLMarca.setText("Marca");

        JTFmarca.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        JTFmarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFmarcaActionPerformed(evt);
            }
        });

        JTFdueno.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        JTFdueno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTFdueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFduenoActionPerformed(evt);
            }
        });

        jBActualizar.setBackground(new java.awt.Color(255, 255, 255));
        jBActualizar.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jBActualizar.setForeground(new java.awt.Color(51, 153, 255));
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBVolver.setBackground(new java.awt.Color(0, 0, 0));
        jBVolver.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jBVolver.setForeground(new java.awt.Color(51, 153, 255));
        jBVolver.setText("Volver");
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        JCBPatente.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        JCBPatente.setSelectedItem(JCBPatente);
        JCBPatente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBPatenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JLPatente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JLMarca)
                                    .addComponent(JLDueno)
                                    .addComponent(jBBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(JTFmarca)
                                                .addComponent(JTFdueno, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                                            .addComponent(JCBPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLPatente)
                    .addComponent(JCBPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLMarca)
                    .addComponent(JTFmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFdueno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLDueno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTFduenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFduenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFduenoActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        most();
        habilitarBoton();         
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        listarVehiculos list = new listarVehiculos();
        list.setBounds(0, 0, 736, 620);
        add(list);
        list.setVisible(true);
        list.repaint();
        list.revalidate();
    }//GEN-LAST:event_jBVolverActionPerformed

    private void JTFmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFmarcaActionPerformed
        if(!JTFmarca.getText().isEmpty()){
            JTFmarca.setEnabled(false);
        }else{
            JTFmarca.setEnabled(true);
        }
    }//GEN-LAST:event_JTFmarcaActionPerformed

    private void JCBPatenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBPatenteActionPerformed
        
        cars.setPatente((String) JCBPatente.getSelectedItem());
        System.out.println(cars.getPatente());
        this.url = "http://localhost:8080/vehiculo/querry?patente="+cars.getPatente();
        System.out.println(url);
        
        
    }//GEN-LAST:event_JCBPatenteActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        String Url = "http://localhost:8080/vehiculo";
        HashMap parametros = new HashMap();
        
        cars.setId_Vehiculo(cars.getId_Vehiculo());
        cars.setPatente(cars.getPatente());
        cars.setMarca(JTFmarca.getText());
        cars.setEstado(cars.getEstado());
        cars.setHora_Entrada(cars.getHora_Entrada());
        cars.setHora_Salida(cars.getHora_Salida());  
        cars.setValor_Pagado(cars.getValor_Pagado());
        cars.setPropietario(JTFdueno.getText());    
        cars.setTipo_Vehiculo(cars.getTipo_Vehiculo());
        
        
        System.out.println("editar 2"+ cars.getMarca());
        
        parametros.put("id_Vehiculo", cars.getId_Vehiculo());
        parametros.put("patente", cars.getPatente());
        parametros.put("marca", cars.getPatente());
        parametros.put("tipo_Vehiculo", cars.getPatente());
        parametros.put("propietario", cars.getPatente());
        parametros.put("estado", cars.getPatente());
        parametros.put("hora_Entrada", cars.getPatente());
        parametros.put("hora_Salida", cars.getPatente());
        parametros.put("valor_Pagado", cars.getPatente());
        
        try {
            String datosDelVehiculo = mapper.writeValueAsString(parametros);
            HttpRequest request = HttpRequest.newBuilder().PUT(HttpRequest.BodyPublishers.ofString(datosDelVehiculo)).
                    uri(URI.create(Url)).build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.body().trim().equals("true")){
                JOptionPane.showMessageDialog(null, "Vehículo registrado");
            }else{
                JOptionPane.showMessageDialog(null, "¡Error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jBActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBPatente;
    private javax.swing.JLabel JLDueno;
    private javax.swing.JLabel JLMarca;
    private javax.swing.JLabel JLPatente;
    private javax.swing.JLabel JLTitulo;
    private javax.swing.JTextField JTFdueno;
    private javax.swing.JTextField JTFmarca;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBVolver;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
