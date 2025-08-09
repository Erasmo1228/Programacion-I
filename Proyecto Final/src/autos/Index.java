package autos;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Index extends javax.swing.JFrame {
static Connection conn=null;
static Statement st=null;
static ResultSet rs=null;


String frase="LOGIN";
     int n=0;
    public Index() {
        initComponents();
        setSize(480,290);
        setLocation(300,100);

    }
   Timer timer = new Timer (1000, new ActionListener ()
{
    public void actionPerformed(ActionEvent e)
    {
     if (n<2)
     {jLabel4.setText("");
      jLabel4.setText(frase);
      n++;
     }
     else
     {n=0;
       jLabel4.setText("");
      jLabel4.setText("Autos Premier");
     }
    }
});
   
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcontra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        btningresar = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 3, 18));
        jLabel1.setForeground(new java.awt.Color(7, 50, 253));
        jLabel1.setText("Autos Premier");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 310, 10));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 12));
        jLabel2.setForeground(new java.awt.Color(8, 6, 6));
        jLabel2.setText("Paswoord: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 167, -1, -1));

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 2, 11));
        jLabel3.setText("El placer sobre ruedas... ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        txtcontra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 167, 100, 20));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 5, 5));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 30));

        txtuser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtuser.setCaretColor(new java.awt.Color(205, 198, 198));
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 127, 100, 20));

        btningresar.setFont(new java.awt.Font("Nimbus Roman No9 L", 3, 13)); // NOI18N
        btningresar.setText("Ingresar");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        getContentPane().add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 90, 20));

        b2.setFont(new java.awt.Font("Nimbus Roman No9 L", 3, 13)); // NOI18N
        b2.setText("Limpiar");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 90, 20));

        b4.setFont(new java.awt.Font("Nimbus Roman No9 L", 3, 13)); // NOI18N
        b4.setText("Crear Usuario");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        getContentPane().add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 120, 20));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 12));
        jLabel5.setForeground(new java.awt.Color(5, 5, 5));
        jLabel5.setText("Usuario: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        String user,password,datos;
       user=txtuser.getText();
       password=txtcontra.getText();
      try{
          conn=Main.Enlace(conn);
          rs=Main.login(rs);
          while(rs.next()){
              if(user.equals((String)rs.getString(2))){
                   if(password.equals((String)rs.getString(3))){
                  dispose();

                  JOptionPane.showMessageDialog(null,(String)rs.getString(1)+" Bienvenido a la Intranet");
                new principal().setVisible(true);
                conn.close();
              }else{
                  JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecta Ingrese Denuevo");
                  txtuser.setText("");
                  txtcontra.setText("");
                  txtuser.requestFocus();
              }
              }

          }
      }
      catch(SQLException e){
          JOptionPane.showInternalMessageDialog(null,"Error en conexion"+e.getMessage());
      }
}//GEN-LAST:event_btningresarActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        txtuser.setText("");
        txtcontra.setText("");
        txtuser.requestFocus();
}//GEN-LAST:event_b2ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        //new usuarios(this,true).setVisible(true);
        new new_usuario().setVisible(true);
}//GEN-LAST:event_b4ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b2;
    private javax.swing.JButton b4;
    private javax.swing.JButton btningresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtcontra;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables

}
