/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Adopter;
import model.Introductor;

/**
 *
 * @author ADMIN
 */
public class AdopterListener extends ConnectDatabase {

    public String storeShow() {
        return "SHOW_ADOPTER";
    }

    public ArrayList<Adopter> getAdopterWithID_TRE(String ID_TRE) {
        String sql = "SHOW_ADOPTER_WITH_ID_TRE\n"
                + "@ID_TRE = ?";
        ArrayList<Adopter> list = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_TRE);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Adopter adop = new Adopter();
                adop.setCCCD(rs.getString(1));
                adop.setName(rs.getString(2));
                adop.setDOB(rs.getString(3));
                adop.setGender(rs.getString(4));
                adop.setAddress(rs.getString(5));
                adop.setPhoneNumber(rs.getString(6));
                adop.DateAdopt = rs.getString(7);
                list.add(adop);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }

    public ArrayList<Adopter> getListAdop() {
        String sql = storeShow();
        ArrayList<Adopter> list = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Adopter adop = new Adopter();
                adop.setCCCD(rs.getString(1));
                adop.setName(rs.getString(2));
                adop.setDOB(rs.getString(3));
                adop.setGender(rs.getString(4));
                adop.setAddress(rs.getString(5));
                adop.setPhoneNumber(rs.getString(6));
                list.add(adop);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;

    }

    private String procedureFind(int i) {
        if (i == 1) {
            return "FIND_ADOPTER_CCCD\n"
                    + "@CCCD = ?";
        } else {
            return "FIND_ADOPTER_NAME\n"
                    + "@NAME = ?";
        }
    }

    public ArrayList<Adopter> FindAdop(int i, String Text) {
        String sql = procedureFind(i);
        ArrayList<Adopter> list = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, Text);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Adopter adop = new Adopter();
                adop.setCCCD(rs.getString(1));
                adop.setName(rs.getString(2));
                adop.setDOB(rs.getString(3));
                adop.setGender(rs.getString(4));
                adop.setAddress(rs.getString(5));
                adop.setPhoneNumber(rs.getString(6));
                list.add(adop);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return list;
    }

    private String procedureUpdateAdopter() {
        return "UPDATE_ADOPTER\n"
                + "@CCCD_CHOOSE = ?, @CCCD = ?, @NAME = ?, @DOB = ?, \n"
                + "@GENDER = ?, @ADDRESS = ?, @PHONENUMBER = ?, @IDNVQL = ?";
    }

    public void UpdateAdopter(String CCCD_Choose, String cccd, String name, String DOB,
            String gender, String Address, String PhoneNumber, int IDNVQL) {
        String sql = procedureUpdateAdopter();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, CCCD_Choose);
            pre.setString(2, cccd);
            pre.setString(3, name);
            pre.setString(4, DOB);
            pre.setString(5, gender);
            pre.setString(6, Address);
            pre.setString(7, PhoneNumber);
            pre.setInt(8, IDNVQL);
//            System.out.println(CCCD_Choose + name + Address);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật đối tượng nhận nuôi trẻ " + name + " thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void DeleteAdopter(String CCCD_Choose) {
        String sql = "DELETE_ADOPTER\n"
                + "@CCCD = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, CCCD_Choose);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá người nhận nuôi " + CCCD_Choose + " thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void AddAdopter(Adopter adop, String ID_TRE, String ID_NVQL, String DateAdopt) {
        String sql = "ADD_ADOPTER\n"
                + "@CCCD = ?, @HoTen  = ?, @GioiTinh  = ?, @DiaChi  = ?, \n"
                + " @SDT = ?, @DOB  = ?, @ID_TRE  = ?, @ID_NVQL  = ?, @NgayNhanNuoi  = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, adop.getCCCD());
            pre.setString(2, adop.getName());
            pre.setString(3, adop.getGender());
            pre.setString(4, adop.getAddress());
            pre.setString(5, adop.getPhoneNumber());
            pre.setString(6, adop.getDOB());
            pre.setString(7, ID_TRE);
            pre.setString(8, ID_NVQL);
            pre.setString(9, DateAdopt);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm người nhận nuôi " + adop.getName() + " thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
