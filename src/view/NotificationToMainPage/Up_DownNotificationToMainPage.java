/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.NotificationToMainPage;

import controller.NotificationListener;
import javax.swing.JOptionPane;
import model.Model_message;

public class Up_DownNotificationToMainPage extends javax.swing.JFrame {
     private String ID_NVQL;
     private Model_message MESSAGE;

    public Model_message getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(Model_message MESSAGE) {
        this.MESSAGE = MESSAGE;
    }
    public String getID_NVQL() {
        return ID_NVQL;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL = ID_NVQL;
    }
    private NotificationListener a = new NotificationListener();
    public Up_DownNotificationToMainPage() {
        initComponents();
        jbtEdit.setVisible(false);
        jbtUp_Down.setVisible(false);
    }
    public Up_DownNotificationToMainPage(Model_message s) {
        initComponents();
        
        this.jtxtHeader.setText(s.getHeader());
        this.jtxtContent.setText(s.getContent());
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

        jbtSend.setVisible(false);
        if(s.getVi_tri().compareTo("1") == 0)
            jbtUp_Down.setText("Ẩn");  
        
        else
            jbtUp_Down.setText("Hiện");

    }
    public void delete(){
        
        String ID =MESSAGE.getID_model();
        a.Delete(ID);      
    }
    public void insert(){
        
        a.InsertStaff(jtxtHeader.getText(), jtxtContent.getText(),"1");
        a.Add_2_ID(ID_NVQL);
    }
    
    public void update() {
       
        String vi_tri;
        if(jbtUp_Down.getText() == "Ẩn")
            vi_tri = "1";
        else
            vi_tri = "2";
        
        a.update(jtxtHeader.getText(), jtxtContent.getText(), MESSAGE.getID_model(), vi_tri);
        a.Add_2_ID(ID_NVQL, MESSAGE.getID_model());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtContent = new javax.swing.JTextArea();
        jtxtHeader = new javax.swing.JTextField();
        jbtEdit = new view.JButtonCustom();
        jbtSend = new view.JButtonCustom();
        jbtExit = new view.JButtonCustom();
        jbtUp_Down = new view.JButtonCustom();
        jbtBack = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(365, 85, 85, 85));
        setUndecorated(true);
        setSize(new java.awt.Dimension(840, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Nội dung");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tiêu đề ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 40));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);

        jtxtContent.setColumns(20);
        jtxtContent.setLineWrap(true);
        jtxtContent.setRows(5);
        jScrollPane2.setViewportView(jtxtContent);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 520, 280));

        jtxtHeader.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtxtHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtHeaderActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 520, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 760, 390));

        jbtEdit.setBorder(null);
        jbtEdit.setText("Sửa");
        jbtEdit.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtEdit.setColoOver(new java.awt.Color(255, 102, 51));
        jbtEdit.setColor(new java.awt.Color(51, 255, 153));
        jbtEdit.setColorClick(new java.awt.Color(0, 204, 255));
        jbtEdit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtEdit.setRadius(40);
        jbtEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtEditMouseClicked(evt);
            }
        });
        jbtEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditActionPerformed(evt);
            }
        });
        jPanel1.add(jbtEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 120, 50));

        jbtSend.setBorder(null);
        jbtSend.setText("Gửi");
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
        jPanel1.add(jbtSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 120, 50));

        jbtExit.setBorder(null);
        jbtExit.setText("Hủy");
        jbtExit.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtExit.setColoOver(new java.awt.Color(255, 102, 51));
        jbtExit.setColor(new java.awt.Color(51, 255, 153));
        jbtExit.setColorClick(new java.awt.Color(0, 204, 255));
        jbtExit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtExit.setRadius(40);
        jbtExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtExitMouseClicked(evt);
            }
        });
        jbtExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExitActionPerformed(evt);
            }
        });
        jPanel1.add(jbtExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 120, 50));

        jbtUp_Down.setBorder(null);
        jbtUp_Down.setText("STATE");
        jbtUp_Down.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUp_Down.setColoOver(new java.awt.Color(255, 102, 51));
        jbtUp_Down.setColor(new java.awt.Color(51, 255, 153));
        jbtUp_Down.setColorClick(new java.awt.Color(0, 204, 255));
        jbtUp_Down.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtUp_Down.setRadius(40);
        jbtUp_Down.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUp_DownMouseClicked(evt);
            }
        });
        jbtUp_Down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUp_DownActionPerformed(evt);
            }
        });
        jPanel1.add(jbtUp_Down, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 120, 50));

        jbtBack.setBorder(null);
        jbtBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back_26px.png"))); // NOI18N
        jbtBack.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtBack.setColoOver(new java.awt.Color(255, 102, 51));
        jbtBack.setColorClick(new java.awt.Color(0, 204, 255));
        jbtBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtBackMouseClicked(evt);
            }
        });
        jPanel1.add(jbtBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(951, 554));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom1MouseClicked

     
    }//GEN-LAST:event_jButtonCustom1MouseClicked

    private void jbtDelelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDelelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDelelActionPerformed

    private void jbtDelelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDelelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDelelMouseClicked

    private void jbtGoodStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGoodStateActionPerformed
       
    }//GEN-LAST:event_jbtGoodStateActionPerformed

    private void jbtGoodStateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtGoodStateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtGoodStateMouseClicked

    private void jbtBadStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBadStateActionPerformed
        update();
        this.dispose();
    }//GEN-LAST:event_jbtBadStateActionPerformed

    private void jbtBadStateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtBadStateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtBadStateMouseClicked

    private void jbtExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtExitActionPerformed

    private void jbtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_jbtExitMouseClicked

    private void jbtSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSendActionPerformed
        insert();
        this.dispose();
        JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
    }//GEN-LAST:event_jbtSendActionPerformed

    private void jbtSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSendMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSendMouseClicked

    private void jbtEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtEditMouseClicked

    private void jbtEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditActionPerformed
        update();
        this.dispose();
        JOptionPane.showMessageDialog(rootPane, "Thông tin đã được thay đổi");
    }//GEN-LAST:event_jbtEditActionPerformed

    private void jtxtHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtHeaderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtHeaderActionPerformed

    private void jbtUp_DownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUp_DownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtUp_DownActionPerformed

    private void jbtUp_DownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUp_DownMouseClicked
        if(jbtUp_Down.getText() == "Ẩn")
        jbtUp_Down.setText("Hiện");
        else
        jbtUp_Down.setText("Ẩn");
    }//GEN-LAST:event_jbtUp_DownMouseClicked

    private void jbtBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtBackMouseClicked
        new NotificationToMainPage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtBackMouseClicked

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
            java.util.logging.Logger.getLogger(Up_DownNotificationToMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Up_DownNotificationToMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Up_DownNotificationToMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Up_DownNotificationToMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Up_DownNotificationToMainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private view.JButtonCustom jbtBack;
    private view.JButtonCustom jbtEdit;
    private view.JButtonCustom jbtExit;
    private view.JButtonCustom jbtSend;
    private view.JButtonCustom jbtUp_Down;
    private javax.swing.JTextArea jtxtContent;
    private javax.swing.JTextField jtxtHeader;
    // End of variables declaration//GEN-END:variables
}
