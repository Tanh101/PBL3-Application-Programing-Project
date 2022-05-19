/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class LaborContract {

    public LaborContract(String ID_NVQL, String ID_CBNV, String DateStart, String DateEnd) {
        this.ID_NVQL = ID_NVQL;
        this.ID_CBNV = ID_CBNV;
        this.DateStart = DateStart;
        this.DateEnd = DateEnd;
    }

    public LaborContract() {
        
    }

    public String getID_NVQL() {
        return ID_NVQL;
    }

    public void setID_NVQL(String ID_NVQL) {
        this.ID_NVQL = ID_NVQL;
    }

    public String getID_CBNV() {
        return ID_CBNV;
    }

    public void setID_CBNV(String ID_CBNV) {
        this.ID_CBNV = ID_CBNV;
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
    private String ID_NVQL, ID_CBNV;
    private String DateStart, DateEnd;
}
