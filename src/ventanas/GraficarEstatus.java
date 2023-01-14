/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
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
public class GraficarEstatus extends javax.swing.JFrame {

    String user;
    int NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado;
    String[] vector_estatus_nombre = new String[5];
    int[] vector_estatus_cantidad = new int[5];

    /**
     * Creates new form GraficarEstatus
     */
    public GraficarEstatus() {
        initComponents();
        user = Login.user;

        setTitle("Tecnico " + user);
        setSize(550, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(),
                jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select estatus, count(estatus) as Cantidad from equipos group by estatus");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    vector_estatus_nombre[posicion] = rs.getString(1);
                    vector_estatus_cantidad[posicion] = rs.getInt(2);

                    if (vector_estatus_nombre[posicion].equalsIgnoreCase("En revision")) {
                        EnRevision = vector_estatus_cantidad[posicion];

                    } else {
                        if (vector_estatus_nombre[posicion].equalsIgnoreCase("Entregado")) {
                            Entregado = vector_estatus_cantidad[posicion];

                        } else {
                            if (vector_estatus_nombre[posicion].equalsIgnoreCase("No reparado")) {
                                NoReparado = vector_estatus_cantidad[posicion];

                            } else {
                                if (vector_estatus_nombre[posicion].equalsIgnoreCase("Nuevo ingreso")) {
                                    NuevoIngreso = vector_estatus_cantidad[posicion];

                                } else {
                                    if (vector_estatus_nombre[posicion].equalsIgnoreCase("Reparado")) {
                                        Reparado = vector_estatus_cantidad[posicion];

                                    }

                                }

                            }

                        }

                    }
                    posicion++;
                } while (rs.next());

            }
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos" + e);
            JOptionPane.showMessageDialog(null, "Error de conexion" + e);
        }
        repaint();
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
   // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de estatus");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel_footer.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel_footer.setText("Creado por Pablo");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GraficarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficarEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables

    public int EstatusMasRepetido(int NuevoIngreso, int NoReparado, int EnRevison, int Reparado, int Entregado) {

        if (NuevoIngreso > NoReparado && NuevoIngreso > EnRevison && NuevoIngreso > Reparado && NuevoIngreso > Entregado) {
            return NuevoIngreso;

        } else if (NoReparado > EnRevison && NoReparado > Reparado && NoReparado > Entregado) {
            return NoReparado;
        } else if (EnRevison > Reparado && EnRevison > Entregado) {
            return EnRevison;
        } else if (Reparado > Entregado) {
            return Reparado;
        } else {
            return Entregado;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int Estatus_Mas_Repetido = EstatusMasRepetido(NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado);

        int largo_NuevoIngreso = NuevoIngreso * 400 / Estatus_Mas_Repetido;
        int largo_NoReparado = NoReparado * 400 / Estatus_Mas_Repetido;
        int largo_EnRevision = EnRevision * 400 / Estatus_Mas_Repetido;
        int largo_Reparado = Reparado * 400 / Estatus_Mas_Repetido;
        int largo_Entregado = Entregado * 400 / Estatus_Mas_Repetido;

        g.setColor(Color.YELLOW);
        g.fillRect(100, 100, largo_NuevoIngreso, 40);
        g.drawString("Nuevo ingreso", 10, 118);
        g.drawString("Cantidad " + NuevoIngreso, 10, 133);

        g.setColor(Color.RED);
        g.fillRect(100, 150, largo_NoReparado, 40);
        g.drawString("No reparado", 10, 168);
        g.drawString("Cantidad " + NoReparado, 10, 183);

        g.setColor(Color.BLACK);
        g.fillRect(100, 200, largo_EnRevision, 40);
        g.drawString("En revision", 10, 218);
        g.drawString("Cantidad " + EnRevision, 10, 233);

        g.setColor(Color.WHITE);
        g.fillRect(100, 250, largo_Reparado, 40);
        g.drawString("Reparado", 10, 268);
        g.drawString("Cantidad " + Reparado, 10, 283);

        g.setColor(Color.BLUE);
        g.fillRect(100, 300, largo_Entregado, 40);
        g.drawString("Entregado", 10, 318);
        g.drawString("Cantidad " + Entregado, 10, 333);

    }

}
