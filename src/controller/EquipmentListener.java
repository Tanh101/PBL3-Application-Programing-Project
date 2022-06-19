package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import model.Children;
import model.Equipment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class EquipmentListener extends ConnectDatabase {

    public String getSQLShow(int i) {
        if (i == 1) {
            return "SHOW_EQUIPMENT"
                    + "";
        } else if (i == 2) {
            return "SHOW_EQUIPMENT_CURRENT";
        } else {
            return "SHOW_EQUIPMENT_BAD";
        }

    }

    private String getSqlFindID() {
        String sql = "SELECT T.MaThietBi, T.TenThietBi, T.Gia, T.DonViCungCap, T.SoThietBiTot, T.SoThietBiHong, CT.NgayNhapVao, CT.NgayXuatRa\n"
                + "FROM TRANGTHIETBI T\n"
                + "INNER JOIN CHITIETTRANGTHIETBI CT\n"
                + "ON T.MaThietBi = CT.MaThietBi\n"
                + "WHERE T.MaThietBi = ?";
        return sql;
    }

    private String getSqlFindName() {
        String sql = "SELECT T.MaThietBi, T.TenThietBi, T.Gia, T.DonViCungCap, T.SoThietBiTot, T.SoThietBiHong, CT.NgayNhapVao, CT.NgayXuatRa\n"
                + "FROM TRANGTHIETBI T\n"
                + "INNER JOIN CHITIETTRANGTHIETBI CT\n"
                + "ON T.MaThietBi = CT.MaThietBi\n"
                + "WHERE T.TenThietBi LIKE ?";
        return sql;
    }

    private String getSqlUpdate() {
        String sql = "EXEC UPDATEEQUIP\n"
                + "@ID_Choose = ?, @ID = ?, @Name = ?, @Price = ?, @NumGood = ?, @NumBad = ?, @Provider = ?, \n"
                + "@ID_NVQL = ?, @DateEnter = ?, @DateQuit = ?";
        return sql;
    }

    private String getSqlInsert() {
        return "INSERT INTO TRANGTHIETBI\n"
                + "VALUES(?,?,?,?,?,?)\n"
                + "INSERT INTO CHITIETTRANGTHIETBI\n"
                + "VALUES(?,?,?,?)";
    }

    private String getSqlDelete() {
        return "DELETE FROM TRANGTHIETBI \n"
                + "WHERE MaThietBi = ?";
    }

    public ArrayList<Equipment> getListEquipment(String sql) {
        ArrayList<Equipment> list = new ArrayList<Equipment>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Equipment equip = new Equipment();
                equip.setID(rs.getString(1));
                equip.setName(rs.getString(2));
                equip.setPrice(rs.getString(3));

                equip.setProviders(rs.getString(4));
                equip.setNumOfGood(Integer.parseInt(rs.getString(5)));
                equip.setNumOfBad(Integer.parseInt(rs.getString(6)));
                equip.setDateEnter(rs.getDate(7).toString());
                Date date = rs.getDate(8);
                if (date == null) {
                    equip.setDateQuit("");
                } else {
                    equip.setDateQuit(date.toString());
                }
                list.add(equip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Equipment> FindID(String Choose) {
        ArrayList<Equipment> list = new ArrayList<Equipment>();
        try {
            String sql = getSqlFindID();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, Choose);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                Equipment equip = new Equipment();
                equip.setID(rs.getString(1));
                equip.setName(rs.getString(2));
                equip.setPrice(rs.getString(3));
                equip.setProviders(rs.getString(4));
                equip.setNumOfGood(Integer.parseInt(rs.getString(5)));
                equip.setNumOfBad(Integer.parseInt(rs.getString(6)));
                equip.setDateEnter(rs.getDate(7).toString());
                Date date = rs.getDate(8);
                if (date == null) {
                    equip.setDateQuit("");
                } else {
                    equip.setDateQuit(date.toString());
                }

                list.add(equip);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public ArrayList<Equipment> FindName(String Name) {
        ArrayList<Equipment> list = new ArrayList<Equipment>();
        try {
            String sql = getSqlFindName();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, Name);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Equipment equip = new Equipment();
                equip.setID(rs.getString(1));
                equip.setName(rs.getString(2));
                equip.setPrice(rs.getString(3));
                equip.setProviders(rs.getString(4));
                equip.setNumOfGood(Integer.parseInt(rs.getString(5)));
                equip.setNumOfBad(Integer.parseInt(rs.getString(6)));
                equip.setDateEnter(rs.getDate(7).toString());
                Date date = rs.getDate(8);
                if (date == null) {
                    equip.setDateQuit("");
                } else {
                    equip.setDateQuit(date.toString());
                }

                list.add(equip);
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public void Update(String ID_Choose, String ID, String Name, String Price, String NumOfGood, String NumOfBad,
            String Provider, String ID_NVQL, String DateEnter, String DateQuit) {
        String sql = getSqlUpdate();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_Choose);
            pre.setString(2, ID);
            pre.setString(3, Name);
            pre.setInt(4, Integer.parseInt(Price));
            pre.setInt(5, Integer.parseInt(NumOfGood));
            pre.setInt(6, Integer.parseInt(NumOfBad));
            pre.setString(7, Provider);
            pre.setString(8, ID_NVQL);
            pre.setString(9, DateEnter);
            pre.setString(10, DateQuit);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật thiết bị " + ID_Choose + " thành công");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void Insert(String ID, String Name, String Price, String NumOfGood, String NumOfBad,
            String Provider, String ID_NVQL, String DateEnter, String DateQuit) {
        String sql = getSqlInsert();

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            pre.setString(2, Name);
            pre.setString(3, Price);
            pre.setInt(4, Integer.parseInt(NumOfGood));
            pre.setInt(5, Integer.parseInt(NumOfBad));
            pre.setString(6, Provider);
            pre.setString(7, ID);
            pre.setString(8, ID_NVQL);
            pre.setString(9, DateEnter);
            pre.setString(10, DateQuit);
            pre.executeUpdate();
            showMessageDialog(null, "Thêm thiết bị " + ID + " thành công");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void Delete(String ID_choose) {
        try {
            String sql = getSqlDelete();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_choose);
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thiết bị " + ID_choose + " thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

//    public static void main(String[] args) {
//        EquipmentListener eq = new EquipmentListener();
//        Equipment e = new Equipment();
////        System.out.println(eq.FindID("TB0019").getID().length() >  0);
//
////        eq.Insert("TB0006", "abcf", "12345", "12", "12", "abcf", "102200319", "2020-12-12", "");
//        eq.Update("TB0001", "TB0001", "Demo", "12345", "12", "12", "abcf", "102200319", "2020-12-12", "");
////        System.out.println(e.getID());
//    }
}
