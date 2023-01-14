/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Pablo
 */
public class RestaurarPassword extends javax.swing.JFrame {

    String user = "", user_update = "";

    /**
     * Creates new form RestaurarPassword
     */
    public RestaurarPassword() {
        initComponents();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;

        setSize(360, 280);
        setResizable(false);
        setTitle("Cambiar contraseña de " + user_update);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(),
                jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        txt_passwordconfirmacion = new javax.swing.JPasswordField();
        jButton_restaurarpassword = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambiar contraseña");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nueva contraseña");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirmar contraseña");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_passwordconfirmacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_passwordconfirmacion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_passwordconfirmacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_passwordconfirmacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_passwordconfirmacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_passwordconfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jButton_restaurarpassword.setBackground(new java.awt.Color(153, 153, 255));
        jButton_restaurarpassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_restaurarpassword.setForeground(new java.awt.Color(255, 255, 255));
        jButton_restaurarpassword.setText("Restaurar password");
        jButton_restaurarpassword.setBorder(null);
        jButton_restaurarpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_restaurarpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_restaurarpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 35));

        jLabel_footer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_footer.setText("Creado por Pablo");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_restaurarpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_restaurarpasswordActionPerformed

        String password, confirmacion_password;

        password = String.valueOf(txt_password.getPassword()).trim();
        confirmacion_password = String.valueOf(txt_password.getPassword()).trim();

        if (!password.equals("") && !confirmacion_password.equals("")) {

            if (password.equals(confirmacion_password)) {

                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update usuarios set password=? where username = '" + user_update + "'");

                    pst.setString(1, password);
                    pst.executeUpdate();
                    cn.close();

                    txt_password.setBackground(Color.GREEN);
                    txt_passwordconfirmacion.setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "Contraseña restablecida");
                    this.dispose();

                } catch (SQLException e) {
                    System.err.println("Error en conexion al intentar restablecer contraseña" + e);
                    JOptionPane.showMessageDialog(null, "Error de conexion");

                }

            } else {
                txt_password.setBackground(Color.red);
                txt_passwordconfirmacion.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }

        } else {
            txt_password.setBackground(Color.red);
            txt_passwordconfirmacion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos");
        }
    }//GEN-LAST:event_jButton_restaurarpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_restaurarpassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_passwordconfirmacion;
    // End of variables declaration//GEN-END:variables
}
