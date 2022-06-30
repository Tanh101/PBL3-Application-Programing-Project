/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import static javax.swing.JOptionPane.showMessageDialog;
import model.Children;
import model.LocalTime;
import model.managementStaff;

/**
 *
 * @author ADMIN
 */
public class AdminListener extends ConnectDatabase {

    private LocalTime localTime = new LocalTime();

    public String getStoreProcShowAll() {
        return "ShowListStaff";
    }

    public String getStoreProShowCurrent() {
        return "ShowListCurrent";
    }

    public String getStoreProShowQuit() {
        return "ShowListQuit";
    }

    public ArrayList<managementStaff> getListManagerStaff(String sql) {
        ArrayList<managementStaff> list = new ArrayList<managementStaff>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                managementStaff managerStaff = new managementStaff();
                managerStaff.setID_NVQL(rs.getString(1));
                managerStaff.setPassword(rs.getString(2));
                managerStaff.setCCCD(rs.getString(3));
                managerStaff.setName(rs.getString(4));
                managerStaff.setDateOfBirth(rs.getDate(5).toString());
                managerStaff.setGender(rs.getString(6));
                managerStaff.setAddress(rs.getString(7));
                managerStaff.setPhoneNumber(rs.getString(8));
                managerStaff.setEmail(rs.getString(9));
                managerStaff.setDateEnter(rs.getDate(10).toString());
                Date date = rs.getDate(11);
                if (date == null) {
                    managerStaff.setDateQuit("");
                } else {
                    managerStaff.setDateQuit(date.toString());
                }
                managerStaff.setImage(rs.getString(12));
                list.add(managerStaff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private String StoreProDelete() {
        return "DeleteNVQL @ID_Choose = ?, @NgayNghiViec = ?";
    }

    public void Delete(String ID_NVQL) {
        String sql = StoreProDelete();
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, ID_NVQL);
            stat.setString(2, localTime.getDateNow());
            stat.executeUpdate();
            showMessageDialog(null, "Xoá Nhân Viên Quản lí có ID: " + ID_NVQL + " thành công !");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }

    }

    private String StroreProcudureAdd() {
        return "AddNVQL @ID_NVQL = ?, @Pass= ?, @ROLE = ?,  @CCCD = ?, @NAME = ?,@DOB = ?,@GENDER = ?,"
                + "@ADDRESS = ?,@PHONE = ?,@EMAIL = ?, @DATEENTER = ?, @DATEQUIT= ?, @IMGAE = ?";
    }

    public void Insert(String IDNVQL, String Pass, int Role, String CCCD, String Name, String DOB, String Gender, String Address,
            String Phone, String Email, String DateEnter, String DateQuit, String Image) {
        String sql = StroreProcudureAdd();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, IDNVQL);
            pre.setString(2, Pass);
            pre.setInt(3, Role);
            pre.setString(4, CCCD);
            pre.setString(5, Name);
            pre.setString(6, DOB);
            pre.setString(7, Gender);
            pre.setString(8, Address);
            pre.setString(9, Phone);
            pre.setString(10, Email);
            pre.setString(11, DateEnter);
            pre.setString(12, DateQuit);
            pre.setString(13, Image);
            pre.executeUpdate();
            showMessageDialog(null, "Thêm Nhân Viên Thành Công!");

        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<managementStaff> FindID(String ID) {
//        return "FindID @ID=? ";
        ArrayList<managementStaff> list = new ArrayList<managementStaff>();
        try {
            PreparedStatement pre = conn.prepareStatement("FindID @ID=?");
            pre.setString(1, ID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                managementStaff managerStaff = new managementStaff();
                managerStaff.setID_NVQL(rs.getString(1));
                managerStaff.setPassword(rs.getString(2));
                managerStaff.setCCCD(rs.getString(3));
                managerStaff.setName(rs.getString(4));
                managerStaff.setDateOfBirth(rs.getDate(5).toString());
                managerStaff.setGender(rs.getString(6));
                managerStaff.setAddress(rs.getString(7));
                managerStaff.setPhoneNumber(rs.getString(8));
                managerStaff.setEmail(rs.getString(9));
                managerStaff.setDateEnter(rs.getDate(10).toString());
                Date date = rs.getDate(11);
                if (date == null) {
                    managerStaff.setDateQuit("");
                } else {
                    managerStaff.setDateQuit(date.toString());
                }
                managerStaff.setImage(rs.getString(12));
                list.add(managerStaff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private String StoreProcedureUpdate() {
        return "UpdateNVQL @ID_CHOOSE = ?,@Pass = ?, @CCCD = ?,@NAME = ?,@DOB = ?,@GENDER = ?,\n"
                + "@ADDRESS = ?,@PHONE = ?,@EMAIL = ?,@DATEENTER = ?,@DATEQUIT = ?,@IMGAE = ?";
    }

    public void Update(String ID_Choose, String Pass, String CCCD, String Name, String DOB, String Gender, String Address,
            String Phone, String Email, String DateEnter, String DateQuit, String Image) {
        String sql = StoreProcedureUpdate();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_Choose);
            pre.setString(2, Pass);
            pre.setString(3, CCCD);
            pre.setString(4, Name);
            pre.setString(5, DOB);
            pre.setString(6, Gender);
            pre.setString(7, Address);
            pre.setString(8, Phone);
            pre.setString(9, Email);
            pre.setString(10, DateEnter);
            pre.setString(11, DateQuit);
            pre.setString(12, Image);
            pre.executeUpdate();
            showMessageDialog(null, "Cập Nhật Nhân Viên " + String.valueOf(ID_Choose) + " Thành Công!");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }

    }

    public static void main(String[] args) {
//        AdminListener adminListener = new AdminListener();
//        Vector<managementStaff> vec = new Vector<>();
//        vec = adminListener.getListManagerStaff(adminListener.getStoreProcShowAll());
//        System.out.println(vec.size());
    }
}
