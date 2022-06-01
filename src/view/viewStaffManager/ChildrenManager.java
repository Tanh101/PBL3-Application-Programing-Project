/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewStaffManager;

import controller.ChildrenListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Children;
import model.Staff;

/**
 *
 * @author ADMIN
 */
public class ChildrenManager extends javax.swing.JFrame {

    private String url = "D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\ChildrenImage\\";
    private String ID_NVQL;

    public void setID_NVQL(String id) {
        this.ID_NVQL = id;
    }
    private ChildrenListener childrenListener = new ChildrenListener();

    /**
     * Creates new form Equipment
     */
    public ChildrenManager() {
        initComponents();
        setWidthTable();
        ShowChild(1);

    }

    public void setWidthTable() {
        jtbChildren.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbChildren.setBackground(Color.WHITE);
        jtbChildren.getColumnModel().getColumn(0).setPreferredWidth(90);
        jtbChildren.getColumnModel().getColumn(1).setPreferredWidth(180);
        jtbChildren.getColumnModel().getColumn(2).setPreferredWidth(110);
        jtbChildren.getColumnModel().getColumn(3).setPreferredWidth(350);
        jtbChildren.getColumnModel().getColumn(4).setPreferredWidth(110);
        jtbChildren.getColumnModel().getColumn(5).setPreferredWidth(120);
        jtbChildren.getColumnModel().getColumn(6).setPreferredWidth(120);
        jtbChildren.getColumnModel().getColumn(7).setPreferredWidth(120);
        jtbChildren.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
        ((DefaultTableCellRenderer) jtbChildren.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void getDataFromTable() {
        int k = jtbChildren.getSelectedRow();
        String ID_Choose = (String) jtbChildren.getModel().getValueAt(k, 0);
        ArrayList<Children> list = new ArrayList<Children>();
        list = childrenListener.FindChild(1, ID_Choose);
        Children s = list.get(0);
        jtxtName.setText(s.getName());
        jtxtDOB.setText(s.getDateOfBirth());
        jtxtAddress.setText(s.getAddress());
        if (s.getGender().compareTo("Nam") == 0) {
            jradioMale.setSelected(true);
        } else {
            jradioFemale.setSelected(true);
        }
        jtxtPath.setText(s.getUrlPath());
        jlbImage.setIcon(ResizeImage(url + s.getUrlPath()));
        jtxtSituation.setText(s.getSituation());
        jtxtDateEnter.setText(s.getDateEnter());
        jtxtDateQuit.setText(s.getDateQuit());
    }

    public void showSupport(ArrayList<Children> list) {
        DefaultTableModel model = (DefaultTableModel) jtbChildren.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                list.get(i).getID_TRE(), list.get(i).getName(), list.get(i).getDateOfBirth(), list.get(i).getAddress(),
                list.get(i).getGender(), list.get(i).getSituation(), list.get(i).getDateEnter(), list.get(i).getDateQuit()
            });
        }
        jtbChildren.setModel(model);
    }

    public void ShowChild(int i) {
        ArrayList<Children> list = new ArrayList<>();
        list = childrenListener.getListChildren(childrenListener.proShowChild(i));
        showSupport(list);
    }
    public void Find(int i, String Text) {
        ArrayList<Children> list = new ArrayList<>();
        list = childrenListener.FindChild(i, Text);
        showSupport(list);
    }

//    public void FindName(String Name) {
//        ArrayList<Children> list = new ArrayList<>();
//        list = childrenListener.FindName(Name);
//        showSupport(list);
//    }

    public void Add() {
        ArrayList<Children> list = new ArrayList<>();
        list = childrenListener.getListChildren(childrenListener.proShowChild(1));
        String tmp = list.get(list.size() - 1).getID_TRE();
        String[] arr = tmp.split("TRE", 2);

        String ID = "TRE";
        if (arr[1].length() == 3 && String.valueOf(Integer.parseInt(arr[1]) + 1).length() == 1) {
            ID += "00";
        } else {
            ID += "0";
        }
        int tmp2 = Integer.parseInt(arr[1]) + 1;
        ID += String.valueOf(tmp2);

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        String Name = jtxtName.getText();
        String DOB = jtxtDOB.getText();
        String Address = jtxtAddress.getText();
        String Gender = "";
        if (jradioMale.isSelected()) {
            Gender = "Nam";
        } else if (jradioFemale.isSelected()) {
            Gender = "Nữ";
        }
        String Situation = jtxtSituation.getText();
        String DateEnter = date.toString();
        String DateQuit = jtxtDateQuit.getText();
        if (DateQuit.compareTo("") == 0) {
            DateQuit = null;
        }
        String NamePhoto = jtxtPath.getText();
        if (NamePhoto.compareTo("") == 0) {
            NamePhoto = url + "default.png";
        }
        if (ID.isEmpty() || Name.isEmpty() || DOB.isEmpty() || Address.isEmpty()
                || Gender.isEmpty() || DateEnter.isEmpty()) {
            showMessageDialog(null, "Không được để trống thông tin nhân viên!");
        } else {
            childrenListener.Insert(ID, Name, DOB, Address, Gender, NamePhoto,"1" ,Situation,  ID_NVQL, DateEnter, DateQuit);
            showMessageDialog(null, "Thêm trẻ " + ID + " thành công");
        }
        
    }

    public void Update() {
        int k = jtbChildren.getSelectedRow();
        if (k < 0) {
            showMessageDialog(null, "Vui lòng chọn trẻ muốn cập nhật");
        } else {
            String ID_Choose = (String) jtbChildren.getModel().getValueAt(k, 0);
            String Name = jtxtName.getText();
            String DOB = jtxtDOB.getText();
            String Address = jtxtAddress.getText();
            String Gender = "";
            if (jradioMale.isSelected()) {
                Gender = "Nam";
            } else if (jradioFemale.isSelected()) {
                Gender = "Nữ";
            }
            String NamePhoto = jtxtPath.getText();
            if (NamePhoto.compareTo("") == 0) {
                NamePhoto = url + "default.png";
            }
            String Situation = jtxtSituation.getText();
            String DateEnter = jtxtDateEnter.getText();
            String DateQuit = jtxtDateQuit.getText();
            if (DateQuit.compareTo("") == 0) {
                DateQuit = null;
            }
            if (Name.isEmpty() || DOB.isEmpty() || Address.isEmpty()
                    || Gender.isEmpty() || DateEnter.isEmpty()) {
                showMessageDialog(null, "Không được để trống thông tin nhân viên!");

            } else {
                childrenListener.Update(ID_Choose, Name, DOB, Address, Gender, NamePhoto,Situation, ID_NVQL, DateEnter, DateQuit);
                showMessageDialog(null, "Cập nhật trẻ " + ID_Choose + " thành công");
            }
        }

    }

    public void Reset() {
        jtxtPath.setText("");
        jtxtName.setText("");
        jtxtDOB.setText("");
        jtxtAddress.setText("");
        jradioMale.setSelected(false);
        jradioFemale.setSelected(false);
        jtxtDateEnter.setText("");
        jtxtDateQuit.setText("");
        jtxtPath.setText("");
        jtxtSituation.setText("");
        jlbImage.setIcon(ResizeImage(url + "default.png"));
    }

    public void Delete() {
        int k = jtbChildren.getSelectedRow();
        if (k < 0) {
            showMessageDialog(null, "Vui lòng chọn trẻ muốn cập nhật");
        } else {
            String ID_Choose = (String) jtbChildren.getModel().getValueAt(k, 0);
            childrenListener.Delete(ID_Choose);
            showMessageDialog(null, "Xoá Trẻ " + ID_Choose + " thành công!");
        }
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(jlbImage.getWidth(), jlbImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    public void Statistic() {
        ArrayList<Children> list = new ArrayList<>();
        list = childrenListener.getListChildren(childrenListener.proShowChild(3));
        jlbNumofChildOut.setText(String.valueOf(list.size()));
        list = childrenListener.getListChildren(childrenListener.proShowChild(2));
        jlbNumofCurrentChild.setText(String.valueOf(list.size()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButtonCustom1 = new view.JButtonCustom();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtAddress = new javax.swing.JTextField();
        jbtUpdate = new view.JButtonCustom();
        jtxtPath = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtDateQuit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtDateEnter = new javax.swing.JTextField();
        jbtChildQuit = new view.JButtonCustom();
        jbtResest = new view.JButtonCustom();
        jLabel6 = new javax.swing.JLabel();
        jtxtDOB = new javax.swing.JTextField();
        jtxtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jbtAdd = new view.JButtonCustom();
        jbtChildCurrent = new view.JButtonCustom();
        jLabel10 = new javax.swing.JLabel();
        jbtDelel = new view.JButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbChildren = new javax.swing.JTable();
        jlbNumofChildOut = new javax.swing.JLabel();
        jradioFemale = new javax.swing.JRadioButton();
        jradioMale = new javax.swing.JRadioButton();
        jlbImage = new javax.swing.JLabel();
        ChooseFile = new view.JButtonCustom();
        jLabel12 = new javax.swing.JLabel();
        jblDemo1 = new javax.swing.JLabel();
        jlbNumofCurrentChild = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtSituation = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtFind = new javax.swing.JTextField();
        jbtFind = new view.JButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(330, 70, 70, 70));
        setUndecorated(true);
        setSize(new java.awt.Dimension(840, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCustom1.setText("X");
        jButtonCustom1.setBoderColor(new java.awt.Color(255, 255, 255));
        jButtonCustom1.setColoOver(new java.awt.Color(255, 51, 51));
        jButtonCustom1.setColorClick(new java.awt.Color(255, 51, 51));
        jButtonCustom1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCustom1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCustom1MouseClicked(evt);
            }
        });
        jPanel1.add(jButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 50, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Địa Chỉ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 80, 40));

        jtxtAddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 240, 40));

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
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(jbtUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 120, 50));

        jtxtPath.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtPath.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPathActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 170, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setText("Ngày rời TT");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 100, 40));

        jtxtDateQuit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateQuit.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDateQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 240, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Ngày nhận nuôi");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 110, 40));

        jtxtDateEnter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDateEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDateEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 240, 40));

        jbtChildQuit.setBorder(null);
        jbtChildQuit.setText("Trẻ Đã Rời");
        jbtChildQuit.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtChildQuit.setColoOver(new java.awt.Color(255, 102, 51));
        jbtChildQuit.setColor(new java.awt.Color(51, 255, 153));
        jbtChildQuit.setColorClick(new java.awt.Color(0, 204, 255));
        jbtChildQuit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtChildQuit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtChildQuit.setRadius(40);
        jbtChildQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtChildQuitMouseClicked(evt);
            }
        });
        jbtChildQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtChildQuitActionPerformed(evt);
            }
        });
        jPanel2.add(jbtChildQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 250, 130, 50));

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
        jbtResest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResestActionPerformed(evt);
            }
        });
        jPanel2.add(jbtResest, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 120, 50));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("Ngày Sinh");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 80, 40));

        jtxtDOB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 240, 40));

        jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 240, 40));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Giới Tính");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 90, 40));

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
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });
        jPanel2.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 120, 50));

        jbtChildCurrent.setBorder(null);
        jbtChildCurrent.setText("Trẻ Hiện Tại");
        jbtChildCurrent.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtChildCurrent.setColoOver(new java.awt.Color(255, 102, 51));
        jbtChildCurrent.setColor(new java.awt.Color(51, 255, 153));
        jbtChildCurrent.setColorClick(new java.awt.Color(0, 204, 255));
        jbtChildCurrent.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtChildCurrent.setRadius(40);
        jbtChildCurrent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtChildCurrentMouseClicked(evt);
            }
        });
        jbtChildCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtChildCurrentActionPerformed(evt);
            }
        });
        jPanel2.add(jbtChildCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 130, 50));

        jLabel10.setBackground(new java.awt.Color(153, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel10.setOpaque(true);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 10, 150));

        jbtDelel.setBorder(null);
        jbtDelel.setText("Xoá");
        jbtDelel.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtDelel.setColoOver(new java.awt.Color(255, 102, 51));
        jbtDelel.setColor(new java.awt.Color(51, 255, 153));
        jbtDelel.setColorClick(new java.awt.Color(0, 204, 255));
        jbtDelel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtDelel.setRadius(40);
        jbtDelel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDelelMouseClicked(evt);
            }
        });
        jbtDelel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDelelActionPerformed(evt);
            }
        });
        jPanel2.add(jbtDelel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 120, 50));

        jtbChildren.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbChildren.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_TRE", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "Giới Tính", "Hoàn cảnh", "Ngày nhận vào", "Ngày rời"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbChildren.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbChildren.setGridColor(new java.awt.Color(0, 204, 204));
        jtbChildren.setOpaque(false);
        jtbChildren.setRowHeight(40);
        jtbChildren.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbChildren.setShowHorizontalLines(true);
        jtbChildren.setShowVerticalLines(true);
        jtbChildren.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbChildrenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbChildren);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1200, 340));

        jlbNumofChildOut.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jPanel2.add(jlbNumofChildOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 50, 40));

        buttonGroupGender.add(jradioFemale);
        jradioFemale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioFemale.setText("Nữ");
        jPanel2.add(jradioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 90, -1, -1));

        buttonGroupGender.add(jradioMale);
        jradioMale.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jradioMale.setText("Nam");
        jPanel2.add(jradioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 90, -1, -1));

        jlbImage.setOpaque(true);
        jPanel2.add(jlbImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 160, 150));

        ChooseFile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ChooseFile.setText("Chọn Ảnh");
        ChooseFile.setBoderColor(new java.awt.Color(255, 255, 255));
        ChooseFile.setColoOver(new java.awt.Color(255, 255, 51));
        ChooseFile.setColor(new java.awt.Color(0, 255, 204));
        ChooseFile.setColorClick(new java.awt.Color(255, 153, 51));
        ChooseFile.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ChooseFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChooseFileMouseClicked(evt);
            }
        });
        ChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseFileActionPerformed(evt);
            }
        });
        jPanel2.add(ChooseFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 90, 30));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setText("Họ Tên");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 90, 40));

        jblDemo1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jblDemo1.setText("Số trẻ hiện tại trong trung tâm:");
        jPanel2.add(jblDemo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 220, 40));

        jlbNumofCurrentChild.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jPanel2.add(jlbNumofCurrentChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 50, 40));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel15.setText("Số trẻ đã rời trung tâm: ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 170, 40));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setText("Hoàn Cảnh");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 80, 40));

        jtxtSituation.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtSituation.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtSituation, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 180, 240, 40));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1190, 660));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("Tìm  Tên Trẻ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 100, 40));

        jtxtFind.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFind.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(jtxtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 240, 40));

        jbtFind.setBorder(null);
        jbtFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search_26px.png"))); // NOI18N
        jbtFind.setText("Tìm");
        jbtFind.setBoderColor(new java.awt.Color(153, 255, 204));
        jbtFind.setColoOver(new java.awt.Color(0, 255, 204));
        jbtFind.setColor(new java.awt.Color(153, 255, 204));
        jbtFind.setColorClick(new java.awt.Color(255, 153, 153));
        jbtFind.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jbtFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFindMouseClicked(evt);
            }
        });
        jPanel1.add(jbtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 700));

        setSize(new java.awt.Dimension(1191, 701));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCustom1MouseClicked

        this.setVisible(false);
    }//GEN-LAST:event_jButtonCustom1MouseClicked

    private void jbtDelelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDelelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDelelActionPerformed

    private void jbtDelelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDelelMouseClicked
        Delete();
        ShowChild(1);
        Statistic();
    }//GEN-LAST:event_jbtDelelMouseClicked

    private void jbtChildCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtChildCurrentActionPerformed

    }//GEN-LAST:event_jbtChildCurrentActionPerformed

    private void jbtChildCurrentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtChildCurrentMouseClicked
        ShowChild(2);
    }//GEN-LAST:event_jbtChildCurrentMouseClicked

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        Add();
        ShowChild(1);
        Reset();
        Statistic();
    }//GEN-LAST:event_jbtAddMouseClicked

    private void jbtResestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResestActionPerformed

    }//GEN-LAST:event_jbtResestActionPerformed

    private void jbtResestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtResestMouseClicked
        ShowChild(1);
        Reset();
    }//GEN-LAST:event_jbtResestMouseClicked

    private void jbtFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFindMouseClicked
        String Name = jtxtFind.getText();
        if (Name.compareTo("") == 0) {
            showMessageDialog(null, "Vui lòng nhập thông tin cần tìm kiếm");
        }else{
            Find( 2, Name);
        }

    }//GEN-LAST:event_jbtFindMouseClicked

    private void jbtChildQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtChildQuitActionPerformed

    }//GEN-LAST:event_jbtChildQuitActionPerformed

    private void jbtChildQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtChildQuitMouseClicked
        ShowChild(3);
    }//GEN-LAST:event_jbtChildQuitMouseClicked

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdateMouseClicked
        Update();
        ShowChild(1);
        Reset();
    }//GEN-LAST:event_jbtUpdateMouseClicked

    private void jtbChildrenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbChildrenMouseClicked
        getDataFromTable();
//        String ID = jtxtID.getText();
//        showDateContract(ID);
    }//GEN-LAST:event_jtbChildrenMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ShowChild(1);
        Statistic();
    }//GEN-LAST:event_formWindowOpened

    private void ChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseFileActionPerformed

    }//GEN-LAST:event_ChooseFileActionPerformed

    private void ChooseFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChooseFileMouseClicked

        JFileChooser f = new JFileChooser("D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\ChildrenImage");
        int result = f.showOpenDialog(this);
        f.setDialogTitle("Mở File");
        File FileName = f.getSelectedFile();
        jtxtPath.setText(FileName.getName());
        jlbImage.setIcon(ResizeImage(String.valueOf(url + FileName.getName())));
    }//GEN-LAST:event_ChooseFileMouseClicked

    private void jtxtPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPathActionPerformed

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
//            java.util.logging.Logger.getLogger(ChildrenManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChildrenManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChildrenManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChildrenManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChildrenManager().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.JButtonCustom ChooseFile;
    private javax.swing.ButtonGroup buttonGroupGender;
    private view.JButtonCustom jButtonCustom1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jblDemo1;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtChildCurrent;
    private view.JButtonCustom jbtChildQuit;
    private view.JButtonCustom jbtDelel;
    private view.JButtonCustom jbtFind;
    private view.JButtonCustom jbtResest;
    private view.JButtonCustom jbtUpdate;
    private javax.swing.JLabel jlbImage;
    private javax.swing.JLabel jlbNumofChildOut;
    private javax.swing.JLabel jlbNumofCurrentChild;
    private javax.swing.JRadioButton jradioFemale;
    private javax.swing.JRadioButton jradioMale;
    private javax.swing.JTable jtbChildren;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtDOB;
    private javax.swing.JTextField jtxtDateEnter;
    private javax.swing.JTextField jtxtDateQuit;
    private javax.swing.JTextField jtxtFind;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtPath;
    private javax.swing.JTextField jtxtSituation;
    // End of variables declaration//GEN-END:variables
}
