/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.NotificationToStaff;


import controller.NotificationListener;
import javax.swing.JOptionPane;
import model.Model_message;

public class SendMessage extends javax.swing.JFrame {
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
    public SendMessage() {
        initComponents();
        
    }
    public SendMessage(Model_message s) {
        initComponents();
        
        this.jtxtHeader.setText(s.getHeader());
        jtxtHeader.setEditable(false);
        this.jtxtContent.setText(s.getContent());
        jtxtContent.setEditable(false);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        jbtExit.setVisible(false);
        jbtSend.setVisible(false);
        

    }
//    public void delete(){
//        String header =ID.getText();
//        a.Delete(header);      
//    }
    public void insert(){
        
        a.InsertStaff(jtxtHeader.getText(), jtxtContent.getText(),"0");
        a.Add_2_ID(ID_NVQL);
    }
    
//    public void update() {
//        String Header = jtxtHeader.getText();
//        String Content = jtxtContent.getText();
//        
//        
//        a.update(jtxtHeader.getText(), jtxtContent.getText(), ID.getText(), "0");
//        a.Add_2_ID(ID_NVQL, MESSAGE.getID_model());
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtHeader = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtContent = new javax.swing.JTextArea();
        jbtSend = new view.JButtonCustom();
        jbtExit = new view.JButtonCustom();
        ID = new javax.swing.JTextField();
        jbtBack = new view.JButtonCustom();

        jButton1.setText("jButton1");

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
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tiêu đề ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 40));

        jtxtHeader.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtHeaderActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 520, 40));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);

        jtxtContent.setColumns(20);
        jtxtContent.setLineWrap(true);
        jtxtContent.setRows(5);
        jScrollPane2.setViewportView(jtxtContent);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 520, 210));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 700, 330));

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
        jPanel1.add(jbtSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 120, 50));

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
        jPanel1.add(jbtExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 120, 50));

        ID.setEditable(false);
        ID.setBackground(new java.awt.Color(255, 255, 255));
        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setBorder(null);
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        jbtBack.setBackground(new java.awt.Color(255, 255, 255));
        jbtBack.setBorder(null);
        jbtBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back_26px.png"))); // NOI18N
        jbtBack.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtBack.setColoOver(new java.awt.Color(204, 255, 255));
        jbtBack.setColorClick(new java.awt.Color(51, 255, 204));
        jbtBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtBack.setRadius(40);
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(908, 554));
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
        
    }//GEN-LAST:event_jbtBadStateActionPerformed

    private void jbtBadStateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtBadStateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtBadStateMouseClicked

    private void jtxtHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtHeaderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtHeaderActionPerformed

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
        new NotificationToStaff().setVisible(true);
    }//GEN-LAST:event_jbtSendActionPerformed

    private void jbtSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSendMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtSendMouseClicked

    private void jbtBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtBackMouseClicked
       this.setVisible(false);
       new NotificationToStaff().setVisible(true);
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
            java.util.logging.Logger.getLogger(SendMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SendMessage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private view.JButtonCustom jbtBack;
    private view.JButtonCustom jbtExit;
    private view.JButtonCustom jbtSend;
    private javax.swing.JTextArea jtxtContent;
    private javax.swing.JTextField jtxtHeader;
    // End of variables declaration//GEN-END:variables
}
