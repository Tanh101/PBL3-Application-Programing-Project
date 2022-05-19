package model;

import java.util.Date;
public class Notification {
    String IDNotification, NameNotification, ContentNotification;

    public Notification(String toString, String toString0) {
            this.NameNotification = toString;
            this.ContentNotification = toString0;
    }

    public Notification() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNameNotification() {
        return NameNotification;
    }

    public void setNameNotification(String NameNotification) {
        this.NameNotification = NameNotification;
    }

    @Override
    public String toString() {
        return NameNotification;
    }

    public String getContentNotification() {
        return ContentNotification;
    }

    public void setContentNotification(String ContentNotification) {
        this.ContentNotification = ContentNotification;
    }

    
    public Notification(String IDNotifi, String NameNotification, String ContentNotification) {
        this.NameNotification = NameNotification;
        this.ContentNotification = ContentNotification;
        this.IDNotification = IDNotifi;
    }
    public String getIDNotification() {
        return IDNotification;
    }

    public void setIDNotification(String IDNotification) {
        this.IDNotification = IDNotification;
    }
    

    
    
}
