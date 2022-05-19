/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class managementStaff {

   

    public managementStaff() {
    }

    public String getID_NVQL() {
        return ID_NVQL;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL = ID_NVQL;
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

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public managementStaff(String ID_NVQL, String Password, String CCCD, String Name, String DateOfBirth, String Gender, String Address, String PhoneNumber, String Email, String DateEnter, String DateQuit, String Image) {
        this.ID_NVQL = ID_NVQL;
        this.Password = Password;
        this.CCCD = CCCD;
        this.Name = Name;
        this.DateOfBirth = DateOfBirth;
        this.Gender = Gender;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.DateEnter = DateEnter;
        this.DateQuit = DateQuit;
        this.Image = Image;
    }
    String ID_NVQL, Password, CCCD, Name, DateOfBirth, Gender, Address, PhoneNumber, Email, DateEnter, DateQuit, Image;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
