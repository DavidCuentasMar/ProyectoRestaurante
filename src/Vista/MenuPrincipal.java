/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Sepulveda
 */
public class MenuPrincipal extends javax.swing.JFrame {

    
    private Controlador Controlador;
    private TomarPedidos TomarPedidos;
    public Cocina cocina;
    public Aprovisionamiento Aprovisionamiento;
    public CreacionPlatos CreacionPlatos;
    public FinDelDia FinDelDia;
    
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() throws IOException {
        Controlador=new Controlador();
        cocina=new Cocina(Controlador);
        TomarPedidos=new TomarPedidos(Controlador,cocina);
        CreacionPlatos=new CreacionPlatos(Controlador);
        Aprovisionamiento=new Aprovisionamiento(Controlador,CreacionPlatos);
FinDelDia=new FinDelDia(Controlador);
        
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

        CamareroButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(390, 430));
        getContentPane().setLayout(null);

        CamareroButton.setBackground(new java.awt.Color(204, 204, 204));
        CamareroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconflat1.png"))); // NOI18N
        CamareroButton.setOpaque(false);
        CamareroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CamareroButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CamareroButton);
        CamareroButton.setBounds(20, 110, 290, 50);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sistema de Control");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 20, 370, 70);

        jButton2.setText("cocina");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 240, 140, 60);

        jButton4.setText("Fin del dia");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 390, 290, 50);

        jButton1.setText("aprovisionamiento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 170, 290, 60);

        jButton3.setText("factura");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 240, 140, 60);

        jButton6.setText("creacion de platos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(20, 310, 290, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desktop-wallpaper-minimalist-background-simple-dark-wallpapers.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-20, -370, 800, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Mesa_Info mesaInfo= new Mesa_Info( Controlador);
            mesaInfo.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void CamareroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CamareroButtonActionPerformed
      DefaultTableModel dm = (DefaultTableModel) TomarPedidos.InfoTable.getModel();
      
        for (int i =TomarPedidos.InfoTable.getRowCount() - 1; i >= 0; i--) {
    dm.removeRow(i);
}
         
        DefaultTableModel platos = (DefaultTableModel) TomarPedidos.PlatosTable.getModel();
        DefaultTableModel bebidas = (DefaultTableModel) TomarPedidos.BebidasTable.getModel();
        DefaultTableModel postres = (DefaultTableModel) TomarPedidos.PostresTable.getModel();
        
        Controlador.AgregarEnMenu(platos,bebidas,postres);
        
        
  
        
        TomarPedidos.setVisible(true);
        
    }//GEN-LAST:event_CamareroButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
         cocina.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

  int fila=Aprovisionamiento.AlmacenTable.getRowCount();
  DefaultTableModel model = (DefaultTableModel) Aprovisionamiento.AlmacenTable.getModel();
        
        for (int i =fila - 1; i >= 0; i--) {
    model.removeRow(i);
}
        
        try {
            Controlador.AgregarIngredientesPlato(Aprovisionamiento);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        Aprovisionamiento.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        
   int fila=CreacionPlatos.IngredienteTable.getRowCount();
  DefaultTableModel model = (DefaultTableModel) CreacionPlatos.IngredienteTable.getModel();
        
        for (int i =fila - 1; i >= 0; i--) {
    model.removeRow(i);
}
        
        
        
        try {
            Controlador.AgregarIngredientesPlato(CreacionPlatos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        CreacionPlatos.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) FinDelDia.FinMesaTable.getModel();       
        Controlador.FinDia(FinDelDia.VentasLabel, FinDelDia.PlatoLabel, FinDelDia.CamareroLabel,model,
        FinDelDia.MenosVendidoLabel,FinDelDia.AliLabel);
        
        FinDelDia.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
         
                try {
                    new MenuPrincipal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CamareroButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}