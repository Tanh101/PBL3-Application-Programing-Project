package controller;

import controller.ConnectDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Notification;
import model.Staff;
import model.LaborContract;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class StaffManagerListener extends ConnectDatabase {

    public Vector<Staff> getListStaff() {
        Vector<Staff> list = new Vector();
        try {
            String sql = "SELECT C.ID_CBNV, t.PASSWORD, C.HoTen, C.NgaySinh, C.SDT, C.GioiTinh, C.QueQuan, C.TenAnh\n"
                    + "FROM CANBONHANVIEN C\n"
                    + "INNER JOIN TAIKHOANCB T\n"
                    + "ON C.ID_CBNV = T.ID_CBNV";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setID_CBNV(rs.getString(1));
                staff.setPassword(rs.getString(2));
                staff.setName(rs.getString(3));
                staff.setDateOfBirth(rs.getDate(4).toString());
                staff.setPhoneNumber(rs.getString(5));
                staff.setGender(rs.getString(6));
                staff.setAddress(rs.getString(7));
                staff.setNamePhoto(rs.getString(8));
                list.add(staff);
            }
//            for (Staff i : list) {
////                System.err.println(i.getDateOfBirth());
//            }
        } catch (Exception e) {
        }
        return list;
    }

    public Vector<Staff> getListStaffCurent() {
        Vector<Staff> list = new Vector();
        try {
            String sql = "SELECT C.ID_CBNV, t.PASSWORD, C.HoTen, C.NgaySinh, C.SDT, C.GioiTinh, C.QueQuan, C.TenAnh\n"
                    + "FROM CANBONHANVIEN C\n"
                    + "INNER JOIN TAIKHOANCB T\n"
                    + "ON C.ID_CBNV = T.ID_CBNV\n"
                    + "INNER JOIN HOPDONGLAODONG H\n"
                    + "ON H.ID_CBNV = C.ID_CBNV\n"
                    + "WHERE H.NgayKetThucLam IS NULL;";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setID_CBNV(rs.getString(1));
                staff.setPassword(rs.getString(2));
                staff.setName(rs.getString(3));
                staff.setDateOfBirth(rs.getDate(4).toString());
                staff.setPhoneNumber(rs.getString(5));
                staff.setGender(rs.getString(6));
                staff.setAddress(rs.getString(7));
                staff.setNamePhoto(rs.getString(8));
                list.add(staff);
            }
//            for (Staff i : list) {
////                System.err.println(i.getDateOfBirth());
//            }
        } catch (Exception e) {
        }
        return list;
    }

    public Vector<Staff> getListStaffQuit() {
        Vector<Staff> list = new Vector();
        try {
            String sql = "SELECT C.ID_CBNV, t.PASSWORD, C.HoTen, C.NgaySinh, C.SDT, C.GioiTinh, C.QueQuan, C.TenAnh\n"
                    + "FROM CANBONHANVIEN C\n"
                    + "INNER JOIN TAIKHOANCB T\n"
                    + "ON C.ID_CBNV = T.ID_CBNV\n"
                    + "INNER JOIN HOPDONGLAODONG H\n"
                    + "ON H.ID_CBNV = C.ID_CBNV\n"
                    + "WHERE H.NgayKetThucLam IS NOT NULL;";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setID_CBNV(rs.getString(1));
                staff.setPassword(rs.getString(2));
                staff.setName(rs.getString(3));
                staff.setDateOfBirth(rs.getDate(4).toString());
                staff.setPhoneNumber(rs.getString(5));
                staff.setGender(rs.getString(6));
                staff.setAddress(rs.getString(7));
                staff.setNamePhoto(rs.getString(8));
                list.add(staff);
            }
//            for (Staff i : list) {
////                System.err.println(i.getDateOfBirth());
//            }
        } catch (Exception e) {
        }
        return list;
    }

    public LaborContract getLaborContract(String ID_CBNV) {
        LaborContract lob = new LaborContract();
        try {
            String sql = "SELECT * FROM HOPDONGLAODONG WHERE ID_CBNV=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_CBNV);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                lob.setID_CBNV(rs.getString(1));
                lob.setID_NVQL(rs.getString(2));
                lob.setDateStart(rs.getDate(3).toString());
                lob.setDateEnd(rs.getDate(4).toString());
                return lob;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return lob;
    }

    //FIND ID
    public Vector<Staff> Find(String ID) {
        Vector<Staff> list = new Vector<Staff>();
        try {
            String sql = "SELECT C.ID_CBNV, t.PASSWORD, C.HoTen, C.NgaySinh, C.SDT, C.GioiTinh, C.QueQuan, C.TenAnh\n"
                    + "FROM CANBONHANVIEN C\n"
                    + "INNER JOIN TAIKHOANCB T\n"
                    + "ON C.ID_CBNV = T.ID_CBNV\n"
                    + "WHERE C.ID_CBNV = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setID_CBNV(rs.getString(1));
                staff.setPassword(rs.getString(2));
                staff.setName(rs.getString(3));
                staff.setDateOfBirth(rs.getDate(4).toString());
                staff.setPhoneNumber(rs.getString(5));
                staff.setGender(rs.getString(6));
                staff.setAddress(rs.getString(7));
                staff.setNamePhoto(rs.getString(8));
                list.add(staff);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public void InsertStaff(String ID, String Pass, String Name,
            String DOB, String Phone, String Gender, String Address, String NamePhoto, String IDNVQL,
            String DateStart, String DateEnd) {
        try {
            String sql = "INSERT INTO TAIKHOANCB\n"
                    + "VALUES (?, ?)\n"
                    + "INSERT INTO CANBONHANVIEN\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)\n"
                    + "INSERT INTO HOPDONGLAODONG\n"
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            pre.setString(2, Pass);

            //INSERT TO CANBONHANVIEN
            pre.setString(3, ID);
            pre.setString(4, Name);
            pre.setString(5, DOB);
            pre.setString(6, Phone);
            pre.setString(7, Gender);
            pre.setString(8, Address);
            pre.setString(9, NamePhoto);

            //INSERT TO HOPDONGLAODONG
            pre.setString(10, ID);
            pre.setString(11, IDNVQL);
            pre.setString(12, DateStart);
            pre.setString(13, DateEnd);

            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công cán bộ nhân viên " + ID + " thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void Delete(String ID) {
        try {
            String sql = "DELETE FROM TAIKHOANCB\n"
                    + "WHERE ID_CBNV = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá cán bộ nhân viên " + ID + " thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void Update(String ID_Choose, String ID_NVQL, String ID, String Pass, String Name,
            String DOB, String Phone, String Gender, String Address, String NamePhoto,
            String DateStart, String DateEnd) {
        try {
            String sql = "UPDATE HOPDONGLAODONG\n"
                    + "SET ID_NVQL = ?, NgayBatDauLam = ?, NgayKetThucLam=?\n"
                    + "WHERE ID_CBNV = ?\n"
                    + "UPDATE CANBONHANVIEN\n"
                    + "SET HoTen = ?, NgaySinh = ?, SDT = ?, GioiTinh = ?, QueQuan = ?, TenAnh = ?\n"
                    + "WHERE ID_CBNV = ?\n"
                    + "UPDATE TAIKHOANCB\n"
                    + "SET ID_CBNV = ?, PASSWORD = ?\n"
                    + "WHERE ID_CBNV = ?;";
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, ID_NVQL);
            pre.setString(2, DateStart);
            pre.setString(3, DateEnd);
            pre.setString(4, ID_Choose);

            pre.setString(5, Name);
            pre.setString(6, DOB);
            pre.setString(7, Phone);
            pre.setString(8, Gender);
            pre.setString(9, Address);
            pre.setString(10, NamePhoto);
            pre.setString(11, ID_Choose);

            pre.setString(12, ID);
            pre.setString(13, Pass);
            pre.setString(14, ID_Choose);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật " + ID +" Thành công!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getNameNVQL(String ID) {
        String Name = "";
        String sql = "SELECT HoTen FROM NHANVIENQUANLY\n"
                + "WHERE ID_NVQL = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Name = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Name;
    }

//    public static void main(String[] args) {
//        StaffManagerListener st = new StaffManagerListener();
////        st.Update("CBNV01", "102200318", "CBNV13", "2020-12-12", "2020-12-12", "2020-12-12", "2020-12-12",
////                "2020-12-12", "2020-12-12", "2020-12-12", "2020-12-12", "2020-12-12");
////        Vector<Staff> kk = st.Find("CBNV01");
//
////        System.out.println(st.getNameNVQL("102200318"));
//    }
}
