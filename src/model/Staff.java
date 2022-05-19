/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Staff {

    public String getID_CBNV() {
        return ID_CBNV;
    }

    public void setID_CBNV(String ID_CBNV) {
        this.ID_CBNV = ID_CBNV;
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNamePhoto() {
        return NamePhoto;
    }

    public void setNamePhoto(String NamePhoto) {
        this.NamePhoto = NamePhoto;
    }

    

    public Staff() {
    }

    public Staff(String ID_CBNV, String Password, String Name, String DateOfBirth, String PhoneNumber, String Gender, String Address, String NamePhoto) {
        this.ID_CBNV = ID_CBNV;
        this.Password = Password;
        this.Name = Name;
        this.DateOfBirth = DateOfBirth;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
        this.Address = Address;
        this.NamePhoto = NamePhoto;
    }

    private String ID_CBNV, Password, Name, DateOfBirth, PhoneNumber, Gender, Address, NamePhoto;

}
