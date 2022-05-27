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
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Children;
import model.Extracurriclar;
import model.managementStaff;

/**
 *
 * @author ADMIN
 */
public class ExtracurricularActivities extends javax.swing.JFrame {

    ActivityListerner ac = new ActivityListerner();

    public String getIDNVQL() {
        return IDNVQL;
    }

    public void setIDNVQL(String IDNVQL) {
        this.IDNVQL = IDNVQL;
    }
    String IDNVQL;

    /**
     * Creates new form Equipment
     */
    public ExtracurricularActivities() {
        initComponents();
        setWidthTable();
    }

    public void setWidthTable() {

        jtbExtracurricular.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbExtracurricular.setBackground(Color.WHITE);
        jtbExtracurricular.getColumnModel().getColumn(0).setPreferredWidth(130);
        jtbExtracurricular.getColumnModel().getColumn(1).setPreferredWidth(250);
        jtbExtracurricular.getColumnModel().getColumn(2).setPreferredWidth(130);
        jtbExtracurricular.getColumnModel().getColumn(3).setPreferredWidth(110);
        jtbExtracurricular.getColumnModel().getColumn(4).setPreferredWidth(130);
        jtbExtracurricular.getColumnModel().getColumn(5).setPreferredWidth(130);
        jtbExtracurricular.getColumnModel().getColumn(6).setPreferredWidth(130);
        jtbExtracurricular.getColumnModel().getColumn(7).setPreferredWidth(130);
        jtbExtracurricular.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 17));
        ((DefaultTableCellRenderer) jtbExtracurricular.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    void Statictical() {
        Vector<Extracurriclar> vec = new Vector<>();
        vec = ac.getListExtracurricular(ac.sqlShowExtrac(2));
        jlbCountCurrent.setText(String.valueOf(vec.size()));
        vec = ac.getListExtracurricular(ac.sqlShowExtrac(3));
        jlbCountDone.setText(String.valueOf(vec.size()));
    }

    public void ClearJtxt() {
        jtxtName.setText("");
        jtxtDateEnded.setText("");
        jtxtDateStart.setText("");
        jtxtDateEnded.setEditable(false);
        jtxtDateStart.setEditable(false);
        jtxtFind.setText("");
        jtxtNumOfChild.setText("");
        jtxtNumOfStaff.setText("");
        jtxtPlace.setText("");
    }

    public void getDataFromTable() {
        int k = jtbExtracurricular.getSelectedRow();
        String ID_Choose = (String) jtbExtracurricular.getModel().getValueAt(k, 0);
        Vector<Extracurriclar> list = new Vector<Extracurriclar>();
        list = ac.Find(2, ID_Choose);
        Extracurriclar ex = list.get(0);
        jtxtName.setText(ex.getName());
        jtxtNumOfStaff.setText(ex.getNumberOfStaff());
        jtxtNumOfChild.setText(ex.getNumberOfChild());
        jtxtPlace.setText(ex.getPlace());
        jtxtDateStart.setText(ex.getDateStart());
        jtxtDateEnded.setText(ex.getDateEnd());

    }

    public void showSupport(Vector<Extracurriclar> vec) {
        DefaultTableModel model = (DefaultTableModel) jtbExtracurricular.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID(), vec.get(i).getName(), vec.get(i).getPlace(), vec.get(i).getIDNVQL(),
                vec.get(i).getNumberOfStaff(), vec.get(i).getNumberOfChild(),
                vec.get(i).getDateStart(), vec.get(i).getDateEnd()
            });
        }
        jtbExtracurricular.setModel(model);
    }

    public void ShowListExtrac(int i) {
        Vector<Extracurriclar> vec = new Vector<>();
        vec = ac.getListExtracurricular(ac.sqlShowExtrac(i));
        showSupport(vec);
    }
   
    public void Add() {
        Vector<Extracurriclar> vec = new Vector<>();
        vec = ac.getListExtracurricular(ac.sqlShowExtrac(1));
        
        String tmp = vec.get(vec.size() - 1).getID();
        String[] arr = tmp.split("HDNK", 2);
        String ID = "HDNK";
        if(arr[1].length() == 3 && String.valueOf(Integer.parseInt(arr[1]) + 1).length() == 1){
            ID += "00";
        }else{
            ID += "0";
        }
        int tmp2 = Integer.parseInt(arr[1]) + 1;
        ID += String.valueOf(tmp2);
        
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        String DateStart = date.toString();
        if (ID.isEmpty() || jtxtName.getText().isEmpty() || jtxtPlace.getText().isEmpty() || IDNVQL.isEmpty()
                || jtxtNumOfStaff.getText().isEmpty() || jtxtNumOfChild.getText().isEmpty() || DateStart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống thông tin hoạt động");
        } else {
            String Name = jtxtName.getText();
            String Place = jtxtPlace.getText();
            int ID_NVQL = Integer.parseInt(IDNVQL);
            int NumofStaff, NumofChild;
            try {
                NumofStaff = Integer.parseInt(jtxtNumOfStaff.getText());
                NumofChild = Integer.parseInt(jtxtNumOfChild.getText());
                if (NumofStaff < 0 || NumofChild < 0) {
                    JOptionPane.showMessageDialog(null, "Số trẻ hoặc số cán bộ không hợp lệ");
                } else {
                    ac.InsertExtrac(ID, Name, Place, ID_NVQL, NumofStaff, NumofChild, DateStart, null);
                    JOptionPane.showMessageDialog(null, "Thêm hoạt động " + ID + " Thành Công!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Số trẻ hoặc số cán bộ không hợp lệ");
            }

        }

    }

    public void Delete() {
        int k = jtbExtracurricular.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hoạt động muốn xoá");
        } else {
            String ID_Choose = (String) jtbExtracurricular.getModel().getValueAt(k, 0);
            ac.DeleteExtrac(ID_Choose);
        }
    }

    public void Update() {
        jtxtDateStart.setEditable(true);
        jtxtDateEnded.setEditable(true);
        int k = jtbExtracurricular.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hoạt động muốn cập nhật!");
        } else {
            String ID_Choose = (String) jtbExtracurricular.getModel().getValueAt(k, 0);
            if (ID_Choose.isEmpty() || jtxtName.getText().isEmpty() || jtxtPlace.getText().isEmpty() || IDNVQL.isEmpty()
                    || jtxtNumOfStaff.getText().isEmpty() || jtxtNumOfChild.getText().isEmpty() || jtxtDateStart.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không được để trống thông tin hoạt động");
            } else {
                String Name = jtxtName.getText();
                String Place = jtxtPlace.getText();
                int ID_NVQL = Integer.parseInt(IDNVQL);
                int NumofStaff, NumofChild;
                String DateStart = jtxtDateStart.getText();
                String DateEnd = jtxtDateEnded.getText();
                if(DateEnd.compareTo("") == 0){
                    DateEnd = null;
                }
                try {
                    NumofStaff = Integer.parseInt(jtxtNumOfStaff.getText());
                    NumofChild = Integer.parseInt(jtxtNumOfChild.getText());
                    if (NumofStaff < 0 || NumofChild < 0) {
                        JOptionPane.showMessageDialog(null, "Số trẻ hoặc số cán bộ không hợp lệ");
                    } else {
                        ac.UpdateExtrac(ID_Choose, Name, Place, ID_NVQL, NumofStaff, NumofChild, DateStart, DateEnd);
                        JOptionPane.showMessageDialog(null, "Cập nhật hoạt động " + ID_Choose + " Thành Công!");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Số trẻ hoặc số cán bộ không hợp lệ");
                }
            }

        }
    }

    public void Find(int i) {
        String Text = jtxtFind.getText();
        Vector<Extracurriclar> vec = new Vector<>();
        vec = ac.Find(i, Text);
        showSupport(vec);
        if (vec.size() < 1) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hoạt động " + Text);
        } else {
            showSupport(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jlbCountDone = new javax.swing.JLabel();
        jtxtPlace = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtDateEnded = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtDateStart = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbExtracurricular = new javax.swing.JTable();
        jtxtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlbCountCurrent = new javax.swing.JLabel();
        jbtExtracEnd = new view.JButtonCustom();
        jbtDelete = new view.JButtonCustom();
        jbtUpda = new view.JButtonCustom();
        jbtShow = new view.JButtonCustom();
        jbtExtracNow = new view.JButtonCustom();
        jbtAdd = new view.JButtonCustom();
        jtxtNumOfStaff = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtxtNumOfChild = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();
        jbtRe = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(840, 650));
        setSize(new java.awt.Dimension(840, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbCountDone.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jlbCountDone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlbCountDone.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jlbCountDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 40, 40));

        jtxtPlace.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPlace.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 240, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Thời Gian Kết Thúc");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 140, 40));

        jtxtDateEnded.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateEnded.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDateEnded, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 240, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Thời Gian Bắt Đầu");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 140, 40));

        jtxtDateStart.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateStart.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 240, 40));

        jtbExtracurricular.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbExtracurricular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hoạt Động", "Tên Hoạt Động", "Địa Điểm", "ID_NVQL", "Số cán bộ tham gia", "Số trẻ tham gia", "Thời Gian Bắt Đầu", "Thời Gian Kết Thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbExtracurricular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbExtracurricular.setGridColor(new java.awt.Color(0, 204, 204));
        jtbExtracurricular.setOpaque(false);
        jtbExtracurricular.setRowHeight(40);
        jtbExtracurricular.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbExtracurricular.setShowHorizontalLines(true);
        jtbExtracurricular.setShowVerticalLines(true);
        jtbExtracurricular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbExtracurricularMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbExtracurricular);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1190, 350));

        jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 240, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Tên Hoạt Động");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 110, 40));

        jLabel10.setBackground(new java.awt.Color(153, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel10.setOpaque(true);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 10, 130));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sum_24px.png"))); // NOI18N
        jLabel8.setText("Tổng hoạt động đã triển khai:");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 240, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sum_24px.png"))); // NOI18N
        jLabel12.setText("Tổng hoạt động hiện nay: ");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel12.setOpaque(true);
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 210, 40));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Địa Điểm");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 90, 40));

        jlbCountCurrent.setBackground(new java.awt.Color(255, 255, 255));
        jlbCountCurrent.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jlbCountCurrent.setOpaque(true);
        jPanel2.add(jlbCountCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 40, 40));

        jbtExtracEnd.setBorder(null);
        jbtExtracEnd.setText("Hoạt động đã kết thúc");
        jbtExtracEnd.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtExtracEnd.setColoOver(new java.awt.Color(255, 102, 51));
        jbtExtracEnd.setColor(new java.awt.Color(51, 255, 153));
        jbtExtracEnd.setColorClick(new java.awt.Color(0, 204, 255));
        jbtExtracEnd.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtExtracEnd.setRadius(40);
        jbtExtracEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtExtracEndMouseClicked(evt);
            }
        });
        jPanel2.add(jbtExtracEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 190, 50));

        jbtDelete.setBorder(null);
        jbtDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Delete_24px.png"))); // NOI18N
        jbtDelete.setText("Xoá");
        jbtDelete.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDelete.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDelete.setColor(new java.awt.Color(51, 255, 153));
        jbtDelete.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDelete.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtDelete.setRadius(40);
        jbtDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDeleteMouseClicked(evt);
            }
        });
        jPanel2.add(jbtDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 230, 100, 50));

        jbtUpda.setBorder(null);
        jbtUpda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/update_24px.png"))); // NOI18N
        jbtUpda.setText("Cập Nhật");
        jbtUpda.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtUpda.setColoOver(new java.awt.Color(255, 102, 51));
        jbtUpda.setColor(new java.awt.Color(51, 255, 153));
        jbtUpda.setColorClick(new java.awt.Color(0, 204, 255));
        jbtUpda.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtUpda.setRadius(40);
        jbtUpda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtUpda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpdaMouseClicked(evt);
            }
        });
        jPanel2.add(jbtUpda, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, 120, 50));

        jbtShow.setBorder(null);
        jbtShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/list_view_24px.png"))); // NOI18N
        jbtShow.setText("Hiển Thị");
        jbtShow.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtShow.setColoOver(new java.awt.Color(255, 102, 51));
        jbtShow.setColor(new java.awt.Color(51, 255, 153));
        jbtShow.setColorClick(new java.awt.Color(0, 204, 255));
        jbtShow.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtShow.setRadius(40);
        jbtShow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtShowMouseClicked(evt);
            }
        });
        jPanel2.add(jbtShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 120, 50));

        jbtExtracNow.setBorder(null);
        jbtExtracNow.setText("Hoạt động hiện tại");
        jbtExtracNow.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtExtracNow.setColoOver(new java.awt.Color(255, 102, 51));
        jbtExtracNow.setColor(new java.awt.Color(51, 255, 153));
        jbtExtracNow.setColorClick(new java.awt.Color(0, 204, 255));
        jbtExtracNow.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtExtracNow.setRadius(40);
        jbtExtracNow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtExtracNowMouseClicked(evt);
            }
        });
        jPanel2.add(jbtExtracNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 170, 50));

        jbtAdd.setBorder(null);
        jbtAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add_24px.png"))); // NOI18N
        jbtAdd.setText("Thêm");
        jbtAdd.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtAdd.setColoOver(new java.awt.Color(255, 102, 51));
        jbtAdd.setColor(new java.awt.Color(51, 255, 153));
        jbtAdd.setColorClick(new java.awt.Color(0, 204, 255));
        jbtAdd.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtAdd.setRadius(40);
        jbtAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddMouseClicked(evt);
            }
        });
        jPanel2.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 100, 50));

        jtxtNumOfStaff.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNumOfStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtNumOfStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 240, 40));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel11.setText("Số Cán Bộ Tham Gia");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 140, 40));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel13.setText("Số Trẻ Tham Gia");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 140, 40));

        jtxtNumOfChild.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNumOfChild.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtNumOfChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 240, 40));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 690));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1190, 690));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tìm Theo Tên Hoạt Động");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 170, 40));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 400, 40));

        jbtFind.setBorder(null);
        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_24px.png"))); // NOI18N
        jbtFind.setBoderColor(new java.awt.Color(153, 255, 204));
        jbtFind.setColoOver(new java.awt.Color(204, 255, 255));
        jbtFind.setColor(new java.awt.Color(153, 255, 204));
        jbtFind.setColorClick(new java.awt.Color(255, 255, 51));
        jbtFind.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFindMouseClicked(evt);
            }
        });
        jPanel1.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 50, 40));

        jbtRe.setBackground(new java.awt.Color(153, 255, 204));
        jbtRe.setBorder(null);
        jbtRe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset_24px.png"))); // NOI18N
        jbtRe.setBoderColor(new java.awt.Color(153, 255, 204));
        jbtRe.setColoOver(new java.awt.Color(204, 255, 255));
        jbtRe.setColor(new java.awt.Color(153, 255, 204));
        jbtRe.setColorClick(new java.awt.Color(255, 255, 51));
        jbtRe.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jbtRe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtReMouseClicked(evt);
            }
        });
        jPanel1.add(jbtRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 740));

        setSize(new java.awt.Dimension(1191, 701));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom1MouseClicked

        this.setVisible(false);
    }//GEN-LAST:event_jButtonCustom1MouseClicked

    private void jbtDelelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDelelActionPerformed

    }//GEN-LAST:event_jbtDelelActionPerformed

    private void jbtDelelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDelelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDelelMouseClicked

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jbtExtracEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExtracEndMouseClicked
        ShowListExtrac(3);
    }//GEN-LAST:event_jbtExtracEndMouseClicked

    private void jtbExtracurricularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbExtracurricularMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbExtracurricularMouseClicked

    private void jbtResestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResestActionPerformed

    }//GEN-LAST:event_jbtResestActionPerformed

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed

    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        Find(1);
    }//GEN-LAST:event_jbtFindMouseClicked

    private void jbtDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeleteMouseClicked
        Delete();
        Statictical();
        ShowListExtrac(1);
    }//GEN-LAST:event_jbtDeleteMouseClicked

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdd3MouseClicked

        Statictical();
        ShowListExtrac(1);
    }//GEN-LAST:event_jbtAdd3MouseClicked

    private void jbtShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtShowMouseClicked
        ShowListExtrac(1);
    }//GEN-LAST:event_jbtShowMouseClicked

    private void jbtExtracNowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExtracNowMouseClicked
        ShowListExtrac(2);
    }//GEN-LAST:event_jbtExtracNowMouseClicked

    private void jbtResestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAdd7MouseClicked

    }//GEN-LAST:event_jbtAdd7MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ShowListExtrac(1);
        Statictical();
        ClearJtxt();
    }//GEN-LAST:event_formWindowOpened

    private void jbtUpdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdaMouseClicked
        Update();
        Statictical();
        ShowListExtrac(1);
    }//GEN-LAST:event_jbtUpdaMouseClicked

    private void jbtReMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtReMouseClicked
        ShowListExtrac(1);
        Statictical();
        ClearJtxt();
    }//GEN-LAST:event_jbtReMouseClicked

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        Add();
        ShowListExtrac(1);
        Statictical();

    }//GEN-LAST:event_jbtAddMouseClicked

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
            java.util.logging.Logger.getLogger(ExtracurricularActivities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExtracurricularActivities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExtracurricularActivities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExtracurricularActivities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExtracurricularActivities().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtDelete;
    private view.JButtonCustom jbtExtracEnd;
    private view.JButtonCustom jbtExtracNow;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtRe;
    private view.JButtonCustom jbtShow;
    private view.JButtonCustom jbtUpda;
    private javax.swing.JLabel jlbCountCurrent;
    private javax.swing.JLabel jlbCountDone;
    private javax.swing.JTable jtbExtracurricular;
    private javax.swing.JTextField jtxtDateEnded;
    private javax.swing.JTextField jtxtDateStart;
    private javax.swing.JTextField jtxtFind;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtNumOfChild;
    private javax.swing.JTextField jtxtNumOfStaff;
    private javax.swing.JTextField jtxtPlace;
    // End of variables declaration//GEN-END:variables
}
