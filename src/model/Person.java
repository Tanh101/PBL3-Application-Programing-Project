/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import microsoft.sql.DateTimeOffset;

/**
 *
 * @author ADMIN
 */
public class Person {

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
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

    public DateTimeOffset getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(DateTimeOffset DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public Person(String Name, String Sex, String Address, String PhoneNumber, DateTimeOffset DateOfBirth) {
        this.Name = Name;
        this.Sex = Sex;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.DateOfBirth = DateOfBirth;
    }

    public Person() {
        
    }
    protected String  Name, Sex, Address, PhoneNumber;
    protected DateTimeOffset DateOfBirth;
}
