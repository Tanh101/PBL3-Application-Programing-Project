/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import java.util.Vector;
import static javax.swing.JOptionPane.showMessageDialog;
import model.Charity;
import model.Extracurriclar;
import model.managementStaff;

/**
 *
 * @author ADMIN
 */
public class ActivityListerner extends ConnectDatabase {

    public String sqlShowExtrac(int i) {
        if (i == 1) {
            return "SHOWHOATDONG";
        } else if (i == 2) {
            return "SHOWHOATDONGNOW";
        } else {
            return "SHOWHOATDONGEND";
        }
    }

    public Vector<Extracurriclar> getListExtracurricular(String sql) {
        Vector<Extracurriclar> list = new Vector<Extracurriclar>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Extracurriclar extrac = new Extracurriclar();
                extrac.setID(rs.getString(1));
                extrac.setName(rs.getString(2));
                extrac.setPlace(rs.getString(3));
                extrac.setIDNVQL(String.valueOf(rs.getInt(4)));
                extrac.setNumberOfStaff(String.valueOf(rs.getInt(5)));
                extrac.setNumberOfChild(String.valueOf(rs.getInt(6)));
                extrac.setDateStart(rs.getDate(7).toString());
                Date date = rs.getDate(8);
                if (date == null) {
                    extrac.setDateEnd("");
                } else {
                    extrac.setDateEnd(date.toString());
                }
                list.add(extrac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private String StoreProAdd() {
        return "ADDECTRACURRICULAR @ID = ?, @NAME = ?, @PLACE = ?,@IDNVQL = ?, @NUMSTAFF = ?, @NUMCHILD = ?, @DATESTART = ?, @DATEEND = ?";
    }

    public void InsertExtrac(String ID, String Name, String Place, int IDNVQL, int NumOfStaff, int NumOfChild, String DateStart, String DateEnd) {
        String sql = StoreProAdd();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            pre.setString(2, Name);
            pre.setString(3, Place);
            pre.setInt(4, IDNVQL);
            pre.setInt(5, NumOfStaff);
            pre.setInt(6, NumOfChild);
            pre.setString(7, DateStart);
            pre.setString(8, DateEnd);
            pre.executeUpdate();
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    private String StoreProDel() {
        return "DELETEEXTRAC @ID = ?";
    }

    public void DeleteExtrac(String ID) {
        String sql = StoreProDel();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            pre.executeUpdate();
            showMessageDialog(null, "Xoá hoạt động " + ID + " thành công!");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    private String StoreProUpdate() {
        return "UPDATEEXTRAC @ID_CHOOSE = ?, @NAME  = ?, @PLACE  = ?, @IDNVQL = ?,"
                + " @NUMSTAFF  = ?, @NUMCHILD  = ?, @DATESTART = ?, @DATEEND  = ?";
    }

    public void UpdateExtrac(String ID_Choose, String Name, String Place, int IDNVQL,
            int NumOfStaff, int NumOfChild, String DateStart, String DateEnd) {
        String sql = StoreProUpdate();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_Choose);
            pre.setString(2, Name);
            pre.setString(3, Place);
            pre.setInt(4, IDNVQL);
            pre.setInt(5, NumOfStaff);
            pre.setInt(6, NumOfChild);
            pre.setString(7, DateStart);
            pre.setString(8, DateEnd);
            pre.executeUpdate();
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }

    }

    private String proFindExtrac(int i) {
        if (i == 1) {
            return " SELECT H.MaHoatDong, H.TenHoatDong, H.DiaDiem, C.ID_NVQL, C.SoCanBo, C.SoTre, C.NgayBatDau, C.NgayKetThuc\n"
                    + "FROM HOATDONGNGOAIKHOA H\n"
                    + "INNER JOIN CHITIETHOATDONGNGOAIKHOA C\n"
                    + "ON H.MaHoatDong = C.MaHoatDong\n"
                    + "WHERE H.TenHoatDong LIKE ?";
        } else {
            return "SELECT H.MaHoatDong, H.TenHoatDong, H.DiaDiem, C.ID_NVQL, C.SoCanBo, C.SoTre, C.NgayBatDau, C.NgayKetThuc\n"
                    + "FROM HOATDONGNGOAIKHOA H\n"
                    + "INNER JOIN CHITIETHOATDONGNGOAIKHOA C\n"
                    + "ON H.MaHoatDong = C.MaHoatDong\n"
                    + "WHERE H.MaHoatDong LIKE ?";
        }
    }

    public Vector<Extracurriclar> Find(int i, String Text) {
        Vector<Extracurriclar> list = new Vector<>();
        String sql = proFindExtrac(i);
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + Text + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Extracurriclar extrac = new Extracurriclar();
                extrac.setID(rs.getString(1));
                extrac.setName(rs.getString(2));
                extrac.setPlace(rs.getString(3));
                extrac.setIDNVQL(String.valueOf(rs.getInt(4)));
                extrac.setNumberOfStaff(String.valueOf(rs.getInt(5)));
                extrac.setNumberOfChild(String.valueOf(rs.getInt(6)));
                extrac.setDateStart(rs.getDate(7).toString());
                Date date = rs.getDate(8);
                if (date == null) {
                    extrac.setDateEnd("");
                } else {
                    extrac.setDateEnd(date.toString());
                }
                list.add(extrac);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;

    }

    //DAO of Charity Management
    public String proShowAllCharity(int i) {

        if (i == 1) {
            return "SHOWALL";
        } else if (i == 2) {
            return "SHOWNOW";
        } else {
            return "SHOWENDED";
        }

    }

    private String proAddCharity() {
        return "INSERT_CHARITY @ID = ?, @NAMEORGAN = ?, @NAMEACTI = ?, @ARTIFACTS = ?,"
                + "@IDNVQL = ?, @DATESTART = ?, @DATEEND = ?";
    }

    private String proDeleteCharity() {
        return "DELETECHARITY @ID_CHOOSE = ?";
    }

    private String proUpdateCharity() {
        return "UPDATE_CHARITY @ID_CHOOSE = ? , @NAMEORGAN = ?, @NAMEACTI = ?, @ARTIFACTS = ?,\n"
                + "@IDNVQL = ?, @DATESTART = ? , @DATEEND =?";
    }

    private String sqlFind(int i) {
        if (i == 1) {
            return "SELECT H.MaToChuc, H.TenToChucTuThien, H.TenHoatDong, H.HienVatTuThien,C.ID_NVQL, C.NgayToChuc, C.NgayKetThuc\n"
                    + "FROM HOATDONGTUTHIEN H\n"
                    + "INNER JOIN CHITIETHOATDONGTUTHIEN C\n"
                    + "ON H.MaToChuc = C.MaToChuc\n"
                    + "WHERE H.TenHoatDong LIKE ?";
        } else {
            return "SELECT H.MaToChuc, H.TenToChucTuThien, H.TenHoatDong, H.HienVatTuThien,C.ID_NVQL, C.NgayToChuc, C.NgayKetThuc\n"
                    + "FROM HOATDONGTUTHIEN H\n"
                    + "INNER JOIN CHITIETHOATDONGTUTHIEN C\n"
                    + "ON H.MaToChuc = C.MaToChuc\n"
                    + "WHERE H.MaToChuc LIKE ?";
        }
    }

    public ArrayList<Charity> getListCharity(String sql) {
        ArrayList<Charity> list = new ArrayList<Charity>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Charity charity = new Charity();
                charity.setID(rs.getString(1));
                charity.setNameOrganization(rs.getString(2));
                charity.setNameCharity(rs.getString(3));
                charity.setArtifacts(rs.getString(4));
                charity.setIDNVQL(String.valueOf(rs.getInt(5)));
                charity.setDateStart(rs.getDate(6).toString());
                Date date = rs.getDate(7);
                if (date == null) {
                    charity.setDateEnd("");
                } else {
                    charity.setDateEnd(date.toString());
                }
                list.add(charity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void InsertChartity(String ID, String NameOrganization, String NameActi, String Artifacts, int IDNV, String DateStart, String DateEnd) {
        String sql = proAddCharity();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            pre.setString(2, NameOrganization);
            pre.setString(3, NameActi);
            pre.setString(4, Artifacts);
            pre.setInt(5, IDNV);
            pre.setString(6, DateStart);
            pre.setString(7, DateEnd);
            pre.executeUpdate();
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void DeleteCharity(String ID_Choose) {
        String sql = proDeleteCharity();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_Choose);
            pre.executeUpdate();
            showMessageDialog(null, "Xoá hoạt động từ thiện " + ID_Choose + "Thành công!");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    public void Update(String ID_Choose, String NameOrganization, String NameActi,
            String Artifacts, int IDNV, String DateStart, String DateEnd) {
        String sql = proUpdateCharity();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_Choose);
            pre.setString(2, NameOrganization);
            pre.setString(3, NameActi);
            pre.setString(4, Artifacts);
            pre.setInt(5, IDNV);
            pre.setString(6, DateStart);
            pre.setString(7, DateEnd);
            pre.executeUpdate();
            showMessageDialog(null, "Cập nhật hoạt động " + ID_Choose + " thành công!");
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public ArrayList<Charity> FindCharity(int i, String Text) {
        ArrayList<Charity> list = new ArrayList<>();
        String sql = sqlFind(i);
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + Text + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Charity charity = new Charity();
                charity.setID(rs.getString(1));
                charity.setNameOrganization(rs.getString(2));
                charity.setNameCharity(rs.getString(3));
                charity.setArtifacts(rs.getString(4));
                charity.setIDNVQL(String.valueOf(rs.getInt(5)));
                charity.setDateStart(rs.getDate(6).toString());
                Date date = rs.getDate(7);
                if (date == null) {
                    charity.setDateEnd("");
                } else {
                    charity.setDateEnd(date.toString());
                }
                list.add(charity);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public static void main(String[] args) {
//        ActivityListerner ac = new ActivityListerner();
//        ac.Update("HDTT1", "aa", "aa", "aa", 102200318, "2002-1-1", "2002-1-1");
//        System.out.println("a..");
    }
}
