/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author herfr
 */
public class mostrar extends javax.swing.JFrame {
    String id, n, ape, ciu, dir,fecha="getdate()";
    LocalDate todaysDate = LocalDate.now();
    public static String us = "", con = "";
    private ResultSet rs;
    public String url="jdbc:sqlserver://192.168.20.192\\SQLPROYECTOS:1433; databaseName=pizzeria";

    /**
     * Creates new form mostrar
     */
    public mostrar() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        fe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cve. Pedido", "Sabor", "N. Rebanadas", "Nombre del cliente", "Observaciones", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Mostrar pedidos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("AA-MM-DD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(fe, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Principal a = new Principal();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            fecha=todaysDate.toString();
            if (fe.getText().length()!=0) {
                fecha=fe.getText();
            }
            System.out.println(fecha);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conect = DriverManager.getConnection(url, us, con);
            Statement st = conect.createStatement();
            rs = st.executeQuery("SELECT * FROM dbo.pedidos  where Fecha='"+fecha+"'");

            DefaultListModel modelo = new DefaultListModel();
            DefaultListModel modelo1 = new DefaultListModel();
            DefaultListModel modelo2 = new DefaultListModel();
            DefaultListModel modelo3 = new DefaultListModel();
            DefaultListModel modelo4 = new DefaultListModel();
            DefaultListModel modelo5 = new DefaultListModel();
            DefaultListModel modelo6 = new DefaultListModel();
            DefaultListModel modelo7 = new DefaultListModel();
            while (rs.next()) {
                
//              JOptionPane.showMessageDialog(null, "\n Los clientes son: " + rs.getString("Nombre"));
                modelo.addElement(rs.getString("Cvepedido"));
//              JOptionPane.showMessageDialog(null, "\n La clave del cliente es: " + rs.getString("CveCliente"));
                modelo1.addElement(rs.getString("Sabor"));
                modelo2.addElement(rs.getString("Rebanadas"));
                modelo3.addElement(rs.getString("Nombre"));
                modelo4.addElement(rs.getString("Observaciones"));
                modelo5.addElement(rs.getString("Fecha"));
                modelo6.addElement(rs.getString("Hora"));
                modelo7.addElement(rs.getString("Precio"));
            }
            int b=modelo.getSize();
            String matris[][]=new String[b][8];
            for (int i = 0; i < b; i++) {
                matris[i][0]=(String) modelo.get(i);
                matris[i][1]=(String) modelo1.get(i);
                matris[i][2]=(String) modelo2.get(i);
                matris[i][3]=(String) modelo3.get(i);
                matris[i][4]=(String) modelo4.get(i);
                matris[i][5]=(String) modelo5.get(i);
                matris[i][6]=(String) modelo6.get(i);
                matris[i][7]=(String) modelo7.get(i);
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    matris,
            new String [] {
                "Cvepedido", "Sabor", "Rebandas", "Nombre", "Obvservaciones", "Fecha", "Hora","Precio"
            }
            ));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(mostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mostrar().setVisible(true);
            }
        });
    }

    public static void setUs(String us) {
        mostrar.us = us;
    }

    public static void setCon(String con) {
        mostrar.con = con;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
