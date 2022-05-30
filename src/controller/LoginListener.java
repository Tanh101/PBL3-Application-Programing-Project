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
//        this.list = new ArrayList<Account>();
    }

    public boolean checkAccount(String acc, String pass) throws SQLException {
        if (conn != null) {
            Account ac = null;
            String sql = "SELECT * FROM TAIKHOAN WHERE ID_NVQL=? AND PASSWORD=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            int account;
            try {
                account = Integer.parseInt(acc);
                pre.setInt(1, Integer.parseInt(acc));
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

    public boolean checkAccountUser(String acc, String pass) throws SQLException {
        Account ac = null;
        String sql = "LOGIN_USER\n"
                + "@USERNAME= ?, @PASS =?";
        PreparedStatement pre = conn.prepareStatement(sql);
        try {
            pre.setString(1, acc);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                showMessageDialog(null, "Đăng Nhập Thành Công!");
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
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

    public String getNameStaff(String UserName) throws SQLException {
        String sql = "SELECT HoTen From CANBONHANVIEN WHERE ID_CBNV=?";
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
}
