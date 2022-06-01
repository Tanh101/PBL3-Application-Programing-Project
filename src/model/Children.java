/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Children {

    public Children(String ID_TRE, String Name, String DateOfBirth, String Address, String Gender, String DateEnter, String DateQuit) {
        this.ID_TRE = ID_TRE;
        this.Name = Name;
        this.DateOfBirth = DateOfBirth;
        this.Address = Address;
        this.Gender = Gender;
        this.DateEnter = DateEnter;
        this.DateQuit = DateQuit;
    }

    public Children() {
    }

    public String getID_TRE() {
        return ID_TRE;
    }

    public void setID_TRE(String ID_TRE) {
        this.ID_TRE = ID_TRE;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDateEnter() {
        return DateEnter;
    }

    public void setDateEnter(String DateEnter) {
        this.DateEnter = DateEnter;
    }

    public String getDateQuit() {
        return DateQuit;
    }

    public void setDateQuit(String DateQuit) {
        this.DateQuit = DateQuit;
    }


    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getSituation() {
        return Situation;
    }

    public void setSituation(String Situation) {
        this.Situation = Situation;
    }

    private String ID_TRE, Name, DateOfBirth, Address, Gender, DateEnter, DateQuit, urlPath, state, Situation;
}
