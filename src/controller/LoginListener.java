/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerStatementColumnEncryptionSetting;
//import java.beans.Statement;



/**
 *
 * @author ADMIN
 */
public class ConnectLogin {
//    String url = "jdbc"

    public static void main(String[] args) {
                String server = "DESKTOP-B0D0J2Q\\SQLEXPRESS";
		String user = "sa";
		String password = "606902";
		String db = "QUANLY";
		int port = 1433;
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser(user);
		ds.setServerName(server);
		ds.setPassword(password);
		ds.setDatabaseName(db);
		ds.setPortNumber(port);
		try {
			java.sql.Connection conn = ds.getConnection();
                        java.sql.Statement sttm = conn.createStatement();
                        String sql = "SELECT * FROM TAIKHOAN ";
                        var rs = sttm.executeQuery(sql);
                        while (rs.next()){
                            System.out.println(rs.getString("ID_NVQL") + rs.getString("PASSWORD") );
                        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    

   

}
