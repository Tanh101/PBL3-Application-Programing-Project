/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class CheckDateTime {

    public boolean checkDate(String d) {
        try {
            LocalDate date = LocalDate.parse(d);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Định dạng ngày tháng không hợp lệ! Vui lòng kiểm tra lại!");
        }
        return false;
    }

    public Date ConvertStingtoDate(String text) {
        Date d = null;
        String date;
        if (checkDate(text)) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-d");

            try {
                d = df.parse(text);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return d;
    }
//
//    public static void main(String[] args) {
//        Date d = new CheckDateTime().ConvertStingtoDate("2020-12-10");
//        System.out.println(d.toString());
//    }

}
