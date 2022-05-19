/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class IntroductionDetails {
    String CCCD, Name, Gender, DateOfBirth, Address, Situation, DateIntroduction;

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
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

    public String getSituation() {
        return Situation;
    }

    public void setSituation(String Situation) {
        this.Situation = Situation;
    }

    public String getDateIntroduction() {
        return DateIntroduction;
    }

    public void setDateIntroduction(String DateIntroduction) {
        this.DateIntroduction = DateIntroduction;
    }

    public IntroductionDetails() {
    }

    public IntroductionDetails(String CCCD, String Name, String Gender, String DateOfBirth, String Address, String Situation, String DateIntroduction) {
        this.CCCD = CCCD;
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.Address = Address;
        this.Situation = Situation;
        this.DateIntroduction = DateIntroduction;
    }
}
