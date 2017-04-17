/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Sepulveda
 */
public class Cocina extends javax.swing.JFrame {

    private Controlador Controlador;

    public Cocina(Controlador Controlador) {

        this.Controlador = Controlador;
        initComponents();
        lblprocesar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        CocinaTable = new javax.swing.JTable();
        lblprocesar = new javax.swing.JLabel();
        tiempoTxtField = new javax.swing.JTextField();
        progress = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        CocinaTable.setFont(new java.awt.Font("Kartika", 1, 13)); // NOI18N
        CocinaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Mesa", "#Camarero", "Pedidos", "#Orden"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CocinaTable.getTableHeader().setResizingAllowed(false);
        CocinaTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(CocinaTable);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 60, 680, 170);

        lblprocesar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblprocesar.setText("Cocinando...");
        getContentPane().add(lblprocesar);
        lblprocesar.setBounds(720, 90, 100, 15);
        getContentPane().add(tiempoTxtField);
        tiempoTxtField.setBounds(700, 140, 130, 30);
        getContentPane().add(progress);
        progress.setBounds(700, 110, 130, 20);

        jButton2.setText("Cocinar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(710, 190, 110, 23);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 29)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Cocina");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 10, 100, 46);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/kitchen-background-sized-1600_opt (2).jpg"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 870, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int fila = CocinaTable.getSelectedRow();
        System.out.println(fila);
        if (fila != -1) {

            DefaultTableModel model = (DefaultTableModel) CocinaTable.getModel();
            String valor = model.getValueAt(fila, 0).toString();
            int num = Integer.parseInt(valor);
            Controlador.ObtenerMesa(num).setProceso(1);
            try {
                Controlador.ActualizarStock();
            } catch (IOException ex) {
                Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
            }

            ProgressBar p = new ProgressBar(lblprocesar, progress, tiempoTxtField, CocinaTable);
            p.execute();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Controlador c = null;
                new Cocina(c).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    public javax.swing.JTable CocinaTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblprocesar;
    private javax.swing.JProgressBar progress;
    private javax.swing.JTextField tiempoTxtField;
    // End of variables declaration//GEN-END:variables
}
