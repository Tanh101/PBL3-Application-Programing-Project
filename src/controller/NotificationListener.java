///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package controller;
//
//import com.microsoft.sqlserver.jdbc.SQLServerStatementColumnEncryptionSetting;
//import java.io.ObjectInputStream;
//import java.util.ArrayList;
//import model.Notification;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
///**
// *
// * @author ADMIN
// */
//public class NotificationListener extends ConnectDatabase {
//
//    public ArrayList<Notification> GetListNotification() {
//        ArrayList<Notification> list = new ArrayList<Notification>();
//        try {
//            String sql = "SELECT * FROM THONGBAO";
//            PreparedStatement pre = conn.prepareStatement(sql);
//            ResultSet rs = pre.executeQuery();
//            while (rs.next()) {
//                Notification mes = new Notification();
//                mes.setIDNotification(rs.getString(1));
//                mes.setNameNotification(rs.getString(2));
//                mes.setContentNotification(rs.getString(3));
//                list.add(mes);
//            }
//        } catch (Exception e) {    
//        }
//        return list;
//    }
//}
