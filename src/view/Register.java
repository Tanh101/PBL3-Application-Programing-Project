/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LoginListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Register extends javax.swing.JFrame {

    LoginListener log = new LoginListener();

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

    public void Register() {
        String Name = jtxtName.getText();
        String Address = jtxtAddress.getText();
        String DOB = jtxtDOB.getText();
        String Gender = "";
        if (jradioMale.isSelected()) {
            Gender = "Nam";
        }
        if (jrdioFemale.isSelected()) {
            Gender = "Nữ";
        }
        String Phone = jtxtPhoneNumber.getText();
        String Username = jtxtUsername.getText();
        String Pass = jtxtPas.getText();
        if (Name.isEmpty() || DOB.isBlank() || Gender.isEmpty() || Phone.isEmpty() || Username.isEmpty() || Pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
        } else {
            log.Register(Name, DOB, Gender, Address, Phone, Username, Pass);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gender = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jbtCloseRegister = new view.JButtonCustom();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jtxtDOB = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtPhoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtPas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jradioMale = new javax.swing.JRadioButton();
        jrdioFemale = new javax.swing.JRadioButton();
        jbtLogin = new view.JButtonCustom();
        jtxtUsername = new javax.swing.JTextField();
        jtxtAddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtCloseRegister.setBorder(null);
        jbtCloseRegister.setText("X");
        jbtCloseRegister.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtCloseRegister.setColoOver(new java.awt.Color(255, 102, 51));
        jbtCloseRegister.setColorClick(new java.awt.Color(255, 51, 0));
        jbtCloseRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtCloseRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtCloseRegisterMouseClicked(evt);
            }
        });
        jPanel1.add(jbtCloseRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 0, 49, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-register.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 320, 310));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 550));

        jPanel3.setBackground(new java.awt.Color(102, 255, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Họ Và Tên");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 110, 31));

        jtxtName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 308, 40));

        jtxtDOB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 308, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Ngày sinh");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 110, 31));

        jtxtPhoneNumber.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(jtxtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 308, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Giới Tính");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 110, 31));

        jtxtPas.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(jtxtPas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 308, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Tài Khoản");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 110, 31));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Mật Khẩu");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 110, 31));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("SĐT liên lạc");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 110, 31));

        Gender.add(jradioMale);
        jradioMale.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jradioMale.setText("Nam");
        jPanel3.add(jradioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        Gender.add(jrdioFemale);
        jrdioFemale.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jrdioFemale.setText("Nữ");
        jPanel3.add(jrdioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        jbtLogin.setForeground(new java.awt.Color(51, 153, 255));
        jbtLogin.setText("Đăng Ký");
        jbtLogin.setBoderColor(new java.awt.Color(0, 153, 255));
        jbtLogin.setColoOver(new java.awt.Color(204, 255, 51));
        jbtLogin.setColorClick(new java.awt.Color(153, 255, 153));
        jbtLogin.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jbtLogin.setRadius(50);
        jbtLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtLoginMouseClicked(evt);
            }
        });
        jPanel3.add(jbtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 140, 60));

        jtxtUsername.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(jtxtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 308, 40));

        jtxtAddress.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jPanel3.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 308, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Địa Chỉ");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 110, 30));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 540, 550));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 860, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCloseRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCloseRegisterMouseClicked
        this.setVisible(false);
//        new Information().setVisible(true);
    }//GEN-LAST:event_jbtCloseRegisterMouseClicked

    private void jbtLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLoginMouseClicked
        Register();
        this.setVisible(false);
    }//GEN-LAST:event_jbtLoginMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Register().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private view.JButtonCustom jbtCloseRegister;
    private view.JButtonCustom jbtLogin;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JRadioButton jrdioFemale;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtPas;
    private javax.swing.JTextField jtxtPhoneNumber;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
}
