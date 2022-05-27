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
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Children;
import model.IntroduceChildren;
import view.viewStaffManager.*;

/**
 *
 * @author ADMIN
 */
public class ChildrenIntroduction extends javax.swing.JFrame {

    private String url = "D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\ChildrenImage\\";
    private ChildrenListener childrenListener = new ChildrenListener();
    String IDNVQL, ID;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setIDNVQL(String IDNVQL) {
        this.IDNVQL = IDNVQL;

    }

    public ChildrenIntroduction() {
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
        jtxtDateIntroduce.setText("");
        jtxtFind.setText("");
        jtxtSituation.setText("");
        jradioFemale.setSelected(false);
        jradioFemale.setSelected(false);

    }

    public void setWidthTable() {
        jtbChildrenIntro.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbChildrenIntro.setBackground(Color.WHITE);
        jtbChildrenIntro.getColumnModel().getColumn(0).setPreferredWidth(90);
        jtbChildrenIntro.getColumnModel().getColumn(1).setPreferredWidth(180);
        jtbChildrenIntro.getColumnModel().getColumn(2).setPreferredWidth(110);
        jtbChildrenIntro.getColumnModel().getColumn(3).setPreferredWidth(180);
        jtbChildrenIntro.getColumnModel().getColumn(4).setPreferredWidth(110);
        jtbChildrenIntro.getColumnModel().getColumn(5).setPreferredWidth(110);
        jtbChildrenIntro.getColumnModel().getColumn(6).setPreferredWidth(110);
        jtbChildrenIntro.getColumnModel().getColumn(7).setPreferredWidth(110);
        jtbChildrenIntro.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        ((DefaultTableCellRenderer) jtbChildrenIntro.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void getDataFromTable() {
        int k = jtbChildrenIntro.getSelectedRow();
        String ID_Choose = (String) jtbChildrenIntro.getModel().getValueAt(k, 0);
        ArrayList<IntroduceChildren> list = new ArrayList<IntroduceChildren>();
        list = childrenListener.FindChildIntro(1, ID, ID_Choose);
        IntroduceChildren ic = list.get(0);
        jtxtName.setText(ic.getName());
        jtxtDOB.setText(ic.getDOB());
        jtxtAddress.setText(ic.getAddress());
        if (ic.getGender().compareTo("Nam") == 0) {
            jradioMale.setSelected(true);
        } else {
            jradioFemale.setSelected(true);
        }
        jtxtNameImg.setText(ic.getUrlImg());
        jlbImage.setIcon(ResizeImage(url + ic.getUrlImg()));
        jtxtSituation.setText(ic.getSituation());
        jtxtDateIntroduce.setText(ic.getDateIntroduce());
    }

    public void showSupport(ArrayList<IntroduceChildren> list) {
        DefaultTableModel model = (DefaultTableModel) jtbChildrenIntro.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                list.get(i).getID_TRE(), list.get(i).getName(), list.get(i).getDOB(), list.get(i).getAddress(),
                list.get(i).getGender(), list.get(i).getSituation(), list.get(i).getState(), list.get(i).getDateIntroduce()
            });
        }
        jtbChildrenIntro.setModel(model);
    }

    public void ShowChild(int i, String ID) {
        ArrayList<IntroduceChildren> list = new ArrayList<>();
        list = childrenListener.listIntroduceChildren(i, ID);
        showSupport(list);
    }

    public void Find(int i, String Name) {
        showSupport(childrenListener.FindChildIntro(i, ID, Name));
    }

    public void Delete() {
        int k = jtbChildrenIntro.getSelectedRow();
        String ID_Choose = (String) jtbChildrenIntro.getModel().getValueAt(k, 0);
        childrenListener.Delete(ID_Choose);
    }

    public void Add() {
        int k = jtbChildrenIntro.getSelectedRow();
        String ID_Choose = (String) jtbChildrenIntro.getModel().getValueAt(k, 0);
        ArrayList<Children> list = new ArrayList<>();
        list = childrenListener.getListChildren(childrenListener.proShowChild(1));
        String tmp = list.get(list.size() - 1).getID_TRE();
        String[] arr = tmp.split("TRE", 2);

        String ID = "TRE";
        if (arr[1].length() == 3 && String.valueOf(Integer.parseInt(arr[1]) + 1).length() == 1) {
            ID += "00";
        } else {
            ID += "0";
        }
        int tmp2 = Integer.parseInt(arr[1]) + 1;
        ID += String.valueOf(tmp2);

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        DateFormat df = new SimpleDateFormat("yyyy-MM-d");
        String DateEnter = df.format(date);
//        System.out.println(DateEnter);
        childrenListener.UpdateState(ID_Choose, ID, "1", Integer.parseInt(IDNVQL), DateEnter, null, "1");
        
    }
    
    public void Update(){
        
    }

//    public void FindID(String ID) {
//        ArrayList<Children> list = new ArrayList<>();
//        list = childrenListener.FindID(ID);
//        showSupport(list);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtxtDateIntroduce = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtxtNameImg = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbChildrenIntro = new javax.swing.JTable();
        jtxtDOB = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtAddress = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jbtAdd1 = new view.JButtonCustom();
        jbtChooseImg = new view.JButtonCustom();
        jtbtDel1 = new view.JButtonCustom();
        jlbImage = new javax.swing.JLabel();
        jbtUpdate2 = new view.JButtonCustom();
        jtxtSituation = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jradioMale = new javax.swing.JRadioButton();
        jradioFemale = new javax.swing.JRadioButton();
        jtbRest = new view.JButtonCustom();
        jLabel12 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jtbFind = new view.JButtonCustom();

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
        jLabel7.setText("Ngày giới thiệu");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 110, 40));

        jtxtDateIntroduce.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateIntroduce.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDateIntroduce, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 260, 40));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel13.setText("Hoàn cảnh");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 90, 40));

        jtxtNameImg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameImg.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtNameImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 180, 30));

        jtbChildrenIntro.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbChildrenIntro.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID_TRE", "Tên Trẻ", "Ngày sinh", "Địa Chỉ", "Giới tính", "Hoàn cảnh", "Trạng thái", "Ngày giới thiệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbChildrenIntro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbChildrenIntro.setGridColor(new java.awt.Color(0, 204, 204));
        jtbChildrenIntro.setOpaque(false);
        jtbChildrenIntro.setRowHeight(40);
        jtbChildrenIntro.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbChildrenIntro.setShowHorizontalLines(true);
        jtbChildrenIntro.setShowVerticalLines(true);
        jtbChildrenIntro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbChildrenIntroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbChildrenIntro);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1200, 340));

        jtxtDOB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 260, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel14.setText("Địa chỉ");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 100, 40));

        jLabel15.setBackground(new java.awt.Color(153, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel15.setOpaque(true);
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 10, 140));

        jtxtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 260, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel16.setText("Ngày sinh");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 120, 40));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel17.setText("Tên trẻ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 90, 40));

        jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 260, 40));

        jbtAdd1.setBorder(null);
        jbtAdd1.setText("Thêm vào trung tâm");
        jbtAdd1.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtAdd1.setColoOver(new java.awt.Color(255, 102, 51));
        jbtAdd1.setColor(new java.awt.Color(51, 255, 153));
        jbtAdd1.setColorClick(new java.awt.Color(0, 204, 255));
        jbtAdd1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtAdd1.setRadius(40);
        jbtAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAdd1MouseClicked(evt);
            }
        });
        jPanel3.add(jbtAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 220, 50));

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
        jPanel3.add(jtbtDel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 120, 50));
        jPanel3.add(jlbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, 150));

        jbtUpdate2.setBorder(null);
        jbtUpdate2.setText("Cập Nhật");
        jbtUpdate2.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUpdate2.setColoOver(new java.awt.Color(255, 102, 51));
        jbtUpdate2.setColor(new java.awt.Color(51, 255, 153));
        jbtUpdate2.setColorClick(new java.awt.Color(0, 204, 255));
        jbtUpdate2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtUpdate2.setRadius(40);
        jbtUpdate2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpdate2MouseClicked(evt);
            }
        });
        jPanel3.add(jbtUpdate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 120, 50));

        jtxtSituation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtSituation.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtSituation, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 260, 40));

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

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setText("Tìm theo tên trẻ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 170, 40));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 310, 40));

        jtbFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_24px.png"))); // NOI18N
        jtbFind.setBoderColor(new java.awt.Color(242, 242, 242));
        jtbFind.setColoOver(new java.awt.Color(153, 255, 204));
        jtbFind.setColor(new java.awt.Color(242, 242, 242));
        jtbFind.setColorClick(new java.awt.Color(102, 255, 153));
        jtbFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbFindMouseClicked(evt);
            }
        });
        jPanel1.add(jtbFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 50, 40));

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
    }//GEN-LAST:event_jtbRestMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ShowChild(1, this.ID);
    }//GEN-LAST:event_formWindowActivated

    private void jtbChildrenIntroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbChildrenIntroMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbChildrenIntroMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ClearJtxt();
    }//GEN-LAST:event_formWindowClosed

    private void jtbtDel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbtDel1MouseClicked
        Delete();
        ShowChild(1, this.ID);
    }//GEN-LAST:event_jtbtDel1MouseClicked

    private void jtbFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFindMouseClicked
        String Name = jtxtName.getText();
        Find(2, Name);
    }//GEN-LAST:event_jtbFindMouseClicked

    private void jbtAdd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdd1MouseClicked
        Add();
        ShowChild(1, ID);
    }//GEN-LAST:event_jbtAdd1MouseClicked

    private void jbtUpdate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdate2MouseClicked
        Update();
    }//GEN-LAST:event_jbtUpdate2MouseClicked

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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private view.JButtonCustom jbtAdd1;
    private view.JButtonCustom jbtChooseImg;
    private view.JButtonCustom jbtUpdate2;
    private javax.swing.JLabel jlbImage;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JTable jtbChildrenIntro;
    private view.JButtonCustom jtbFind;
    private view.JButtonCustom jtbRest;
    private view.JButtonCustom jtbtDel1;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtDateIntroduce;
    private javax.swing.JTextField jtxtFind;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtNameImg;
    private javax.swing.JTextField jtxtSituation;
    // End of variables declaration//GEN-END:variables
}
