package com.examplecclass.teaaestate;

import java.time.LocalDate;

public class fcRcdCapExRqst {
    private String apprvl,dprtmt,prty,supplr,rqstby;
    private int rqstID;
    private LocalDate expdate;

    public fcRcdCapExRqst() {
    }

    public fcRcdCapExRqst(String apprvl, String dprtmt, String prty, String supplr, String rqstby, int rqstID, LocalDate expdate) {
        this.apprvl = apprvl;
        this.dprtmt = dprtmt;
        this.prty = prty;
        this.supplr = supplr;
        this.rqstby = rqstby;
        this.rqstID = rqstID;
        this.expdate = expdate;
    }

    public String getApprvl() {
        return apprvl;
    }

    public void setApprvl(String apprvl) {
        this.apprvl = apprvl;
    }

    public String getDprtmt() {
        return dprtmt;
    }

    public void setDprtmt(String dprtmt) {
        this.dprtmt = dprtmt;
    }

    public String getPrty() {
        return prty;
    }

    public void setPrty(String prty) {
        this.prty = prty;
    }

    public String getSupplr() {
        return supplr;
    }

    public void setSupplr(String supplr) {
        this.supplr = supplr;
    }

    public String getRqstby() {
        return rqstby;
    }

    public void setRqstby(String rqstby) {
        this.rqstby = rqstby;
    }

    public int getRqstID() {
        return rqstID;
    }

    public void setRqstID(int rqstID) {
        this.rqstID = rqstID;
    }

    public LocalDate getExpdate() {
        return expdate;
    }

    public void setExpdate(LocalDate expdate) {
        this.expdate = expdate;
    }

    @Override
    public String toString() {
        return "fcRcdCapExRqst{" +
                "apprvl='" + apprvl + '\'' +
                ", dprtmt='" + dprtmt + '\'' +
                ", prty='" + prty + '\'' +
                ", supplr='" + supplr + '\'' +
                ", rqstby='" + rqstby + '\'' +
                ", rqstID=" + rqstID +
                ", expdate=" + expdate +
                '}';
    }
}
