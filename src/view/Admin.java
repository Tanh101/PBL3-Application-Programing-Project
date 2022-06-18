package view;

import controller.AdminListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Children;
import model.managementStaff;
import view.AddJframe.AddStaffManager;

/**
 *
 * @author ADMIN
 */
public class Admin extends javax.swing.JFrame {

    private String url = "D:\\project\\TrungTamBaoTroTreEm\\DemoPBL\\src\\Img\\StaffManagement\\";
    AddStaffManager add = new AddStaffManager();
    AdminListener adminListener = new AdminListener();
    Login log = new Login();
    private static int count = 0;

    public Admin() {
        initComponents();
        setWidthTable();
        jbtLogout.setVisible(false);
    }

    public void setWidthTable() {

        jtbStaffManager.getTableHeader().setBackground(new Color(0, 204, 255));
        jtbStaffManager.setBackground(Color.WHITE);
        jtbStaffManager.getColumnModel().getColumn(0).setPreferredWidth(110);
        jtbStaffManager.getColumnModel().getColumn(1).setPreferredWidth(110);
        jtbStaffManager.getColumnModel().getColumn(2).setPreferredWidth(130);
        jtbStaffManager.getColumnModel().getColumn(3).setPreferredWidth(300);
        jtbStaffManager.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtbStaffManager.getColumnModel().getColumn(5).setPreferredWidth(110);
        jtbStaffManager.getColumnModel().getColumn(6).setPreferredWidth(110);
        jtbStaffManager.getColumnModel().getColumn(7).setPreferredWidth(110);
        jtbStaffManager.getColumnModel().getColumn(8).setPreferredWidth(110);
        jtbStaffManager.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 17));
        ((DefaultTableCellRenderer) jtbStaffManager.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }

    public void showSupport(Vector<managementStaff> vec) {
        DefaultTableModel model = (DefaultTableModel) jtbStaffManager.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vec.size(); i++) {
            model.addRow(new Object[]{
                vec.get(i).getID_NVQL(), vec.get(i).getPassword(), vec.get(i).getCCCD(), vec.get(i).getName(),
                vec.get(i).getDateOfBirth(), vec.get(i).getGender(), vec.get(i).getPhoneNumber(),
                vec.get(i).getDateEnter(), vec.get(i).getDateQuit()
            });
        }
        jtbStaffManager.setModel(model);
    }

    public void ShowListManagerStaff() {
        Vector<managementStaff> vec = new Vector<>();
        vec = adminListener.getListManagerStaff(adminListener.getStoreProcShowAll());
//        System.out.println(vec.size());
        showSupport(vec);
    }

    public void ShowListCurrent() {
        Vector<managementStaff> vec = new Vector<>();
        vec = adminListener.getListManagerStaff(adminListener.getStoreProShowCurrent());
        showSupport(vec);
    }

    public void ShowListQuit() {
        Vector<managementStaff> vec = new Vector<>();
        vec = adminListener.getListManagerStaff(adminListener.getStoreProShowQuit());
        showSupport(vec);
    }

    public void Delete() {
        try {
            int k = jtbStaffManager.getSelectedRow();
            String ID_Choose = (String) jtbStaffManager.getModel().getValueAt(k, 0);
            Vector<managementStaff> list = new Vector<managementStaff>();
            adminListener.Delete(ID_Choose);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn xoá");
        }
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(add.getJlbImage().getWidth(), add.getJlbImage().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    public void getDataFromTable() {
        int k = jtbStaffManager.getSelectedRow();
        String ID_Choose = (String) jtbStaffManager.getModel().getValueAt(k, 0);
        Vector<managementStaff> list = new Vector<managementStaff>();
        list = adminListener.FindID(Integer.parseInt(ID_Choose));
        managementStaff mstaff = list.get(0);
        add.getJtxtIDNVQL().setText(mstaff.getID_NVQL());
        add.getJtxtPassword().setText(mstaff.getPassword());
        add.getJtxtCCCD().setText(mstaff.getCCCD());
        add.getJtxtName().setText((mstaff.getName()));
        if (mstaff.getGender().compareTo("Nam") == 0) {
            add.getJradioMale().setSelected(true);
        }
        else{
            add.getJradioFemale().setSelected(true);
        }
        add.setJtxtEmail((mstaff.getEmail()));
        add.getJtxtAddress().setText(mstaff.getAddress());
        add.getJtxtDOB().setText(mstaff.getDateOfBirth());
        add.getJtxtPhone().setText(mstaff.getPhoneNumber());
        add.getJtxtDateEnter().setText(mstaff.getDateEnter());
        add.getJtxtDateQuit().setText(mstaff.getDateQuit());
        add.getJtxtUrlImage().setText(mstaff.getImage());
        add.getJlbImage().setIcon(ResizeImage(url + add.getJtxtUrlImage().getText()));
        add.setID_Choose(ID_Choose);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtLogout = new view.JButtonCustom();
        jbtLogoutIcon = new jbuttonCustom.JButtonCustom();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbStaffManager = new javax.swing.JTable();
        jbtExit = new jbuttonCustom.JButtonCustom();
        jLabel9 = new javax.swing.JLabel();
        jtbMaxmize = new jbuttonCustom.JButtonCustom();
        jbtMinimize = new jbuttonCustom.JButtonCustom();
        jPanel6 = new javax.swing.JPanel();
        jbtShowCurrent = new view.JButtonCustom();
        jbtUpdate = new view.JButtonCustom();
        jbtAdd = new view.JButtonCustom();
        jbtShowQuit = new view.JButtonCustom();
        jbtDelete = new view.JButtonCustom();
        jbtShow = new view.JButtonCustom();
        jLabel3 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 0, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_user_64px.png"))); // NOI18N
        jLabel1.setText("ADMIN");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("____________________________________________");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 260, 20));

        jbtLogout.setText("ĐĂNG XUẤT");
        jbtLogout.setBoderColor(new java.awt.Color(102, 0, 255));
        jbtLogout.setColoOver(new java.awt.Color(153, 102, 255));
        jbtLogout.setColorClick(new java.awt.Color(255, 102, 0));
        jbtLogout.setRadius(10);
        jbtLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtLogoutMouseClicked(evt);
            }
        });
        jPanel2.add(jbtLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, 40));

        jbtLogoutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout_rounded_down_26px.png"))); // NOI18N
        jbtLogoutIcon.setBoderColor(new java.awt.Color(102, 0, 204));
        jbtLogoutIcon.setColoOver(new java.awt.Color(255, 102, 102));
        jbtLogoutIcon.setColor(new java.awt.Color(102, 0, 204));
        jbtLogoutIcon.setColorClick(new java.awt.Color(255, 102, 102));
        jbtLogoutIcon.setRadius(20);
        jbtLogoutIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtLogoutIconMouseClicked(evt);
            }
        });
        jPanel2.add(jbtLogoutIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 50, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jtbStaffManager.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jtbStaffManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_NVQL", "Mật Khẩu", "CCCD", "Họ Tên", "Ngày Sinh", "Giới Tính", "SĐT", "Ngày Bắt Đầu", "Ngày Nghĩ Việc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbStaffManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbStaffManager.setGridColor(new java.awt.Color(0, 204, 204));
        jtbStaffManager.setOpaque(false);
        jtbStaffManager.setRowHeight(40);
        jtbStaffManager.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jtbStaffManager.setShowHorizontalLines(true);
        jtbStaffManager.setShowVerticalLines(true);
        jtbStaffManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbStaffManagerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbStaffManager);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtExit.setText("X");
        jbtExit.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtExit.setColoOver(new java.awt.Color(255, 102, 102));
        jbtExit.setColorClick(new java.awt.Color(255, 51, 0));
        jbtExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtExitMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ NHÂN VIÊN");

        jtbMaxmize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/maximize_window_24px.png"))); // NOI18N
        jtbMaxmize.setBoderColor(new java.awt.Color(255, 255, 255));
        jtbMaxmize.setColoOver(new java.awt.Color(255, 102, 102));
        jtbMaxmize.setColorClick(new java.awt.Color(255, 51, 0));
        jtbMaxmize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMaxmizeMouseClicked(evt);
            }
        });

        jbtMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/subtract_16px.png"))); // NOI18N
        jbtMinimize.setBoderColor(new java.awt.Color(255, 255, 255));
        jbtMinimize.setColoOver(new java.awt.Color(255, 102, 102));
        jbtMinimize.setColorClick(new java.awt.Color(255, 51, 0));
        jbtMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtMinimizeMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jbtShowCurrent.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jbtShowCurrent.setText("Nhân viên hiện tại");
        jbtShowCurrent.setBoderColor(new java.awt.Color(0, 255, 204));
        jbtShowCurrent.setColoOver(new java.awt.Color(102, 255, 102));
        jbtShowCurrent.setColor(new java.awt.Color(0, 255, 204));
        jbtShowCurrent.setColorClick(new java.awt.Color(204, 255, 102));
        jbtShowCurrent.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jbtShowCurrent.setRadius(20);
        jbtShowCurrent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtShowCurrentMouseClicked(evt);
            }
        });

        jbtUpdate.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jbtUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reset_24px.png"))); // NOI18N
        jbtUpdate.setText("Cập Nhật");
        jbtUpdate.setBoderColor(new java.awt.Color(0, 255, 204));
        jbtUpdate.setColoOver(new java.awt.Color(102, 255, 102));
        jbtUpdate.setColor(new java.awt.Color(0, 255, 204));
        jbtUpdate.setColorClick(new java.awt.Color(204, 255, 102));
        jbtUpdate.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jbtUpdate.setRadius(20);
        jbtUpdate.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jbtUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtUpdateMouseClicked(evt);
            }
        });

        jbtAdd.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jbtAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/add_24px.png"))); // NOI18N
        jbtAdd.setText("Thêm");
        jbtAdd.setBoderColor(new java.awt.Color(0, 255, 204));
        jbtAdd.setColoOver(new java.awt.Color(102, 255, 102));
        jbtAdd.setColor(new java.awt.Color(0, 255, 204));
        jbtAdd.setColorClick(new java.awt.Color(204, 255, 102));
        jbtAdd.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jbtAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtAdd.setRadius(20);
        jbtAdd.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jbtAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddMouseClicked(evt);
            }
        });

        jbtShowQuit.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jbtShowQuit.setText("Nhân viên thôi việc");
        jbtShowQuit.setBoderColor(new java.awt.Color(0, 255, 204));
        jbtShowQuit.setColoOver(new java.awt.Color(102, 255, 102));
        jbtShowQuit.setColor(new java.awt.Color(0, 255, 204));
        jbtShowQuit.setColorClick(new java.awt.Color(204, 255, 102));
        jbtShowQuit.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jbtShowQuit.setRadius(20);
        jbtShowQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtShowQuitMouseClicked(evt);
            }
        });

        jbtDelete.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jbtDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Delete_24px.png"))); // NOI18N
        jbtDelete.setText("Xoá");
        jbtDelete.setBoderColor(new java.awt.Color(0, 255, 204));
        jbtDelete.setColoOver(new java.awt.Color(102, 255, 102));
        jbtDelete.setColor(new java.awt.Color(0, 255, 204));
        jbtDelete.setColorClick(new java.awt.Color(204, 255, 102));
        jbtDelete.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jbtDelete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtDelete.setRadius(20);
        jbtDelete.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jbtDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDeleteMouseClicked(evt);
            }
        });

        jbtShow.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jbtShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/list_view_24px.png"))); // NOI18N
        jbtShow.setText("Hiển thị");
        jbtShow.setBoderColor(new java.awt.Color(0, 255, 204));
        jbtShow.setColoOver(new java.awt.Color(102, 255, 102));
        jbtShow.setColor(new java.awt.Color(0, 255, 204));
        jbtShow.setColorClick(new java.awt.Color(204, 255, 102));
        jbtShow.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jbtShow.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtShow.setRadius(20);
        jbtShow.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jbtShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtShowMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jbtAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jbtShowQuit, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(jbtUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jbtShow, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(jbtShowCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addComponent(jbtDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbtShowQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbtUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbtShowCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbtShow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel3.setBackground(new java.awt.Color(102, 0, 204));
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtbMaxmize, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtExit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtbMaxmize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1245, 714));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        add.setVisible(true);
        add.getJbtUpdate().setVisible(false);
        add.getJbttAdd().setVisible(true);
        add.getJtxtDateEnter().setEnabled(false);
        add.getJtxtDateQuit().setEnabled(false);
//        add.Resest();

    }//GEN-LAST:event_jbtAddMouseClicked

    private void jtbStaffManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbStaffManagerMouseClicked
//        getDataFromTable();
//                String ID = jtxtID.getText();
//                showDateContract(ID);
    }//GEN-LAST:event_jtbStaffManagerMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ShowListManagerStaff();
    }//GEN-LAST:event_formWindowOpened

    private void jbtLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLogoutMouseClicked
        this.setVisible(false);
        log.setVisible(true);
    }//GEN-LAST:event_jbtLogoutMouseClicked

    private void jbtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jbtExitMouseClicked

    private void jtbMaxmizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMaxmizeMouseClicked
        if (count % 2 == 0) {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            setExtendedState(JFrame.NORMAL);
        }
        count++;

    }//GEN-LAST:event_jtbMaxmizeMouseClicked

    private void jbtMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtMinimizeMouseClicked
        setExtendedState(JFrame.HIDE_ON_CLOSE);

    }//GEN-LAST:event_jbtMinimizeMouseClicked

    private void jbtShowQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtShowQuitMouseClicked
        ShowListQuit();
    }//GEN-LAST:event_jbtShowQuitMouseClicked

    private void jbtShowCurrentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtShowCurrentMouseClicked
        ShowListCurrent();
    }//GEN-LAST:event_jbtShowCurrentMouseClicked

    private void jbtDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeleteMouseClicked
        Delete();
        ShowListCurrent();
    }//GEN-LAST:event_jbtDeleteMouseClicked

    private void jbtUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtUpdateMouseClicked
        int k = jtbStaffManager.getSelectedRow();
        if (k < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn Nhân viên muốn cập nhật thông tin");
        } else {
            add.setVisible(true);
            add.getJbtUpdate().setVisible(true);
            add.getJbttAdd().setVisible(false);
            add.getJtxtDateEnter().setEnabled(true);
            add.getJtxtDateQuit().setEnabled(true);
            getDataFromTable();
        }
    }//GEN-LAST:event_jbtUpdateMouseClicked

    private void jbtLogoutIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtLogoutIconMouseClicked
        if (count % 2 == 0) {
            jbtLogout.setVisible(true);
        } else {
            jbtLogout.setVisible(false);
        }
        count++;

    }//GEN-LAST:event_jbtLogoutIconMouseClicked

    private void jbtShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtShowMouseClicked
        ShowListManagerStaff();   
    }//GEN-LAST:event_jbtShowMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ShowListManagerStaff();   
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private view.JButtonCustom jbtAdd;
    private view.JButtonCustom jbtDelete;
    private jbuttonCustom.JButtonCustom jbtExit;
    private view.JButtonCustom jbtLogout;
    private jbuttonCustom.JButtonCustom jbtLogoutIcon;
    private jbuttonCustom.JButtonCustom jbtMinimize;
    private view.JButtonCustom jbtShow;
    private view.JButtonCustom jbtShowCurrent;
    private view.JButtonCustom jbtShowQuit;
    private view.JButtonCustom jbtUpdate;
    private jbuttonCustom.JButtonCustom jtbMaxmize;
    private javax.swing.JTable jtbStaffManager;
    // End of variables declaration//GEN-END:variables
}
