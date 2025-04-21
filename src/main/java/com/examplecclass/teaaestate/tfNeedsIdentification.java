package com.examplecclass.teaaestate;

import java.time.LocalDate;

public class tfNeedsIdentification {
    private String rqstby, dprtmnt, prorty,trningtopicnd,sgstedprcpnt;
    private LocalDate rqstdate;

    public tfNeedsIdentification() {
    }

    public tfNeedsIdentification(String rqstby, String dprtmnt, String prorty, String trningtopicnd, String sgstedprcpnt, LocalDate rqstdate) {
        this.rqstby = rqstby;
        this.dprtmnt = dprtmnt;
        this.prorty = prorty;
        this.trningtopicnd = trningtopicnd;
        this.sgstedprcpnt = sgstedprcpnt;
        this.rqstdate = rqstdate;
    }

    public String getRqstby() {
        return rqstby;
    }

    public void setRqstby(String rqstby) {
        this.rqstby = rqstby;
    }

    public String getDprtmnt() {
        return dprtmnt;
    }

    public void setDprtmnt(String dprtmnt) {
        this.dprtmnt = dprtmnt;
    }

    public String getProrty() {
        return prorty;
    }

    public void setProrty(String prorty) {
        this.prorty = prorty;
    }

    public String getTrningtopicnd() {
        return trningtopicnd;
    }

    public void setTrningtopicnd(String trningtopicnd) {
        this.trningtopicnd = trningtopicnd;
    }

    public String getSgstedprcpnt() {
        return sgstedprcpnt;
    }

    public void setSgstedprcpnt(String sgstedprcpnt) {
        this.sgstedprcpnt = sgstedprcpnt;
    }

    public LocalDate getRqstdate() {
        return rqstdate;
    }

    public void setRqstdate(LocalDate rqstdate) {
        this.rqstdate = rqstdate;
    }

    @Override
    public String toString() {
        return "tfNeedsIdentification{" +
                "rqstby='" + rqstby + '\'' +
                ", dprtmnt='" + dprtmnt + '\'' +
                ", prorty='" + prorty + '\'' +
                ", trningtopicnd='" + trningtopicnd + '\'' +
                ", sgstedprcpnt='" + sgstedprcpnt + '\'' +
                ", rqstdate=" + rqstdate +
                '}';
    }
}
