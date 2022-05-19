/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Equipment {

    public Equipment(String ID, String Name, String Price, String Providers, int NumOfGood, int NumOfBad, String DateEnter, String DateQuit) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Providers = Providers;
        this.NumOfGood = NumOfGood;
        this.NumOfBad = NumOfBad;
        this.DateEnter = DateEnter;
        this.DateQuit = DateQuit;
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getProviders() {
        return Providers;
    }

    public void setProviders(String Providers) {
        this.Providers = Providers;
    }

    public int getNumOfGood() {
        return NumOfGood;
    }

    public void setNumOfGood(int NumOfGood) {
        this.NumOfGood = NumOfGood;
    }

    public int getNumOfBad() {
        return NumOfBad;
    }

    public void setNumOfBad(int NumOfBad) {
        this.NumOfBad = NumOfBad;
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
    String ID, Name, Price, Providers;
    int NumOfGood, NumOfBad;
    String DateEnter, DateQuit;

    public Equipment() {
    }
}
