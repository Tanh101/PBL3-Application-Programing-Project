/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

/**
 *
 * @author ADMIN
 */
public class demo1 extends javax.swing.JFrame {

    /**
     * Creates new form ư
     */
    public demo1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtNameActi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtDateQuit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtDateEnter = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCharityActi = new javax.swing.JTable();
        jtxtSuport = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtNameOrgani = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtID = new javax.swing.JTextField();
        jbtAdd = new view.JButtonCustom();
        jbtUpdate = new view.JButtonCustom();
        jbttNowActi = new view.JButtonCustom();
        jbtReset = new view.JButtonCustom();
        jtbtDel = new view.JButtonCustom();
        jtbtStopActi = new view.JButtonCustom();
        jbtResest1 = new view.JButtonCustom();
        jLabel12 = new javax.swing.JLabel();
        jtxtFind1 = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Tên Hoạt Động");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 110, 40));

        jtxtNameActi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameActi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(jtxtNameActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 260, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Thời Gian Kết Thúc");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 140, 40));

        jtxtDateQuit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(jtxtDateQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 260, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Thời Gian Bắt Đầu");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 140, 40));

        jtxtDateEnter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(jtxtDateEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 260, 40));

        jtbCharityActi.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbCharityActi.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Tổ Chức", "Tên Tổ Chức", "Tên Hoạt Động", "Thời Gian Bắt Đầu", "Thời Gian Kết Thúc", "Tiền/Hiện Vật Ủng Hộ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbCharityActi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbCharityActi.setGridColor(new java.awt.Color(0, 204, 204));
        jtbCharityActi.setOpaque(false);
        jtbCharityActi.setRowHeight(40);
        jtbCharityActi.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbCharityActi.setShowHorizontalLines(true);
        jtbCharityActi.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jtbCharityActi);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1110, 340));

        jtxtSuport.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtSuport.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(jtxtSuport, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 260, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Tên Tổ Chức");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 100, 40));

        jLabel10.setBackground(new java.awt.Color(153, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel10.setOpaque(true);
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 10, 140));

        jtxtNameOrgani.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameOrgani.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(jtxtNameOrgani, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 260, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setText("Tiền/Hiện vật ủng hộ");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 150, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel11.setText("Mã Tổ Chức");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 100, 40));

        jtxtID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel4.add(jtxtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 260, 40));

        jbtAdd.setBorder(null);
        jbtAdd.setText("Thêm");
        jbtAdd.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtAdd.setColoOver(new java.awt.Color(255, 102, 51));
        jbtAdd.setColor(new java.awt.Color(51, 255, 153));
        jbtAdd.setColorClick(new java.awt.Color(0, 204, 255));
        jbtAdd.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtAdd.setRadius(40);
        jPanel4.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, 50));

        jbtUpdate.setBorder(null);
        jbtUpdate.setText("Cập Nhật");
        jbtUpdate.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUpdate.setColoOver(new java.awt.Color(255, 102, 51));
        jbtUpdate.setColor(new java.awt.Color(51, 255, 153));
        jbtUpdate.setColorClick(new java.awt.Color(0, 204, 255));
        jbtUpdate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtUpdate.setRadius(40);
        jPanel4.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 120, 50));

        jbttNowActi.setBorder(null);
        jbttNowActi.setText("Hoạt động hiện tại");
        jbttNowActi.setBoderColor(new java.awt.Color(255, 255, 255));
        jbttNowActi.setColoOver(new java.awt.Color(255, 102, 51));
        jbttNowActi.setColor(new java.awt.Color(51, 255, 153));
        jbttNowActi.setColorClick(new java.awt.Color(0, 204, 255));
        jbttNowActi.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbttNowActi.setRadius(40);
        jPanel4.add(jbttNowActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 150, 50));

        jbtReset.setBorder(null);
        jbtReset.setText("Làm mới");
        jbtReset.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtReset.setColoOver(new java.awt.Color(255, 102, 51));
        jbtReset.setColor(new java.awt.Color(51, 255, 153));
        jbtReset.setColorClick(new java.awt.Color(0, 204, 255));
        jbtReset.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtReset.setRadius(40);
        jPanel4.add(jbtReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 120, 50));

        jtbtDel.setBorder(null);
        jtbtDel.setText("Xoá");
        jtbtDel.setBoderColor(new java.awt.Color(255, 255, 255));
        jtbtDel.setColoOver(new java.awt.Color(255, 102, 51));
        jtbtDel.setColor(new java.awt.Color(51, 255, 153));
        jtbtDel.setColorClick(new java.awt.Color(0, 204, 255));
        jtbtDel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jtbtDel.setRadius(40);
        jPanel4.add(jtbtDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 120, 50));

        jtbtStopActi.setBorder(null);
        jtbtStopActi.setText("Hoạt động đã ngưng");
        jtbtStopActi.setBoderColor(new java.awt.Color(255, 255, 255));
        jtbtStopActi.setColoOver(new java.awt.Color(255, 102, 51));
        jtbtStopActi.setColor(new java.awt.Color(51, 255, 153));
        jtbtStopActi.setColorClick(new java.awt.Color(0, 204, 255));
        jtbtStopActi.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jtbtStopActi.setRadius(40);
        jPanel4.add(jtbtStopActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, 180, 50));

        jTabbedPane1.addTab("tab1", jPanel4);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 1160, 650));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1110, 600));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1110, 660));

        jbtResest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset_24px.png"))); // NOI18N
        jbtResest1.setBoderColor(new java.awt.Color(242, 242, 242));
        jbtResest1.setColoOver(new java.awt.Color(153, 255, 204));
        jbtResest1.setColor(new java.awt.Color(242, 242, 242));
        jbtResest1.setColorClick(new java.awt.Color(102, 255, 153));
        jPanel1.add(jbtResest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setText("Tìm Theo Tên Tổ Chức");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 170, 40));

        jtxtFind1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 310, 40));

        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_24px.png"))); // NOI18N
        jbtFind.setBoderColor(new java.awt.Color(242, 242, 242));
        jbtFind.setColoOver(new java.awt.Color(153, 255, 204));
        jbtFind.setColor(new java.awt.Color(242, 242, 242));
        jbtFind.setColorClick(new java.awt.Color(102, 255, 153));
        jPanel1.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1120, 700));

        setSize(new java.awt.Dimension(1133, 713));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(demo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(demo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(demo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(demo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new demo1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtResest1;
    private view.JButtonCustom jbtReset;
    private view.JButtonCustom jbtUpdate;
    private view.JButtonCustom jbttNowActi;
    private javax.swing.JTable jtbCharityActi;
    private view.JButtonCustom jtbtDel;
    private view.JButtonCustom jtbtStopActi;
    private javax.swing.JTextField jtxtDateEnter;
    private javax.swing.JTextField jtxtDateQuit;
    private javax.swing.JTextField jtxtFind1;
    private javax.swing.JTextField jtxtID;
    private javax.swing.JTextField jtxtNameActi;
    private javax.swing.JTextField jtxtNameOrgani;
    private javax.swing.JTextField jtxtSuport;
    // End of variables declaration//GEN-END:variables
}