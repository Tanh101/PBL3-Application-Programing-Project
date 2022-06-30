/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.AddJframe;

import controller.AdminListener;
import java.awt.Image;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.LocalTime;
import model.managementStaff;
import view.JButtonCustom;

/**
 *
 * @author ADMIN
 */
public class AddStaffManager extends javax.swing.JFrame {
    private LocalTime localTime = new LocalTime();
    private String url = "D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\StaffManagement\\";

    public String getID_Choose() {
        return ID_Choose;
    }

    public void setID_Choose(String ID_Choose) {
        this.ID_Choose = ID_Choose;
    }
    String ID_Choose;
    AdminListener adminListener = new AdminListener();

    /**
     * Creates new form AddStaffManager
     */
    public AddStaffManager() {
        initComponents();
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(jlbImage.getWidth(), jlbImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    public void Resest() {
        jtxtPassword.setText("");
        jtxtCCCD.setText("");
        jtxtName.setText("");
        jtxtEmail.setText("");
        jtxtAddress.setText("");
        jtxtDOB.setText("");
        jtxtPhone.setText("");
        jtxtDateEnter.setText("");
        jtxtDateQuit.setText("");
        jtxtUrlImage.setText("");
        jlbImage.setIcon(ResizeImage(url + "default.jfif"));
    }

    public void Add() {
        
        ArrayList<managementStaff> list = adminListener.getListManagerStaff(adminListener.getStoreProcShowAll());
        int IDNVQL = Integer.parseInt(list.get(list.size()-1).getID_NVQL()) + 1;
        String Pass = jtxtPassword.getText();
        String CCCD = jtxtCCCD.getText();
        String Name = jtxtName.getText();
        String DOB = jtxtDOB.getText();
        String Gender = "";
        if (jradioMale.isSelected() == true) {
            Gender = "Nam";
        } else if (jradioFemale.isSelected() == true) {
            Gender = "Nữ";
        }
        String Address = jtxtAddress.getText();
        String Phone = jtxtPhone.getText();
        String Email = jtxtEmail.getText();

        String DateEnter = localTime.getDateNow();
        String DateQuit = jtxtDateQuit.getText();
        if (DateQuit.compareTo("") == 0) {
            DateQuit = null;
        }
        String Img = jtxtUrlImage.getText();
        if (Img.compareTo("") == 0) {
            Img = url + "default.jfif";
        }
        if (Pass.isEmpty() || CCCD.isEmpty() || Name.isEmpty()
                || DOB.isEmpty() || Gender.isEmpty() || Address.isEmpty() || Phone.isEmpty() || Email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được bỏ trống thông tin nhân viên!");
        } else {
            adminListener.Insert(String.valueOf(IDNVQL), Pass,2, CCCD, Name, DOB, Gender, Address, Phone, Email, DateEnter, DateQuit, Img);
            Resest();
            this.setVisible(false);
        }
    }
    
    public void Update(){
        String Pass = jtxtPassword.getText();
        String CCCD = jtxtCCCD.getText();
        String Name = jtxtName.getText();
        String DOB = jtxtDOB.getText();
        String Gender = "";
        if (jradioMale.isSelected() == true) {
            Gender = "Nam";
        } else if (jradioFemale.isSelected() == true) {
            Gender = "Nữ";
        }
        String Address = jtxtAddress.getText();
        String Phone = jtxtPhone.getText();
        String Email = jtxtEmail.getText();

        String DateEnter = jtxtDateEnter.getText();
        String DateQuit = jtxtDateQuit.getText();
        if (DateQuit.compareTo("") == 0) {
            DateQuit = null;
        }
        String Img = jtxtUrlImage.getText();
        if (Img.compareTo("") == 0) {
            Img = url + "default.jfif";
        }
        if (Pass.isEmpty() || CCCD.isEmpty() || Name.isEmpty()
                || DOB.isEmpty() || Gender.isEmpty() || Address.isEmpty() || Phone.isEmpty() || 
                Email.isEmpty() || DateEnter.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được bỏ trống thông tin nhân viên!");
        } else {
            adminListener.Update((ID_Choose), Pass, CCCD, Name, DOB, Gender,
                                Address, Phone, Email, DateEnter, DateQuit,  Img);
            Resest();
            this.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlbImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtCCCD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtDOB = new javax.swing.JTextField();
        jtxtUrlImage = new javax.swing.JTextField();
        jtxtAddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jradioMale = new javax.swing.JRadioButton();
        jradioFemale = new javax.swing.JRadioButton();
        jtxtDateQuit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtxtDateEnter = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbtChooseImg = new view.JButtonCustom();
        jbtUpdate = new view.JButtonCustom();
        jbtAdd = new view.JButtonCustom();
        jButtonCustom1 = new jbuttonCustom.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbImage.setOpaque(true);
        jPanel1.add(jlbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 170, 150));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Mật khẩu");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 90, 30));

        jtxtPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 260, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("CCCD");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 80, 30));

        jtxtCCCD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 260, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Họ Tên");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 90, 30));

        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 260, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Ngày Sinh");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 80, 30));

        jtxtDOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 260, 40));
        jPanel1.add(jtxtUrlImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 160, 30));

        jtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 260, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Địa Chỉ");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 80, 30));

        jtxtPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 260, 40));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel10.setText("SĐT");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 70, 30));

        jtxtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 260, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel11.setText("Email");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 80, 30));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setText("Giới Tính");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 90, 40));

        buttonGroup1.add(jradioMale);
        jradioMale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioMale.setText("Nam");
        jPanel1.add(jradioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));

        buttonGroup1.add(jradioFemale);
        jradioFemale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioFemale.setText("Nữ");
        jPanel1.add(jradioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        jtxtDateQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtDateQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 260, 40));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel13.setText("Ngày Nghĩ Việc");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 100, 30));

        jtxtDateEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtDateEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 260, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel14.setText("Ngày vào làm");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 100, 30));

        jLabel7.setBackground(new java.awt.Color(102, 255, 204));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 10, 320));

        jbtChooseImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/image_file_add_24px.png"))); // NOI18N
        jbtChooseImg.setText("Chọn ảnh");
        jbtChooseImg.setBoderColor(new java.awt.Color(153, 255, 153));
        jbtChooseImg.setColoOver(new java.awt.Color(204, 255, 0));
        jbtChooseImg.setColor(new java.awt.Color(153, 255, 153));
        jbtChooseImg.setColorClick(new java.awt.Color(153, 255, 153));
        jbtChooseImg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtChooseImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtChooseImgMouseClicked(evt);
            }
        });
        jPanel1.add(jbtChooseImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 120, 30));

        jbtUpdate.setText("Cập Nhật");
        jbtUpdate.setBoderColor(new java.awt.Color(102, 255, 255));
        jbtUpdate.setColoOver(new java.awt.Color(153, 255, 255));
        jbtUpdate.setColor(new java.awt.Color(51, 255, 255));
        jbtUpdate.setColorClick(new java.awt.Color(51, 255, 102));
        jbtUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtUpdate.setRadius(30);
        jbtUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpdateMouseClicked(evt);
            }
        });
        jPanel1.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 150, 70));

        jbtAdd.setText("Thêm");
        jbtAdd.setBoderColor(new java.awt.Color(102, 255, 255));
        jbtAdd.setColoOver(new java.awt.Color(153, 255, 255));
        jbtAdd.setColor(new java.awt.Color(51, 255, 255));
        jbtAdd.setColorClick(new java.awt.Color(51, 255, 102));
        jbtAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtAdd.setRadius(30);
        jbtAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddMouseClicked(evt);
            }
        });
        jPanel1.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 150, 70));

        jButtonCustom1.setText("X");
        jButtonCustom1.setBoderColor(new java.awt.Color(255, 255, 255));
        jButtonCustom1.setColoOver(new java.awt.Color(255, 102, 102));
        jButtonCustom1.setColorClick(new java.awt.Color(255, 0, 0));
        jButtonCustom1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCustom1MouseClicked(evt);
            }
        });
        jPanel1.add(jButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtChooseImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtChooseImgMouseClicked
        JFileChooser f = new JFileChooser("D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\StaffManagement");
        int result = f.showOpenDialog(this);
        f.setDialogTitle("Mở File");
        File FileName = f.getSelectedFile();
        jtxtUrlImage.setText(FileName.getName());
        jlbImage.setIcon(ResizeImage(String.valueOf(url + FileName.getName())));
    }//GEN-LAST:event_jbtChooseImgMouseClicked

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        Add();
//        this.setVisible(false);
    }//GEN-LAST:event_jbtAddMouseClicked

    private void jButtonCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom1MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCustom1MouseClicked

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdateMouseClicked
        Update();
    }//GEN-LAST:event_jbtUpdateMouseClicked

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
            java.util.logging.Logger.getLogger(AddStaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStaffManager().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private jbuttonCustom.JButtonCustom jButtonCustom1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtChooseImg;
    private view.JButtonCustom jbtUpdate;
    private javax.swing.JLabel jlbImage;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtCCCD;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtDateEnter;
    private javax.swing.JTextField jtxtDateQuit;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtPassword;
    private javax.swing.JTextField jtxtPhone;
    private javax.swing.JTextField jtxtUrlImage;
    // End of variables declaration//GEN-END:variables

    public JButtonCustom getJbtChooseImg() {
        return jbtChooseImg;
    }

    public void setJbtChooseImg(JButtonCustom jbtChooseImg) {
        this.jbtChooseImg = jbtChooseImg;
    }

    public JButtonCustom getJbtUpdate() {
        return jbtUpdate;
    }

    public void setJbtUpdate(JButtonCustom jbtUpdate) {
        this.jbtUpdate = jbtUpdate;
    }

    public JLabel getJlbImage() {
        return jlbImage;
    }

    public void setJlbImage(JLabel jlbImage) {
        this.jlbImage = jlbImage;
    }

    public JRadioButton getJradioFemale() {
        return jradioFemale;
    }

    public void setJradioFemale(JRadioButton jradioFemale) {
        this.jradioFemale = jradioFemale;
    }

    public JRadioButton getJradioMale() {
        return jradioMale;
    }

    public void setJradioMale(JRadioButton jradioMale) {
        this.jradioMale = jradioMale;
    }

    public JButtonCustom getJbttAdd() {
        return jbtAdd;
    }

    public void setJbtAdd(JButtonCustom jtxtAdd) {
        this.jbtAdd = jtxtAdd;
    }

    public JTextField getJtxtAddress() {
        return jtxtAddress;
    }

    public void setJtxtAddress(JTextField jtxtAddress) {
        this.jtxtAddress = jtxtAddress;
    }

    public JTextField getJtxtCCCD() {
        return jtxtCCCD;
    }

    public void setJtxtCCCD(JTextField jtxtCCCD) {
        this.jtxtCCCD = jtxtCCCD;
    }

    public JTextField getJtxtDOB() {
        return jtxtDOB;
    }

    public void setJtxtDOB(JTextField jtxtDOB) {
        this.jtxtDOB = jtxtDOB;
    }

    public JTextField getJtxtDateEnter() {
        return jtxtDateEnter;
    }

    public void setJtxtDateEnter(JTextField jtxtDateEnter) {
        this.jtxtDateEnter = jtxtDateEnter;
    }

    public JTextField getJtxtDateQuit() {
        return jtxtDateQuit;
    }

    public void setJtxtDateQuit(JTextField jtxtDateQuit) {
        this.jtxtDateQuit = jtxtDateQuit;
    }
    
    public JTextField getJtxtName() {
        return jtxtName;
    }

    public void setJtxtName(JTextField jtxtName) {
        this.jtxtName = jtxtName;
    }

    public JTextField getJtxtPassword() {
        return jtxtPassword;
    }

    public void setJtxtPassword(JTextField jtxtPassword) {
        this.jtxtPassword = jtxtPassword;
    }

    public JTextField getJtxtPhone() {
        return jtxtPhone;
    }

    public void setJtxtPhone(JTextField jtxtPhone) {
        this.jtxtPhone = jtxtPhone;
    }

    public JTextField getJtxtUrlImage() {
        return jtxtUrlImage;
    }

    public void setJtxtUrlImage(JTextField jtxtUrlImage) {
        this.jtxtUrlImage = jtxtUrlImage;
    }
    public void setJtxtEmail(String Email){
        this.jtxtEmail.setText(Email);
    }
    public String getJtxtEmail(){
       return this.jtxtEmail.getText();
    }
}
