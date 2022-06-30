/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

import controller.AdopterListener;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Adopter;
import model.LocalTime;
import view.JButtonCustom;

/**
 *
 * @author ADMIN
 */
public class Adopt extends javax.swing.JFrame {

    private AdopterListener adopterListener = new AdopterListener();
    public String[] obj = new String[2];

    public Adopt() {
        initComponents();
    }

    public void Reset() {
        jtxtCCCD.setText("");
        jtxtName.setText("");
        JtxtAddress.setText("");
        jtxtDOB.setText("");
        jtxtPhone.setText("");
        jradioFemale.setSelected(false);
        jradioMale.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtxtDOB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtDateAdopt = new javax.swing.JTextField();
        jtxtPhone = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtCCCD = new javax.swing.JTextField();
        jbtAdd = new view.JButtonCustom();
        jLabel18 = new javax.swing.JLabel();
        JtxtAddress = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtxtID_TRE = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jradioMale = new javax.swing.JRadioButton();
        jradioFemale = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        jButtonCustom1 = new view.JButtonCustom();
        jbtReset2 = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Ngày Sinh");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 110, 40));

        jtxtDOB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 260, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Ngày nhận nuôi");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 140, 40));

        jtxtDateAdopt.setEditable(false);
        jtxtDateAdopt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateAdopt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDateAdopt, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 260, 40));

        jtxtPhone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 260, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel14.setText("Họ Tên");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 100, 40));

        jLabel15.setBackground(new java.awt.Color(153, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel15.setOpaque(true);
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 10, 270));

        jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 260, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel16.setText("Số điện thoại");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 110, 40));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel17.setText("Số CCCD");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, 40));

        jtxtCCCD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtCCCD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 260, 40));

        jbtAdd.setBorder(null);
        jbtAdd.setText("Thêm");
        jbtAdd.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtAdd.setColoOver(new java.awt.Color(255, 102, 51));
        jbtAdd.setColor(new java.awt.Color(51, 255, 153));
        jbtAdd.setColorClick(new java.awt.Color(0, 204, 255));
        jbtAdd.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtAdd.setRadius(40);
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });
        jPanel3.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 140, 60));

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel18.setText("Địa Chỉ");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 100, 40));

        JtxtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(JtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 260, 40));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel19.setText("ID_Trẻ");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 90, 40));

        jtxtID_TRE.setEditable(false);
        jtxtID_TRE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtID_TRE.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtID_TRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 260, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Giới Tính");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 90, 40));

        buttonGroup1.add(jradioMale);
        jradioMale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioMale.setText("Nam");
        jPanel3.add(jradioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 290, -1, -1));

        buttonGroup1.add(jradioFemale);
        jradioFemale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioFemale.setText("Nữ");
        jPanel3.add(jradioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, -1, -1));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel20.setText("Tìm Số CCCD");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 100, 40));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 260, 40));

        jbtFind.setBackground(new java.awt.Color(242, 242, 242));
        jbtFind.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_24px.png"))); // NOI18N
        jbtFind.setBoderColor(new java.awt.Color(242, 242, 242));
        jbtFind.setColoOver(new java.awt.Color(255, 255, 255));
        jbtFind.setColor(new java.awt.Color(242, 242, 242));
        jbtFind.setColorClick(new java.awt.Color(102, 255, 153));
        jbtFind.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFindMouseClicked(evt);
            }
        });
        jPanel3.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 50, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 540));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1120, 540));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN CÁ NHÂN NHẬN NUÔI TRẺ TRONG TRUNG TÂM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 690, 40));

        jButtonCustom1.setBackground(new java.awt.Color(242, 242, 242));
        jButtonCustom1.setText("X");
        jButtonCustom1.setBoderColor(new java.awt.Color(242, 242, 242));
        jButtonCustom1.setColoOver(new java.awt.Color(255, 51, 51));
        jButtonCustom1.setColor(new java.awt.Color(242, 242, 242));
        jButtonCustom1.setColorClick(new java.awt.Color(255, 51, 51));
        jButtonCustom1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCustom1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCustom1MouseClicked(evt);
            }
        });
        jPanel1.add(jButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 40, 40));

        jbtReset2.setBackground(new java.awt.Color(242, 242, 242));
        jbtReset2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbtReset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset_24px.png"))); // NOI18N
        jbtReset2.setBoderColor(new java.awt.Color(242, 242, 242));
        jbtReset2.setColoOver(new java.awt.Color(255, 255, 255));
        jbtReset2.setColor(new java.awt.Color(242, 242, 242));
        jbtReset2.setColorClick(new java.awt.Color(0, 204, 255));
        jbtReset2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jPanel1.add(jbtReset2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1120, 580));

        setSize(new java.awt.Dimension(1121, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        Adopter adop = new Adopter();
        adop.setName(jtxtName.getText());
        String ID_TRE = obj[0];
        String ID_NVQL = obj[1];
        adop.setCCCD(jtxtCCCD.getText());
        adop.setGender("Nam");
        if (jradioFemale.isSelected()) {
            adop.setGender("Nữ");
        }
        adop.setAddress(JtxtAddress.getText());
        adop.setPhoneNumber(jtxtPhone.getText());
        adop.setDOB(LocalTime.ChangeTypeDate_yMd(jtxtDOB.getText()));
        String DateAdopt = LocalTime.getDateNow();
        if (adop.checkInformation() == false) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin người nhận nuôi");

        } else {
            if (!LocalTime.checkDate_yyyyMMdd(adop.getDOB())) {
                JOptionPane.showMessageDialog(null, "Sai định dạng ngày sinh (dd-mm-yyyy), vui lòng kiểm tra lại");
                jtxtDOB.setBackground(Color.red);
            } else {
                System.out.println(DateAdopt);
                adopterListener.AddAdopter(adop, ID_TRE, ID_NVQL, DateAdopt);
                jtxtDOB.setBackground(Color.white);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jButtonCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom1MouseClicked
        Reset();
        this.setVisible(false);

    }//GEN-LAST:event_jButtonCustom1MouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        String CCCD = jtxtFind.getText();
        ArrayList<Adopter> list = adopterListener.FindAdop(1, CCCD);
        Adopter a = list.get(0);
        if (list.size() > 0) {
            JOptionPane.showMessageDialog(null, "Tìm kiếm thành công! Người nhận nuôi đã có trong trung tâm");
            jtxtName.setText(a.getName());
            JtxtAddress.setText(a.getAddress());
            jtxtCCCD.setText(a.getCCCD());
            jtxtDOB.setText(LocalTime.ChangeTypeDate_dMy(a.getDOB()));
            jtxtPhone.setText(a.getPhoneNumber());
            jtxtDateAdopt.setText(LocalTime.ChangeTypeDate_dMy(LocalTime.getDateNow()));
            if (a.getGender().compareTo("Nam") == 0) {
                jradioMale.setSelected(true);
            } else {
                jradioFemale.setSelected(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Người này chưa nhận nuôi trẻ nào trong trung tâm");
            jtxtName.setEditable(true);
            JtxtAddress.setEditable(true);
            jtxtCCCD.setEditable(true);
            jtxtDOB.setEditable(true);
            jtxtPhone.setEditable(true);
            jtxtDateAdopt.setEditable(true);
            jradioMale.setSelected(false);
            jradioFemale.setSelected(false);

        }

    }//GEN-LAST:event_jbtFindMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtxtAddress;
    private javax.swing.ButtonGroup buttonGroup1;
    private view.JButtonCustom jButtonCustom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtReset2;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JTextField jtxtCCCD;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtDateAdopt;
    private javax.swing.JTextField jtxtFind;
    private javax.swing.JTextField jtxtID_TRE;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtPhone;
    // End of variables declaration//GEN-END:variables

    public JTextField getJtxtDateAdopt() {
        return jtxtDateAdopt;
    }

    public JTextField getJtxtID_TRE() {
        return jtxtID_TRE;
    }

    public JButton getJbtAdd() {
        return jbtAdd;
    }

    public javax.swing.JTextField getJtxtAddress() {
        return JtxtAddress;
    }

    public javax.swing.JRadioButton getJradioFemale() {
        return jradioFemale;
    }

    public javax.swing.JRadioButton getJradioMale() {
        return jradioMale;
    }

    public javax.swing.JTextField getJtxtCCCD() {
        return jtxtCCCD;
    }

    public javax.swing.JTextField getJtxtDOB() {
        return jtxtDOB;
    }

    public javax.swing.JTextField getJtxtName() {
        return jtxtName;
    }

    public javax.swing.JTextField getJtxtPhone() {
        return jtxtPhone;
    }
}
