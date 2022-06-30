/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.AddJframe;

import controller.ChildrenListener;
import controller.IntroductorListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Adopted;
import model.Children;
import model.IntroduceChildren;
import view.LoginUser;
import view.viewStaffManager.*;

/**
 *
 * @author ADMIN
 */
public class InforChildrenIntroduction extends javax.swing.JFrame {

    private String url = "D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\ChildrenImage\\";
    private ChildrenListener childrenListener = new ChildrenListener();
    private IntroductorListener introListener = new IntroductorListener();
    String IDNVQL, ID;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setIDNVQL(String IDNVQL) {
        this.IDNVQL = IDNVQL;

    }

    public InforChildrenIntroduction() {
        initComponents();
//        setWidthTable();
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(jlbImage.getWidth(), jlbImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    public void ClearJtxt() {
        jtxtAddress.setText("");
        jtxtName.setText("");
        jtxtDOB.setText("");
        jtxtSituation.setText("");
        jradioFemale.setSelected(false);
        jradioFemale.setSelected(false);
        jtxtNameImg.setText("");
        jlbImage.setIcon(ResizeImage(url + "default.png"));
        jlbName.setText(ID);

    }

    public void setWidthTable() {
        jtbChildIntro.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbChildIntro.setBackground(Color.WHITE);
        jtbChildIntro.getColumnModel().getColumn(0).setPreferredWidth(90);
        jtbChildIntro.getColumnModel().getColumn(0).setPreferredWidth(90);
        jtbChildIntro.getColumnModel().getColumn(1).setPreferredWidth(180);
        jtbChildIntro.getColumnModel().getColumn(2).setPreferredWidth(110);
        jtbChildIntro.getColumnModel().getColumn(3).setPreferredWidth(180);
        jtbChildIntro.getColumnModel().getColumn(4).setPreferredWidth(110);
        jtbChildIntro.getColumnModel().getColumn(5).setPreferredWidth(110);
        jtbChildIntro.getColumnModel().getColumn(6).setPreferredWidth(110);
        jtbChildIntro.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        ((DefaultTableCellRenderer) jtbChildIntro.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void getDataFromTable() {
        int k = jtbChildIntro.getSelectedRow();
        ArrayList<IntroduceChildren> list = new ArrayList<>();
        String ID_Choose = jtbChildIntro.getModel().getValueAt(k, 0).toString();
        list = childrenListener.FindChildIntro(1, ID, ID_Choose);
        jtxtNameImg.setText(list.get(0).getUrlImg());
        jlbImage.setIcon(ResizeImage(url + list.get(0).getUrlImg()));
        jtxtName.setText(list.get(0).getName());
        jtxtDOB.setText(list.get(0).getDOB());
        jtxtAddress.setText(list.get(0).getAddress());
        if (list.get(0).getGender().compareTo("Nam") == 0) {
            jradioMale.setSelected(true);
        } else {
            jradioFemale.setSelected(true);
        }
        jtxtSituation.setText(list.get(0).getSituation());
    }

    public void showSupport(ArrayList<IntroduceChildren> list) {
        DefaultTableModel model = (DefaultTableModel) jtbChildIntro.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                list.get(i).getID_TRE(), list.get(i).getName(), list.get(i).getDOB(), list.get(i).getAddress(),
                list.get(i).getGender(), list.get(i).getSituation(), list.get(i).getState(), list.get(i).getDateIntroduce()
            });
        }
        jtbChildIntro.setModel(model);
    }

    public void ShowChild(int i, String ID) {
        ArrayList<IntroduceChildren> list = new ArrayList<>();
        list = childrenListener.listIntroduceChildren(i, ID);
        showSupport(list);
    }

    public void Add() {
        ArrayList<IntroduceChildren> list = new ArrayList<>();
        list = childrenListener.getListChildrenIntroduced(childrenListener.proShowChildIntro());
        String ID_TRE;
        if (list.size() == 0) {
            ID_TRE = "TREGT001";
        } else {
            String tmp = list.get(list.size() - 1).getID_TRE();
            String[] arr = tmp.split("TREGT", 2);

            ID_TRE = "TREGT";
            if (String.valueOf(Integer.parseInt(arr[1]) + 1).length() == 1) {
                ID_TRE += "00";
            } else {
                ID_TRE += "0";
            }
            int tmp2 = Integer.parseInt(arr[1]) + 1;
            ID_TRE += String.valueOf(tmp2);
        }

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String Name = jtxtName.getText();
        String DOB = jtxtDOB.getText();
        String Address = jtxtAddress.getText();
        String Gender = "";
        if (jradioMale.isSelected()) {
            Gender = "Nam";
        } else if (jradioFemale.isSelected()) {
            Gender = "Nữ";
        }
        String Situation = jtxtSituation.getText();
        String DateEnter = date.toString();
        String NamePhoto = jtxtNameImg.getText();
        if (NamePhoto.compareTo("") == 0) {
            NamePhoto = url + "default.png";
        }
        if (ID.isEmpty() || Name.isEmpty() || DOB.isEmpty() || Address.isEmpty()
                || Gender.isEmpty() || DateEnter.isEmpty()) {
            showMessageDialog(null, "Không được để trống thông tin nhân viên!");
        } else {
            childrenListener.AddNewChildrenFromIntroductor(ID_TRE, Name, DOB, Address, Gender, NamePhoto, "0", Situation, ID, DateEnter, "0");
//            showMessageDialog(null, "Giới thiệu trẻ " + Name + " thành công");

        }
    }
//    public void Find(int i, String Name) {
//        showSupport(childrenListener.showAdopted(i, Name));
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtxtNameImg = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbChildIntro = new javax.swing.JTable();
        jtxtDOB = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtAddress = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jbtChooseImg = new view.JButtonCustom();
        jlbImage = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jradioMale = new javax.swing.JRadioButton();
        jradioFemale = new javax.swing.JRadioButton();
        jbtIntroduction = new view.JButtonCustom();
        jbtReset = new view.JButtonCustom();
        jLabel19 = new javax.swing.JLabel();
        jtxtSituation = new javax.swing.JTextField();
        jtbRest = new view.JButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        jlbName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtNameImg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameImg.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtNameImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 180, 30));

        jtbChildIntro.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbChildIntro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_TRE", "Tên Trẻ", "Ngày sinh", "Địa Chỉ", "Giới tính", "Hoàn Cảnh", "Trạng thái", "Ngày Giới Thiệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbChildIntro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbChildIntro.setGridColor(new java.awt.Color(0, 204, 204));
        jtbChildIntro.setOpaque(false);
        jtbChildIntro.setRowHeight(40);
        jtbChildIntro.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbChildIntro.setShowHorizontalLines(true);
        jtbChildIntro.setShowVerticalLines(true);
        jtbChildIntro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbChildIntroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbChildIntro);
        if (jtbChildIntro.getColumnModel().getColumnCount() > 0) {
            jtbChildIntro.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1270, 340));

        jtxtDOB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 170, 260, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel14.setText("Địa chỉ");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 100, 40));

        jLabel15.setBackground(new java.awt.Color(153, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel15.setOpaque(true);
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 10, 160));

        jtxtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtAddressActionPerformed(evt);
            }
        });
        jPanel3.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 260, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel16.setText("Ngày sinh");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, 120, 40));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel17.setText("Tên trẻ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 90, 40));

        jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 260, 40));

        jbtChooseImg.setBorder(null);
        jbtChooseImg.setText("Chọn ảnh");
        jbtChooseImg.setBoderColor(new java.awt.Color(0, 204, 255));
        jbtChooseImg.setColoOver(new java.awt.Color(255, 102, 51));
        jbtChooseImg.setColor(new java.awt.Color(51, 255, 153));
        jbtChooseImg.setColorClick(new java.awt.Color(0, 204, 255));
        jbtChooseImg.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbtChooseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtChooseImgActionPerformed(evt);
            }
        });
        jPanel3.add(jbtChooseImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 110, 30));
        jPanel3.add(jlbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 140, 130));

        jLabel18.setBackground(new java.awt.Color(153, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel18.setOpaque(true);
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 10, 160));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Giới Tính");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 90, 40));

        buttonGroup2.add(jradioMale);
        jradioMale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioMale.setText("Nam");
        jPanel3.add(jradioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, -1));

        buttonGroup2.add(jradioFemale);
        jradioFemale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioFemale.setText("Nữ");
        jPanel3.add(jradioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, -1, -1));

        jbtIntroduction.setBorder(null);
        jbtIntroduction.setText("Giới Thiệu");
        jbtIntroduction.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtIntroduction.setColoOver(new java.awt.Color(255, 102, 51));
        jbtIntroduction.setColor(new java.awt.Color(51, 255, 153));
        jbtIntroduction.setColorClick(new java.awt.Color(0, 204, 255));
        jbtIntroduction.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtIntroduction.setRadius(40);
        jbtIntroduction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtIntroductionMouseClicked(evt);
            }
        });
        jPanel3.add(jbtIntroduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 120, 50));

        jbtReset.setBorder(null);
        jbtReset.setText("Làm mới");
        jbtReset.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtReset.setColoOver(new java.awt.Color(255, 102, 51));
        jbtReset.setColor(new java.awt.Color(51, 255, 153));
        jbtReset.setColorClick(new java.awt.Color(0, 204, 255));
        jbtReset.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtReset.setRadius(40);
        jbtReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtResetMouseClicked(evt);
            }
        });
        jPanel3.add(jbtReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 120, 50));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel19.setText("Hoàn Cảnh");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 90, 40));

        jtxtSituation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtSituation.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtSituation, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 260, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 650));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1260, 650));

        jtbRest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back_26px.png"))); // NOI18N
        jtbRest.setBoderColor(new java.awt.Color(242, 242, 242));
        jtbRest.setColoOver(new java.awt.Color(153, 255, 204));
        jtbRest.setColor(new java.awt.Color(242, 242, 242));
        jtbRest.setColorClick(new java.awt.Color(102, 255, 153));
        jtbRest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbRestMouseClicked(evt);
            }
        });
        jPanel1.add(jtbRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("GIỚI THIỆU TRẺ");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 310, 60));

        jlbName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbName.setText("Ly Van Tanh");
        jlbName.setOpaque(true);
        jPanel1.add(jlbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 210, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1260, 700));

        setSize(new java.awt.Dimension(1259, 701));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtChooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtChooseImgActionPerformed
        JFileChooser f = new JFileChooser("D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\ChildrenImage");
        int result = f.showOpenDialog(this);
        f.setDialogTitle("Mở File");
        File FileName = f.getSelectedFile();
        jtxtNameImg.setText(FileName.getName());
        jlbImage.setIcon(ResizeImage(String.valueOf(url + FileName.getName())));
    }//GEN-LAST:event_jbtChooseImgActionPerformed

    private void jtbRestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbRestMouseClicked
        this.setVisible(false);
        new LoginUser().setVisible(true);
    }//GEN-LAST:event_jtbRestMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ShowChild(1, ID);
    }//GEN-LAST:event_formWindowActivated

    private void jtbChildIntroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbChildIntroMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbChildIntroMouseClicked

    private void jtxtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAddressActionPerformed

    private void jbtIntroductionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtIntroductionMouseClicked
        Add();
        ShowChild(1, ID);
        ClearJtxt();
        jlbName.setText(introListener.getNameIntroductor(ID));
    }//GEN-LAST:event_jbtIntroductionMouseClicked

    private void jbtResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtResetMouseClicked
        ShowChild(1, ID);
        ClearJtxt();
        jlbName.setText(introListener.getNameIntroductor(ID));
    }//GEN-LAST:event_jbtResetMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jlbName.setText(ID);
    }//GEN-LAST:event_formWindowOpened

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
//            java.util.logging.Logger.getLogger(ChildrenIntroduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChildrenIntroduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChildrenIntroduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChildrenIntroduction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChildrenIntroduction().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private view.JButtonCustom jbtChooseImg;
    private view.JButtonCustom jbtIntroduction;
    private view.JButtonCustom jbtReset;
    private javax.swing.JLabel jlbImage;
    private javax.swing.JLabel jlbName;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JTable jtbChildIntro;
    private view.JButtonCustom jtbRest;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtNameImg;
    private javax.swing.JTextField jtxtSituation;
    // End of variables declaration//GEN-END:variables
}
