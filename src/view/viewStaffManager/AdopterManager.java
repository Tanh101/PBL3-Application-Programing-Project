/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

import controller.AdopterListener;
import controller.IntroductorListener;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Adopter;
import model.Introductor;
import view.AddJframe.ChildrenAdopted;

/**
 *
 * @author ADMIN
 */
public class AdopterManager extends javax.swing.JFrame {
    AdopterListener adop = new AdopterListener();
    ChildrenAdopted chilAdop = new ChildrenAdopted();
    public String getID_NVQL() {
        return ID_NVQL;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL = ID_NVQL;
    }
    private String ID_NVQL;
    
    
    
    /**
     * Creates new form ư
     */
    public AdopterManager() {
        initComponents();
        setWidthTable();
    }
    
    public void setWidthTable() {

        jtbAdopter.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbAdopter.setBackground(Color.WHITE);
        jtbAdopter.getColumnModel().getColumn(0).setPreferredWidth(130);
        jtbAdopter.getColumnModel().getColumn(1).setPreferredWidth(250);
        jtbAdopter.getColumnModel().getColumn(2).setPreferredWidth(130);
        jtbAdopter.getColumnModel().getColumn(3).setPreferredWidth(130);
        jtbAdopter.getColumnModel().getColumn(4).setPreferredWidth(200);
        jtbAdopter.getColumnModel().getColumn(5).setPreferredWidth(130);
        jtbAdopter.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 17));
        ((DefaultTableCellRenderer) jtbAdopter.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void ClearText() {
        jtxtFind.setText("");
        jtxtNameIntro.setText("");
        jtxtAddress.setText("");
        jtxtDOB.setText("");
        jtxtPhoneNumber.setText("");
        jradioFemale.setSelected(false);
        jradioMale.setSelected(false);
        jtxtCCCD.setText("");
    }

    public void Statistic() {
        ArrayList<Adopter> list = new ArrayList<>();
        list = adop.getListAdop();
        jlbAmount.setText("Tổng số người nhận nuôi:  " + String.valueOf(list.size()));
    }

    public void getDataFromTable() {
        int k = jtbAdopter.getSelectedRow();
        String ID_Choose = (String) jtbAdopter.getModel().getValueAt(k, 0);
        ArrayList<Adopter> list = new ArrayList<Adopter>();
        list = adop.FindAdop(1, ID_Choose);
        Adopter adopter = list.get(0);
        jtxtCCCD.setText(adopter.getCCCD());
        jtxtNameIntro.setText(adopter.getName());
        jtxtAddress.setText(adopter.getAddress());
        jtxtDOB.setText(adopter.getDOB());
        jtxtPhoneNumber.setText(adopter.getPhoneNumber());
        if (adopter.getGender().toUpperCase().compareTo("NAM") == 0) {
            jradioMale.setSelected(true);
        } else {
            jradioFemale.setSelected(true);
        }
    }

    public void showSupport(ArrayList<Adopter> list) {
        DefaultTableModel model = (DefaultTableModel) jtbAdopter.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                list.get(i).getCCCD(), list.get(i).getName(),list.get(i).getDOB(), 
                list.get(i).getGender(),list.get(i).getAddress(),list.get(i).getPhoneNumber()
            });
        }
        jtbAdopter.setModel(model);
    }

    public void Show() {
        ArrayList<Adopter> list = new ArrayList<>();
        list = adop.getListAdop();
        showSupport(list);
    }
    
    public void Update() {
        int k = jtbAdopter.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn đối tượng muốn cập nhật");
        } else {
            String CCCD_Choose = (String) jtbAdopter.getModel().getValueAt(k, 0);
            String CCCD = jtxtCCCD.getText();
            String Name = jtxtNameIntro.getText();
            String DOB = jtxtDOB.getText();
            String Gender;
            if (jradioMale.isSelected() == true) {
                Gender = "Nam";
            } else {
                Gender = "Nữ";
            }
            String Address = jtxtAddress.getText();
            String Phone = jtxtPhoneNumber.getText();
            if (Name.isEmpty() || DOB.isEmpty() || Address.isEmpty() || Phone.isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin người nhận nuôi");
            } else {
                adop.UpdateAdopter(CCCD_Choose, CCCD, Name, DOB, Gender, Address, Phone, Integer.parseInt(ID_NVQL));
            }
        }
    }

    public void Find(int i) {
        String Text = jtxtFind.getText();
        ArrayList<Adopter> list = adop.FindAdop(i, Text);
        showSupport(list);
    }
    
    public void Delete(){
        int k = jtbAdopter.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn đối tượng muốn cập nhật");
        } else {
            String CCCD_Choose = (String) jtbAdopter.getModel().getValueAt(k, 0);
            adop.DeleteAdopter(CCCD_Choose);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtxtPhoneNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbAdopter = new javax.swing.JTable();
        jtxtAddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtDOB = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtNameIntro = new javax.swing.JTextField();
        jbtUpdate = new view.JButtonCustom();
        jbtDisplay = new view.JButtonCustom();
        jbtDelete = new view.JButtonCustom();
        jbtWatch = new view.JButtonCustom();
        jLabel9 = new javax.swing.JLabel();
        jradioMale = new javax.swing.JRadioButton();
        jradioFemale = new javax.swing.JRadioButton();
        jtxtCCCD = new javax.swing.JTextField();
        jlbAmount = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jbtResest1 = new view.JButtonCustom();
        jLabel12 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Số điện thoại");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 110, 40));

        jtxtPhoneNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPhoneNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 260, 40));

        jtbAdopter.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbAdopter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ Và Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbAdopter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbAdopter.setGridColor(new java.awt.Color(0, 204, 204));
        jtbAdopter.setOpaque(false);
        jtbAdopter.setRowHeight(40);
        jtbAdopter.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbAdopter.setShowHorizontalLines(true);
        jtbAdopter.setShowVerticalLines(true);
        jtbAdopter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbAdopterMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbAdopter);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1200, 340));

        jtxtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 260, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel14.setText("Ngày sinh");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 40));

        jLabel15.setBackground(new java.awt.Color(153, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel15.setOpaque(true);
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 10, 120));

        jtxtDOB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 260, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel16.setText("Địa chỉ");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 100, 40));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel17.setText("Họ và tên");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 100, 40));

        jtxtNameIntro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameIntro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtNameIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 260, 40));

        jbtUpdate.setBorder(null);
        jbtUpdate.setText("Cập Nhật");
        jbtUpdate.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUpdate.setColoOver(new java.awt.Color(255, 102, 51));
        jbtUpdate.setColor(new java.awt.Color(51, 255, 153));
        jbtUpdate.setColorClick(new java.awt.Color(0, 204, 255));
        jbtUpdate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtUpdate.setRadius(40);
        jbtUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpdateMouseClicked(evt);
            }
        });
        jPanel3.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 120, 50));

        jbtDisplay.setBorder(null);
        jbtDisplay.setText("Hiển Thị");
        jbtDisplay.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDisplay.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDisplay.setColor(new java.awt.Color(51, 255, 153));
        jbtDisplay.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDisplay.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtDisplay.setRadius(40);
        jbtDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDisplayMouseClicked(evt);
            }
        });
        jPanel3.add(jbtDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 120, 50));

        jbtDelete.setBorder(null);
        jbtDelete.setText("Xoá");
        jbtDelete.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDelete.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDelete.setColor(new java.awt.Color(51, 255, 153));
        jbtDelete.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDelete.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtDelete.setRadius(40);
        jbtDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDeleteMouseClicked(evt);
            }
        });
        jPanel3.add(jbtDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, 120, 50));

        jbtWatch.setBorder(null);
        jbtWatch.setText("Xem trẻ được nhận nuôi");
        jbtWatch.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtWatch.setColoOver(new java.awt.Color(255, 102, 51));
        jbtWatch.setColor(new java.awt.Color(51, 255, 153));
        jbtWatch.setColorClick(new java.awt.Color(0, 204, 255));
        jbtWatch.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtWatch.setRadius(40);
        jbtWatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtWatchMouseClicked(evt);
            }
        });
        jPanel3.add(jbtWatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 230, 50));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Giới Tính");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 90, 40));

        buttonGroup1.add(jradioMale);
        jradioMale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioMale.setText("Nam");
        jPanel3.add(jradioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, -1, -1));

        buttonGroup1.add(jradioFemale);
        jradioFemale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioFemale.setText("Nữ");
        jPanel3.add(jradioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 190, -1, -1));

        jtxtCCCD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtCCCD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 260, 40));

        jlbAmount.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jlbAmount.setText("Tổng số người nhận nuôi: ");
        jPanel3.add(jlbAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 270, 40));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel19.setText("Số CCCD");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 100, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 660));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1190, 660));

        jbtResest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset_24px.png"))); // NOI18N
        jbtResest1.setBoderColor(new java.awt.Color(255, 255, 102));
        jbtResest1.setColoOver(new java.awt.Color(102, 255, 102));
        jbtResest1.setColor(new java.awt.Color(255, 255, 102));
        jbtResest1.setColorClick(new java.awt.Color(0, 204, 51));
        jPanel1.add(jbtResest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setText("Tìm theo họ tên");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 170, 40));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 310, 40));

        jbtFind.setBackground(new java.awt.Color(255, 255, 102));
        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_24px.png"))); // NOI18N
        jbtFind.setBoderColor(new java.awt.Color(255, 255, 102));
        jbtFind.setColoOver(new java.awt.Color(102, 255, 204));
        jbtFind.setColor(new java.awt.Color(255, 255, 102));
        jbtFind.setColorClick(new java.awt.Color(102, 255, 153));
        jbtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFindMouseClicked(evt);
            }
        });
        jPanel1.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1190, 700));

        setSize(new java.awt.Dimension(1191, 701));
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Show();
        ClearText();
        Statistic();
    }//GEN-LAST:event_formWindowActivated

    private void jbtDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDisplayMouseClicked
        Show();
        ClearText();
        Statistic();
    }//GEN-LAST:event_jbtDisplayMouseClicked

    private void jtbAdopterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbAdopterMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbAdopterMouseClicked

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdateMouseClicked
        Update();
        Show();
    }//GEN-LAST:event_jbtUpdateMouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        Find(2);
        
    }//GEN-LAST:event_jbtFindMouseClicked

    private void jbtWatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtWatchMouseClicked
        int k = jtbAdopter.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn đối tượng muốn xem");
        } else {
            String CCCD_Choose = (String) jtbAdopter.getModel().getValueAt(k, 0);
            chilAdop.setID(CCCD_Choose);
        }
        chilAdop.setVisible(true);
    }//GEN-LAST:event_jbtWatchMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        chilAdop.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void jbtDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeleteMouseClicked
       Delete();
       Statistic();
        Show();
    }//GEN-LAST:event_jbtDeleteMouseClicked

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
//            java.util.logging.Logger.getLogger(AdopterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdopterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdopterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdopterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdopterManager().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private view.JButtonCustom jbtDelete;
    private view.JButtonCustom jbtDisplay;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtResest1;
    private view.JButtonCustom jbtUpdate;
    private view.JButtonCustom jbtWatch;
    private javax.swing.JLabel jlbAmount;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JTable jtbAdopter;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtCCCD;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtFind;
    private javax.swing.JTextField jtxtNameIntro;
    private javax.swing.JTextField jtxtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
