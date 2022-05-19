package view.AddJframe;

import controller.EquipmentListener;
import controller.SendID_NVQL;
import java.sql.Date;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextField;
import model.Equipment;
import view.JButtonCustom;
import view.viewStaffManager.EquipmentManager;

public class AddEquipment extends javax.swing.JFrame {

    private EquipmentListener equipListener = new EquipmentListener();

    public String getIDNVQL() {
        return IDNVQL;
    }

    public void setIDNVQL(String IDNVQL) {
        this.IDNVQL = IDNVQL;
    }

    public String getIDChosse() {
        return IDChosse;
    }

    public void setIDChosse(String IDChosse) {
        this.IDChosse = IDChosse;
    }
    String IDNVQL, IDChosse;

    public AddEquipment() {
        initComponents();
    }

    public void Add() {
//        jtxtDateEnter.setEnabled(false);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        String ID = jtxtID.getText();
        String Name = jtxtName.getText();
        String Price = jtxtPrice.getText();
        String NumGood = jtxtNumGood.getText();
        String NumBad = jtxtNumBad.getText();
        String Provider = jtxtProvider.getText();
        String DateEnter = date.toString();
        String DateQuit = jtxtDateQuit.getText();
        if (DateQuit.compareTo("") == 0) {
            DateQuit = null;
        }
        if (ID.isEmpty() || Name.isEmpty() || Price.isEmpty() || NumGood.isEmpty()
                || NumBad.isEmpty() || Provider.isEmpty()) {
            showMessageDialog(null, "Không được để trống thông tin Thiết Bị!");
        } else {
//            System.out.println(ID+ Name+ Price+NumGood+ NumBad+Provider+ getIDNVQL()+ DateEnter+ DateQuit);
            equipListener.Insert(ID, Name, Price, NumGood, NumBad, Provider, getIDNVQL(), DateEnter, DateQuit);
            if (equipListener.FindID(ID) != null) {
                showMessageDialog(null, "Thêm Thành công!");
            } else {
                showMessageDialog(null, "Mã Thiết Bị đã tồn tại! Vui lòng kiểm tra lại");
            }
        }
    }

    public void Update() {

        String ID = jtxtID.getText();
        String Name = jtxtName.getText();
        String Price = jtxtPrice.getText();
        String NumGood = jtxtNumGood.getText();
        String NumBad = jtxtNumBad.getText();
        String Provider = jtxtProvider.getText();
        String DateEnter = jtxtDateEnter.getText();
        String DateQuit = jtxtDateQuit.getText();
        if (DateQuit.compareTo("") == 0) {
            DateQuit = null;
        }
        if (ID.isEmpty() || Name.isEmpty() || Price.isEmpty() || NumGood.isEmpty()
                || NumBad.isEmpty() || Provider.isEmpty()) {
            showMessageDialog(null, "Không được để trống thông tin Thiết Bị!");
        } else {
        
            equipListener.Update(IDChosse, ID, Name, Price, NumGood, NumBad, Provider, getIDNVQL(), DateEnter, DateQuit);
            showMessageDialog(null, "Cập nhật thành công!");

        }
    }

    public void resetForm() {
//        jtxtDateEnter.setEnabled(true);
        jtxtID.setText("");
        jtxtName.setText("");
        jtxtPrice.setText("");
        jtxtProvider.setText("");
        jtxtNumGood.setText("");
        jtxtNumBad.setText("");
        jtxtDateEnter.setText("");
        jtxtDateQuit.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtxtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtNumGood = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtDateEnter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtDateQuit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtProvider = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtNumBad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonCustom1 = new view.JButtonCustom();
        jbtAdd = new view.JButtonCustom();
        jLabel2 = new javax.swing.JLabel();
        jbtUpdate = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 240, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setText("Mã Thiết Bị");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Giá");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, 40));

        jtxtPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 240, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Tên Thiết Bị");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 40));

        jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 240, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Số lượng TB Tốt");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 110, 40));

        jtxtNumGood.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNumGood.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtNumGood, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 240, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Ngày Nhập Vào");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, 40));

        jtxtDateEnter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtDateEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 240, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Ngày Xuất Ra");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 110, 40));

        jtxtDateQuit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtDateQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 240, 40));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel10.setText("Đơn Vị Cung Cấp");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 120, 40));

        jtxtProvider.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtProvider.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 240, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Số Lượng TB hỏng");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 140, 40));

        jtxtNumBad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNumBad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtNumBad, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 240, 40));

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setMinimumSize(new java.awt.Dimension(10, 10));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(10, 10));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 730, -1));

        jLabel11.setBackground(new java.awt.Color(102, 204, 255));
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 10, 170));

        jButtonCustom1.setText("X");
        jButtonCustom1.setBoderColor(new java.awt.Color(255, 255, 255));
        jButtonCustom1.setColoOver(new java.awt.Color(255, 102, 102));
        jButtonCustom1.setColorClick(new java.awt.Color(255, 153, 153));
        jButtonCustom1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCustom1MouseClicked(evt);
            }
        });
        jPanel1.add(jButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 50, 40));

        jbtAdd.setText("Thêm");
        jbtAdd.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtAdd.setColoOver(new java.awt.Color(51, 255, 102));
        jbtAdd.setColor(new java.awt.Color(0, 255, 204));
        jbtAdd.setColorClick(new java.awt.Color(255, 255, 51));
        jbtAdd.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jbtAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtAdd.setRadius(50);
        jbtAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddMouseClicked(evt);
            }
        });
        jPanel1.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 180, 70));

        jLabel2.setBackground(new java.awt.Color(51, 204, 255));
        jLabel2.setMinimumSize(new java.awt.Dimension(10, 10));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(10, 10));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 730, 10));

        jbtUpdate.setText("Cập Nhật");
        jbtUpdate.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUpdate.setColoOver(new java.awt.Color(51, 255, 102));
        jbtUpdate.setColor(new java.awt.Color(0, 255, 204));
        jbtUpdate.setColorClick(new java.awt.Color(255, 255, 51));
        jbtUpdate.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jbtUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtUpdate.setRadius(50);
        jbtUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpdateMouseClicked(evt);
            }
        });
        jPanel1.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 180, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom1MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCustom1MouseClicked

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        Add();
        resetForm();
        this.setVisible(false);
//        equipManager.ShowListEquip();
    }//GEN-LAST:event_jbtAddMouseClicked

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdateMouseClicked
        Update();
        this.setVisible(false);
    }//GEN-LAST:event_jbtUpdateMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        resetForm();
    }//GEN-LAST:event_formWindowClosed

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
//            java.util.logging.Logger.getLogger(AddEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddEquipment().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.JButtonCustom jButtonCustom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtUpdate;
    private javax.swing.JTextField jtxtDateEnter;
    private javax.swing.JTextField jtxtDateQuit;
    private javax.swing.JTextField jtxtID;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtNumBad;
    private javax.swing.JTextField jtxtNumGood;
    private javax.swing.JTextField jtxtPrice;
    private javax.swing.JTextField jtxtProvider;
    // End of variables declaration//GEN-END:variables

    public JButtonCustom getJbtAdd() {
        return jbtAdd;
    }

    public void setJbtAdd(JButtonCustom jbtAdd) {
        this.jbtAdd = jbtAdd;
    }

    public JButtonCustom getJbtUpdate() {
        return jbtUpdate;
    }

    public void setJbtAdd1(JButtonCustom jbtAdd1) {
        this.jbtUpdate = jbtAdd1;
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

    public JTextField getJtxtID() {
        return jtxtID;
    }

    public void setJtxtID(JTextField jtxtID) {
        this.jtxtID = jtxtID;
    }

    public JTextField getJtxtName() {
        return jtxtName;
    }

    public void setJtxtName(JTextField jtxtName) {
        this.jtxtName = jtxtName;
    }

    public JTextField getJtxtNumBad() {
        return jtxtNumBad;
    }

    public void setJtxtNumBad(JTextField jtxtNumBad) {
        this.jtxtNumBad = jtxtNumBad;
    }

    public JTextField getJtxtNumGood() {
        return jtxtNumGood;
    }

    public void setJtxtNumGood(JTextField jtxtNumGood) {
        this.jtxtNumGood = jtxtNumGood;
    }

    public JTextField getJtxtPrice() {
        return jtxtPrice;
    }

    public void setJtxtPrice(JTextField jtxtPrice) {
        this.jtxtPrice = jtxtPrice;
    }

    public JTextField getJtxtProvider() {
        return jtxtProvider;
    }

    public void setJtxtProvider(JTextField jtxtProvider) {
        this.jtxtProvider = jtxtProvider;
    }
}
