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
public class User extends Person {

    public String getUserName() {
        return UserName;
    }

    public User(String UserName, String Name, String Sex, String Address, String PhoneNumber, DateTimeOffset DateOfBirth) {
        super(Name, Sex, Address, PhoneNumber, DateOfBirth);
        this.UserName = UserName;
    }

    public User(String UserName) {
        this.UserName = UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    private String UserName;
}
