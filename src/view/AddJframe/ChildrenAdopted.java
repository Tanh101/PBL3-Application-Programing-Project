/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.AddJframe;

import controller.ChildrenListener;
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
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Adopted;
import model.Children;
import model.IntroduceChildren;
import model.LocalTime;
import view.viewStaffManager.*;

/**
 *
 * @author ADMIN
 */
public class ChildrenAdopted extends javax.swing.JFrame {

    private String url = "D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\ChildrenImage\\";
    private ChildrenListener childrenListener = new ChildrenListener();
    String IDNVQL, ID;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setIDNVQL(String IDNVQL) {
        this.IDNVQL = IDNVQL;

    }

    public ChildrenAdopted() {
        initComponents();
        setWidthTable();
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
        jtxtDateAdopt.setText("");
        jradioFemale.setSelected(false);
        jradioFemale.setSelected(false);
        jtxtDOB.setBackground(Color.white);
        jtxtDateAdopt.setBackground(Color.white);

    }

    public void setWidthTable() {
        jtbChildrenAdopter.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbChildrenAdopter.setBackground(Color.WHITE);
        jtbChildrenAdopter.getColumnModel().getColumn(0).setPreferredWidth(90);
        jtbChildrenAdopter.getColumnModel().getColumn(1).setPreferredWidth(180);
        jtbChildrenAdopter.getColumnModel().getColumn(2).setPreferredWidth(110);
        jtbChildrenAdopter.getColumnModel().getColumn(3).setPreferredWidth(180);
        jtbChildrenAdopter.getColumnModel().getColumn(4).setPreferredWidth(110);
        jtbChildrenAdopter.getColumnModel().getColumn(5).setPreferredWidth(110);
        jtbChildrenAdopter.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        ((DefaultTableCellRenderer) jtbChildrenAdopter.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void getDataFromTable() {
        int k = jtbChildrenAdopter.getSelectedRow();
        String ID_Choose = (String) jtbChildrenAdopter.getModel().getValueAt(k, 0);
        ArrayList<Adopted> list = new ArrayList<Adopted>();
        list = childrenListener.showAdopted(2, ID_Choose);
        Adopted ic = list.get(0);
        jtxtName.setText(ic.getName());
        jtxtDOB.setText(LocalTime.ChangeTypeDate_dMy(ic.getDOB()));
        jtxtAddress.setText(ic.getAddress());
        if (ic.getGender().compareTo("Nam") == 0) {
            jradioMale.setSelected(true);
        } else {
            jradioFemale.setSelected(true);
        }
        jtxtNameImg.setText(ic.getImg());
        jlbImage.setIcon(ResizeImage(url + ic.getImg()));
        jtxtDateAdopt.setText(LocalTime.ChangeTypeDate_dMy(ic.getDateAdopt()));
    }

    public void showSupport(ArrayList<Adopted> list) {
        DefaultTableModel model = (DefaultTableModel) jtbChildrenAdopter.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                list.get(i).getID_TRE(), list.get(i).getName(), LocalTime.ChangeTypeDate_dMy(list.get(i).getDOB()), list.get(i).getAddress(),
                list.get(i).getGender(), list.get(i).getState(), LocalTime.ChangeTypeDate_dMy(list.get(i).getDateAdopt())
            });
        }
        jtbChildrenAdopter.setModel(model);
    }

    public void ShowChild(int i, String ID) {
        ArrayList<Adopted> list = new ArrayList<Adopted>();
        list = childrenListener.showAdopted(i, ID);
        showSupport(list);
    }

    public void Find(int i, String Name) {
        showSupport(childrenListener.showAdopted(i, Name));
    }

    public void Delete() {
        int k = jtbChildrenAdopter.getSelectedRow();
        if (k < 0) {
            showMessageDialog(null, "Vui Lòng chọn trẻ muốn xoá!");
        } else {
            String ID_Choose = (String) jtbChildrenAdopter.getModel().getValueAt(k, 0);
            childrenListener.Delete(ID_Choose);
        }

    }

    public void Update() {
        int k = jtbChildrenAdopter.getSelectedRow();
        if (k < 0) {
            showMessageDialog(null, "Vui Lòng chọn trẻ muốn cập nhật!");
        } else {
            String ID_Choose = (String) jtbChildrenAdopter.getModel().getValueAt(k, 0);
            String Name = jtxtName.getText();
            String DOB = jtxtDOB.getText();
            DOB = LocalTime.ChangeTypeDate_yMd(DOB);
            String Address = jtxtAddress.getText();
            String Gender;
            if (jradioMale.isSelected()) {
                Gender = "Nam";
            } else {
                Gender = "Nữ";
            }
            String Img = jtxtNameImg.getText();
            String DateAdopt = jtxtDateAdopt.getText();
            DateAdopt = LocalTime.ChangeTypeDate_yMd(DateAdopt);
            String img = jtxtNameImg.getText();
            if (Name.isEmpty() || DOB.isEmpty() || Gender.isEmpty() || Img.isEmpty() || DateAdopt.isEmpty()) {
                showMessageDialog(null, "Vui lòng điền đầy đủ thông tin của trẻ");
            } else {
                if (LocalTime.checkDate_yyyyMMdd(DOB)) {
                    if (LocalTime.checkDate_yyyyMMdd(DateAdopt)) {
                        childrenListener.UpdateAdopted(ID_Choose, Name, DOB, Address, Gender, DateAdopt, img);
                        ShowChild(3, ID);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ngày nhận nuôi không hợp lệ");
                        jtxtDateAdopt.setBackground(new Color(255, 172, 164));
                    }
                } else {
                    jtxtDOB.setBackground(new Color(255, 172, 164));
                    JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtxtDateAdopt = new javax.swing.JTextField();
        jtxtNameImg = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbChildrenAdopter = new javax.swing.JTable();
        jtxtDOB = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtAddress = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jbtChooseImg = new view.JButtonCustom();
        jtbtDel1 = new view.JButtonCustom();
        jlbImage = new javax.swing.JLabel();
        jtbShow = new view.JButtonCustom();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jradioMale = new javax.swing.JRadioButton();
        jradioFemale = new javax.swing.JRadioButton();
        jbtUpdate1 = new view.JButtonCustom();
        jtbRest = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Ngày nhận nuôi");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 110, 40));

        jtxtDateAdopt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateAdopt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDateAdopt, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 260, 40));

        jtxtNameImg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameImg.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtNameImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 180, 30));

        jtbChildrenAdopter.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbChildrenAdopter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_TRE", "Tên Trẻ", "Ngày sinh", "Địa Chỉ", "Giới tính", "Trạng thái", "Ngày Nhận Nuôi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbChildrenAdopter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbChildrenAdopter.setGridColor(new java.awt.Color(0, 204, 204));
        jtbChildrenAdopter.setOpaque(false);
        jtbChildrenAdopter.setRowHeight(40);
        jtbChildrenAdopter.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbChildrenAdopter.setShowHorizontalLines(true);
        jtbChildrenAdopter.setShowVerticalLines(true);
        jtbChildrenAdopter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbChildrenAdopterMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbChildrenAdopter);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1200, 340));

        jtxtDOB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 260, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel14.setText("Địa chỉ");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 100, 40));

        jLabel15.setBackground(new java.awt.Color(153, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel15.setOpaque(true);
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 10, 140));

        jtxtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 260, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel16.setText("Ngày sinh");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 120, 40));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel17.setText("Tên trẻ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 90, 40));

        jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 260, 40));

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
        jPanel3.add(jbtChooseImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 110, 30));

        jtbtDel1.setBorder(null);
        jtbtDel1.setText("Xoá");
        jtbtDel1.setBoderColor(new java.awt.Color(255, 255, 255));
        jtbtDel1.setColoOver(new java.awt.Color(255, 102, 51));
        jtbtDel1.setColor(new java.awt.Color(51, 255, 153));
        jtbtDel1.setColorClick(new java.awt.Color(0, 204, 255));
        jtbtDel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jtbtDel1.setRadius(40);
        jtbtDel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbtDel1MouseClicked(evt);
            }
        });
        jPanel3.add(jtbtDel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 120, 50));
        jPanel3.add(jlbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, 150));

        jtbShow.setBorder(null);
        jtbShow.setText("Hiển thị");
        jtbShow.setBoderColor(new java.awt.Color(255, 255, 255));
        jtbShow.setColoOver(new java.awt.Color(255, 102, 51));
        jtbShow.setColor(new java.awt.Color(51, 255, 153));
        jtbShow.setColorClick(new java.awt.Color(0, 204, 255));
        jtbShow.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jtbShow.setRadius(40);
        jtbShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbShowMouseClicked(evt);
            }
        });
        jPanel3.add(jtbShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 120, 50));

        jLabel18.setBackground(new java.awt.Color(153, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel18.setOpaque(true);
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 10, 140));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Giới Tính");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 90, 40));

        buttonGroup2.add(jradioMale);
        jradioMale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioMale.setText("Nam");
        jPanel3.add(jradioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        buttonGroup2.add(jradioFemale);
        jradioFemale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioFemale.setText("Nữ");
        jPanel3.add(jradioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        jbtUpdate1.setBorder(null);
        jbtUpdate1.setText("Cập Nhật");
        jbtUpdate1.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUpdate1.setColoOver(new java.awt.Color(255, 102, 51));
        jbtUpdate1.setColor(new java.awt.Color(51, 255, 153));
        jbtUpdate1.setColorClick(new java.awt.Color(0, 204, 255));
        jbtUpdate1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtUpdate1.setRadius(40);
        jbtUpdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpdate1MouseClicked(evt);
            }
        });
        jPanel3.add(jbtUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 120, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 660));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1190, 660));

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
        jPanel1.add(jtbRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1190, 700));

        setSize(new java.awt.Dimension(1191, 701));
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
//        new AdopterManager().setVisible(true);
    }//GEN-LAST:event_jtbRestMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ShowChild(1, ID);
    }//GEN-LAST:event_formWindowActivated

    private void jtbChildrenAdopterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbChildrenAdopterMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbChildrenAdopterMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ClearJtxt();
    }//GEN-LAST:event_formWindowClosed

    private void jtbtDel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbtDel1MouseClicked
        Delete();
        ShowChild(1, this.ID);
    }//GEN-LAST:event_jtbtDel1MouseClicked

    private void jtbShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbShowMouseClicked
        ShowChild(1, ID);
    }//GEN-LAST:event_jtbShowMouseClicked

    private void jbtUpdate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdate1MouseClicked
        Update();

    }//GEN-LAST:event_jbtUpdate1MouseClicked

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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private view.JButtonCustom jbtChooseImg;
    private view.JButtonCustom jbtUpdate1;
    private javax.swing.JLabel jlbImage;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JTable jtbChildrenAdopter;
    private view.JButtonCustom jtbRest;
    private view.JButtonCustom jtbShow;
    private view.JButtonCustom jtbtDel1;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtDateAdopt;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtNameImg;
    // End of variables declaration//GEN-END:variables
}
