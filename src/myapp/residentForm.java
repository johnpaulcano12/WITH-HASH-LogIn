    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import config.db_configuration;
import internalPages.resident;
import java.awt.BasicStroke;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import net.proteanit.sql.DbUtils;
import static internalPages.resident.res_tbl;

/**
 *
 * @author Mark
 */
public class residentForm extends javax.swing.JFrame {

    /**
     * Creates new form residentForm
     */
    public residentForm() {
        initComponents();
    }
     Color addb = new Color(255,204,204);
     Color addB = new Color(240,240,240);
     
     Color hover = new Color(69,193,255);
    Color defButton = new Color(0,153,153);
    
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
      public void displayData(){
       
        try{
       
            db_configuration dbc = new db_configuration();
            ResultSet rs = dbc.getData("SELECT * FROM residents");
            res_tbl.setModel(DbUtils.resultSetToTableModel(rs));
       
        }catch(SQLException ex){
            System.out.println("Error Message: "+ex);
       
        }
    }
      
      public String action;
   
      public void resetData(){
     fname.setText("");
     lname.setText("");
     bdate.setText("");
     sex.clearSelection();
     status.setSelectedIndex(0);
     children.setText("");
     contact.setText("");
     email.setText("");
     
     }
      public void close(){
        viewPage vp = new viewPage();
        vp.setVisible(true);
        resident r = new resident();
        viewPage.displayPane.add(r).setVisible(true);
        displayData();
        this.dispose();
      }
      
        int validateRegister(){
        int result;
       
    if(fname.getText().isEmpty() || lname.getText().isEmpty() || bdate.getText().isEmpty() 
            || children.getText().isEmpty() || contact.getText().isEmpty() || email.getText().isEmpty()
            || status.getSelectedItem().equals("STATUS")){
            Object message = "All fields are required!";
   JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    result = 0;
    }else{
            result =1;
            }
    return result;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        sex = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        fname = new javax.swing.JTextField();
        bdate = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        status = new javax.swing.JComboBox<>();
        contact = new javax.swing.JTextField();
        children = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jl5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exitPane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        s_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fname.setBackground(new java.awt.Color(0, 204, 204));
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 210, 60));

        bdate.setBackground(new java.awt.Color(0, 204, 204));
        bdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bdate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Birthdate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(bdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 210, 60));

        male.setBackground(new java.awt.Color(0, 204, 204));
        sex.add(male);
        male.setText("Male");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, male, org.jdesktop.beansbinding.ELProperty.create("${actionCommand}"), male, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        male.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maleMouseClicked(evt);
            }
        });
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel1.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 80, 30));

        female.setBackground(new java.awt.Color(0, 204, 204));
        sex.add(female);
        female.setText("Female");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, female, org.jdesktop.beansbinding.ELProperty.create("${actionCommand}"), female, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel1.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 80, 30));

        status.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STATUS", "Single", "Engaged", "Married", "Widow" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 90, 30));

        contact.setBackground(new java.awt.Color(0, 204, 204));
        contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contact.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Children", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 210, 60));

        children.setBackground(new java.awt.Color(0, 204, 204));
        children.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        children.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(children, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 210, 60));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(null);

        jl5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl5.setText("label");
        jPanel3.add(jl5);
        jl5.setBounds(10, 0, 70, 30);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 90, 30));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("RESIDENT FORM");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 50));

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

        jLabel3.setFont(new java.awt.Font("Corbel Light", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(88, 87, 87));
        jLabel3.setText(" x");
        exitPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 20, 30));

        jPanel2.add(exitPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 40, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 50));

        email.setBackground(new java.awt.Color(0, 204, 204));
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 210, 60));

        lname.setBackground(new java.awt.Color(0, 204, 204));
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 210, 60));

        s_id.setBackground(new java.awt.Color(0, 204, 204));
        s_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        s_id.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resident ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.add(s_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Gender");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 400));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void maleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maleMouseClicked

    }//GEN-LAST:event_maleMouseClicked

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        female.setSelected(false);
        
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        male.setSelected(false);
    }//GEN-LAST:event_femaleActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
          int check = validateRegister();
           
           if(check == 1){
        if(action.equals("add")){    
        db_configuration dbc = new db_configuration();
        dbc.insertData("INSERT INTO residents( res_lname,res_fname, res_bdate, res_gender, "
                + "res_status, res_child, res_contact, res_email)VALUES('"
                +lname.getText()+"','"+fname.getText()+"','"+bdate.getText()+"','"
                +sex.getSelection().getActionCommand()+"','"+status.getSelectedItem().toString()
                +"','"+children.getText()+"','"+contact.getText()+"','"+email.getText()+"')");

        resetData();
        JOptionPane.showMessageDialog(null, "Added Successfully");
        close();
        }
        
        else if(action.equals("edit")){
        db_configuration dbc = new db_configuration();
        dbc.updateData("UPDATE residents"
                + "SET res_fname = '"+fname.getText()+"', "
                + "res_lname='"+lname.getText()+"', "        
                + "res_bdate='"+bdate.getText()+"', "
                + "res_status ='"+status.getSelectedItem().toString()+ "', "
              //  + "res_gender ='"+rd_gender.getSelection().getActionCommand()+"', "
                + "res_child='"+children.getText()+"',"
                + "res_contact ='"+contact.getText()+"', "
                + "res_email ='"+email.getText()+"', "
                + "WHERE res_id = '"+s_id.getText()+"'");
       
         resetData();
         JOptionPane.showMessageDialog(null, "Updated Successfully!");
         close();
        }else{
           Object message = "No actions selected!";
           JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
           }else{
              System.out.println("Saving data failed!");
           }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setBackground(new Color(0,153,255));
        buttonBorderAnimation(jPanel3);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setBackground(new Color(69,193,255));
        buttonDefaultColor(jPanel3);
    }//GEN-LAST:event_jPanel3MouseExited

    private void exitPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseClicked
     close(); 
    }//GEN-LAST:event_exitPaneMouseClicked

    private void exitPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseEntered
        exitPane.setBackground(new Color(204,0,51));
    }//GEN-LAST:event_exitPaneMouseEntered

    private void exitPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPaneMouseExited
        exitPane.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_exitPaneMouseExited

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

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
            java.util.logging.Logger.getLogger(residentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(residentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(residentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(residentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new residentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField bdate;
    public static javax.swing.JTextField children;
    public static javax.swing.JTextField contact;
    public static javax.swing.JTextField email;
    private javax.swing.JPanel exitPane;
    public static javax.swing.JRadioButton female;
    public static javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel jl5;
    public static javax.swing.JTextField lname;
    public static javax.swing.JRadioButton male;
    public static javax.swing.JTextField s_id;
    public static javax.swing.ButtonGroup sex;
    public static javax.swing.JComboBox<String> status;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}