/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Consultas.Consultas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class EditarRubrica extends javax.swing.JFrame {

    Object[][] dtPer;
    Consultas con = new Consultas();
    Integer fila = -1;

    /**
     * Creates new form EditarRubrica
     */
    public EditarRubrica() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRubricas = new javax.swing.JTable();
        nombreRubrica1 = new javax.swing.JTextField();
        nombreRubrica2 = new javax.swing.JTextField();
        nombreRubrica3 = new javax.swing.JTextField();
        nombreRubrica4 = new javax.swing.JTextField();
        nombreRubrica5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        ponderacion2 = new javax.swing.JTextField();
        ponderacion3 = new javax.swing.JTextField();
        ponderacion1 = new javax.swing.JTextField();
        ponderacion4 = new javax.swing.JTextField();
        ponderacion5 = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel1.setText("Rúbricas");

        btnRegresar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tablaRubricas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaRubricas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRubricasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaRubricas);

        nombreRubrica1.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        nombreRubrica2.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        nombreRubrica3.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        nombreRubrica4.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        nombreRubrica5.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel16.setText("Ponderación:");

        jLabel17.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel17.setText("Ponderación:");

        jLabel18.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel18.setText("Ponderación:");

        jLabel19.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel19.setText("Ponderación:");

        jLabel11.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel11.setText("Nombre rúbrica 2:");

        jLabel12.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel12.setText("Nombre rúbrica 1:");

        jLabel13.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel13.setText("Nombre rúbrica 3:");

        jLabel14.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel14.setText("Nombre rúbrica 4:");

        jLabel15.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel15.setText("Nombre rúbrica 5:");

        jLabel20.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jLabel20.setText("Ponderación:");

        ponderacion2.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        ponderacion3.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        ponderacion1.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        ponderacion4.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        ponderacion5.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N

        btnModificar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 328, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreRubrica5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreRubrica4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreRubrica3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreRubrica2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreRubrica1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ponderacion1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ponderacion2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ponderacion3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ponderacion4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ponderacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(222, 222, 222)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(588, 588, 588))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(nombreRubrica1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(ponderacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nombreRubrica2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(ponderacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(nombreRubrica3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(ponderacion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(nombreRubrica4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(ponderacion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nombreRubrica5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(ponderacion5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnModificar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        Inicio menu = new Inicio();
        menu.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
        updateTabla();
    }//GEN-LAST:event_formWindowOpened

    private void tablaRubricasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRubricasMouseClicked
        fila = tablaRubricas.rowAtPoint(evt.getPoint());
        if (fila > -1) {
            nombreRubrica1.setText(String.valueOf(tablaRubricas.getValueAt(fila, 5)));
            ponderacion1.setText(String.valueOf(tablaRubricas.getValueAt(fila, 6)));
            nombreRubrica2.setText(String.valueOf(tablaRubricas.getValueAt(fila, 7)));
            ponderacion2.setText(String.valueOf(tablaRubricas.getValueAt(fila, 8)));
            nombreRubrica3.setText(String.valueOf(tablaRubricas.getValueAt(fila, 9)));
            ponderacion3.setText(String.valueOf(tablaRubricas.getValueAt(fila, 10)));
            nombreRubrica4.setText(String.valueOf(tablaRubricas.getValueAt(fila, 11)));
            ponderacion4.setText(String.valueOf(tablaRubricas.getValueAt(fila, 12)));
            nombreRubrica5.setText(String.valueOf(tablaRubricas.getValueAt(fila, 13)));
            ponderacion5.setText(String.valueOf(tablaRubricas.getValueAt(fila, 14)));
        }
    }//GEN-LAST:event_tablaRubricasMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (fila > -1) {
            String nom1 = nombreRubrica1.getText();
            String val1 = ponderacion1.getText();
            String nom2 = nombreRubrica2.getText();
            String val2 = ponderacion2.getText();
            String nom3 = nombreRubrica3.getText();
            String val3 = ponderacion3.getText();
            String nom4 = nombreRubrica4.getText();
            String val4 = ponderacion4.getText();
            String nom5 = nombreRubrica5.getText();
            String val5 = ponderacion5.getText();
            con.updateRubrica(nom1, val1, nom2, val2, nom3, val3, nom4, val4, nom5, val5, String.valueOf(tablaRubricas.getValueAt(fila, 0)), String.valueOf(tablaRubricas.getValueAt(fila, 1)), String.valueOf(tablaRubricas.getValueAt(fila, 2)), String.valueOf(tablaRubricas.getValueAt(fila, 3)), String.valueOf(tablaRubricas.getValueAt(fila, 4)));
            updateTabla();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    public void updateTabla() {
        String[] columNames = {"UNIDAD", "GRUPO", "MATERIA", "AÑO", "PERIODO", "RUBRICA", "VALOR", "RUBRICA", "VALOR", "RUBRICA", "VALOR", "RUBRICA", "VALOR", "RUBRICA", "VALOR"};
        // se utiliza la funcion
        dtPer = con.getVerRubricas();
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtPer, columNames);
        tablaRubricas.setModel(datos);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarRubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarRubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarRubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarRubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarRubrica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombreRubrica1;
    private javax.swing.JTextField nombreRubrica2;
    private javax.swing.JTextField nombreRubrica3;
    private javax.swing.JTextField nombreRubrica4;
    private javax.swing.JTextField nombreRubrica5;
    private javax.swing.JTextField ponderacion1;
    private javax.swing.JTextField ponderacion2;
    private javax.swing.JTextField ponderacion3;
    private javax.swing.JTextField ponderacion4;
    private javax.swing.JTextField ponderacion5;
    private javax.swing.JTable tablaRubricas;
    // End of variables declaration//GEN-END:variables
}
