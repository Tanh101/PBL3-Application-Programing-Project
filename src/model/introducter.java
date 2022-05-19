/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class introducter {

    public introducter(String CCCD, String Name, String Gender, String Address, String PhoneNumber, String DayOfBirth) {
        this.CCCD = CCCD;
        this.Name = Name;
        this.Gender = Gender;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.DayOfBirth = DayOfBirth;
    }

    public introducter() {
    }

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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getDayOfBirth() {
        return DayOfBirth;
    }

    public void setDayOfBirth(String DayOfBirth) {
        this.DayOfBirth = DayOfBirth;
    }
    private String CCCD, Name,  Gender,  Address,  PhoneNumber,  DayOfBirth;
}
