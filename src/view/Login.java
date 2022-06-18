/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LoginListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import view.viewStaffManager.StaffManager;

/**
 *
 * @author ADMIN
 */
public class Login extends javax.swing.JFrame {

    private static int count = 0;

    public Login() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtAccount = new javax.swing.JTextField();
        jpass = new javax.swing.JPasswordField();
        jboxChoose = new javax.swing.JComboBox<>();
        jlbVisible = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbRemember = new javax.swing.JCheckBox();
        jbtLogin = new view.JButtonCustom();
        jbtExit = new javax.swing.JButton();
        jpnExit = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/bg-login.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 445, 350));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 490));

        jPanel3.setBackground(new java.awt.Color(25, 118, 211));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tài Khoản");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 82, 31));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_user_64px.png"))); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 24, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mật Khẩu");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 84, 34));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đăng Nhập");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 36, 158, 52));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_____________________________________________________________________________");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("________________________________________________________________");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 310, -1));

        jtxtAccount.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtxtAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtAccountActionPerformed(evt);
            }
        });
        jPanel3.add(jtxtAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 308, 40));

        jpass.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jpass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jpass.setToolTipText("");
        jpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpassKeyPressed(evt);
            }
        });
        jPanel3.add(jpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 310, 40));

        jboxChoose.setForeground(new java.awt.Color(0, 153, 255));
        jboxChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Trị Viên", "Nhân Viên Quản Lý", "Cán Bộ" }));
        jboxChoose.setBorder(null);
        jboxChoose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jboxChoose.setOpaque(true);
        jboxChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jboxChooseActionPerformed(evt);
            }
        });
        jPanel3.add(jboxChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 150, -1));

        jlbVisible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_invisible_20px_1.png"))); // NOI18N
        jlbVisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbVisibleMouseClicked(evt);
            }
        });
        jPanel3.add(jlbVisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 50, 50));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_customer_26px_1.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 50, 50));

        jcbRemember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbRemember.setForeground(new java.awt.Color(255, 255, 255));
        jcbRemember.setText("Ghi Nhớ Mật Khẩu");
        jPanel3.add(jcbRemember, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jbtLogin.setForeground(new java.awt.Color(51, 153, 255));
        jbtLogin.setText("Đăng Nhập");
        jbtLogin.setBoderColor(new java.awt.Color(0, 153, 255));
        jbtLogin.setColoOver(new java.awt.Color(204, 255, 51));
        jbtLogin.setColorClick(new java.awt.Color(153, 255, 153));
        jbtLogin.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        jbtLogin.setRadius(50);
        jbtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLoginActionPerformed(evt);
            }
        });
        jPanel3.add(jbtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 160, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 470, 440));

        jbtExit.setBackground(new java.awt.Color(153, 255, 153));
        jbtExit.setText("X");
        jbtExit.setContentAreaFilled(false);
        jbtExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtExitMouseExited(evt);
            }
        });
        jbtExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExitActionPerformed(evt);
            }
        });
        jPanel1.add(jbtExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 50, 40));

        jpnExit.setBackground(new java.awt.Color(255, 255, 255));
        jpnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpnExitMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jpnExitLayout = new javax.swing.GroupLayout(jpnExit);
        jpnExit.setLayout(jpnExitLayout);
        jpnExitLayout.setHorizontalGroup(
            jpnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jpnExitLayout.setVerticalGroup(
            jpnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jpnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLoginActionPerformed

        LoginListener log = new LoginListener();
        String value = this.jboxChoose.getSelectedItem().toString();
        if (value.equals("Quản Trị Viên")) {
            String passText = new String(this.jpass.getPassword());
            if (this.jtxtAccount.getText().compareTo("lyvantanh1001") == 0
                    && passText.compareTo("lyvantanh2002") == 0) {
                new Admin().setVisible(true);
                this.setVisible(false);

            } else {
                showMessageDialog(null, "Vui lòng kiểm tra lại tài khoản hoặc mật khẩu!");
            }
        } else {
            String acc = this.jtxtAccount.getText();
            String pass = new String(this.jpass.getPassword());
            try {
                if (log.checkAccount(acc, pass) == true) {
                    this.setVisible(false);
                    staff st = new staff();
                    st.getjlbNameStaff().setText(log.getNameStaff(acc));
                    System.out.println(log.getNameStaff(acc));
                    st.setVisible(true);
                    st.setID_NVQL(acc);
                    st.setVisible(true);
                } else {
                    showMessageDialog(null, "Vui lòng kiểm tra lại tài khoản hoặc mật khẩu!");
                }
            } catch (SQLException ex) {

            }
        }


    }//GEN-LAST:event_jbtLoginActionPerformed

    private void jlbVisibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVisibleMouseClicked
        count++;
        for (int i = 0; i < count; i++)
            if (i % 2 == 0) {
                this.jpass.setEchoChar((char) 0);
                ImageIcon icon1 = new ImageIcon("D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\icons8_eye_20px_1.png");
                this.jlbVisible.setIcon(icon1);

            } else {
                ImageIcon icon2 = new ImageIcon("D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\icons8_invisible_20px_1.png");
                jlbVisible.setIcon(icon2);
                this.jpass.setEchoChar('*');
            }
    }//GEN-LAST:event_jlbVisibleMouseClicked

    private void jboxChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jboxChooseActionPerformed

    }//GEN-LAST:event_jboxChooseActionPerformed

    private void jtxtAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtAccountActionPerformed

    }//GEN-LAST:event_jtxtAccountActionPerformed

    private void jbtExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtExitActionPerformed

    private void jbtExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExitMouseExited

        jpnExit.setBackground(Color.WHITE);
    }//GEN-LAST:event_jbtExitMouseExited

    private void jbtExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExitMouseEntered
        jpnExit.setBackground(Color.red);
    }//GEN-LAST:event_jbtExitMouseEntered

    private void jbtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExitMouseClicked
        this.setVisible(false);
        new MainPage().setVisible(true);
    }//GEN-LAST:event_jbtExitMouseClicked

    private void jpnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnExitMouseEntered

    }//GEN-LAST:event_jpnExitMouseEntered

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            LoginListener log = new LoginListener();
            String value = this.jboxChoose.getSelectedItem().toString();
            if (value.equals("Quản Trị Viên")) {
                String passText = new String(this.jpass.getPassword());
                if (this.jtxtAccount.getText().compareTo("lyvantanh1001") == 0
                        && passText.compareTo("lyvantanh2002") == 0) {
                    new Admin().setVisible(true);
                    this.setVisible(false);

                } else {
                    showMessageDialog(null, "Vui lòng kiểm tra lại tài khoản hoặc mật khẩu!");
                }
            } else {
                String acc = this.jtxtAccount.getText();
                String pass = new String(this.jpass.getPassword());
                try {
                    if (log.checkAccount(acc, pass) == true) {
                        this.setVisible(false);
                        staff st = new staff();
                        st.getjlbNameStaff().setText(log.getNameStaff(acc));
                        System.out.println(log.getNameStaff(acc));
                        st.setVisible(true);
                        st.setID_NVQL(acc);
                        st.setVisible(true);
                    } else {
                        showMessageDialog(null, "Vui lòng kiểm tra lại tài khoản hoặc mật khẩu!");
                    }
                } catch (SQLException ex) {

                }
            }
        }
    }//GEN-LAST:event_jpassKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            LoginListener log = new LoginListener();
            String value = this.jboxChoose.getSelectedItem().toString();
            if (value.equals("Quản Trị Viên")) {
                String passText = new String(this.jpass.getPassword());
                if (this.jtxtAccount.getText().compareTo("lyvantanh1001") == 0
                        && passText.compareTo("lyvantanh2002") == 0) {
                    new Admin().setVisible(true);
                    this.setVisible(false);

                } else {
                    showMessageDialog(null, "Vui lòng kiểm tra lại tài khoản hoặc mật khẩu!");
                }
            } else {
                String acc = this.jtxtAccount.getText();
                String pass = new String(this.jpass.getPassword());
                try {
                    if (log.checkAccount(acc, pass) == true) {
                        this.setVisible(false);
                        staff st = new staff();
                        st.getjlbNameStaff().setText(log.getNameStaff(acc));
                        System.out.println(log.getNameStaff(acc));
                        st.setVisible(true);
                        st.setID_NVQL(acc);
                        st.setVisible(true);
                    } else {
                        showMessageDialog(null, "Vui lòng kiểm tra lại tài khoản hoặc mật khẩu!");
                    }
                } catch (SQLException ex) {

                }
            }
        }
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> jboxChoose;
    private javax.swing.JButton jbtExit;
    private view.JButtonCustom jbtLogin;
    private javax.swing.JCheckBox jcbRemember;
    private javax.swing.JLabel jlbVisible;
    private javax.swing.JPasswordField jpass;
    private javax.swing.JPanel jpnExit;
    private javax.swing.JTextField jtxtAccount;
    // End of variables declaration//GEN-END:variables
//    public static void main(String[] args) {
//        new Login().setVisible(true);
//    }
}
