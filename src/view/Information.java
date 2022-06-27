package view;

import controller.ActivityListerner;
import controller.InformationListener;
import controller.LoginListener;
import controller.NotificationListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jdk.jfr.Event;
import model.Charity;
import model.Model_message;
import model.Notification;
import view.NotificationToStaff.SendMessage;

public class Information extends JFrame {

    LoginFeedback log = new LoginFeedback();
//    Information infor = new Information();

    public Information() {
        initComponents();
        setWidthTable();

    }

    public Information(int a) {
        initComponents();
        jlbMain.setBackground(new Color(255, 255, 255));
        jlbActi.setBackground(new Color(255, 255, 255));
        jlbNew.setBackground(new Color(102, 255, 255));
//        jlbFeed.setBackground(new Color(255, 255, 255));
        jTabbedPane1.setSelectedIndex(1);
        ShowListContentNotification();
    }

    private NotificationListener abc = new NotificationListener();
    private ActivityListerner ac = new ActivityListerner();

    public void getDataFromTable_news() {
        int k = jList1.getSelectedIndex();
        Model_message a = abc.Find_the_number(k);
        new_view b = new new_view(a);
        b.setVisible(true);
        this.setVisible(false);
    }

    public void SetColor(JLabel lb) {
        jlbMain.setBackground(new Color(255, 255, 255));
        jlbActi.setBackground(new Color(255, 255, 255));
        jlbNew.setBackground(new Color(255, 255, 255));
        lb.setBackground(new Color(102, 255, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jButtonCustom2 = new view.JButtonCustom();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpnMain = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpnNews = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jpnActi = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbActivity = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jbtMain = new javax.swing.JToggleButton();
        jlbMain = new javax.swing.JLabel();
        jbtNews = new javax.swing.JToggleButton();
        jlbNew = new javax.swing.JLabel();
        jbtActi = new javax.swing.JToggleButton();
        jlbActi = new javax.swing.JLabel();

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");
        jMenu4.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCustom2.setBorder(null);
        jButtonCustom2.setText("X");
        jButtonCustom2.setBoderColor(new java.awt.Color(255, 255, 255));
        jButtonCustom2.setColoOver(new java.awt.Color(255, 51, 51));
        jButtonCustom2.setColorClick(new java.awt.Color(255, 51, 51));
        jButtonCustom2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCustom2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCustom2MouseClicked(evt);
            }
        });
        jPanel1.add(jButtonCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, 40));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jpnMain.setBackground(new java.awt.Color(255, 255, 255));
        jpnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("- Trung tâm bảo trợ trẻ em Việt- Nhật được thành lập vào tháng 4 năm 2012, với mục tiêu và sứ mệnh của mình, trung tâm đã hỗ trợ cưu mang trẻ em mồ côi, trẻ không ");
        jpnMain.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 910, 20));

        jLabel11.setText("nương tựa - Trung tâm bảo trợ trẻ em Việt- Nhật được thành lập vào tháng 4 năm 2012, với mục tiêu và sứ mệnh của mình, trung tâm đã hỗ trợ cưu mang trẻ em mồ côi,");
        jpnMain.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 910, -1));

        jLabel12.setText("nương tựa - Trung tâm bảo trợ trẻ em Việt- Nhật được thành lập vào tháng 4 năm 2012, với mục tiêu và sứ mệnh của mình, trung tâm đã hỗ trợ cưu mang trẻ em mồ côi,");
        jpnMain.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 910, -1));

        jLabel13.setText("nương tựa - Trung tâm bảo trợ trẻ em Việt- Nhật được thành lập vào tháng 4 năm 2012, với mục tiêu và sứ mệnh của mình, trung tâm đã hỗ trợ cưu mang trẻ em mồ côi,");
        jpnMain.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 910, -1));

        jLabel14.setText("nương tựa - Trung tâm bảo trợ trẻ em Việt- Nhật được thành lập vào tháng 4 năm 2012, với mục tiêu và sứ mệnh của mình, trung tâm đã hỗ trợ cưu mang trẻ em mồ côi,");
        jpnMain.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 910, -1));

        jLabel15.setText("nương tựa - Trung tâm bảo trợ trẻ em Việt- Nhật được thành lập vào tháng 4 năm 2012, với mục tiêu và sứ mệnh của mình, trung tâm đã hỗ trợ cưu mang trẻ em mồ côi,");
        jpnMain.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 910, -1));

        jLabel16.setText("nương tựa - Trung tâm bảo trợ trẻ em Việt- Nhật được thành lập vào tháng 4 năm 2012, với mục tiêu và sứ mệnh của mình, trung tâm đã hỗ trợ cưu mang trẻ em mồ côi,");
        jpnMain.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 910, -1));

        jLabel17.setText("nương tựa - Trung tâm bảo trợ trẻ em Việt- Nhật được thành lập vào tháng 4 năm 2012, với mục tiêu và sứ mệnh của mình, trung tâm đã hỗ trợ cưu mang trẻ em mồ côi,");
        jpnMain.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 910, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logoZalo.jpg"))); // NOI18N
        jpnMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 200));

        jTabbedPane1.addTab("tab1", jpnMain);

        jpnNews.setBackground(new java.awt.Color(255, 255, 255));
        jpnNews.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setToolTipText("");
        jList1.setFixedCellHeight(50);
        jList1.setFixedCellWidth(600);
        jList1.setFocusCycleRoot(true);
        jList1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);
        jList1.getAccessibleContext().setAccessibleName("");

        jpnNews.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 970, 350));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logoZalo.jpg"))); // NOI18N
        jpnNews.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 200));

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/facebook_48px.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 40, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/LocalRed.png"))); // NOI18N
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 60));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel4.setText("Hoà Khánh Bắc, Liên Chiểu, Đà Nẵng");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 230, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/phone_26px.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 50, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hostline 24/7:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("0914.922.922");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 120, 20));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel8.setText("54 Nguyễn Lương Bằng");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 150, 20));

        jLabel9.setText("https://www.facebook.com/baotrotrem");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 210, 20));

        jpnNews.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1010, -1));

        jTabbedPane1.addTab("tab2", jpnNews);

        jpnActi.setBackground(new java.awt.Color(255, 255, 255));
        jpnActi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbActivity.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtbActivity.setModel(new javax.swing.table.DefaultTableModel(
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
                "Tên Tổ Chức", "Tên Hoạt Động", "Ngày Diễn Ra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbActivity.setRowHeight(35);
        jtbActivity.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPane2.setViewportView(jtbActivity);

        jpnActi.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1010, 540));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel19.setText("MỘT SỐ HOẠT ĐỘNG TỪ THIỆN CỦA TRUNG TÂM");
        jpnActi.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 750, 70));

        jTabbedPane1.addTab("tab3", jpnActi);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1060, 620));

        jbtMain.setBackground(new java.awt.Color(204, 204, 255));
        jbtMain.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jbtMain.setText("TRANG CHỦ");
        jbtMain.setBorder(null);
        jbtMain.setBorderPainted(false);
        jbtMain.setContentAreaFilled(false);
        jbtMain.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMainActionPerformed(evt);
            }
        });
        jPanel1.add(jbtMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 120, 30));

        jlbMain.setBackground(new java.awt.Color(102, 255, 255));
        jlbMain.setOpaque(true);
        jPanel1.add(jlbMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 120, 10));

        jbtNews.setBackground(new java.awt.Color(204, 204, 255));
        jbtNews.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jbtNews.setText("TIN TỨC");
        jbtNews.setBorder(null);
        jbtNews.setBorderPainted(false);
        jbtNews.setContentAreaFilled(false);
        jbtNews.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtNews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtNewsMouseClicked(evt);
            }
        });
        jbtNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNewsActionPerformed(evt);
            }
        });
        jPanel1.add(jbtNews, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 120, 30));

        jlbNew.setBackground(new java.awt.Color(255, 255, 255));
        jlbNew.setOpaque(true);
        jPanel1.add(jlbNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 120, 10));

        jbtActi.setBackground(new java.awt.Color(204, 204, 255));
        jbtActi.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jbtActi.setText("HOẠT ĐỘNG TỪ THIỆN");
        jbtActi.setBorder(null);
        jbtActi.setBorderPainted(false);
        jbtActi.setContentAreaFilled(false);
        jbtActi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtActi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtActiMouseClicked(evt);
            }
        });
        jPanel1.add(jbtActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 180, 30));

        jlbActi.setBackground(new java.awt.Color(255, 255, 255));
        jlbActi.setOpaque(true);
        jPanel1.add(jlbActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 180, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNewsActionPerformed
        SetColor(jlbNew);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jbtNewsActionPerformed

    private void jbtNewsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNewsMouseClicked
        ShowListContentNotification();
    }//GEN-LAST:event_jbtNewsMouseClicked

    private void jbtMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMainActionPerformed
        jlbMain.setBackground(new Color(102, 255, 255));
        jlbActi.setBackground(new Color(255, 255, 255));
        jlbNew.setBackground(new Color(255, 255, 255));
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jbtMainActionPerformed

    private void jButtonCustom2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new MainPage().setVisible(true);
    }//GEN-LAST:event_jButtonCustom2MouseClicked

    private void jbtActiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtActiMouseClicked
        SetColor(jlbActi);
        jTabbedPane1.setSelectedIndex(2);
        ShowListAction();
        setWidthTable();
    }//GEN-LAST:event_jbtActiMouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        getDataFromTable_news();
    }//GEN-LAST:event_jList1MouseClicked
    public void ShowListContentNotification() {
        InformationListener info = new InformationListener();
        Vector<String> listContent = info.getListContent();
        DefaultListModel cbo = new DefaultListModel();
        for (String no : listContent) {
            cbo.addElement(no);
        }
        jList1.setModel(cbo);
    }

    public void ShowListAction() {
        ActivityListerner ac = new ActivityListerner();
        ArrayList<Charity> vec = ac.getListCharity("SHOWALL");
        DefaultTableModel model = (DefaultTableModel) jtbActivity.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getNameOrganization(), vec.get(i).getNameCharity(), vec.get(i).getDateStart()
            });
        }
        jtbActivity.setModel(model);
    }

    public void setWidthTable() {
        jtbActivity.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbActivity.setBackground(Color.WHITE);
        jtbActivity.getColumnModel().getColumn(0).setPreferredWidth(250);
        jtbActivity.getColumnModel().getColumn(1).setPreferredWidth(250);
        jtbActivity.getColumnModel().getColumn(2).setPreferredWidth(130);
        jtbActivity.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 17));
        ((DefaultTableCellRenderer) jtbActivity.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.JButtonCustom jButtonCustom2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jbtActi;
    private javax.swing.JToggleButton jbtMain;
    private javax.swing.JToggleButton jbtNews;
    private javax.swing.JLabel jlbActi;
    private javax.swing.JLabel jlbMain;
    private javax.swing.JLabel jlbNew;
    private javax.swing.JPanel jpnActi;
    private javax.swing.JPanel jpnMain;
    private javax.swing.JPanel jpnNews;
    private javax.swing.JTable jtbActivity;
    // End of variables declaration//GEN-END:variables

}
