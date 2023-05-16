/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import com.mysql.jdbc.Connection;
import config.db_configuration;
import java.awt.BasicStroke;
import java.awt.Color;
import java.sql.DriverManager;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
//import org.mindrot.jbcrypt.BCrypt;



/**
 *
 * @author Mark
 */
public class registerPage extends javax.swing.JFrame {
    private Connection con;

    /**
     * Creates new form registerPage
     */
    public registerPage() {
        initComponents();
        mmzPane.setBackground(new Color(0,0,0,0));
        exitPane.setBackground(new Color(0,0,0,0));
        fname.setBackground(new Color(75,75,75,75));
        lname.setBackground(new Color(75,75,75,75));
        bdate.setBackground(new Color(75,75,75,75));
        email.setBackground(new Color(75,75,75,75));
        uname.setBackground(new Color(75,75,75,75));
        pword.setBackground(new Color(75,75,75,75));
    }
     Color exited = new Color(69,193,215);
      Color hover = new Color(239,124,239);
    Color defButton = new Color(124,111,207);
    
    Border empty = BorderFactory.createEmptyBorder();
    
    void buttonBorderAnimation(JPanel panel){
    panel.setBackground(hover);
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
    
    
    }
      
    
    
    
    void buttonDefaultColor(JPanel panel){
    panel.setBackground(defButton);
    panel.setBorder(empty);
    }
    int validateRegister(){
        int result;
    if(fname.getText().isEmpty() || lname.getText().isEmpty() || bdate.getText().isEmpty() 
            || email.getText().isEmpty() || uname.getText().isEmpty() || pword.getText().isEmpty() ){
            Object message = "All fields are required";
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    result = 0;
    }else{
            result =1;
            }
   
    return result;
    }
    
    public void registerPage (){
        
        String Fname = fname.getText();
        String Lname = lname.getText();
        String Bdate= bdate.getText();
        String Uname= uname.getText();
        String Pword = pword.getText();
        String Email = email.getText();
        String hasedpassword = BCrypt.hashpw(Pword, BCrypt.gensalt());
     
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/system_db", "root", "");
            String sql = "insert into users(u_fname,u_lname,u_bdate,u_user,u_pword,u_email)values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, Fname);
        pst.setString(2, Lname);
        pst.setString(3, Bdate);
        pst.setString(4, Uname);
        pst.setString(5,hasedpassword );
        pst.setString(6, Email);
        
       int uprcount = pst.executeUpdate();
       if(uprcount >0){
       JOptionPane.showMessageDialog(this, "SIGN UP SUCCESSFULLY");
      loginForm in= new loginForm();
        in.setVisible(true);
        this. dispose();
        
       }else{
       JOptionPane.showMessageDialog(this, "SIGH UP FAILED");
             
       }
       
    } catch (Exception e) {
    e.printStackTrace();
    }  
    }
    
 public boolean validation (){
     String Fname = fname.getText();
     String Lname = lname.getText();
     String Uname = lname.getText();
     String Pword = lname.getText();
     String Email = email.getText();
         
     
     
    if (Fname.equals("") ){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR FIRST NAME");
 return false;
 }
 if(Lname.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR LAST NAME");
 return false;
 }
if(Uname.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER USERNAME");
 return false;
 }     
if(Pword.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR PASSWORD");
 return false;
 }    
if(Email.equals("")){
 JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR EMAIL");
 return false;
 }  
return true;
 }
        
 
   
    
     

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        regsiter = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mmzPane = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        exitPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        f = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l = new javax.swing.JLabel();
        b1 = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        e1 = new javax.swing.JLabel();
        e = new javax.swing.JLabel();
        u = new javax.swing.JLabel();
        u1 = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        bdate = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        uname = new javax.swing.JTextField();
        pword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REGISTRATION FORM");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(370, 40, 330, 20);

        regsiter.setBackground(new java.awt.Color(0, 153, 153));
        regsiter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regsiterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regsiterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regsiterMouseExited(evt);
            }
        });
        regsiter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("REGISTER");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        regsiter.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        jPanel1.add(regsiter);
        regsiter.setBounds(480, 410, 110, 30);

        mmzPane.setBackground(new java.awt.Color(0, 153, 153));
        mmzPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mmzPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mmzPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mmzPaneMouseExited(evt);
            }
        });
        mmzPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("—");
        mmzPane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 20, 50));

        jPanel1.add(mmzPane);
        mmzPane.setBounds(620, 0, 40, 30);

        exitPane.setBackground(new java.awt.Color(0, 153, 153));
        exitPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitPaneMouseExited(evt);
            }
        });
        exitPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Corbel Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("  x");
        exitPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel1.add(exitPane);
        exitPane.setBounds(660, 0, 40, 30);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("REGISTRATION FORM");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(390, 10, 300, 80);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsFolder/bglogo.png"))); // NOI18N
        jLabel13.setText("jLabel10");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, -30, 370, 550);

        f.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        f.setForeground(new java.awt.Color(255, 255, 255));
        f.setText("First Name");
        jPanel1.add(f);
        f.setBounds(420, 110, 70, 20);

        f1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        f1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(f1);
        f1.setBounds(410, 100, 70, 20);

        l1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(l1);
        l1.setBounds(410, 150, 90, 20);

        l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l.setForeground(new java.awt.Color(255, 255, 255));
        l.setText("Last Name");
        jPanel1.add(l);
        l.setBounds(420, 160, 70, 20);

        b1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(b1);
        b1.setBounds(410, 200, 90, 20);

        b.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        b.setForeground(new java.awt.Color(255, 255, 255));
        b.setText("Birthdate");
        jPanel1.add(b);
        b.setBounds(420, 210, 70, 20);

        e1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        e1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(e1);
        e1.setBounds(410, 250, 90, 20);

        e.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        e.setForeground(new java.awt.Color(255, 255, 255));
        e.setText("Email");
        jPanel1.add(e);
        e.setBounds(420, 260, 70, 20);

        u.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        u.setForeground(new java.awt.Color(255, 255, 255));
        u.setText("Username");
        jPanel1.add(u);
        u.setBounds(420, 310, 70, 20);

        u1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        u1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(u1);
        u1.setBounds(410, 300, 90, 20);

        p.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setText("Password");
        jPanel1.add(p);
        p.setBounds(420, 360, 70, 20);

        p1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(p1);
        p1.setBounds(410, 350, 90, 20);

        fname.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnameKeyTyped(evt);
            }
        });
        jPanel1.add(fname);
        fname.setBounds(410, 100, 250, 40);

        lname.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnameKeyTyped(evt);
            }
        });
        jPanel1.add(lname);
        lname.setBounds(410, 150, 250, 40);

        bdate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        bdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bdateKeyTyped(evt);
            }
        });
        jPanel1.add(bdate);
        bdate.setBounds(410, 200, 250, 40);

        email.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(410, 250, 250, 40);

        uname.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        uname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unameKeyTyped(evt);
            }
        });
        jPanel1.add(uname);
        uname.setBounds(410, 300, 250, 40);

        pword.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwordKeyTyped(evt);
            }
        });
        jPanel1.add(pword);
        pword.setBounds(410, 350, 250, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mark\\Pictures\\architecture-1048092_640.jpg")); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(220, 0, 480, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regsiterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regsiterMouseExited
         regsiter.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_regsiterMouseExited

    private void regsiterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regsiterMouseEntered
        regsiter.setBackground(new Color (69,193,215));
    }//GEN-LAST:event_regsiterMouseEntered

    private void regsiterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regsiterMouseClicked
      
        if (validation()==true){
            registerPage();
        }
            
        
        
    }//GEN-LAST:event_regsiterMouseClicked

    private void mmzPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mmzPaneMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_mmzPaneMouseClicked

    private void mmzPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mmzPaneMouseEntered
  
    }//GEN-LAST:event_mmzPaneMouseEntered

    private void mmzPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mmzPaneMouseExited

    }//GEN-LAST:event_mmzPaneMouseExited

    private void exitPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseClicked
       loginForm lf = new loginForm();
       lf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_exitPaneMouseClicked

    private void exitPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseEntered
     
    }//GEN-LAST:event_exitPaneMouseEntered

    private void exitPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseExited
       
    }//GEN-LAST:event_exitPaneMouseExited

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyTyped
        f.setText("");
        f1.setText(" First Name");
    }//GEN-LAST:event_fnameKeyTyped

    private void lnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyTyped
        l.setText("");
        l1.setText(" Last Name");
    }//GEN-LAST:event_lnameKeyTyped

    private void bdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bdateKeyTyped
        b.setText("");
        b1.setText(" Birthdate");
    }//GEN-LAST:event_bdateKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        e.setText("");
        e1.setText(" Email");
    }//GEN-LAST:event_emailKeyTyped

    private void unameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unameKeyTyped
        u.setText("");
        u1.setText(" Username");
    }//GEN-LAST:event_unameKeyTyped

    private void pwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwordKeyTyped
        p.setText("");
        p1.setText(" Password");
    }//GEN-LAST:event_pwordKeyTyped

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
            java.util.logging.Logger.getLogger(registerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b;
    private javax.swing.JLabel b1;
    private javax.swing.JTextField bdate;
    private javax.swing.JLabel e;
    private javax.swing.JLabel e1;
    private javax.swing.JTextField email;
    private javax.swing.JPanel exitPane;
    private javax.swing.JLabel f;
    private javax.swing.JLabel f1;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l;
    private javax.swing.JLabel l1;
    private javax.swing.JTextField lname;
    private javax.swing.JPanel mmzPane;
    private javax.swing.JLabel p;
    private javax.swing.JLabel p1;
    private javax.swing.JTextField pword;
    public static javax.swing.JPanel regsiter;
    private javax.swing.JLabel u;
    private javax.swing.JLabel u1;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
