/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.NotificationToStaff;

//import thong_bao_cho_trang_chu.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import model.Model_message;
import controller.NotificationListener;

/**
 *
 * @author ADMIN
 */
public class NotificationToStaff extends javax.swing.JFrame {

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
    SendMessage a = new SendMessage();

    private NotificationListener abc = new NotificationListener();

    public NotificationToStaff() {
        initComponents();
        showListCurrentStaff();
        setWidthTable();
    }

    public void setWidthTable() {
        jtbNotificationToStaff.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbNotificationToStaff.setBackground(Color.WHITE);
        jtbNotificationToStaff.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtbNotificationToStaff.getColumnModel().getColumn(1).setPreferredWidth(150);
        jtbNotificationToStaff.getColumnModel().getColumn(2).setPreferredWidth(175);

        jtbNotificationToStaff.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        ((DefaultTableCellRenderer) jtbNotificationToStaff.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void showListCurrentStaff() {
        Vector<Model_message> vec = abc.getListStaffCurent("0");
        DefaultTableModel model = (DefaultTableModel) jtbNotificationToStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_model(), vec.get(i).getHeader(), vec.get(i).getContent()
            });
        }
        jtbNotificationToStaff.setModel(model);
    }

    public void showListCurrent(String a) {
        Vector<Model_message> vec = abc.getListStaffCurent(a);
        DefaultTableModel model = (DefaultTableModel) jtbNotificationToStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_model(), vec.get(i).getHeader(), vec.get(i).getContent()
            });
        }
        jtbNotificationToStaff.setModel(model);
    }

    public Model_message getDataFromTable() {
        int k = jtbNotificationToStaff.getSelectedRow();
        String ID_Choose = (String) jtbNotificationToStaff.getModel().getValueAt(k, 0);
        Vector<Model_message> list = new Vector<Model_message>();
        list = abc.FindID(ID_Choose);
        model.Model_message s = list.get(0);
        return s;
    }

    public void Delete(Model_message a) {
        abc.Delete(a.getID_model());
    }

    public void See(Model_message a) {
        SendMessage b = new SendMessage(a);
//       b.setMESSAGE(a);
//       b.setID_NVQL(ID_NVQL);
        b.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtbStaff = new javax.swing.JScrollPane();
        jtbNotificationToStaff = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        jbtSee = new view.JButtonCustom();
        jbtSend = new view.JButtonCustom();

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

        jtbStaff.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jtbStaff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtbStaff.setRowHeaderView(null);

        jtbNotificationToStaff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtbNotificationToStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jtbNotificationToStaff.setRowHeight(40);
        jtbNotificationToStaff.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jtbNotificationToStaff.setShowGrid(true);
        jtbNotificationToStaff.setUpdateSelectionOnSort(false);
        jtbNotificationToStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbNotificationToStaffMouseClicked(evt);
            }
        });
        jtbStaff.setViewportView(jtbNotificationToStaff);
        if (jtbNotificationToStaff.getColumnModel().getColumnCount() > 0) {
            jtbNotificationToStaff.getColumnModel().getColumn(0).setPreferredWidth(110);
            jtbNotificationToStaff.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbNotificationToStaff.getColumnModel().getColumn(2).setPreferredWidth(350);
        }

        jPanel1.add(jtbStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1090, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG BÁO CHO CÁN BỘ NHÂN VIÊN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 460, 70));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 400, 40));

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
        jPanel1.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 50, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tìm theo tiêu đề");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 130, 40));

        jbtSee.setBorder(null);
        jbtSee.setText("Xem Thông Báo");
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
        jbtSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSeeActionPerformed(evt);
            }
        });
        jPanel1.add(jbtSee, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 150, 60));

        jbtSend.setBorder(null);
        jbtSend.setText("Soạn Thông Báo");
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
        jPanel1.add(jbtSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 150, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 580));

        setSize(new java.awt.Dimension(1079, 576));
    }// </editor-fold>//GEN-END:initComponents

    private void jtbNotificationToStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNotificationToStaffMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbNotificationToStaffMouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        Vector<Model_message> vec = new Vector<Model_message>();
        DefaultTableModel model = (DefaultTableModel) jtbNotificationToStaff.getModel();
        if (jtxtFind.getText() == "")
            showListCurrentStaff();
        else {
            vec = abc.Finda("%" + jtxtFind.getText() + "%", "0");
            model.setRowCount(0);
            for (int i = 0; i < vec.size(); i++) {
                model.addRow(new Object[]{
                    vec.get(i).getID_model(), vec.get(i).getHeader(), vec.get(i).getContent()
                });
            }
            jtbNotificationToStaff.setModel(model);
        }
    }//GEN-LAST:event_jbtFindMouseClicked

    private void jbtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFindActionPerformed
        showListCurrentStaff();
    }//GEN-LAST:event_jbtFindActionPerformed

    private void jbtSeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSeeMouseClicked
        Model_message b = getDataFromTable();
        See(b);
        this.setVisible(false);
    }//GEN-LAST:event_jbtSeeMouseClicked

    private void jbtSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSeeActionPerformed

    private void jbtSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSendMouseClicked
        SendMessage a = new SendMessage();
        a.setID_NVQL(ID_NVQL);
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtSendMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        showListCurrentStaff();
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotificationToStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtSee;
    private view.JButtonCustom jbtSend;
    private javax.swing.JTable jtbNotificationToStaff;
    private javax.swing.JScrollPane jtbStaff;
    private javax.swing.JTextField jtxtFind;
    // End of variables declaration//GEN-END:variables
}
