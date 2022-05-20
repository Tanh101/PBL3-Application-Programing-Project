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
    private String ID, Name, Place, DateStart, DateEnd;

    public Extracurriclar() {
    }

    public Extracurriclar(String ID, String Name, String Place, String DateStart, String DateEnd) {
        this.ID = ID;
        this.Name = Name;
        this.Place = Place;
        this.DateStart = DateStart;
        this.DateEnd = DateEnd;
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
