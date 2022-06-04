/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import model.Adopted;
import model.Adopter;
import model.Children;
import model.IntroduceChildren;
import model.Staff;
import view.AddJframe.ChildrenAdopted;

/**
 *
 * @author ADMIN
 */
public class ChildrenListener extends ConnectDatabase {

    public String proShowChild(int i) {
        if (i == 1) {
            return "SHOW_CHILDREN";
        } else if (i == 2) {
            return "SHOW_CHILDREN_NOW";
        } else {
            return "SHOW_CHILDREN_END";
        }

    }
    public String proShowChildIntro(){
        return "SELECT * FROM TRE WHERE Quyen = '0'";
    }

    private String ProcedureFindChild(int i) {
        if (i == 1) {
            return "FIND_CHILD @ID_TRE = ?";
        } else if (i == 2) {
            return "FIND_CHILD_NAME @NAME = ";
        } else if (i == 3) {

        }
        return "";
    }

//    private String getSqlFindName() {
//        String sql = "SELECT T.ID_Tre, T.HoTen, T.NgaySinh, T.DiaChi, T.GioiTinh,T.TenAnh, Q.NgayVaoTT, Q.NgayRoiTT\n"
//                + "FROM TRE T\n"
//                + "INNER JOIN QUANLYTRE Q\n"
//                + "ON T.ID_Tre = Q.ID_Tre\n"
//                + "WHERE T.HoTen LIKE ? AND T.Quyen = '1'";
//        return sql;
//    }
    private String getSqlUpdate() {
        String sql = "UPDATE TRE\n"
                + "SET HoTen = ?, NgaySinh = ?,DiaChi = ?, GioiTinh = ?, TenAnh = ?, HoanCanh = ?\n"
                + "WHERE ID_Tre = ?\n"
                + "UPDATE QUANLYTRE\n"
                + "SET ID_NVQL = ?,NgayVaoTT = ?, NgayRoiTT = ?\n"
                + "WHERE ID_Tre = ?";
        return sql;
    }

    private String getSqlInsert() {
        return "INSERT INTO TRE\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);\n"
                + "INSERT INTO QUANLYTRE\n"
                + "VALUES (?, ?, ?, ?)";
    }

    private String getSqlDelete() {
        return "DELETE FROM TRE \n"
                + "WHERE ID_Tre = ?";
    }

    public ArrayList<Children> getListChildren(String sql) {
        ArrayList<Children> list = new ArrayList<Children>();
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
                chil.setSituation(rs.getString(7));
                chil.setDateEnter(rs.getDate(8).toString());
                Date date = rs.getDate(9);
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

    public ArrayList<Children> FindChild(int i, String Choose) {
        ArrayList<Children> list = new ArrayList<Children>();
        try {
            String sql = ProcedureFindChild(i);                    
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
                chil.setSituation(rs.getString(7));
                chil.setDateEnter(rs.getDate(8).toString());
                Date date = rs.getDate(9);
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

    public void Update(String ID_Choose, String Name, String DOB, String Address,
            String Gender, String NamePhoto,String Situation, String ID_NVQL, String DateEnter, String DateQuit) {
        String sql = getSqlUpdate();
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, Name);
            pre.setString(2, DOB);
            pre.setString(3, Address);
            pre.setString(4, Gender);
            pre.setString(5, NamePhoto);
            pre.setString(6, Situation);
            pre.setString(7, ID_Choose);
            pre.setString(8, ID_NVQL);
            pre.setString(9, DateEnter);
            pre.setString(10, DateQuit);
            pre.setString(11, ID_Choose);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void Insert(String ID_TRE, String Name, String DOB, String Address,
            String Gender, String NamePhoto, String Access, String Situation, String ID_NVQL, String DateEnter, String DateQuit) {
        String sql = getSqlInsert();

        try {
            if (FindChild(1, ID_TRE).size() == 0) {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, ID_TRE);
                pre.setString(2, Name);
                pre.setString(3, DOB);
                pre.setString(4, Address);
                pre.setString(5, Gender);
                pre.setString(6, NamePhoto);
                pre.setString(7, Access);
                pre.setString(8, Situation);
                pre.setString(9, ID_TRE);
                pre.setString(10, ID_NVQL);
                pre.setString(11, DateEnter);
                pre.setString(12, DateQuit);

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

    //------------------------------------------------------INTRODUCTOR MANAGEMENT ----------------------------------------------
    public String ProShowIntroChild(int i) {
        if (i == 1) {
            return "SHOW_CHILDREN_INTRODUCED @ID  = ?";
        } else if (i == 2) {
            return "SHOW_CHILDREN_APPROVED  @ID  = ?";
        } else {
            return "SHOW_CHILDREN_NOT_APPROVED @ID  = ?";
        }
    }

    public ArrayList<IntroduceChildren> listIntroduceChildren(int i, String ID) {
        ArrayList<IntroduceChildren> list = new ArrayList<IntroduceChildren>();
        String sql = ProShowIntroChild(i);
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                IntroduceChildren chil = new IntroduceChildren();
                chil.setID_TRE(rs.getString(1));
                chil.setName(rs.getString(2));
                chil.setDOB(rs.getDate(3).toString());
                chil.setAddress(rs.getString(4));
                chil.setGender(rs.getString(5));
                chil.setUrlImg(rs.getString(6));
                chil.setSituation(rs.getString(7));
                chil.setState(rs.getString(8));
                Date date = rs.getDate(9);
                if (date == null) {
                    chil.setDateIntroduce("");
                } else {
                    chil.setDateIntroduce(date.toString());
                }
                list.add(chil);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void UpdateChildrenIntro(String ID_Choose, String Name, String DOB, String Address, String Gender, String Situation, String DateIntro, String Img) {
        String sql = "UPDATE_CHILDREN_INTRODUCED\n"
                + "@ID_CHOOSE = ?, @NAME = ?, @DOB = ?, @ADDRESS = ?, @GENDER = ?, @SITUATION = ?, @DATEINTRO = ?, @IMG = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_Choose);
            pre.setString(2, Name);
            pre.setString(3, DOB);
            pre.setString(4, Address);
            pre.setString(5, Gender);
            pre.setString(6, Situation);
            pre.setString(7, DateIntro);
            pre.setString(8, Img);
            pre.executeUpdate();
            showMessageDialog(null, "Cập nhật trẻ " + ID_Choose + " thành công");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    private String procedureFindItroChild(int i) {
        if (i == 1) {
            return "FIND_ID_CHILD @ID =?"
                    + ", @ID_CHOOSE =?";
        } else {
            return "FIND_NAME_CHILD @ID =?"
                    + ", @NAME = ?";
        }
    }

    public ArrayList<IntroduceChildren> FindChildIntro(int i, String IDDTGT, String text) {
        ArrayList<IntroduceChildren> list = new ArrayList<IntroduceChildren>();
        String sql = procedureFindItroChild(i);
        try {
//            System.out.println(sql);
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, IDDTGT);
            pre.setString(2, text);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                IntroduceChildren chil = new IntroduceChildren();
                chil.setID_TRE(rs.getString(1));
                chil.setName(rs.getString(2));
                chil.setDOB(rs.getDate(3).toString());
                chil.setAddress(rs.getString(4));
                chil.setGender(rs.getString(5));
                chil.setUrlImg(rs.getString(6));
                chil.setSituation(rs.getString(7));
                chil.setState(rs.getString(8));
                Date date = rs.getDate(9);
                if (date == null) {
                    chil.setDateIntroduce("");
                } else {
                    chil.setDateIntroduce(date.toString());
                }
                list.add(chil);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public void UpdateState(String ID_Choose, String NewID, String State, int IDNVQL, String DateEnter, String DateQuit, String Access) {
        String sql = "UPDATE_STATE_CHILDREN\n"
                + "@ID_CHOOSE = ?, @ID = ?, @STATE = ? ,@IDNVQL = ?, @DATEENTER = ?, @DATEQUIT = ?, @ACCESS = ?";
        try {
            if (FindChild(1, ID_Choose).size() <= 0) {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, ID_Choose);
                pre.setString(2, NewID);
                pre.setString(3, State);
                pre.setInt(4, IDNVQL);
                pre.setString(5, DateEnter);
                pre.setString(6, DateQuit);
                pre.setString(7, Access);
                pre.executeUpdate();
                showMessageDialog(null, "Thêm trẻ " + NewID + " vào trung tâm thành công");
            } else {
                showMessageDialog(null, "Trẻ đã tồn tại trong trung tâm");
            }
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }

    //------------------------------------------------------Adopter MANAGEMENT ----------------------------------------------
    //----------------------------------------------Children change to Adopted -----------------------------------------
    private String proShowChildAdop(int i) {
        if (i == 1) {
            return "SHOW_ADOPTED @CCCD_CHOOSE = ?";
        } else if (i == 2) {

            return "FIND_ADOPTED_IDTRE\n"
                    + "@ID_TRE = ?";
        } else {
            return "FIND_ADOPTED_NAME\n"
                    + "@NAME = ?";
        }
    }

    public ArrayList<Adopted> showAdopted(int i, String ID) {
        ArrayList<Adopted> list = new ArrayList<Adopted>();
        String sql = proShowChildAdop(i);
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Adopted chil = new Adopted();
                chil.setID_TRE(rs.getString(1));
                chil.setName(rs.getString(2));
                chil.setDOB(rs.getDate(3).toString());
                chil.setAddress(rs.getString(4));
                chil.setGender(rs.getString(5));
                chil.setImg(rs.getString(6));
                chil.setState(rs.getString(7));
                Date date = rs.getDate(8);
                if (date == null) {
                    chil.setDateAdopt("");
                } else {
                    chil.setDateAdopt(date.toString());
                }
                list.add(chil);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void UpdateAdopted(String ID_Choose, String Name, String DOB, String Address, String Gender, String DateAdopt, String img) {
        String sql = "UPDATE_ADOPTED\n"
                + "@ID_CHOOSE = ?, @NAME = ?, @DOB = ?, @ADDRESS = ?,@GENDER = ?,  @DATEADOPT = ?, @IMG = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ID_Choose);
            pre.setString(2, Name);
            pre.setString(3, DOB);
            pre.setString(4, Address);
            pre.setString(5, Gender);
            pre.setString(6, DateAdopt);
            pre.setString(7, img);
            pre.executeUpdate();
            showMessageDialog(null, "Cập nhật trẻ " + ID_Choose + " thành công!");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
        }
    }
    public static void main(String[] args) {
        ChildrenListener st = new ChildrenListener();
        ArrayList<Children> v = new ArrayList<>();
        v = st.FindChild(2, " ");
        System.out.println(v.size());
    }
}
