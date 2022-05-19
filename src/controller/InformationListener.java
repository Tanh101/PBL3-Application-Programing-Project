/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Notification;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class InformationListener extends ConnectDatabase {
    
    public Vector<Notification> getListNotification() {
        Vector<Notification> demo = new Vector<Notification>();

        String sql = "SELECT MaThongBao, TenThongBao,NoiDungThongBao FROM THONGBAO";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                demo.add(new Notification(res.getString("MaThongBao"), res.getString("TenThongBao"), res.getString("NoiDungThongBao")));
            }
        } catch (Exception e) {
            
        }
        return demo;
    }
    
    public Vector<String> getListContent() {
        Vector<String> demo = new Vector<String>();
        Vector<Notification> list = getListNotification();
        for(Notification notifi : list){
            demo.add(notifi.getNameNotification());
        }
        
        return demo;
    }
    

}
