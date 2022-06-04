package view;

import controller.ConnectDatabase;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainPage extends javax.swing.JFrame{
    public int layed = 1;
    public MainPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbtIntroChid = new view.JButtonCustom();
        jbtLogin = new view.JButtonCustom();
        jbtInfor = new view.JButtonCustom();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TRUNG TÂM BẢO TRỢ TRẺ EM");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_crosswalk_80px.png"))); // NOI18N
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ TRUNG TÂM BẢO TRỢ TRẺ EM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addGap(160, 160, 160))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jbtIntroChid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_child_with_pacifier_64px.png"))); // NOI18N
        jbtIntroChid.setText("Giới Thiệu Trẻ");
        jbtIntroChid.setBoderColor(new java.awt.Color(0, 0, 102));
        jbtIntroChid.setColoOver(new java.awt.Color(0, 255, 204));
        jbtIntroChid.setColor(new java.awt.Color(102, 204, 255));
        jbtIntroChid.setColorClick(new java.awt.Color(102, 255, 0));
        jbtIntroChid.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbtIntroChid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtIntroChid.setRadius(50);
        jbtIntroChid.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtIntroChid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIntroChidActionPerformed(evt);
            }
        });

        jbtLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_Locked_User_64px.png"))); // NOI18N
        jbtLogin.setText("Đăng Nhập");
        jbtLogin.setBoderColor(new java.awt.Color(0, 0, 102));
        jbtLogin.setColoOver(new java.awt.Color(0, 255, 204));
        jbtLogin.setColor(new java.awt.Color(102, 204, 255));
        jbtLogin.setColorClick(new java.awt.Color(102, 255, 0));
        jbtLogin.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbtLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtLogin.setRadius(50);
        jbtLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLoginActionPerformed(evt);
            }
        });

        jbtInfor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_info_48px_2.png"))); // NOI18N
        jbtInfor.setText("Thông Tin");
        jbtInfor.setBoderColor(new java.awt.Color(0, 0, 102));
        jbtInfor.setColoOver(new java.awt.Color(0, 255, 204));
        jbtInfor.setColor(new java.awt.Color(102, 204, 255));
        jbtInfor.setColorClick(new java.awt.Color(102, 255, 0));
        jbtInfor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jbtInfor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtInfor.setRadius(50);
        jbtInfor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInforActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jbtInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(126, 126, 126)
                .addComponent(jbtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(147, 147, 147)
                .addComponent(jbtIntroChid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(116, 116, 116))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jbtIntroChid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(161, 161, 161))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/LocalRed.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel4.setText("54 Nguyễn Lương Bằng, Hoà Khánh Bắc, Liên Chiểu, Đà Nẵng");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/phone_26px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hostline 24/7:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("0914.922.922");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(130, 130, 130)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(110, 110, 110))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(130, 130, 130))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInforActionPerformed
        jbtInfor.setCursor(new Cursor(TEXT_CURSOR) {
        });
        this.setVisible(false);
        new Information().setVisible(true);
        layed  = 2;
        
    }//GEN-LAST:event_jbtInforActionPerformed

    private void jbtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLoginActionPerformed
       if(evt.getActionCommand() != null){
           this.setVisible(false);
           Login log = new Login();
           log.setVisible(true);
           layed = 2;
       }
    }//GEN-LAST:event_jbtLoginActionPerformed

    private void jbtIntroChidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIntroChidActionPerformed
        // TODO add your handling code here:
//        this.setEnabled(false);
        this.setVisible(false);
        LoginUser log = new LoginUser();
        log.setVisible(true);
        if(log.getCheckLogin() == 1){
            log.setVisible(false);
        }
        layed = 3;
        
    }//GEN-LAST:event_jbtIntroChidActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         new ConnectDatabase();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private view.JButtonCustom jbtInfor;
    private view.JButtonCustom jbtIntroChid;
    private view.JButtonCustom jbtLogin;
    // End of variables declaration//GEN-END:variables

    
}
