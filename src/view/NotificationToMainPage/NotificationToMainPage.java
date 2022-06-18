/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.NotificationToMainPage;

import controller.NotificationListener;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import model.Model_message;

/**
 *
 * @author ADMIN
 */
public class NotificationToMainPage extends javax.swing.JFrame {

    /**
     * Creates new form Equipment
     */
    private String ID_NVQL = null;

    public String getID_NVQL() {
        return ID_NVQL;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL = ID_NVQL;
    }
    Up_DownNotificationToMainPage a = new Up_DownNotificationToMainPage();

    private NotificationListener abc = new NotificationListener();

    public NotificationToMainPage() {
        initComponents();
        showListCurrentStaff();
        setWidthTable();
    }

    public void setWidthTable() {
        jtbStaff.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbStaff.setBackground(Color.WHITE);
        jtbStaff.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtbStaff.getColumnModel().getColumn(1).setPreferredWidth(150);
        jtbStaff.getColumnModel().getColumn(2).setPreferredWidth(175);

        jtbStaff.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        ((DefaultTableCellRenderer) jtbStaff.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void showListCurrentStaff() {
        Vector<Model_message> vec = abc.getListStaffCurent_TT();
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_model(), vec.get(i).getHeader(), vec.get(i).getContent()
            });
        }
        jtbStaff.setModel(model);
    }

    public void showListCurrent(String a) {
        Vector<Model_message> vec = abc.getListStaffCurent(a);
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_model(), vec.get(i).getHeader(), vec.get(i).getContent()
            });
        }
        jtbStaff.setModel(model);
    }

    public Model_message getDataFromTable() {
        int k = jtbStaff.getSelectedRow();
        String ID_Choose = (String) jtbStaff.getModel().getValueAt(k, 0);
        Vector<Model_message> list = new Vector<Model_message>();
        list = abc.FindID(ID_Choose);
        model.Model_message s = list.get(0);
        return s;
    }

    public void Delete(Model_message a) {
        abc.Delete(a.getID_model());
    }

    public void See(Model_message a) {
        Up_DownNotificationToMainPage b = new Up_DownNotificationToMainPage(a);
        b.setID_NVQL(ID_NVQL);
        b.setMESSAGE(a);
        b.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtUp = new view.JButtonCustom();
        jtbStaffa = new javax.swing.JScrollPane();
        jtbStaff = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        jbtSee = new view.JButtonCustom();
        jbtDelete = new view.JButtonCustom();
        jbtSend = new view.JButtonCustom();
        jbtDown = new view.JButtonCustom();
        jbtReset = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(365, 85, 85, 85));
        setUndecorated(true);
        setSize(new java.awt.Dimension(840, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtUp.setBorder(null);
        jbtUp.setText("Trạng thái hiện");
        jbtUp.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUp.setColoOver(new java.awt.Color(255, 102, 51));
        jbtUp.setColor(new java.awt.Color(51, 255, 153));
        jbtUp.setColorClick(new java.awt.Color(0, 204, 255));
        jbtUp.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtUp.setRadius(40);
        jbtUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpMouseClicked(evt);
            }
        });
        jbtUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpActionPerformed(evt);
            }
        });
        jPanel1.add(jbtUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 190, 140, 50));

        jtbStaffa.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jtbStaffa.setAlignmentX(2.0F);
        jtbStaffa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbStaffa.setVerifyInputWhenFocusTarget(false);

        jtbStaff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Thông Báo ", "Tiêu Đề", "Nội dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbStaff.setRowHeight(40);
        jtbStaff.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbStaff.setShowGrid(true);
        jtbStaff.setUpdateSelectionOnSort(false);
        jtbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbStaffMouseClicked(evt);
            }
        });
        jtbStaffa.setViewportView(jtbStaff);
        if (jtbStaff.getColumnModel().getColumnCount() > 0) {
            jtbStaff.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtbStaff.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbStaff.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        jPanel1.add(jtbStaffa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1120, 330));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG BÁO HIỂN THỊ RA TRANG CHỦ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 600, 70));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 400, 40));

        jbtFind.setBorder(null);
        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_24px.png"))); // NOI18N
        jbtFind.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtFind.setColoOver(new java.awt.Color(0, 204, 255));
        jbtFind.setColorClick(new java.awt.Color(54, 220, 79));
        jbtFind.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFindMouseClicked(evt);
            }
        });
        jbtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFindActionPerformed(evt);
            }
        });
        jPanel1.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 50, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tìm Theo Tên Nội Dung");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 180, 40));

        jbtSee.setBorder(null);
        jbtSee.setText("Xem");
        jbtSee.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtSee.setColoOver(new java.awt.Color(255, 102, 51));
        jbtSee.setColor(new java.awt.Color(51, 255, 153));
        jbtSee.setColorClick(new java.awt.Color(0, 204, 255));
        jbtSee.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtSee.setRadius(40);
        jbtSee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSeeMouseClicked(evt);
            }
        });
        jPanel1.add(jbtSee, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 120, 50));

        jbtDelete.setBorder(null);
        jbtDelete.setText("Xóa");
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
        jbtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jbtDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 120, 50));

        jbtSend.setBorder(null);
        jbtSend.setText("Soạn thông báo");
        jbtSend.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtSend.setColoOver(new java.awt.Color(255, 102, 51));
        jbtSend.setColor(new java.awt.Color(51, 255, 153));
        jbtSend.setColorClick(new java.awt.Color(0, 204, 255));
        jbtSend.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtSend.setRadius(40);
        jbtSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSendMouseClicked(evt);
            }
        });
        jPanel1.add(jbtSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 130, 50));

        jbtDown.setBorder(null);
        jbtDown.setText("Trạng thái ẩn");
        jbtDown.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDown.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDown.setColor(new java.awt.Color(51, 255, 153));
        jbtDown.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDown.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtDown.setRadius(40);
        jbtDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDownMouseClicked(evt);
            }
        });
        jbtDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDownActionPerformed(evt);
            }
        });
        jPanel1.add(jbtDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 130, 50));

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
        jbtReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResetActionPerformed(evt);
            }
        });
        jPanel1.add(jbtReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 120, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 590));

        setSize(new java.awt.Dimension(1118, 587));
    }// </editor-fold>//GEN-END:initComponents

    private void jtbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbStaffMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbStaffMouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        Vector<Model_message> vec = new Vector<Model_message>();
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        if (jtxtFind.getText() == "")
            showListCurrentStaff();
        else {
            vec = abc.Finda("%" + jtxtFind.getText() + "%");
            model.setRowCount(0);
            for (int i = 0; i < vec.size(); i++) {
                model.addRow(new Object[]{
                    vec.get(i).getID_model(), vec.get(i).getHeader(), vec.get(i).getContent()
                });
            }
            jtbStaff.setModel(model);
        }
    }//GEN-LAST:event_jbtFindMouseClicked

    private void jbtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFindActionPerformed
        showListCurrentStaff();
    }//GEN-LAST:event_jbtFindActionPerformed

    private void jbtUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtUpMouseClicked

    private void jbtUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpActionPerformed
        showListCurrent("1");
    }//GEN-LAST:event_jbtUpActionPerformed

    private void jbtSeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSeeMouseClicked
        Model_message b = getDataFromTable();
        if (b.getContent().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thông báo muốn xem");
        } else {
            See(b);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jbtSeeMouseClicked

    private void jbtDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeleteMouseClicked
        Model_message b = getDataFromTable();
        Delete(b);
        showListCurrentStaff();
        JOptionPane.showMessageDialog(rootPane, "Thông báo đã xoá");
    }//GEN-LAST:event_jbtDeleteMouseClicked

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDeleteActionPerformed

    private void jbtSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSendMouseClicked
        Up_DownNotificationToMainPage a = new Up_DownNotificationToMainPage();
        a.setID_NVQL(ID_NVQL);
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtSendMouseClicked

    private void jbtDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDownMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDownMouseClicked

    private void jbtDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDownActionPerformed
        showListCurrent("2");
    }//GEN-LAST:event_jbtDownActionPerformed

    private void jbtResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtResetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtResetMouseClicked

    private void jbtResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResetActionPerformed
        showListCurrentStaff();
    }//GEN-LAST:event_jbtResetActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        showListCurrentStaff();
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotificationToMainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private view.JButtonCustom jbtDelete;
    private view.JButtonCustom jbtDown;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtReset;
    private view.JButtonCustom jbtSee;
    private view.JButtonCustom jbtSend;
    private view.JButtonCustom jbtUp;
    private javax.swing.JTable jtbStaff;
    private javax.swing.JScrollPane jtbStaffa;
    private javax.swing.JTextField jtxtFind;
    // End of variables declaration//GEN-END:variables
}
