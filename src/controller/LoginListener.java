/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.DriverManager;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Account.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class LoginListener extends ConnectDatabase {

    private static ArrayList<Account> list = new ArrayList<Account>();

    public LoginListener() {

    }

    public boolean checkAccount(String acc, String pass, int i) {
        if (conn != null) {
            Account ac = null;
            String sql = "";
            if (i == 1) {
                sql = "LOGIN_ADMIN @ACCOUNT = ?, @PASSWORD = ?";
            } else if (i == 2) {
                sql = "LOGIN_NVQL @ACCOUNT = ?, @PASSWORD = ?";
            } else {
                sql = "LOGIN_USER\n"
                        + "@USERNAME= ?, @PASS =?";
            }
            try {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, acc);
                pre.setString(2, pass);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return false;
    }


    public String getName(String UserName) throws SQLException {
        String sql = "SELECT HoTen From CANHAN\n"
                + "INNER JOIN TAIKHOANUSER\n"
                + "ON CANHAN.UserName = TAIKHOANUSER.UserName\n"
                + "WHERE TAIKHOANUSER.UserName = ?";
        PreparedStatement pre = conn.prepareStatement(sql);
        try {
            pre.setString(1, UserName);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public String getNameStaff(String UserName) {
        String sql = "SELECT HoTen From CANBONHANVIEN WHERE ID_CBNV=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, UserName);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    //-------------------------------------REGISTER-------------------------------------------
    public void Register(String Name, String DOB, String Gender, String Address, String PhoneNumber, String Username, String pass) {
        String sql = " REGISTER\n"
                + "@Name = ?, @DOB = ?, @Gender = ?, @Address = ?,@PhoneNumber = ?, @Username = ?, @pass = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, Name);
            pre.setString(2, DOB);
            pre.setString(3, Gender);
            pre.setString(4, Address);
            pre.setString(5, PhoneNumber);
            pre.setString(6, Username);
            pre.setString(7, pass);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void RegisterIntroductor(String ID, String Name, String DOB, String Gender,
            String Address, String PhoneNumber, String IDNVQL, String Username, String pass, String Access) {
        String sql = "ADD_NEW_INTRODUCTOR @ID = ?, @Name = ?, @DOB = ?, @Gender = ?,@ADDRESS = ?,"
                + "@PHONE = ?, @IDNVQL = ?, @USERNAME = ?, @PASSWORD = ?, @ACCESS = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            pre.setString(2, Name);
            pre.setString(3, DOB);
            pre.setString(4, Gender);
            pre.setString(5, Address);
            pre.setString(6, PhoneNumber);
            pre.setString(7, IDNVQL);
            pre.setString(8, Username);
            pre.setString(9, pass);
            pre.setString(10, Access);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thành công");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
//            e.printStackTrace();
        }
    }

    public String getID(String UserName) {
        String sql = "SELECT ID FROM DOITUONGGIOITHIEUTRE WHERE TaiKhoan = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, UserName);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
