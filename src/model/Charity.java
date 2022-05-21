/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Charity {

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNameOrganization() {
        return NameOrganization;
    }

    public void setNameOrganization(String NameOrganization) {
        this.NameOrganization = NameOrganization;
    }

    public String getNameCharity() {
        return NameCharity;
    }

    public void setNameCharity(String NameCharity) {
        this.NameCharity = NameCharity;
    }

    public String getArtifacts() {
        return Artifacts;
    }

    public void setArtifacts(String Artifacts) {
        this.Artifacts = Artifacts;
    }

    public String getDateStart() {
        return DateStart;
    }

    public void setDateStart(String DateStart) {
        this.DateStart = DateStart;
    }

    public String getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(String DateEnd) {
        this.DateEnd = DateEnd;
    }

    

    public Charity() {
        
    }

    public String getIDNVQL() {
        return IDNVQL;
    }

    public void setIDNVQL(String IDNVQL) {
        this.IDNVQL = IDNVQL;
    }

    public Charity(String ID, String NameOrganization, String NameCharity, String Artifacts, String IDNVQL, String DateStart, String DateEnd) {
        this.ID = ID;
        this.NameOrganization = NameOrganization;
        this.NameCharity = NameCharity;
        this.Artifacts = Artifacts;
        this.IDNVQL = IDNVQL;
        this.DateStart = DateStart;
        this.DateEnd = DateEnd;
    }
    String ID, NameOrganization, NameCharity, Artifacts,IDNVQL, DateStart, DateEnd;
    
}
