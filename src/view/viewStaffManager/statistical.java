/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

/**
 *
 * @author ADMIN
 */
public class statistical extends javax.swing.JFrame {

    /**
     * Creates new form ư
     */
    public statistical() {
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
        jLabel7 = new javax.swing.JLabel();
        jtxtDateQuit1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtxtDateEnter1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCharityActi1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jbtAdd1 = new view.JButtonCustom();
        jbtReset1 = new view.JButtonCustom();
        jtbtDel1 = new view.JButtonCustom();
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

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Thời Gian Kết Thúc");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 140, 40));

        jtxtDateQuit1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateQuit1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDateQuit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 260, 40));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel13.setText("Thời Gian Bắt Đầu");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 140, 40));

        jtxtDateEnter1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateEnter1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDateEnter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 260, 40));

        jtbCharityActi1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbCharityActi1.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbCharityActi1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbCharityActi1.setGridColor(new java.awt.Color(0, 204, 204));
        jtbCharityActi1.setOpaque(false);
        jtbCharityActi1.setRowHeight(40);
        jtbCharityActi1.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbCharityActi1.setShowHorizontalLines(true);
        jtbCharityActi1.setShowVerticalLines(true);
        jScrollPane2.setViewportView(jtbCharityActi1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1200, 340));

        jLabel15.setBackground(new java.awt.Color(153, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel15.setOpaque(true);
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 10, 140));

        jbtAdd1.setBorder(null);
        jbtAdd1.setText("Thêm");
        jbtAdd1.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtAdd1.setColoOver(new java.awt.Color(255, 102, 51));
        jbtAdd1.setColor(new java.awt.Color(51, 255, 153));
        jbtAdd1.setColorClick(new java.awt.Color(0, 204, 255));
        jbtAdd1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtAdd1.setRadius(40);
        jPanel3.add(jbtAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, 50));

        jbtReset1.setBorder(null);
        jbtReset1.setText("Làm mới");
        jbtReset1.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtReset1.setColoOver(new java.awt.Color(255, 102, 51));
        jbtReset1.setColor(new java.awt.Color(51, 255, 153));
        jbtReset1.setColorClick(new java.awt.Color(0, 204, 255));
        jbtReset1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtReset1.setRadius(40);
        jPanel3.add(jbtReset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 120, 50));

        jtbtDel1.setBorder(null);
        jtbtDel1.setText("Xoá");
        jtbtDel1.setBoderColor(new java.awt.Color(255, 255, 255));
        jtbtDel1.setColoOver(new java.awt.Color(255, 102, 51));
        jtbtDel1.setColor(new java.awt.Color(51, 255, 153));
        jtbtDel1.setColorClick(new java.awt.Color(0, 204, 255));
        jtbtDel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jtbtDel1.setRadius(40);
        jPanel3.add(jtbtDel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 120, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 660));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1190, 660));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1190, 700));

        setSize(new java.awt.Dimension(1205, 708));
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(statistical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(statistical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(statistical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(statistical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new statistical().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private view.JButtonCustom jbtAdd1;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtResest1;
    private view.JButtonCustom jbtReset1;
    private javax.swing.JTable jtbCharityActi1;
    private view.JButtonCustom jtbtDel1;
    private javax.swing.JTextField jtxtDateEnter1;
    private javax.swing.JTextField jtxtDateQuit1;
    private javax.swing.JTextField jtxtFind1;
    // End of variables declaration//GEN-END:variables
}
