/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class LocalTime {

    public static String getDateNow() {
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public static String ChangeTypeDate_dMy(String Date) {
        SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outSDF = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        String outDate = "";
        if (Date.compareTo("") == 0) {
            return "";
        }
        try {
            date = inSDF.parse(Date);
            outDate = outSDF.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outDate;
    }

    public static String ChangeTypeDate_yMd(String Date) {
        SimpleDateFormat inSDF = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String outDate = "";
        if (Date.compareTo("") == 0) {
            return "";
        }
        try {
            date = inSDF.parse(Date);
            outDate = outSDF.format(date);

        } catch (ParseException e) {
//            e.printStackTrace();
//              JOptionPane.showMe
        }
        return outDate;
    }

    public static boolean checkDate_ddMMyyyy(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        return dateFormat.parse(s, new ParsePosition(0)) != null;
    }

    public static boolean checkDate_yyyyMMdd(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        return dateFormat.parse(s, new ParsePosition(0)) != null;
    }

     public static boolean checkPhone(String str)  {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean kt = str.matches(reg);
        if(kt == false){
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng!");
            return false;
        }
        return true;
    }
     public static boolean checkNumber(JTextField s){
         try {
             int n = Integer.parseInt(s.getText());
             s.setBackground(Color.white);
             return true;
         } catch (Exception e) {
             s.setBackground(new Color(255, 190, 185));
             return false;
         }
     }
//    public static void main(String[] args) {
//        System.out.println(ChangeTypeDate_dMy(getDateNow()));
//    }

}
