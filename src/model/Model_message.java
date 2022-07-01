/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
        
/**
 *
 * @author ADMIN
 */
public class Model_message {
    String ID_model;
    String header;
    String content;
    String vi_tri;
    String Date;
     
     
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
   
    

    public void setID_model(String ID_model) {
        this.ID_model = ID_model;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setVi_tri(String vi_tri) {
        this.vi_tri = vi_tri;
    }

    public String getID_model() {
        return ID_model;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public String getVi_tri() {
        return vi_tri;
    }

   

    public static void main(String[] args) {
        System.out.println("Hello");
    }
    
}
