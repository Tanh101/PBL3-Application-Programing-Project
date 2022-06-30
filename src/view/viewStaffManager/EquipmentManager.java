/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

import controller.EquipmentListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Children;
import model.Equipment;
import model.LocalTime;
import view.AddJframe.AddEquipment;

/**
 *
 * @author ADMIN
 */
public class EquipmentManager extends javax.swing.JFrame {

    private String ID_NVQL;

    public void setID_NVQL(String id) {
        this.ID_NVQL = id;
    }
    private EquipmentListener equipmentListener = new EquipmentListener();
    private AddEquipment addEquip = new AddEquipment();

    /**
     * Creates new form Equipment
     */
    public EquipmentManager() {
        initComponents();
        setWidthTable();
    }

    public void setWidthTable() {
        jtbEquipment.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbEquipment.setBackground(Color.WHITE);
        jtbEquipment.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtbEquipment.getColumnModel().getColumn(1).setPreferredWidth(175);
        jtbEquipment.getColumnModel().getColumn(2).setPreferredWidth(110);
        jtbEquipment.getColumnModel().getColumn(3).setPreferredWidth(250);
        jtbEquipment.getColumnModel().getColumn(4).setPreferredWidth(110);
        jtbEquipment.getColumnModel().getColumn(5).setPreferredWidth(110);
        jtbEquipment.getColumnModel().getColumn(6).setPreferredWidth(110);
//        jtbEquipment.getColumnModel().getColumn(7).setPreferredWidth(110);
        jtbEquipment.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        ((DefaultTableCellRenderer) jtbEquipment.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void showSupport(ArrayList<Equipment> vec) {
        DefaultTableModel model = (DefaultTableModel) jtbEquipment.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID(), vec.get(i).getName(), vec.get(i).getPrice(), vec.get(i).getProviders(),
                vec.get(i).getNumOfGood(), vec.get(i).getNumOfBad(),
                LocalTime.ChangeTypeDate_dMy(vec.get(i).getDateEnter())
            });
        }
        jtbEquipment.setModel(model);
    }

    public void ShowEquip(int i) {
        ArrayList<Equipment> vec = new ArrayList<>();
        vec = equipmentListener.getListEquipment(equipmentListener.getSQLShow(i));
        showSupport(vec);
    }

    public void Delete() {
        addEquip.getJtxtDateEnter().setEnabled(true);
        int k = jtbEquipment.getSelectedRow();
        String ID_Choose = (String) jtbEquipment.getModel().getValueAt(k, 0);
        equipmentListener.Delete(ID_Choose);

    }

    public void getDataFromTableToForm() {
        addEquip.getJtxtDateEnter().setEnabled(true);
        int k = jtbEquipment.getSelectedRow();
        if (k >= 0) {
            String ID_Choose = (String) jtbEquipment.getModel().getValueAt(k, 0);
            addEquip.setIDChosse(ID_Choose);
            ArrayList<Equipment> list = new ArrayList<>();
            Equipment equip = new Equipment();
            list = equipmentListener.FindID(ID_Choose);
            equip = list.get(0);
            addEquip.getJtxtID().setText(equip.getID());
            addEquip.getJtxtName().setText(equip.getName());
            addEquip.getJtxtPrice().setText(equip.getPrice());
            addEquip.getJtxtProvider().setText(equip.getProviders());
            addEquip.getJtxtNumGood().setText(String.valueOf(equip.getNumOfGood()));
            addEquip.getJtxtNumBad().setText(String.valueOf(equip.getNumOfBad()));
            addEquip.getJtxtDateEnter().setText(LocalTime.ChangeTypeDate_dMy(equip.getDateEnter()));
            if (equip.getDateQuit().compareTo("") == 0) {
                addEquip.getJtxtDateQuit().setText("");
            } else {
                addEquip.getJtxtDateQuit().setText(LocalTime.ChangeTypeDate_dMy(equip.getDateQuit()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thiết bị muốn cập nhật");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jbtUpdate = new view.JButtonCustom();
        jtxtFind = new javax.swing.JTextField();
        jbtBadState = new view.JButtonCustom();
        jbtFind = new view.JButtonCustom();
        jbtShow = new view.JButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEquipment = new javax.swing.JTable();
        jbtAdd = new view.JButtonCustom();
        jbtGoodState = new view.JButtonCustom();
        jbtDelel = new view.JButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        jButtonCustom1 = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(365, 85, 85, 85));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(840, 650));
        setSize(new java.awt.Dimension(840, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtUpdate.setBorder(null);
        jbtUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/update_24px.png"))); // NOI18N
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
        jPanel2.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 120, 50));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtFindKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 400, 40));

        jbtBadState.setBorder(null);
        jbtBadState.setText("Tình Trạng Hư");
        jbtBadState.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtBadState.setColoOver(new java.awt.Color(255, 102, 51));
        jbtBadState.setColor(new java.awt.Color(51, 255, 153));
        jbtBadState.setColorClick(new java.awt.Color(0, 204, 255));
        jbtBadState.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtBadState.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtBadState.setRadius(40);
        jbtBadState.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtBadStateMouseClicked(evt);
            }
        });
        jPanel2.add(jbtBadState, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 130, 60));

        jbtFind.setBorder(null);
        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_26px.png"))); // NOI18N
        jbtFind.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtFind.setColoOver(new java.awt.Color(0, 204, 255));
        jbtFind.setColorClick(new java.awt.Color(54, 220, 79));
        jbtFind.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFindMouseClicked(evt);
            }
        });
        jPanel2.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 50, 40));

        jbtShow.setBorder(null);
        jbtShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/list_view_24px.png"))); // NOI18N
        jbtShow.setText("Hiển Thị");
        jbtShow.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtShow.setColoOver(new java.awt.Color(255, 102, 51));
        jbtShow.setColor(new java.awt.Color(51, 255, 153));
        jbtShow.setColorClick(new java.awt.Color(0, 204, 255));
        jbtShow.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtShow.setRadius(40);
        jbtShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtShowMouseClicked(evt);
            }
        });
        jPanel2.add(jbtShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 120, 50));

        jtbEquipment.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbEquipment.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Thiết Bị", "Tên Thiết Bị", "Giá", "Đơn Vị Cung Cấp", "Số TB Tốt", "Số TB Hỏng", "Ngày Nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbEquipment.setGridColor(new java.awt.Color(0, 204, 204));
        jtbEquipment.setOpaque(false);
        jtbEquipment.setRowHeight(40);
        jtbEquipment.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbEquipment.setShowHorizontalLines(true);
        jtbEquipment.setShowVerticalLines(true);
        jtbEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbEquipmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbEquipment);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 1110, 380));

        jbtAdd.setBorder(null);
        jbtAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add_24px.png"))); // NOI18N
        jbtAdd.setText("Thêm");
        jbtAdd.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtAdd.setColoOver(new java.awt.Color(255, 102, 51));
        jbtAdd.setColor(new java.awt.Color(51, 255, 153));
        jbtAdd.setColorClick(new java.awt.Color(0, 204, 255));
        jbtAdd.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtAdd.setRadius(40);
        jbtAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddMouseClicked(evt);
            }
        });
        jPanel2.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 120, 50));

        jbtGoodState.setBorder(null);
        jbtGoodState.setText("Tình Trạng Tốt");
        jbtGoodState.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtGoodState.setColoOver(new java.awt.Color(255, 102, 51));
        jbtGoodState.setColor(new java.awt.Color(51, 255, 153));
        jbtGoodState.setColorClick(new java.awt.Color(0, 204, 255));
        jbtGoodState.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtGoodState.setRadius(40);
        jbtGoodState.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtGoodStateMouseClicked(evt);
            }
        });
        jPanel2.add(jbtGoodState, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 130, 60));

        jbtDelel.setBorder(null);
        jbtDelel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Delete_24px.png"))); // NOI18N
        jbtDelel.setText("Xoá");
        jbtDelel.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDelel.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDelel.setColor(new java.awt.Color(51, 255, 153));
        jbtDelel.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDelel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtDelel.setRadius(40);
        jbtDelel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDelelMouseClicked(evt);
            }
        });
        jPanel2.add(jbtDelel, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 120, 50));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tìm Theo Tên Thiết Bị");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 150, 40));

        jButtonCustom1.setText("X");
        jButtonCustom1.setBoderColor(new java.awt.Color(255, 255, 255));
        jButtonCustom1.setColoOver(new java.awt.Color(255, 51, 51));
        jButtonCustom1.setColorClick(new java.awt.Color(255, 51, 51));
        jButtonCustom1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCustom1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCustom1MouseClicked(evt);
            }
        });
        jPanel2.add(jButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 50, 40));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 650));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 650));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 650));

        setSize(new java.awt.Dimension(1103, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom1MouseClicked

        this.setVisible(false);

    }//GEN-LAST:event_jButtonCustom1MouseClicked

    private void jbtDelelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDelelMouseClicked
        Delete();
        ShowEquip(1);
    }//GEN-LAST:event_jbtDelelMouseClicked

    private void jbtGoodStateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtGoodStateMouseClicked
        ShowEquip(2);
    }//GEN-LAST:event_jbtGoodStateMouseClicked

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        addEquip.getJtxtDateEnter().setText(date.toString());
        addEquip.getJtxtNumBad().setText("0");
        addEquip.getJtxtDateEnter().setEnabled(false);
        addEquip.getJtxtDateQuit().setEnabled(false);
        addEquip.getJbtUpdate().setVisible(false);
        addEquip.getJbtAdd().setVisible(true);
        addEquip.setVisible(true);
    }//GEN-LAST:event_jbtAddMouseClicked

    private void jtbEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbEquipmentMouseClicked

    }//GEN-LAST:event_jtbEquipmentMouseClicked

    private void jbtShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtShowMouseClicked
        jtxtFind.setText("");
        ShowEquip(1);

    }//GEN-LAST:event_jbtShowMouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        ArrayList<Equipment> equip = new ArrayList<Equipment>();
        equip = equipmentListener.FindName("%" + jtxtFind.getText() + "%");
        showSupport(equip);
    }//GEN-LAST:event_jbtFindMouseClicked

    private void jbtBadStateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtBadStateMouseClicked
        ShowEquip(3);
    }//GEN-LAST:event_jbtBadStateMouseClicked

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdateMouseClicked

        addEquip.getJtxtDateEnter().setEnabled(true);
        int k = jtbEquipment.getSelectedRow();
        if (k >= 0) {
            String ID_Choose = (String) jtbEquipment.getModel().getValueAt(k, 0);
            addEquip.setIDChosse(ID_Choose);
            ArrayList<Equipment> list = new ArrayList<>();
            Equipment equip = new Equipment();
            list = equipmentListener.FindID(ID_Choose);
            equip = list.get(0);
            addEquip.getJtxtID().setText(equip.getID());
            addEquip.getJtxtName().setText(equip.getName());
            addEquip.getJtxtPrice().setText(equip.getPrice());
            addEquip.getJtxtProvider().setText(equip.getProviders());
            addEquip.getJtxtNumGood().setText(String.valueOf(equip.getNumOfGood()));
            addEquip.getJtxtNumBad().setText(String.valueOf(equip.getNumOfBad()));
            addEquip.getJtxtDateEnter().setText(LocalTime.ChangeTypeDate_dMy(equip.getDateEnter()));
            if (equip.getDateQuit().compareTo("") == 0) {
                addEquip.getJtxtDateQuit().setText("");
            } else {
                addEquip.getJtxtDateQuit().setText(LocalTime.ChangeTypeDate_dMy(equip.getDateQuit()));
            }
            addEquip.setVisible(true);
            addEquip.getJbtUpdate().setVisible(true);
            addEquip.getJtxtDateQuit().setEnabled(true);
            addEquip.getJbtAdd().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thiết bị muốn cập nhật");
        }
    }//GEN-LAST:event_jbtUpdateMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ShowEquip(1);
        addEquip.setIDNVQL(ID_NVQL);

    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ShowEquip(1);
    }//GEN-LAST:event_formWindowActivated

    private void jtxtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtFindKeyPressed
        if (evt.getKeyCode() ==  KeyEvent.VK_ENTER) {
            ArrayList<Equipment> equip = new ArrayList<Equipment>();
            equip = equipmentListener.FindName("%" + jtxtFind.getText() + "%");
            showSupport(equip);
        }
    }//GEN-LAST:event_jtxtFindKeyPressed

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
            java.util.logging.Logger.getLogger(EquipmentManager.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipmentManager.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipmentManager.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipmentManager.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipmentManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.JButtonCustom jButtonCustom1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtBadState;
    private view.JButtonCustom jbtDelel;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtGoodState;
    private view.JButtonCustom jbtShow;
    private view.JButtonCustom jbtUpdate;
    private javax.swing.JTable jtbEquipment;
    private javax.swing.JTextField jtxtFind;
    // End of variables declaration//GEN-END:variables
}
