/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import model.Children;
import model.Staff;

/**
 *
 * @author ADMIN
 */
public class ChildrenListener extends ConnectDatabase {

    public String getSQLShowAll() {
        String sql = "SELECT T.ID_Tre, T.HoTen, T.NgaySinh, T.DiaChi, T.GioiTinh,T.TenAnh, Q.NgayVaoTT, Q.NgayRoiTT\n"
                + "FROM TRE T\n"
                + "INNER JOIN QUANLYTRE Q\n"
                + "ON T.ID_Tre = Q.ID_Tre";
        return sql;
    }

    public String getSQLShowCurrent() {
        String sql = "SELECT T.ID_Tre, T.HoTen, T.NgaySinh, T.DiaChi, T.GioiTinh,T.TenAnh, Q.NgayVaoTT, Q.NgayRoiTT\n"
                + "FROM TRE T\n"
                + "INNER JOIN QUANLYTRE Q\n"
                + "ON T.ID_Tre = Q.ID_Tre\n"
                + "WHERE Q.NgayRoiTT IS NULL";
        return sql;
    }

    public String getSQLShowQuit() {
        String sql = "SELECT T.ID_Tre, T.HoTen, T.NgaySinh, T.DiaChi, T.GioiTinh,T.TenAnh, Q.NgayVaoTT, Q.NgayRoiTT\n"
                + "FROM TRE T\n"
                + "INNER JOIN QUANLYTRE Q\n"
                + "ON T.ID_Tre = Q.ID_Tre\n"
                + "WHERE Q.NgayRoiTT IS NOT NULL";
        return sql;
    }

    private String getSqlFindID() {
        String sql = "SELECT T.ID_Tre, T.HoTen, T.NgaySinh, T.DiaChi, T.GioiTinh,T.TenAnh, Q.NgayVaoTT, Q.NgayRoiTT\n"
                + "FROM TRE T\n"
                + "INNER JOIN QUANLYTRE Q\n"
                + "ON T.ID_Tre = Q.ID_Tre\n"
                + "WHERE T.ID_TRE = ?";
        return sql;
    }

    private String getSqlFindName() {
        String sql = "SELECT T.ID_Tre, T.HoTen, T.NgaySinh, T.DiaChi, T.GioiTinh,T.TenAnh, Q.NgayVaoTT, Q.NgayRoiTT\n"
                + "FROM TRE T\n"
                + "INNER JOIN QUANLYTRE Q\n"
                + "ON T.ID_Tre = Q.ID_Tre\n"
                + "WHERE T.HoTen LIKE ?";
        return sql;
    }

    private String getSqlUpdate() {
        String sql = "UPDATE TRE\n"
                + "SET ID_Tre = ?, HoTen = ?, NgaySinh = ?,DiaChi = ?, GioiTinh = ?, TenAnh = ?\n"
                + "WHERE ID_Tre = ?\n"
                + "UPDATE QUANLYTRE\n"
                + "SET ID_NVQL = ?,NgayVaoTT = ?, NgayRoiTT = ?\n"
                + "WHERE ID_Tre = ?";
        return sql;
    }

    private String getSqlInsert() {
        return "INSERT INTO TRE\n"
                + "VALUES (?, ?, ?, ?, ?, ?);\n"
                + "INSERT INTO QUANLYTRE\n"
                + "VALUES (?, ?, ?, ?)";
    }

    private String getSqlDelete() {
        return "DELETE FROM TRE \n"
                + "WHERE ID_Tre = ?";
    }

    public Vector<Children> getListChildren(String sql) {
        Vector<Children> list = new Vector<Children>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Children chil = new Children();
                chil.setID_TRE(rs.getString(1));
                chil.setName(rs.getString(2));
                chil.setDateOfBirth(rs.getDate(3).toString());

                chil.setAddress(rs.getString(4));
                chil.setGender(rs.getString(5));
                chil.setUrlPath(rs.getString(6));
                chil.setDateEnter(rs.getDate(7).toString());
                Date date = rs.getDate(8);
                if (date == null) {
                    chil.setDateQuit("");
                } else {
                    chil.setDateQuit(date.toString());
                }
                list.add(chil);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Vector<Children> FindID(String Choose) {
        Vector<Children> list = new Vector<Children>();
        try {
            String sql = getSqlFindID();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, Choose);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Children chil = new Children();
                chil.setID_TRE(rs.getString(1));
                chil.setName(rs.getString(2));
                chil.setDateOfBirth(rs.getDate(3).toString());

                chil.setAddress(rs.getString(4));
                chil.setGender(rs.getString(5));
                chil.setUrlPath(rs.getString(6));
                chil.setDateEnter(rs.getDate(7).toString());
                Date date = rs.getDate(8);
                if (date == null) {
                    chil.setDateQuit("");
                } else {
                    chil.setDateQuit(date.toString());
                }
                list.add(chil);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public Vector<Children> FindName(String Choose) {
        Vector<Children> list = new Vector<Children>();
        try {
            String sql = getSqlFindName();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, Choose);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Children chil = new Children();
                chil.setID_TRE(rs.getString(1));
                chil.setName(rs.getString(2));
                chil.setDateOfBirth(rs.getDate(3).toString());

                chil.setAddress(rs.getString(4));
                chil.setGender(rs.getString(5));
                chil.setUrlPath(rs.getString(6));
                chil.setDateEnter(rs.getDate(7).toString());
                Date date = rs.getDate(8);
                if (date == null) {
                    chil.setDateQuit("");
                } else {
                    chil.setDateQuit(date.toString());
                }
                list.add(chil);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public void Update(String ID_Choose, String ID_TRE, String Name, String DOB, String Address,
            String Gender,String NamePhoto, String ID_NVQL, String DateEnter, String DateQuit) {
        String sql = getSqlUpdate();
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, ID_TRE);
            pre.setString(2, Name);
            pre.setString(3, DOB);
            pre.setString(4, Address);
            pre.setString(5, Gender);
            pre.setString(6, NamePhoto);
            pre.setString(7, ID_Choose);

            pre.setString(8, ID_NVQL);
            pre.setString(9, DateEnter);
            pre.setString(10, DateQuit);
            pre.setString(11, ID_TRE);

            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void Insert(String ID_TRE, String Name, String DOB, String Address,
            String Gender,String NamePhoto, String ID_NVQL, String DateEnter, String DateQuit) {
        String sql = getSqlInsert();

        try {
            if (FindID(ID_TRE).size() == 0) {

                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, ID_TRE);
                pre.setString(2, Name);
                pre.setString(3, DOB);
                pre.setString(4, Address);
                pre.setString(5, Gender);
                pre.setString(6, NamePhoto);
                pre.setString(7, ID_TRE);
                pre.setString(8, ID_NVQL);
                pre.setString(9, DateEnter);
                pre.setString(10, DateQuit);

                pre.executeUpdate();
            } else {
                showMessageDialog(null, "Trẻ đã tồn tại trong trung tâm");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delete(String ID_choose) {
        try {
            String sql = getSqlDelete();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_choose);
            pre.executeUpdate();
        } catch (Exception e) {
        }

    }

//    public static void main(String[] args) {
////        ChildrenListener st = new ChildrenListener();
////        Vector<Children> v = new Vector<>();
////        v = st.FindName("%Le%");
//        
//    }
}
