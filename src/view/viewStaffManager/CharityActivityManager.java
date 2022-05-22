/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

import controller.ActivityListerner;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Stack;
//import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Charity;
import model.Extracurriclar;

/**
 *
 * @author ADMIN
 */
public class CharityActivityManager extends javax.swing.JFrame {

    private ActivityListerner ac = new ActivityListerner();

    public void setIDNVQL(String IDNVQL) {
        this.IDNVQL = IDNVQL;
    }
    private String IDNVQL;

    /**
     * Creates new form Equipment
     */
    public CharityActivityManager() {
        initComponents();
        setWidthTable();
    }

    public void setWidthTable() {

        jtbCharityActi.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbCharityActi.setBackground(Color.WHITE);
        jtbCharityActi.getColumnModel().getColumn(0).setPreferredWidth(130);
        jtbCharityActi.getColumnModel().getColumn(1).setPreferredWidth(250);
        jtbCharityActi.getColumnModel().getColumn(2).setPreferredWidth(250);
        jtbCharityActi.getColumnModel().getColumn(3).setPreferredWidth(130);
        jtbCharityActi.getColumnModel().getColumn(4).setPreferredWidth(130);
        jtbCharityActi.getColumnModel().getColumn(5).setPreferredWidth(130);
        jtbCharityActi.getColumnModel().getColumn(6).setPreferredWidth(130);
        jtbCharityActi.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 17));
        ((DefaultTableCellRenderer) jtbCharityActi.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void ClearText() {
        jtxtFind.setText("");
        jtxtNameOrgani.setText("");
        jtxtNameActi.setText("");
        jtxtDateEnter.setText("");
        jtxtDateQuit.setText("");
        jtxtSuport.setText("");
        jtxtDateEnter.setEditable(false);
    }

    public void Statistic() {
        ArrayList<Charity> list = new ArrayList<>();
        list = ac.getListCharity(ac.proShowAllCharity(2));
        jlbCountCurrent.setText(String.valueOf(list.size()));
        list = ac.getListCharity(ac.proShowAllCharity(3));
        jlbCountDone.setText(String.valueOf(list.size()));
    }

    public void getDataFromTable() {
        int k = jtbCharityActi.getSelectedRow();
        String ID_Choose = (String) jtbCharityActi.getModel().getValueAt(k, 0);
        ArrayList<Charity> list = new ArrayList<Charity>();
        list = ac.FindCharity(2, ID_Choose);
        Charity ch = list.get(0);
        jtxtNameOrgani.setText(ch.getNameOrganization());
        jtxtNameActi.setText(ch.getNameCharity());
        jtxtSuport.setText(ch.getArtifacts());
        jtxtDateEnter.setText(ch.getDateStart());
        jtxtDateQuit.setText(ch.getDateEnd());

    }

    //----------------------------------------------------function event when you click button ---------------------------------------------------------------
    public void showSupport(ArrayList<Charity> list) {
        DefaultTableModel model = (DefaultTableModel) jtbCharityActi.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                list.get(i).getID(), list.get(i).getNameOrganization(), list.get(i).getNameCharity(),
                list.get(i).getArtifacts(), list.get(i).getIDNVQL(),
                list.get(i).getDateStart(), list.get(i).getDateEnd()
            });
        }
        jtbCharityActi.setModel(model);
    }

    public void Show(int i) {
        ArrayList<Charity> list = new ArrayList<>();
        list = ac.getListCharity(ac.proShowAllCharity(i));
        showSupport(list);
    }

    public void Add() {
        ArrayList<Charity> list = new ArrayList<>();
        list = ac.getListCharity(ac.proShowAllCharity(1));

        String tmp = list.get(list.size() - 1).getID();
        String[] arr = tmp.split("HDTT", 2);
        int tmp2 = Integer.parseInt(arr[1]) + 1;
        String ID = "HDTT" + String.valueOf(tmp2);

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        String DateStart = date.toString();

        if (ID.isEmpty() || jtxtNameOrgani.getText().isEmpty() || jtxtNameActi.getText().isEmpty() || IDNVQL.isEmpty()
                || jtxtSuport.getText().isEmpty() || DateStart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống thông tin hoạt động");
        } else {
            String NameOrgani = jtxtNameOrgani.getText();
            String NameActi = jtxtNameActi.getText();
            String Artifacts = jtxtSuport.getText();
            int ID_NVQL = Integer.parseInt(IDNVQL);

            ac.InsertChartity(ID, NameOrgani, NameActi, Artifacts, ID_NVQL, DateStart, null);
            JOptionPane.showMessageDialog(null, "Thêm hoạt động từ thiện " + ID + " Thành Công!");
        }
    }

    public void Delete() {
        int k = jtbCharityActi.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hoạt động muốn xoá");
        } else {
            String ID_Choose = (String) jtbCharityActi.getModel().getValueAt(k, 0);
            ac.DeleteCharity(ID_Choose);
        }
    }

    public void Update() {
        jtxtDateEnter.setEditable(true);
        jtxtDateQuit.setEditable(true);
        int k = jtbCharityActi.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hoạt động muốn cập nhật!");
        } else {
            String ID_Choose = (String) jtbCharityActi.getModel().getValueAt(k, 0);
            String DateStart = jtxtDateEnter.getText();
            String DateEnd = jtxtDateQuit.getText();
            if (DateEnd.compareTo("") == 0) {
                DateEnd = null;
            }
            if (jtxtNameOrgani.getText().isEmpty() || jtxtNameActi.getText().isEmpty() || IDNVQL.isEmpty()
                    || jtxtSuport.getText().isEmpty() || DateStart.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không được để trống thông tin hoạt động");
            } else {
                String NameOrgani = jtxtNameOrgani.getText();
                String NameActi = jtxtNameActi.getText();
                String Artifacts = jtxtSuport.getText();
                int ID_NVQL = Integer.parseInt(IDNVQL);
                ac.Update(ID_Choose, NameOrgani, NameActi, Artifacts, ID_NVQL, DateStart, DateEnd);
            }
        }
    }

    public void Find(int i) {
        String Text = jtxtFind.getText();
        ArrayList<Charity> list = new ArrayList<>();
        list = ac.FindCharity(i, Text);
        if (list.size() < 1) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hoạt động " + Text);
            showSupport(list);
        } else {
            showSupport(list);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
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
        jbtAdd = new view.JButtonCustom();
        jbtUpda = new view.JButtonCustom();
        jbtNowActi = new view.JButtonCustom();
        jbtShow = new view.JButtonCustom();
        jtbtDel = new view.JButtonCustom();
        jtbtStopActi = new view.JButtonCustom();
        jLabel12 = new javax.swing.JLabel();
        jlbCountCurrent = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlbCountDone = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jbtFind = new view.JButtonCustom();
        jbtResest1 = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        setUndecorated(true);
        setSize(new java.awt.Dimension(840, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Tên Hoạt Động");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 110, 40));

        jtxtNameActi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameActi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtNameActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 260, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Thời Gian Kết Thúc");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 140, 40));

        jtxtDateQuit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDateQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 260, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Thời Gian Bắt Đầu");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 140, 40));

        jtxtDateEnter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDateEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 260, 40));

        jtbCharityActi.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbCharityActi.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Hoạt Động", "Tên Tổ Chức", "Tên Hoạt Động", "Tiền/Hiện Vật Ủng Hộ", "ID_NVQL", "Thời Gian Bắt Đầu", "Thời Gian Kết Thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jtbCharityActi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCharityActiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCharityActi);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1140, 350));

        jtxtSuport.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtSuport.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtSuport, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 260, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Tên Tổ Chức");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 100, 40));

        jLabel10.setBackground(new java.awt.Color(153, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel10.setOpaque(true);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 10, 140));

        jtxtNameOrgani.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameOrgani.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtNameOrgani, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 260, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setText("Tiền/Hiện vật ủng hộ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 150, 40));

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
        jPanel2.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 120, 50));

        jbtUpda.setBorder(null);
        jbtUpda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/update_24px.png"))); // NOI18N
        jbtUpda.setText("Cập Nhật");
        jbtUpda.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUpda.setColoOver(new java.awt.Color(255, 102, 51));
        jbtUpda.setColor(new java.awt.Color(51, 255, 153));
        jbtUpda.setColorClick(new java.awt.Color(0, 204, 255));
        jbtUpda.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtUpda.setRadius(40);
        jbtUpda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpdaMouseClicked(evt);
            }
        });
        jPanel2.add(jbtUpda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 120, 50));

        jbtNowActi.setBorder(null);
        jbtNowActi.setText("Hoạt động hiện tại");
        jbtNowActi.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtNowActi.setColoOver(new java.awt.Color(255, 102, 51));
        jbtNowActi.setColor(new java.awt.Color(51, 255, 153));
        jbtNowActi.setColorClick(new java.awt.Color(0, 204, 255));
        jbtNowActi.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtNowActi.setRadius(40);
        jbtNowActi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtNowActiMouseClicked(evt);
            }
        });
        jPanel2.add(jbtNowActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 150, 50));

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
        jPanel2.add(jbtShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 120, 50));

        jtbtDel.setBorder(null);
        jtbtDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Delete_24px.png"))); // NOI18N
        jtbtDel.setText("Xoá");
        jtbtDel.setBoderColor(new java.awt.Color(255, 255, 255));
        jtbtDel.setColoOver(new java.awt.Color(255, 102, 51));
        jtbtDel.setColor(new java.awt.Color(51, 255, 153));
        jtbtDel.setColorClick(new java.awt.Color(0, 204, 255));
        jtbtDel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jtbtDel.setRadius(40);
        jtbtDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbtDelMouseClicked(evt);
            }
        });
        jPanel2.add(jtbtDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 280, 120, 50));

        jtbtStopActi.setBorder(null);
        jtbtStopActi.setText("Hoạt động đã kết thúc");
        jtbtStopActi.setBoderColor(new java.awt.Color(255, 255, 255));
        jtbtStopActi.setColoOver(new java.awt.Color(255, 102, 51));
        jtbtStopActi.setColor(new java.awt.Color(51, 255, 153));
        jtbtStopActi.setColorClick(new java.awt.Color(0, 204, 255));
        jtbtStopActi.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jtbtStopActi.setRadius(40);
        jtbtStopActi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbtStopActiMouseClicked(evt);
            }
        });
        jPanel2.add(jtbtStopActi, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, 180, 50));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sum_24px.png"))); // NOI18N
        jLabel12.setText("Tổng hoạt động hiện nay: ");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel12.setOpaque(true);
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 210, 40));

        jlbCountCurrent.setBackground(new java.awt.Color(255, 255, 255));
        jlbCountCurrent.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jlbCountCurrent.setOpaque(true);
        jPanel2.add(jlbCountCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sum_24px.png"))); // NOI18N
        jLabel11.setText("Tổng hoạt động đã triển khai:");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 240, 40));

        jlbCountDone.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jlbCountDone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlbCountDone.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jlbCountDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 40, 40));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, 700));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1140, 660));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 310, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tìm Theo Tên Tổ Chức");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 170, 40));

        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_24px.png"))); // NOI18N
        jbtFind.setBoderColor(new java.awt.Color(242, 242, 242));
        jbtFind.setColoOver(new java.awt.Color(153, 255, 204));
        jbtFind.setColor(new java.awt.Color(242, 242, 242));
        jbtFind.setColorClick(new java.awt.Color(102, 255, 153));
        jbtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFindMouseClicked(evt);
            }
        });
        getContentPane().add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 50, 40));

        jbtResest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/home_24px.png"))); // NOI18N
        jbtResest1.setBoderColor(new java.awt.Color(242, 242, 242));
        jbtResest1.setColoOver(new java.awt.Color(153, 255, 204));
        jbtResest1.setColor(new java.awt.Color(242, 242, 242));
        jbtResest1.setColorClick(new java.awt.Color(102, 255, 153));
        jbtResest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtResest1MouseClicked(evt);
            }
        });
        getContentPane().add(jbtResest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        setSize(new java.awt.Dimension(1140, 701));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom1MouseClicked

        this.setVisible(false);
    }//GEN-LAST:event_jButtonCustom1MouseClicked

    private void jbtDelelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDelelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDelelActionPerformed

    private void jbtDelelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDelelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDelelMouseClicked

    private void jtbCharityActiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCharityActiMouseClicked
        jtxtDateEnter.setEditable(true);
        getDataFromTable();
    }//GEN-LAST:event_jtbCharityActiMouseClicked

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        Add();
        Show(1);
        ClearText();
        Statistic();
    }//GEN-LAST:event_jbtAddMouseClicked
    /*
    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtUpdateMouseClicked

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtUpdateActionPerformed
*/
    private void jbtNowActiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtNowActiMouseClicked
        Show(2);
    }//GEN-LAST:event_jbtNowActiMouseClicked

    private void jbtShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtShowMouseClicked
        Show(1);
    }//GEN-LAST:event_jbtShowMouseClicked

    private void jtbtDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbtDelMouseClicked
        Delete();
        Show(1);
        Statistic();
    }//GEN-LAST:event_jtbtDelMouseClicked

    private void jtbtStopActiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbtStopActiMouseClicked
        Show(3);
    }//GEN-LAST:event_jtbtStopActiMouseClicked

    private void jbtUpdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdaMouseClicked
        Update();
        Show(1);
    }//GEN-LAST:event_jbtUpdaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Statistic();
        ClearText();
        Show(1);
    }//GEN-LAST:event_formWindowOpened

    private void jbtResest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtResest1MouseClicked
        ClearText();
        Show(1);
    }//GEN-LAST:event_jbtResest1MouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        Find(1);
    }//GEN-LAST:event_jbtFindMouseClicked

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
            java.util.logging.Logger.getLogger(CharityActivityManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharityActivityManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharityActivityManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharityActivityManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharityActivityManager().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtNowActi;
    private view.JButtonCustom jbtResest1;
    private view.JButtonCustom jbtShow;
    private view.JButtonCustom jbtUpda;
    private javax.swing.JLabel jlbCountCurrent;
    private javax.swing.JLabel jlbCountDone;
    private javax.swing.JTable jtbCharityActi;
    private view.JButtonCustom jtbtDel;
    private view.JButtonCustom jtbtStopActi;
    private javax.swing.JTextField jtxtDateEnter;
    private javax.swing.JTextField jtxtDateQuit;
    private javax.swing.JTextField jtxtFind;
    private javax.swing.JTextField jtxtNameActi;
    private javax.swing.JTextField jtxtNameOrgani;
    private javax.swing.JTextField jtxtSuport;
    // End of variables declaration//GEN-END:variables
}
