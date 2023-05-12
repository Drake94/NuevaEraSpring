package Vistas;

import Modelo.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Diego Ortega
 * @Email: draco_9431@hotmail.com
 * @fecha creacion 26/04/2023
 */
public class salidaVehiculo extends javax.swing.JPanel {


   
    public salidaVehiculo() {
        initComponents();
        
        
        //Valida y verifica que la libreria esta instalada
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(crearVehiculos.class.getName()).log(Level.SEVERE, null, ex);

        }    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        BTCobrar = new javax.swing.JButton();
        JLtitulo = new javax.swing.JLabel();
        JLingrese = new javax.swing.JLabel();
        tfPatentesal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 153, 255));
        setPreferredSize(new java.awt.Dimension(736, 620));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vehiculo estacionado.png"))); // NOI18N

        BTCobrar.setBackground(new java.awt.Color(255, 255, 255));
        BTCobrar.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        BTCobrar.setForeground(new java.awt.Color(51, 153, 255));
        BTCobrar.setText("Cobrar");
        BTCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCobrarActionPerformed(evt);
            }
        });

        JLtitulo.setFont(new java.awt.Font("Perpetua", 1, 58)); // NOI18N
        JLtitulo.setForeground(new java.awt.Color(255, 255, 255));
        JLtitulo.setText("Salida de vehículo");

        JLingrese.setFont(new java.awt.Font("Perpetua", 1, 48)); // NOI18N
        JLingrese.setForeground(new java.awt.Color(255, 255, 255));
        JLingrese.setText("Ingrese Patente");

        tfPatentesal.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        tfPatentesal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPatentesal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPatentesalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 54, Short.MAX_VALUE)
                        .addComponent(JLtitulo)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTCobrar, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(tfPatentesal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLingrese)
                        .addGap(100, 100, 100)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(JLtitulo)
                .addGap(18, 18, 18)
                .addComponent(JLingrese)
                .addGap(59, 59, 59)
                .addComponent(tfPatentesal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(BTCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfPatentesalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPatentesalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPatentesalActionPerformed

    private void BTCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCobrarActionPerformed
        //variable Valor a pagar
        Double valorAPagar =0.0;
        //Formato fecha y hora
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        //guarda la informacion a que hora sale del estacionamiento
        String fechaHora = dateFormat.format(date);
        Vehiculo tipo = new Vehiculo();
        try{
            //conexión a la base de datos
            //validación de libreria
            tipo.setPatente(tfPatentesal.getText());
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/estacionamientonuevaera","root", "");
            Statement stat = conexion.createStatement();
            ResultSet rs = stat.executeQuery("SELECT hora_Entrada,Tipo_Vehiculo FROM vehiculo WHERE Patente='"+tfPatentesal.getText()+"' AND estado='Disponible'");
            rs.next();
            String horaSalida = rs.getString(1);
            Date horasalida = dateFormat.parse(horaSalida);
            //Como se cobra por minutos Se resta a la hora de entrada la hora de salida,
            //y se divide en 60000 devido a que esta en milisegundos
            int minutosACobrar = (int) (date.getTime() - horasalida.getTime())/60000;
            System.out.println(minutosACobrar);
            
            if(rs.getString(2).equals("Automovil")){
                valorAPagar = minutosACobrar*25.1;
            }else if(rs.getString(2).equals("Moto")){
                valorAPagar = minutosACobrar*20.1;
            }
            System.out.println("Valor a pagar por " + rs.getString(2) + "= " + valorAPagar );
            stat.executeUpdate("UPDATE vehiculo SET hora_Salida='"+ fechaHora + "', estado='No Disponible', valor_Pagado='"+ valorAPagar +"'WHERE Patente='"+tfPatentesal.getText()+"' AND estado='Disponible'");
            int respuesta = JOptionPane.showConfirmDialog(null,"Valor a pagar:  $"+valorAPagar+"'\nDesea Imprimir Recibo","Salida de vehiculo",JOptionPane.YES_NO_OPTION); 
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra en el Estacionamiento, por favor revise la placa ingresada");
            
            Logger.getLogger(salidaVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(salidaVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTCobrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTCobrar;
    private javax.swing.JLabel JLingrese;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfPatentesal;
    // End of variables declaration//GEN-END:variables
}
