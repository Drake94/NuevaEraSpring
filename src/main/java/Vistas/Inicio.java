package Vistas;

import java.awt.Image;
import java.awt.Toolkit;
/**
 *
 * @author Diego Ortega
 * @Email: draco_9431@hotmail.com
 * @fecha creacion 19/04/2023
 */
public class Inicio extends javax.swing.JFrame {

    listarVehiculos listarVehiculos;
    fondoInicio fondoInicio;
    crearVehiculos crea;
    salidaVehiculo salir;
    EditarDatos Edit;
    
    public Inicio() {
        
        initComponents();
        setSize(1280,650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        listarVehiculos = new listarVehiculos();
        listarVehiculos.setBounds(541, 0, 736, 620);
        add(listarVehiculos);
        listarVehiculos.setVisible(false);
        fondoInicio= new fondoInicio();
        fondoInicio.setBounds(541, 0, 736, 620);
        add(fondoInicio);
        fondoInicio.setVisible(true);
        crea = new crearVehiculos();
        crea.setBounds(541,0,736,620);
        crea.setVisible(false);
        add(crea);
        salir = new salidaVehiculo();
        salir.setBounds(541,0,736,620);
        salir.setVisible(false);
        add(salir);
        Edit= new EditarDatos();
        Edit.setBounds(541, 0, 736, 620);
        Edit.setVisible(false);
        add(Edit);
     
    }
    
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/logo_Epng.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButtonCrear = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();
        jButtonListar = new javax.swing.JButton();
        jButtonSalida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jButtonCrear.setBackground(new java.awt.Color(2, 123, 164));
        jButtonCrear.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jButtonCrear.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCrear.setText("Registrar vehículo");
        jButtonCrear.setToolTipText("");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });

        jButtonSalir.setBackground(new java.awt.Color(2, 123, 164));
        jButtonSalir.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jLabelFondo.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo E.jpg"))); // NOI18N
        jLabelFondo.setToolTipText("");
        jLabelFondo.setAlignmentX(0.5F);
        jLabelFondo.setPreferredSize(new java.awt.Dimension(920, 752));

        jButtonListar.setBackground(new java.awt.Color(2, 123, 164));
        jButtonListar.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jButtonListar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonListar.setText("Lista de vehículo");
        jButtonListar.setToolTipText("");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonSalida.setBackground(new java.awt.Color(2, 123, 164));
        jButtonSalida.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jButtonSalida.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalida.setText("Salida vehículo");
        jButtonSalida.setToolTipText("");
        jButtonSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
            .addComponent(jLabelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jButtonCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 540, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        //Botón para salir 
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        //Boton redirige a crear vehiculo
        setSize(1280, 650 );
        crea.setVisible(true);
        listarVehiculos.setVisible(false);
        fondoInicio.setVisible(false);
        salir.setVisible(false);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        //Boton redirige a listar vehiculos
        Edit.removeAll();
        Edit.hide();
        Edit.setVisible(false);
        setSize(1280, 650 );
        //listarVehiculos list = new listarVehiculos();
        crea.setVisible(false);
        fondoInicio.setVisible(false);
        salir.setVisible(false);
        //list.setBounds(541, 0, 736, 620);
        //add(list);
        listarVehiculos.setVisible(true);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalidaActionPerformed
        setSize(1280, 650 );
        crea.setVisible(false);
        listarVehiculos.setVisible(false);
        fondoInicio.setVisible(false);
        salir.setVisible(true);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonSalidaActionPerformed


    public static void main(String args[]) {
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Crea y muestra el formulario */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonSalida;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
