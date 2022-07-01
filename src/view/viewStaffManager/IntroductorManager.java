/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

import controller.IntroductorListener;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Charity;
import model.Introductor;
import model.LocalTime;
import view.AddJframe.ChildrenIntroduction;

/**
 *
 * @author ADMIN
 */
public class IntroductorManager extends javax.swing.JFrame {

    IntroductorListener intro = new IntroductorListener();
    ChildrenIntroduction childIntro = new ChildrenIntroduction();

    public String getID_NVQL() {
        return ID_NVQL;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL = ID_NVQL;
    }
    private String ID_NVQL;

    public IntroductorManager() {
        initComponents();
        setWidthTable();
    }

    public void setWidthTable() {

        jtbIntroductor.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbIntroductor.setBackground(Color.WHITE);
        jtbIntroductor.getColumnModel().getColumn(0).setPreferredWidth(120);
        jtbIntroductor.getColumnModel().getColumn(1).setPreferredWidth(250);
        jtbIntroductor.getColumnModel().getColumn(2).setPreferredWidth(130);
        jtbIntroductor.getColumnModel().getColumn(3).setPreferredWidth(110);
        jtbIntroductor.getColumnModel().getColumn(4).setPreferredWidth(130);
        jtbIntroductor.getColumnModel().getColumn(5).setPreferredWidth(110);
        jtbIntroductor.getColumnModel().getColumn(6).setPreferredWidth(250);
        jtbIntroductor.getColumnModel().getColumn(7).setPreferredWidth(130);
        jtbIntroductor.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 17));
        ((DefaultTableCellRenderer) jtbIntroductor.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void ClearText() {
        jtxtFind.setText("");
        jtxtNameIntro.setText("");
        jtxtAddress.setText("");
        jtxtDOB.setText("");
        jtxtPhoneNumber.setText("");
        jradioFemale.setSelected(false);
        jradioMale.setSelected(false);
        jtxtUsername.setText("");
        jtxtPass.setText("");
        jtxtDOB.setBackground(Color.white);
        jtxtPhoneNumber.setBackground(Color.white);

    }

    public void Statistic() {
        ArrayList<Introductor> list = new ArrayList<>();
        list = intro.getListIntro();
        jlbCountIntro.setText("Tổng số cá nhân giới thiệu:  " + String.valueOf(list.size()));
    }

    public void getDataFromTable() {
        int k = jtbIntroductor.getSelectedRow();
        String ID_Choose = (String) jtbIntroductor.getModel().getValueAt(k, 0);
        childIntro.setID(ID_Choose);
        ArrayList<Introductor> list = new ArrayList<Introductor>();
        list = intro.getListIntro(1, ID_Choose);
        Introductor introductor = list.get(0);
        jtxtNameIntro.setText(introductor.getName());
        jtxtAddress.setText(introductor.getAddress());
        jtxtDOB.setText(LocalTime.ChangeTypeDate_dMy(introductor.getDayOfBirth()));
        jtxtPhoneNumber.setText(introductor.getPhoneNumber());
        if (introductor.getGender().toUpperCase().compareTo("NAM") == 0) {
            jradioMale.setSelected(true);
        } else {
            jradioFemale.setSelected(true);
        }
        jtxtUsername.setText(introductor.getUsername());
        jtxtPass.setText(introductor.getPassword());
    }

    public void showSupport(ArrayList<Introductor> list) {
        DefaultTableModel model = (DefaultTableModel) jtbIntroductor.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                list.get(i).getID(), list.get(i).getName(), list.get(i).getUsername(),
                list.get(i).getPassword(), LocalTime.ChangeTypeDate_dMy(list.get(i).getDayOfBirth()),
                list.get(i).getGender(), list.get(i).getAddress(),
                list.get(i).getPhoneNumber()
            });
        }
        jtbIntroductor.setModel(model);
    }

    public void Show() {
        ArrayList<Introductor> list = new ArrayList<>();
        list = intro.getListIntro();
        showSupport(list);
    }

    public void Add() {
        String ID = intro.getListIntro().get(intro.getListIntro().size() - 1).getID();
        String[] arr = ID.split("DTGT", 2);
        ID = String.valueOf(Integer.parseInt(arr[1]) + 1);
        if (ID.length() == 1) {
            arr[0] += "00";
        } else {
            arr[0] += "0";
        }
        ID = "DTGT" + arr[0] + ID;

        String Name = jtxtNameIntro.getText();
        String DOB = jtxtDOB.getText();
//        DOB = LocalTime.ChangeTypeDate_yMd
        String Gender;
        if (jradioMale.isSelected() == true) {
            Gender = "Nam";
        } else {
            Gender = "Nữ";
        }
        String Address = jtxtAddress.getText();
        String Phone = jtxtPhoneNumber.getText();
        String Username = jtxtUsername.getText();
        String Password = jtxtPass.getText();
        if (Name.isEmpty() || DOB.isEmpty() || Address.isEmpty() || Phone.isEmpty() || Username.isEmpty() || Password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin người giới thiệu");
        } else {
            if (LocalTime.checkDate_ddMMyyyy(DOB)) {
                if (LocalTime.checkPhone(Phone)) {
                    DOB = LocalTime.ChangeTypeDate_yMd(DOB);
                    intro.AddIntro(ID, Name, DOB, Gender, Address, Phone, Integer.parseInt(ID_NVQL), Username, Password, "1");
                    Show();
                    Statistic();
                    ClearText();
                } else {
                    jtxtPhoneNumber.setBackground(new Color(255, 190, 185));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ! Vui lòng kiểm tra lại");
                jtxtDOB.setBackground(new Color(255, 190, 185));
            }
        }

    }

    public void Delete() {
        int k = jtbIntroductor.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn đối tượng muốn xoá");
        } else {
            String ID_Choose = (String) jtbIntroductor.getModel().getValueAt(k, 0);
            intro.DeleteIntro(ID_Choose);
            JOptionPane.showMessageDialog(null, "Xoá thành công đối tượng giới thiệu " + ID_Choose);
        }
    }

    public void Update() {
        int k = jtbIntroductor.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn đối tượng muốn cập nhật");
        } else {
            String ID_Choose = (String) jtbIntroductor.getModel().getValueAt(k, 0);
            String UserName_choose = (String) jtbIntroductor.getModel().getValueAt(k, 2);
            String pass = jtxtPass.getText();
            String username = jtxtUsername.getText();
            String Name = jtxtNameIntro.getText();
            String DOB = jtxtDOB.getText();
            String Address = jtxtAddress.getText();
            String Phone = jtxtPhoneNumber.getText();
            String Username = jtxtUsername.getText();
            String Password = jtxtPass.getText();
            if (LocalTime.checkDate_ddMMyyyy(DOB)) {
                if (LocalTime.checkPhone(Phone)) {
                    DOB = LocalTime.ChangeTypeDate_yMd(DOB);
                    String Gender;
                    if (jradioMale.isSelected() == true) {
                        Gender = "Nam";
                    } else {
                        Gender = "Nữ";
                    }
                    if (Name.isEmpty() || DOB.isEmpty() || Address.isEmpty() || Phone.isEmpty() || Username.isEmpty() || Password.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin người giới thiệu");
                    } else {
                        intro.Update(ID_Choose, Name, DOB, Gender, Address, Phone, Integer.parseInt(ID_NVQL), UserName_choose, username, pass, "1");
                    }
                    Show();
                    ClearText();

                } else {
                    jtxtPhoneNumber.setBackground(new Color(255, 190, 185));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ! Vui lòng kiểm tra lại");
                jtxtDOB.setBackground(new Color(255, 190, 185));
            }

        }
    }

    public void Find(int i) {
        String Text = jtxtFind.getText();
        ArrayList<Introductor> list = intro.getListIntro(i, Text);
        showSupport(list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtxtPhoneNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbIntroductor = new javax.swing.JTable();
        jtxtAddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtDOB = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jlbCountIntro = new javax.swing.JLabel();
        jtxtNameIntro = new javax.swing.JTextField();
        jbtAdd = new view.JButtonCustom();
        jbtUpdate = new view.JButtonCustom();
        jbtDisplay = new view.JButtonCustom();
        jbtDelete = new view.JButtonCustom();
        jbtWatchChild = new view.JButtonCustom();
        jLabel9 = new javax.swing.JLabel();
        jradioMale = new javax.swing.JRadioButton();
        jradioFemale = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jtxtUsername = new javax.swing.JTextField();
        jtxtPass = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jbtResest1 = new view.JButtonCustom();
        jLabel12 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Số điện thoại");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 110, 40));

        jtxtPhoneNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPhoneNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 260, 40));

        jtbIntroductor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbIntroductor.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "Họ Và Tên", "Tài Khoản", "Mật Khẩu", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbIntroductor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbIntroductor.setGridColor(new java.awt.Color(0, 204, 204));
        jtbIntroductor.setOpaque(false);
        jtbIntroductor.setRowHeight(40);
        jtbIntroductor.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbIntroductor.setShowHorizontalLines(true);
        jtbIntroductor.setShowVerticalLines(true);
        jtbIntroductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbIntroductorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbIntroductor);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1200, 340));

        jtxtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 260, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel14.setText("Ngày sinh");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, 40));

        jLabel15.setBackground(new java.awt.Color(153, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel15.setOpaque(true);
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 10, 120));

        jtxtDOB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 260, 40));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel16.setText("Địa chỉ");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 100, 40));

        jlbCountIntro.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jlbCountIntro.setText("Số lượng người giới thiệu: ");
        jPanel3.add(jlbCountIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 280, 40));

        jtxtNameIntro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNameIntro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtNameIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 260, 40));

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
        jPanel3.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 120, 50));

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
        jPanel3.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 120, 50));

        jbtDisplay.setBorder(null);
        jbtDisplay.setText("Hiển Thị");
        jbtDisplay.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDisplay.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDisplay.setColor(new java.awt.Color(51, 255, 153));
        jbtDisplay.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDisplay.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtDisplay.setRadius(40);
        jbtDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDisplayMouseClicked(evt);
            }
        });
        jPanel3.add(jbtDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 120, 50));

        jbtDelete.setBorder(null);
        jbtDelete.setText("Xoá");
        jbtDelete.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDelete.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDelete.setColor(new java.awt.Color(51, 255, 153));
        jbtDelete.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDelete.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtDelete.setRadius(40);
        jbtDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDeleteMouseClicked(evt);
            }
        });
        jPanel3.add(jbtDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 250, 120, 50));

        jbtWatchChild.setBorder(null);
        jbtWatchChild.setText("Xem trẻ được giới thiệu");
        jbtWatchChild.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtWatchChild.setColoOver(new java.awt.Color(255, 102, 51));
        jbtWatchChild.setColor(new java.awt.Color(51, 255, 153));
        jbtWatchChild.setColorClick(new java.awt.Color(0, 204, 255));
        jbtWatchChild.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtWatchChild.setRadius(40);
        jbtWatchChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtWatchChildMouseClicked(evt);
            }
        });
        jPanel3.add(jbtWatchChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 230, 50));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Giới Tính");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 90, 40));

        buttonGroup1.add(jradioMale);
        jradioMale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioMale.setText("Nam");
        jPanel3.add(jradioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        buttonGroup1.add(jradioFemale);
        jradioFemale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioFemale.setText("Nữ");
        jPanel3.add(jradioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel18.setText("Họ và tên");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 100, 40));

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel19.setText("Tài khoản");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 100, 40));

        jtxtUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 260, 40));

        jtxtPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel3.add(jtxtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 260, 40));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel20.setText("Mật khẩu");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 100, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 660));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1190, 660));

        jbtResest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset_24px.png"))); // NOI18N
        jbtResest1.setBoderColor(new java.awt.Color(255, 255, 102));
        jbtResest1.setColoOver(new java.awt.Color(102, 255, 102));
        jbtResest1.setColor(new java.awt.Color(255, 255, 102));
        jbtResest1.setColorClick(new java.awt.Color(0, 204, 51));
        jbtResest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtResest1MouseClicked(evt);
            }
        });
        jPanel1.add(jbtResest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setText("Tìm theo họ tên");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 170, 40));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 310, 40));

        jbtFind.setBackground(new java.awt.Color(255, 255, 102));
        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_24px.png"))); // NOI18N
        jbtFind.setBoderColor(new java.awt.Color(255, 255, 102));
        jbtFind.setColoOver(new java.awt.Color(102, 255, 204));
        jbtFind.setColor(new java.awt.Color(255, 255, 102));
        jbtFind.setColorClick(new java.awt.Color(102, 255, 153));
        jbtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFindMouseClicked(evt);
            }
        });
        jPanel1.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 1190, 700));

        setSize(new java.awt.Dimension(1191, 701));
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Show();
        Statistic();


    }//GEN-LAST:event_formWindowOpened

    private void jbtDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDisplayMouseClicked
        Show();
    }//GEN-LAST:event_jbtDisplayMouseClicked

    private void jbtResest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtResest1MouseClicked
        Show();
        ClearText();
    }//GEN-LAST:event_jbtResest1MouseClicked

    private void jtbIntroductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbIntroductorMouseClicked
        getDataFromTable();
    }//GEN-LAST:event_jtbIntroductorMouseClicked

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        Add();

    }//GEN-LAST:event_jbtAddMouseClicked

    private void jbtDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeleteMouseClicked
        Delete();
        Show();
        Statistic();
    }//GEN-LAST:event_jbtDeleteMouseClicked

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdateMouseClicked
        Update();

    }//GEN-LAST:event_jbtUpdateMouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        Find(2);
    }//GEN-LAST:event_jbtFindMouseClicked

    private void jbtWatchChildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtWatchChildMouseClicked

        int k = jtbIntroductor.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn đối tượng muốn xem!");
        } else {
            String ID_Choose = (String) jtbIntroductor.getModel().getValueAt(k, 0);
            childIntro.setVisible(true);
            childIntro.setIDNVQL(ID_NVQL);
            childIntro.setID(ID_Choose);
        }
    }//GEN-LAST:event_jbtWatchChildMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        childIntro.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

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
    //            java.util.logging.Logger.getLogger(IntroductorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(IntroductorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(IntroductorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(IntroductorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        //</editor-fold>
    //        //</editor-fold>
    //        //</editor-fold>
    //        //</editor-fold>
    //
    //        /* Create and display the form */
    //        java.awt.EventQueue.invokeLater(new Runnable() {
    //            public void run() {
    //                new IntroductorManager().setVisible(true);
    //            }
    //        });
    //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtDelete;
    private view.JButtonCustom jbtDisplay;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtResest1;
    private view.JButtonCustom jbtUpdate;
    private view.JButtonCustom jbtWatchChild;
    private javax.swing.JLabel jlbCountIntro;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JTable jtbIntroductor;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtFind;
    private javax.swing.JTextField jtxtNameIntro;
    private javax.swing.JTextField jtxtPass;
    private javax.swing.JTextField jtxtPhoneNumber;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
}
