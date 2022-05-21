/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Extracurriclar {

    private String ID, Name, Place,IDNVQL, NumberOfStaff, NumberOfChild, DateStart, DateEnd;
    
    public String getIDNVQL() {
        return IDNVQL;
    }

    public void setIDNVQL(String IDCBNV) {
        this.IDNVQL = IDCBNV;
    }

    public String getNumberOfStaff() {
        return NumberOfStaff;
    }

    public void setNumberOfStaff(String NumberOfStaff) {
        this.NumberOfStaff = NumberOfStaff;
    }

    public String getNumberOfChild() {
        return NumberOfChild;
    }

    public void setNumberOfChild(String NumberOfChild) {
        this.NumberOfChild = NumberOfChild;
    }

    public Extracurriclar(String ID, String Name, String Place, String IDNVQL, String NumberOfStaff, String NumberOfChild, String DateStart, String DateEnd) {
        this.ID = ID;
        this.Name = Name;
        this.Place = Place;
        this.IDNVQL = IDNVQL;
        this.NumberOfStaff = NumberOfStaff;
        this.NumberOfChild = NumberOfChild;
        this.DateStart = DateStart;
        this.DateEnd = DateEnd;
    }
    

    public Extracurriclar() {
    }

   

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public String getDateStart() {
        return DateStart;
    }

    public void setDateStart(String DateStart) {
        this.DateStart = DateStart;
    }

    public String getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(String DateEnd) {
        this.DateEnd = DateEnd;
    }
}
