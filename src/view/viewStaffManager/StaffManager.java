/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

import controller.StaffManagerListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.LaborContract;
import model.LocalTime;
import model.Staff;
import view.staff;

/**
 *
 * @author ADMIN
 */
public class StaffManager extends javax.swing.JFrame {

    private LocalTime localTime = new LocalTime();
    private String url = "D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\StaffImage\\";

    private StaffManagerListener staffListener = new StaffManagerListener();
    String ID_NVQL_Extends;

    public String getID_NVQL() {
        return ID_NVQL_Extends;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL_Extends = ID_NVQL;
    }

    public String getNameNVQL() {
        return staffListener.getNameNVQL(ID_NVQL_Extends);
    }

    /**
     * Creates new form StaffManager
     */
    public StaffManager() {
        initComponents();
        setWidthTable();
        showListStaff();

        jTabbedPane1.setSelectedIndex(0);

    }

    public void setWidthTable() {
//        jtbStaff.setAutoResizeMode(jtbStaff.AUTO_RESIZE_OFF);
        jtbStaff.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbStaff.setBackground(Color.WHITE);
        jtbStaff.getColumnModel().getColumn(0).setPreferredWidth(90);
        jtbStaff.getColumnModel().getColumn(1).setPreferredWidth(130);
        jtbStaff.getColumnModel().getColumn(2).setPreferredWidth(180);
        jtbStaff.getColumnModel().getColumn(3).setPreferredWidth(110);
        jtbStaff.getColumnModel().getColumn(4).setPreferredWidth(100);
        jtbStaff.getColumnModel().getColumn(5).setPreferredWidth(90);
        jtbStaff.getColumnModel().getColumn(6).setPreferredWidth(380);
        jtbStaff.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        ((DefaultTableCellRenderer) jtbStaff.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void showSupport(ArrayList<Staff> vec) {
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_CBNV(), vec.get(i).getPassword(), vec.get(i).getName(), vec.get(i).getDateOfBirth(),
                vec.get(i).getPhoneNumber(), vec.get(i).getGender(), vec.get(i).getAddress()
            });
        }
        jtbStaff.setModel(model);
    }

    public void showListStaff() {

        ArrayList<Staff> vec = staffListener.getListStaff(1);
        showSupport(vec);
    }

    public void showListCurrentStaff() {
        ArrayList<Staff> vec = staffListener.getListStaff(2);
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_CBNV(), vec.get(i).getPassword(), vec.get(i).getName(), vec.get(i).getDateOfBirth(),
                vec.get(i).getPhoneNumber(), vec.get(i).getGender(), vec.get(i).getAddress()
            });
        }
        jtbStaff.setModel(model);
    }

    public void showListQuitStaff() {
        ArrayList<Staff> vec = staffListener.getListStaff(3);
        DefaultTableModel model = (DefaultTableModel) jtbStaff.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_CBNV(), vec.get(i).getPassword(), vec.get(i).getName(), vec.get(i).getDateOfBirth(),
                vec.get(i).getPhoneNumber(), vec.get(i).getGender(), vec.get(i).getAddress()
            });
        }
        jtbStaff.setModel(model);
    }

    public void showDateContract(String ID) {
        LaborContract lob = staffListener.getLaborContract(ID);
        jtxtDateStart.setText(lob.getDateStart());
        jtxtDateEnd.setText(lob.getDateEnd());
    }

    public void getDataFromTable() {
        int k = jtbStaff.getSelectedRow();
        String ID_Choose = (String) jtbStaff.getModel().getValueAt(k, 0);
        ArrayList<Staff> list = new ArrayList<Staff>();
        list = staffListener.Find(ID_Choose, 1);
        Staff s = list.get(0);
        jtxtID.setText(s.getID_CBNV());
        jtxtPass.setText(s.getPassword());
        jtxtName.setText(s.getName());
        jtxtDateOfBirth.setText(s.getDateOfBirth());
        jtxtPhoneNumber.setText(s.getPhoneNumber());
        if (s.getGender().compareTo("Nam") == 0) {
            jrdioMale.setSelected(true);
        } else {
            jradioFemale.setSelected(true);
        }
        jtxtAddress.setText(s.getAddress());
        jtxtPhoto.setText(s.getNamePhoto());
        jlbImage.setIcon(ResizeImage(url + s.getNamePhoto()));
    }

    public void Insert() {
        String ID = autoCreateID();
        String Pass = jtxtPass.getText();
        String Name = jtxtName.getText();
        String DOB = jtxtDateOfBirth.getText();
        String PhoneNumber = jtxtPhoneNumber.getText();
        String Address = jtxtAddress.getText();
        String Gender = "";
        if (jrdioMale.isSelected()) {
            Gender = "Nam";
        } else if (jradioFemale.isSelected()) {
            Gender = "Nữ";
        }
        String DateStart = localTime.getDateNow();
        String NamePhoto = jtxtPhoto.getText();
        if (NamePhoto.compareTo("") == 0) {
            NamePhoto = url + "default.png";
        }
        if (ID.isEmpty() || Pass.isEmpty() || Name.isEmpty() || DOB.isEmpty() || PhoneNumber.isEmpty()
                || Address.isEmpty() || Gender.isEmpty()) {
            showMessageDialog(null, "Không được để trống thông tin nhân viên!");
        } else {
            staffListener.InsertStaff(ID, Pass, Name, DOB, PhoneNumber, Gender, Address, NamePhoto, ID_NVQL_Extends, DateStart);
        }
    }

    public void Delete() {
        int k = jtbStaff.getSelectedRow();
        String ID_Choose = (String) jtbStaff.getModel().getValueAt(k, 0);
        staffListener.Delete(ID_Choose, ID_NVQL_Extends);
    }

    public void Update() {
        int k = jtbStaff.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui Lòng chọn cán bộ muốn cập nhật");
        } else {
            String ID_Choose = (String) jtbStaff.getModel().getValueAt(k, 0);
            String ID = jtxtID.getText();
            String Pass = jtxtPass.getText();
            String Name = jtxtName.getText();
            String DOB = jtxtDateOfBirth.getText();
            String PhoneNumber = jtxtPhoneNumber.getText();
            String Address = jtxtAddress.getText();

            String Gender = "";
            if (jrdioMale.isSelected()) {
                Gender = "Nam";
            } else if (jradioFemale.isSelected()) {
                Gender = "Nữ";
            }
            String NamePhoto = jtxtPhoto.getText();
            if (NamePhoto.compareTo("") == 0) {
                NamePhoto = url + "default.png";
            }
            String DateStart = jtxtDateStart.getText();
            String DateEnd = jtxtDateEnd.getText();
            if (DateEnd.compareTo("") == 0) {
                DateEnd = null;
            }
            if (ID.isEmpty() || Pass.isEmpty() || Name.isEmpty() || DOB.isEmpty() || PhoneNumber.isEmpty()
                    || Address.isEmpty() || Gender.isEmpty() || DateStart.isEmpty()) {
                showMessageDialog(null, "Không được để trống thông tin nhân viên!");
            } else {
                staffListener.Update(ID_Choose, this.ID_NVQL_Extends, ID, Pass, Name, DOB, PhoneNumber, Gender, Address, NamePhoto, DateStart, DateEnd);
            }
        }

    }

    public void Resest() {
        jtxtID.setText("");
        jtxtPass.setText("");
        jtxtName.setText("");
        jtxtDateOfBirth.setText("");
        jtxtPhoneNumber.setText("");
        jrdioMale.setSelected(false);
        jradioFemale.setSelected(false);
        jtxtAddress.setText("");
        jtxtDateStart.setText("");
        jtxtDateEnd.setText("");
        jtxtPhoto.setText("");
        jlbImage.setIcon(ResizeImage(url + "default.png"));
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(jlbImage.getWidth(), jlbImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    public String autoCreateID() {
        String ID = "CBNV";
        ArrayList<Staff> list = new ArrayList<>();
        list = staffListener.getListStaff(1);
        String ID_Final = list.get(list.size() - 1).getID_CBNV();
        String line = ID_Final.substring(4);
        int tmp = Integer.parseInt(line) + 1;
        if (tmp < 10) {
            ID += "0" + String.valueOf(tmp);
        } else {
            ID += String.valueOf(tmp);
        }
        return ID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtDateOfBirth = new javax.swing.JTextField();
        jbtUpdate = new view.JButtonCustom();
        jrdioMale = new javax.swing.JRadioButton();
        jradioFemale = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jtxtPhoneNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtAddress = new javax.swing.JTextField();
        jbtStaffQuit = new view.JButtonCustom();
        jbtResest = new view.JButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbStaff = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jtxtPass = new javax.swing.JTextField();
        jtxtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtDateStart = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtDateEnd = new javax.swing.JTextField();
        jbtAdd = new view.JButtonCustom();
        jbtStaffCurrent = new view.JButtonCustom();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jbtDelel1 = new view.JButtonCustom();
        jlbImage = new javax.swing.JLabel();
        jButtonCustom2 = new view.JButtonCustom();
        jtxtPhoto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButtonCustom1 = new jbuttonCustom.JButtonCustom();
        jtxtName1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind1 = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(840, 650));
        setSize(new java.awt.Dimension(840, 650));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(1191, 701));
        jPanel3.setPreferredSize(new java.awt.Dimension(1191, 701));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1300, 701));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1191, 701));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel1.setText("Giới Tính");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 67, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Ngày Sinh");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 67, 40));

        jtxtDateOfBirth.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateOfBirth.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtDateOfBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDateOfBirthActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 240, 40));

        jbtUpdate.setBorder(null);
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
        jPanel2.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, 120, 50));

        buttonGroupGender.add(jrdioMale);
        jrdioMale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jrdioMale.setText("Nam");
        jPanel2.add(jrdioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 250, -1, -1));

        buttonGroupGender.add(jradioFemale);
        jradioFemale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioFemale.setText("Nữ");
        jPanel2.add(jradioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Số Điện Thoại");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 110, 40));

        jtxtPhoneNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPhoneNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 240, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Quê Quán");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 80, 40));

        jtxtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, 240, 40));

        jbtStaffQuit.setBorder(null);
        jbtStaffQuit.setText("Cán Bộ Thôi Việc");
        jbtStaffQuit.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtStaffQuit.setColoOver(new java.awt.Color(255, 102, 51));
        jbtStaffQuit.setColor(new java.awt.Color(51, 255, 153));
        jbtStaffQuit.setColorClick(new java.awt.Color(0, 204, 255));
        jbtStaffQuit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtStaffQuit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtStaffQuit.setRadius(40);
        jbtStaffQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtStaffQuitActionPerformed(evt);
            }
        });
        jPanel2.add(jbtStaffQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 140, 50));

        jbtResest.setBorder(null);
        jbtResest.setText("Làm mới");
        jbtResest.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtResest.setColoOver(new java.awt.Color(255, 102, 51));
        jbtResest.setColor(new java.awt.Color(51, 255, 153));
        jbtResest.setColorClick(new java.awt.Color(0, 204, 255));
        jbtResest.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtResest.setRadius(40);
        jbtResest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtResestMouseClicked(evt);
            }
        });
        jPanel2.add(jbtResest, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 120, 50));

        jtbStaff.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_CBNV", "Mật Khẩu", "Họ Tên", "Ngày Sinh", "SĐT", "Giới Tính", "Quê Quán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbStaff.setGridColor(new java.awt.Color(0, 204, 204));
        jtbStaff.setOpaque(false);
        jtbStaff.setRowHeight(40);
        jtbStaff.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbStaff.setShowHorizontalLines(true);
        jtbStaff.setShowVerticalLines(true);
        jtbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbStaff);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1190, 310));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Mật Khẩu");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 67, 40));

        jtxtPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 240, 40));

        jtxtID.setEditable(false);
        jtxtID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 240, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("ID_CBNV");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 67, 40));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText(" Ngày Vào Làm");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, 40));

        jtxtDateStart.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateStart.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 240, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setText("Ngày Nghỉ Việc");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, -1, 30));

        jtxtDateEnd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateEnd.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 240, 40));

        jbtAdd.setBorder(null);
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
        jPanel2.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 120, 50));

        jbtStaffCurrent.setBorder(null);
        jbtStaffCurrent.setText("Cán Bộ Hiện Tại");
        jbtStaffCurrent.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtStaffCurrent.setColoOver(new java.awt.Color(255, 102, 51));
        jbtStaffCurrent.setColor(new java.awt.Color(51, 255, 153));
        jbtStaffCurrent.setColorClick(new java.awt.Color(0, 204, 255));
        jbtStaffCurrent.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtStaffCurrent.setRadius(40);
        jbtStaffCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtStaffCurrentActionPerformed(evt);
            }
        });
        jPanel2.add(jbtStaffCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 350, 140, 50));

        jLabel11.setText("yyyy-mm-dd");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, -1, -1));

        jLabel12.setText("yyyy-mm-dd");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, -1, -1));

        jLabel13.setText("yyyy-mm-dd");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        jbtDelel1.setBorder(null);
        jbtDelel1.setText("Xoá");
        jbtDelel1.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDelel1.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDelel1.setColor(new java.awt.Color(51, 255, 153));
        jbtDelel1.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDelel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtDelel1.setRadius(40);
        jbtDelel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDelel1MouseClicked(evt);
            }
        });
        jPanel2.add(jbtDelel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 120, 50));

        jlbImage.setOpaque(true);
        jPanel2.add(jlbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 150, 140));

        jButtonCustom2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCustom2.setText("Chọn Ảnh");
        jButtonCustom2.setBoderColor(new java.awt.Color(255, 255, 255));
        jButtonCustom2.setColoOver(new java.awt.Color(102, 255, 204));
        jButtonCustom2.setColor(new java.awt.Color(102, 204, 255));
        jButtonCustom2.setColorClick(new java.awt.Color(255, 255, 102));
        jButtonCustom2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButtonCustom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCustom2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 80, 30));
        jPanel2.add(jtxtPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 140, 30));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel10.setText("Họ Tên");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 67, 40));

        jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 240, 40));

        jLabel2.setBackground(new java.awt.Color(102, 255, 255));
        jLabel2.setOpaque(true);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 5, 250));

        jLabel14.setBackground(new java.awt.Color(102, 255, 255));
        jLabel14.setOpaque(true);
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 5, 250));

        jButtonCustom1.setText("X");
        jButtonCustom1.setBoderColor(new java.awt.Color(255, 255, 255));
        jButtonCustom1.setColoOver(new java.awt.Color(255, 102, 0));
        jButtonCustom1.setColorClick(new java.awt.Color(255, 0, 0));
        jPanel2.add(jButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1145, 0, 50, 40));

        jtxtName1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 240, 40));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel15.setText("Tìm  Tên Cán Bộ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 130, 40));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtFindKeyPressed(evt);
            }
        });
        jPanel2.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 240, 40));

        jbtFind1.setBorder(null);
        jbtFind1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_26px.png"))); // NOI18N
        jbtFind1.setText("Tìm");
        jbtFind1.setBoderColor(new java.awt.Color(153, 255, 204));
        jbtFind1.setColoOver(new java.awt.Color(0, 255, 204));
        jbtFind1.setColor(new java.awt.Color(153, 255, 204));
        jbtFind1.setColorClick(new java.awt.Color(255, 153, 153));
        jbtFind1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtFind1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFind1MouseClicked(evt);
            }
        });
        jPanel2.add(jbtFind1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 90, 40));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 730));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1191, 730));
        jPanel3.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 730));

        setSize(new java.awt.Dimension(1193, 731));
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void jbtResestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtResestMouseClicked
        Resest();
        showListStaff();
    }//GEN-LAST:event_jbtResestMouseClicked

    private void jbtStaffQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtStaffQuitActionPerformed
        showListQuitStaff();

    }//GEN-LAST:event_jbtStaffQuitActionPerformed

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdateMouseClicked
        Update();
        showListStaff();
    }//GEN-LAST:event_jbtUpdateMouseClicked

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        Insert();
        showListStaff();

    }//GEN-LAST:event_jbtAddMouseClicked

    private void jbtStaffCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtStaffCurrentActionPerformed
        showListCurrentStaff();
    }//GEN-LAST:event_jbtStaffCurrentActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        showListStaff();
        Resest();
    }//GEN-LAST:event_formWindowOpened

    private void jtbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbStaffMouseClicked
        getDataFromTable();
        String ID = jtxtID.getText();
        showDateContract(ID);
    }//GEN-LAST:event_jtbStaffMouseClicked

    private void jbtDelel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDelel1MouseClicked
        Delete();
        showListStaff();
    }//GEN-LAST:event_jbtDelel1MouseClicked

    private void jButtonCustom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustom2ActionPerformed
        JFileChooser f = new JFileChooser("D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\StaffImage");
        int result = f.showOpenDialog(this);
        f.setDialogTitle("Mở File");
        File FileName = f.getSelectedFile();
        jtxtPhoto.setText(FileName.getName());
        jlbImage.setIcon(ResizeImage(String.valueOf(url + FileName.getName())));
    }//GEN-LAST:event_jButtonCustom2ActionPerformed

    private void jtxtDateOfBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDateOfBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDateOfBirthActionPerformed

    private void jbtFind1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFind1MouseClicked
        String Name = jtxtFind.getText();
        ArrayList<Staff> list = new ArrayList<Staff>();
        if (Name.compareTo("") != 0) {
            list = staffListener.Find(Name, 2);
            showSupport(list);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên muốn tìm kiếm!");
        }


    }//GEN-LAST:event_jbtFind1MouseClicked

    private void jtxtFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtFindKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String Name = jtxtFind.getText();
            ArrayList<Staff> list = new ArrayList<Staff>();
            if (Name.compareTo("") != 0) {
                list = staffListener.Find(Name, 2);
                showSupport(list);
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên muốn tìm kiếm!");
            }
        }
    }//GEN-LAST:event_jtxtFindKeyPressed

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
//            java.util.logging.Logger.getLogger(StaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StaffManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StaffManager().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupGender;
    private jbuttonCustom.JButtonCustom jButtonCustom1;
    private view.JButtonCustom jButtonCustom2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private view.JButtonCustom jbtDelel1;
    private view.JButtonCustom jbtFind1;
    private view.JButtonCustom jbtResest;
    private view.JButtonCustom jbtStaffCurrent;
    private view.JButtonCustom jbtStaffQuit;
    private view.JButtonCustom jbtUpdate;
    private javax.swing.JLabel jlbImage;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jrdioMale;
    private javax.swing.JTable jtbStaff;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtDateEnd;
    private javax.swing.JTextField jtxtDateOfBirth;
    private javax.swing.JTextField jtxtDateStart;
    private javax.swing.JTextField jtxtFind;
    private javax.swing.JTextField jtxtID;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtName1;
    private javax.swing.JTextField jtxtPass;
    private javax.swing.JTextField jtxtPhoneNumber;
    private javax.swing.JTextField jtxtPhoto;
    // End of variables declaration//GEN-END:variables
}
