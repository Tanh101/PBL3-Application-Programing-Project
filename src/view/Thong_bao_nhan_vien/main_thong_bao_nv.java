/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Thong_bao_nhan_vien;


import thong_bao_cho_trang_chu.*;
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
public class main_thong_bao_nv extends javax.swing.JFrame {

    /**
     * Creates new form Equipment
     */
    private String ID_NVQL =null;

    public String getID_NVQL() {
        return ID_NVQL;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL = ID_NVQL;
    }
    hien_thi_thong_bao_nv a =new hien_thi_thong_bao_nv();
    
    private NotificationListener abc = new NotificationListener();
    public main_thong_bao_nv() {
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
        Vector<Model_message> vec = abc.getListStaffCurent("0");
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_model(),vec.get(i).getHeader(),vec.get(i).getContent()
            });
        }
        jtbStaff.setModel(model);
    }public void showListCurrent(String a) {
        Vector<Model_message> vec = abc.getListStaffCurent(a);
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_model(),vec.get(i).getHeader(),vec.get(i).getContent()
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
    public void Delete(Model_message a)
    {
        abc.Delete(a.getID_model());
    }
    public void See(Model_message a)
    {
       hien_thi_thong_bao_nv b = new hien_thi_thong_bao_nv(a);
       b.setVisible(true);
        
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtbStaffa = new javax.swing.JScrollPane();
        jtbStaff = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        jbtSee = new view.JButtonCustom();
        jbtSend = new view.JButtonCustom();
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

        jtbStaffa.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jtbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jtbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbStaffMouseClicked(evt);
            }
        });
        jtbStaffa.setViewportView(jtbStaff);

        jPanel1.add(jtbStaffa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1010, 230));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG BÁO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 210, 70));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 400, 40));

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
        jPanel1.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 50, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tìm Theo Tên Nội Dung");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 180, 40));

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
        jbtSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSeeActionPerformed(evt);
            }
        });
        jPanel1.add(jbtSee, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 120, 50));

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
        jbtSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSendActionPerformed(evt);
            }
        });
        jPanel1.add(jbtSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 120, 50));

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
        jPanel1.add(jbtReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 120, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 590));

        setSize(new java.awt.Dimension(1017, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void jtbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbStaffMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbStaffMouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        Vector<Model_message> vec = new Vector<Model_message>();
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        if (jtxtFind.getText()=="")
            showListCurrentStaff();
        else{
            vec = abc.Finda("%" + jtxtFind.getText() + "%","0");
            model.setRowCount(0);
            for (int i = 0; i < vec.size(); i++) {
                model.addRow(new Object[]{
                    vec.get(i).getID_model(),vec.get(i).getHeader(),vec.get(i).getContent()
                });
            }
            jtbStaff.setModel(model);
        }
    }//GEN-LAST:event_jbtFindMouseClicked

    private void jbtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFindActionPerformed
        showListCurrentStaff();
    }//GEN-LAST:event_jbtFindActionPerformed

    private void jbtSeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSeeMouseClicked
        Model_message b = getDataFromTable();
        See(b);
    }//GEN-LAST:event_jbtSeeMouseClicked

    private void jbtSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSeeActionPerformed

    private void jbtSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSendMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSendMouseClicked

    private void jbtSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSendActionPerformed
       hien_thi_thong_bao_nv a = new hien_thi_thong_bao_nv();
       a.setID_NVQL(ID_NVQL);
       a.setVisible(true);
    }//GEN-LAST:event_jbtSendActionPerformed

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
                new main_thong_bao_nv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtReset;
    private view.JButtonCustom jbtSee;
    private view.JButtonCustom jbtSend;
    private javax.swing.JTable jtbStaff;
    private javax.swing.JScrollPane jtbStaffa;
    private javax.swing.JTextField jtxtFind;
    // End of variables declaration//GEN-END:variables
}
