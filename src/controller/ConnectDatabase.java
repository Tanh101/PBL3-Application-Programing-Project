/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author ADMIN
 */
public class ConnectDatabase {
    protected Connection conn = null;
    public ConnectDatabase(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLY;";
            conn = DriverManager.getConnection(url, "sa", "606902");
        } catch (Exception e) {
            
        }
    }
}
