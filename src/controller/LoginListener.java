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
        String sql = "SELECT * FROM TAIKHOANUSER WHERE UserName=? AND PASSWORD=?";
        PreparedStatement pre = conn.prepareStatement(sql);
        try {
            pre.setString(1, acc);
            pre.setString(2, pass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
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
}
