/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Introductor;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class IntroductorListener extends ConnectDatabase {

    private String StoreProcedureInsert() {
        return "DELETE_INTRO @ID_CHOOSE ";
    }

    private String storeProShow() {
        return "SHOW_INTRO";
    }

    private String storeProFind(int i) {
        if (i == 1) {
            return "FIND_ID_INTRODUCTOR @TEXT = ?";
        } else if (i == 2) {
            return "FIND_NAME_INTRODUCTOR @TEXT = ?";
        } else {
            return "FIND_USERNAME_INTRODUCTOR @TEXT = ?";
        }
    }

    public ArrayList<Introductor> getListIntro() {
        String sql = storeProShow();
        ArrayList<Introductor> list = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Introductor intro = new Introductor();
                intro.setID(rs.getString(1));
                intro.setName(rs.getString(2));
                intro.setDayOfBirth(rs.getString(3));
                intro.setGender(rs.getString(4));
                intro.setAddress(rs.getString(5));
                intro.setPhoneNumber(rs.getString(6));
                intro.setUsername(rs.getString(7));
                intro.setPassword(rs.getString(8));
                list.add(intro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;

    }

    public ArrayList<Introductor> getListIntro(int i, String Text) {
        String sql = storeProFind(i);
        ArrayList<Introductor> list = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, Text);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Introductor intro = new Introductor();
                intro.setID(rs.getString(1));
                intro.setName(rs.getString(2));
                intro.setDayOfBirth(rs.getString(3));
                intro.setGender(rs.getString(4));
                intro.setAddress(rs.getString(5));
                intro.setPhoneNumber(rs.getString(6));
                intro.setUsername(rs.getString(7));
                intro.setPassword(rs.getString(8));
                list.add(intro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;

    }

    public void AddIntro(String ID, String Name, String DOB, String Gender, String Address, String Phone, int IDNVQL, String Username, String Password, String Access) {
        String sql = "ADD_NEW_INTRODUCTOR\n"
                + "@ID = ?, @NAME  = ?, @DOB  = ?, @GENDER  = ?, @ADDRESS = ?, @PHONE = ?, @IDNVQL  = ?, @USERNAME = ?, @PASSWORD = ?, @ACCESS = ?";
        try {
            if (getListIntro(3, Username).size() > 0) {
                JOptionPane.showMessageDialog(null, "Tên tài khoản đã tồn tại trong hệ thống, Vui lòng kiểm tra lại!");

            } else {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, ID);
                pre.setString(2, Name);
                pre.setString(3, DOB);
                pre.setString(4, Gender);
                pre.setString(5, Address);
                pre.setString(6, Phone);
                pre.setInt(7, IDNVQL);
                pre.setString(8, Username);
                pre.setString(9, Password);
                pre.setString(10, Access);
                pre.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm nhật thành công người giới thiệu " + ID);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void DeleteIntro(String ID_Choose) {
        String sql = "DELETE_INTRO @ID_CHOOSE =  ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_Choose);
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void Update(String ID_CHOOSE, String Name, String DOB, String Gender, String Address, String Phone, int IDNVQL,
            String UserName_Choose, String username, String password, String Access) {
        String sql = "UPDATE_INTRODUCTOR\n"
                + "@ID_CHOOSE = ?, @NAME  = ?, @DOB  = ?, @GENDER  = ?, @ADDRESS = ?, @PHONE = ?, @IDNVQL  = ?, "
                + "@USERNAME_CHOOSE = ?,@USERNAME = ?, @PASSWORD  = ?, @ACCESS = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_CHOOSE);
            pre.setString(2, Name);
            pre.setString(3, DOB);
            pre.setString(4, Gender);
            pre.setString(5, Address);
            pre.setString(6, Phone);
            pre.setInt(7, IDNVQL);
            pre.setString(8, UserName_Choose);
            pre.setString(9, username);
            pre.setString(10, password);
            pre.setString(11, Access);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật người giới thiệu " + ID_CHOOSE + " Thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getNameIntroductor(String IDDTGT) {
        String Name = "";
        try {
            String sql = "SELECT HoTen FROM DOITUONGGIOITHIEUTRE WHERE TaiKhoan = ?";

            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, IDDTGT);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Name = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Name;
    }
}
