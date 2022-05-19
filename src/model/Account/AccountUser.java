/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountUser {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public AccountUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    private String userName;
    private String passWord;
}
