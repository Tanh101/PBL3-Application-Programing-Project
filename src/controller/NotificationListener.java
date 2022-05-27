/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Model_message;
import model.Model_message;

/**
 *
 * @author ADMIN
 */
public class NotificationListener extends ConnectDatabase {

    public String total() {
        String ID = null;

        try {
            String a = "SELECT * from THONGBAO";
            PreparedStatement b = conn.prepareStatement(a);
            ResultSet c = b.executeQuery();
            while ((c.next())) {
                ID = c.getString(1);
            }
        } catch (Exception e) {

        }
        return ID;
    }

    public void Add_2_ID(String ID_NVQL, String ID_TB) {
        try {
            String sql = "INSERT INTO dbo.CHITIETTHONGBAO  VALUES (? ,?, ?)";
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            String DateEnter = date.toString();
            System.out.println(DateEnter);
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, ID_TB);
            pre.setInt(2, Integer.parseInt(ID_NVQL));
            pre.setString(3, DateEnter);
            ResultSet rs = pre.executeQuery();
            JOptionPane.showMessageDialog(null, "Thêm thông báo thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void InsertStaff(String Header, String Content, String loai_thong_bao) {
        String ID = total();

        String[] arr = ID.split("TB", 2);
        String ID_FINAL = "TB";
        if (String.valueOf(Integer.parseInt(arr[1]) + 1).length() == 1) {
            ID += "00";
        } else {
            ID += "0";
        }
        int tmp2 = Integer.parseInt(arr[1]) + 1;
        ID_FINAL += String.valueOf(tmp2);

        try {
            String sql = "INSERT INTO dbo.THONGBAO  VALUES (? ,?, ?, ?)";

            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setString(1, "TB002");
            pre.setString(1, ID_FINAL);
            pre.setString(2, Header);
            pre.setString(3, Content);
            pre.setString(4, loai_thong_bao);
            ResultSet rs = pre.executeQuery();
        } catch (Exception e) {

        }
    }

    public Vector<Model_message> getListStaffCurent() {
        Vector<Model_message> list = new Vector();

        try {
            String sql = "SELECT * from THONGBAO ";
            PreparedStatement pre = conn.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Model_message m = new Model_message();
                m.setID_model(rs.getString(1));
                m.setHeader(rs.getString(2));
                m.setContent(rs.getString(3));
                m.setVi_tri(rs.getString(4));
                list.add(m);

            }

        } catch (Exception e) {
        }
        return list;
    }

    public Vector<Model_message> getListStaffCurent_TT() {
        Vector<Model_message> list = new Vector();

        try {
            String sql = "SELECT * from THONGBAO where [vitri] ='1' or vitri = '2' ";
            PreparedStatement pre = conn.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Model_message m = new Model_message();
                m.setID_model(rs.getString(1));
                m.setHeader(rs.getString(2));
                m.setContent(rs.getString(3));
                m.setVi_tri(rs.getString(4));
                list.add(m);

            }

        } catch (Exception e) {
        }
        return list;
    }

    public Vector<Model_message> getListStaffCurent(String vi_tri) {
        Vector<Model_message> list = new Vector();

        try {
            String sql = "SELECT * from THONGBAO where [vitri] =?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, vi_tri);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Model_message m = new Model_message();
                m.setID_model(rs.getString(1));
                m.setHeader(rs.getString(2));
                m.setContent(rs.getString(3));
                m.setVi_tri(rs.getString(4));
                list.add(m);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public Vector<Model_message> FindID(String ID) {
        Vector<Model_message> list = new Vector<>();
        try {
            String sql = "SELECT * from THONGBAO WHERE MaThongBao =? ";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                rs.getString(1);
                Model_message m = new Model_message();
                m.setID_model(rs.getString(1));
                m.setHeader(rs.getString(2));
                m.setContent(rs.getString(3));
                m.setVi_tri(rs.getString(4));
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Vector<Model_message> Find(String name, String vi_tri) {
        Vector<Model_message> list = new Vector<>();
        try {
            String sql = "SELECT * from THONGBAO WHERE TenThongBao =? and [vitri] = ?";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, vi_tri);

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                rs.getString(1);
                Model_message m = new Model_message();
                m.setID_model(rs.getString(1));
                m.setHeader(rs.getString(2));
                m.setContent(rs.getString(3));
                m.setVi_tri(vi_tri);
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Vector<Model_message> Finda(String name, String vi_tri) {
        Vector<Model_message> list = new Vector<>();
        try {
            String sql = "SELECT * from THONGBAO WHERE TenThongBao like ? and [vitri] = ?";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, vi_tri);

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                rs.getString(1);
                Model_message m = new Model_message();
                m.setID_model(rs.getString(1));
                m.setHeader(rs.getString(2));
                m.setContent(rs.getString(3));
                m.setVi_tri(vi_tri);
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Vector<Model_message> Finda(String name) {
        Vector<Model_message> list = new Vector<>();
        try {
            String sql = "SELECT * from THONGBAO WHERE TenThongBao like ? and [vitri] = '1' or vitri = '2' ";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, name);

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                rs.getString(1);
                Model_message m = new Model_message();
                m.setID_model(rs.getString(1));
                m.setHeader(rs.getString(2));
                m.setContent(rs.getString(3));
                m.setVi_tri(rs.getString(4));
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(String tenthongbao, String noidung, String mathongbao, String vi_tri) {
        Vector<Model_message> list = new Vector<>();
        try {
            String sql = "UPDATE dbo.THONGBAO SET Tenthongbao = ?, noidungthongbao = ? ,vitri = ? WHERE mathongbao = ? ";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, tenthongbao);
            pre.setString(2, noidung);
            pre.setString(4, mathongbao);
            pre.setString(3, vi_tri);
            pre.executeUpdate();

        } catch (Exception e) {

        }

    }

    public void Delete(String ID_choose) {
        try {
            String sql = "DELETE FROM Thongbao WHERE MaThongBao = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_choose);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }
}
