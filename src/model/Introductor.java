/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Introductor {

    

    public Introductor() {
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

    public String getDayOfBirth() {
        return DayOfBirth;
    }

    public void setDayOfBirth(String DayOfBirth) {
        this.DayOfBirth = DayOfBirth;
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

    public Introductor(String ID, String Name, String DayOfBirth, String Gender, String Address, String PhoneNumber, String Username, String Password) {
        this.ID = ID;
        this.Name = Name;
        this.DayOfBirth = DayOfBirth;
        this.Gender = Gender;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.Username = Username;
        this.Password = Password;
    }

    
    private String ID, Name, DayOfBirth, Gender,  Address,  PhoneNumber, Username, Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
