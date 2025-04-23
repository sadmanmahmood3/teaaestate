package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class tfMonitorCompletion implements Serializable {
    private String trningsession, cmptnstatus, wrkrname;
    private Integer wrkrid;
    private LocalDate date;

    public tfMonitorCompletion() {
    }

    public tfMonitorCompletion(String trningsession, String cmptnstatus, String wrkrname, Integer wrkrid, LocalDate date) {
        this.trningsession = trningsession;
        this.cmptnstatus = cmptnstatus;
        this.wrkrname = wrkrname;
        this.wrkrid = wrkrid;
        this.date = date;
    }

    public tfMonitorCompletion(String trningsession, String cmptnstatus, String wrkrname, int wrkrid) {
    }

    public String getTrningsession() {
        return trningsession;
    }

    public void setTrningsession(String trningsession) {
        this.trningsession = trningsession;
    }

    public String getCmptnstatus() {
        return cmptnstatus;
    }

    public void setCmptnstatus(String cmptnstatus) {
        this.cmptnstatus = cmptnstatus;
    }

    public String getWrkrname() {
        return wrkrname;
    }

    public void setWrkrname(String wrkrname) {
        this.wrkrname = wrkrname;
    }

    public Integer getWrkrid() {
        return wrkrid;
    }

    public void setWrkrid(Integer wrkrid) {
        this.wrkrid = wrkrid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "tfMonitorCompletion{" +
                "trningsession='" + trningsession + '\'' +
                ", cmptnstatus='" + cmptnstatus + '\'' +
                ", wrkrname='" + wrkrname + '\'' +
                ", wrkrid=" + wrkrid +
                ", date=" + date +
                '}';
    }
}
