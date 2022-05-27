/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class IntroduceChildren {

   

    private String ID_TRE, Name, DOB, Address, Gender, UrlImg, Situation, State, DateIntroduce;

    public IntroduceChildren() {
    }

    public IntroduceChildren(String ID_TRE, String Name, String DOB, String Address, String Gender, String UrlImg, String Situation, String State, String DateIntroduce) {
        this.ID_TRE = ID_TRE;
        this.Name = Name;
        this.DOB = DOB;
        this.Address = Address;
        this.Gender = Gender;
        this.UrlImg = UrlImg;
        this.Situation = Situation;
        this.State = State;
        this.DateIntroduce = DateIntroduce;
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
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

    public String getUrlImg() {
        return UrlImg;
    }

    public void setUrlImg(String UrlImg) {
        this.UrlImg = UrlImg;
    }

    public String getSituation() {
        return Situation;
    }

    public void setSituation(String Situation) {
        this.Situation = Situation;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getDateIntroduce() {
        return DateIntroduce;
    }

    public void setDateIntroduce(String DateIntroduce) {
        this.DateIntroduce = DateIntroduce;
    }
    
}
