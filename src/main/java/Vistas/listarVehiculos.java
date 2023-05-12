package Vistas;

import Modelo.Vehiculo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


/**
 * @author Diego Ortega
 * @Email: draco_9431@hotmail.com
 * @fecha creacion 19/04/2023
 */


public class listarVehiculos extends javax.swing.JPanel {
    
    HttpClient cliente = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    
    EditarDatos EditarDatos;
    String consulta;
    String tipoVehiculo = "otro", estado = "", fecha =""; 
    String url = "http://localhost:8080/vehiculo";
    
    ObjectMapper mapper = new ObjectMapper();
    
    public listarVehiculos() {
        initComponents();        
        EditarDatos = new EditarDatos();
        EditarDatos.setBounds(541, 0, 736, 620);
        add(EditarDatos);
        EditarDatos.setVisible(false);
        this.setBounds(541, 0, 736, 620);
        this.setVisible(true);
        rbEstacionado.setSelected(true);
        cbMoto.setSelected(true);
        cbauto.setSelected(true);
        TableColumnModel columnModel = tblVehiculos.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(0).setPreferredWidth(40);
        
        //Valida y verifica que la libreria esta instalada
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listarVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Listar();
        most();
        
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
            System.out.println(vehiculoLista.size());
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
  
    
    public void Listar(){
        DefaultTableModel modelo = (DefaultTableModel) tblVehiculos.getModel();
        modelo.setRowCount(0);
        
        if(cbauto.isSelected()){
            if(cbMoto.isSelected()){
                tipoVehiculo = "";
            }else{
                tipoVehiculo = "Automovil";
            }
        } else if (cbMoto.isSelected()){
            tipoVehiculo = "Moto";
        }
        
        if(rbFuera.isSelected()){
            estado = "No Disponible";   
        }
        if(rbEstacionado.isSelected()){
            estado = "Disponible";
        }
        if (cal.getDate() != null){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = cal.getDate();
            fecha = dateFormat.format(date);   
        }
        
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/estacionamientonuevaera","root", "");
            Statement stat = conexion.createStatement();
            consulta = "SELECT * FROM vehiculo WHERE estado ='"+ estado + "' AND Tipo_Vehiculo LIKE'%" + tipoVehiculo + "%' AND Patente LIKE '%" + tf1patente.getText() + "%' AND Propietario Like '%" + tf1Dueño.getText() + "%' AND hora_Entrada LIKE'" + fecha + "%'"; 
            //System.out.println(consulta);
            ResultSet rs = stat.executeQuery(consulta);
            rs.next();
            
            do {
                String horaSalida = rs.getString(8);
                String valorPagado = rs.getString(9);
                if(horaSalida == null){
                    horaSalida = "No ha salido";
                    valorPagado = "0";
                } else {
                    horaSalida = rs.getString(8);//.substring(10).substring(0,6);
                    valorPagado = rs.getString(9);
                }
                String[] fila = {rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4), rs.getString(7)/*.substring(10).substring(0,6)*/, horaSalida,"$" + valorPagado};
                modelo.addRow(fila);           
            } while (rs.next());
            
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra en el Estacionamiento, por favor revise la placa ingresada");
            
            Logger.getLogger(listarVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelListar = new javax.swing.JLabel();
        jLabelTipovehiculoBuscar = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelDueñoBuscar = new javax.swing.JLabel();
        jLabelPatenteBuscar = new javax.swing.JLabel();
        jLabelUbicacion = new javax.swing.JLabel();
        rbEstacionado = new javax.swing.JRadioButton();
        rbFuera = new javax.swing.JRadioButton();
        cbMoto = new javax.swing.JCheckBox();
        cbauto = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        tf1patente = new javax.swing.JTextField();
        tf1Dueño = new javax.swing.JTextField();
        cal = new com.toedter.calendar.JDateChooser();
        JBEdit = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 153, 255));

        jLabelListar.setFont(new java.awt.Font("Perpetua", 1, 48)); // NOI18N
        jLabelListar.setForeground(new java.awt.Color(242, 242, 242));
        jLabelListar.setText("Buscar vehículo");

        jLabelTipovehiculoBuscar.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabelTipovehiculoBuscar.setForeground(new java.awt.Color(242, 242, 242));
        jLabelTipovehiculoBuscar.setText("Tipo de vehículo");

        jLabelFecha.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(242, 242, 242));
        jLabelFecha.setText("Fecha");

        jLabelDueñoBuscar.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabelDueñoBuscar.setForeground(new java.awt.Color(242, 242, 242));
        jLabelDueñoBuscar.setText("Dueño");

        jLabelPatenteBuscar.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabelPatenteBuscar.setForeground(new java.awt.Color(242, 242, 242));
        jLabelPatenteBuscar.setText("Patente");

        jLabelUbicacion.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jLabelUbicacion.setForeground(new java.awt.Color(242, 242, 242));
        jLabelUbicacion.setText("Ubicación");

        rbEstacionado.setBackground(new java.awt.Color(51, 153, 255));
        rbEstacionado.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        rbEstacionado.setForeground(new java.awt.Color(242, 242, 242));
        rbEstacionado.setText("Estacionado");
        rbEstacionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstacionadoActionPerformed(evt);
            }
        });

        rbFuera.setBackground(new java.awt.Color(51, 153, 255));
        rbFuera.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        rbFuera.setForeground(new java.awt.Color(242, 242, 242));
        rbFuera.setText("Fuera");

        cbMoto.setBackground(new java.awt.Color(51, 153, 255));
        cbMoto.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        cbMoto.setForeground(new java.awt.Color(242, 242, 242));
        cbMoto.setText("Moto");
        cbMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMotoActionPerformed(evt);
            }
        });

        cbauto.setBackground(new java.awt.Color(51, 153, 255));
        cbauto.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        cbauto.setForeground(new java.awt.Color(242, 242, 242));
        cbauto.setText("Automóvil");
        cbauto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbautoActionPerformed(evt);
            }
        });

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patente", "Marca", "Dueño", "Tipo de vehículo", "Hora de entrada", "Hora de salida", "Pagado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculos.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblVehiculos);
        tblVehiculos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblVehiculos.getColumnModel().getColumnCount() > 0) {
            tblVehiculos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblVehiculos.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblVehiculos.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblVehiculos.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblVehiculos.getColumnModel().getColumn(4).setPreferredWidth(90);
            tblVehiculos.getColumnModel().getColumn(5).setPreferredWidth(90);
            tblVehiculos.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        tf1Dueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1DueñoActionPerformed(evt);
            }
        });

        cal.setBackground(new java.awt.Color(255, 255, 255));
        cal.setForeground(new java.awt.Color(255, 255, 255));
        cal.setToolTipText("");
        cal.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N

        JBEdit.setBackground(new java.awt.Color(255, 255, 255));
        JBEdit.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        JBEdit.setForeground(new java.awt.Color(51, 153, 255));
        JBEdit.setText("Editar vehículo");
        JBEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditActionPerformed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(51, 153, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabelListar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(JBEdit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPatenteBuscar)
                                    .addComponent(jLabelDueñoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf1Dueño, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf1patente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(141, 141, 141)
                                        .addComponent(jLabelFecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelUbicacion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbFuera))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelTipovehiculoBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbMoto)))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbauto)
                                    .addComponent(rbEstacionado)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPatenteBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf1patente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDueñoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf1Dueño, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipovehiculoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbMoto)
                        .addComponent(cbauto)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbFuera)
                            .addComponent(rbEstacionado))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMotoActionPerformed
       
    }//GEN-LAST:event_cbMotoActionPerformed

    private void cbautoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbautoActionPerformed
        
    }//GEN-LAST:event_cbautoActionPerformed

    private void rbEstacionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstacionadoActionPerformed
        
    }//GEN-LAST:event_rbEstacionadoActionPerformed

    private void tf1DueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1DueñoActionPerformed
        
    }//GEN-LAST:event_tf1DueñoActionPerformed
    
    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        Listar();
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void JBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditActionPerformed
        this.removeAll();
        
        EditarDatos Edit = new EditarDatos();
        Edit.setBounds(0, 0, 736, 620);
        add(Edit);
        Edit.setVisible(true);
        Edit.repaint();
        Edit.revalidate();
    }//GEN-LAST:event_JBEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEdit;
    private com.toedter.calendar.JDateChooser cal;
    private javax.swing.JCheckBox cbMoto;
    private javax.swing.JCheckBox cbauto;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JLabel jLabelDueñoBuscar;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelListar;
    private javax.swing.JLabel jLabelPatenteBuscar;
    private javax.swing.JLabel jLabelTipovehiculoBuscar;
    private javax.swing.JLabel jLabelUbicacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbEstacionado;
    private javax.swing.JRadioButton rbFuera;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField tf1Dueño;
    private javax.swing.JTextField tf1patente;
    // End of variables declaration//GEN-END:variables

}
