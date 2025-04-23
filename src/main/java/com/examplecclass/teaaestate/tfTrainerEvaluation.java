package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class tfTrainerEvaluation implements Serializable {
    private String trnername, evlutorname, dlryqultyrting, timeatngmnt;
    private LocalDate trningdate;

    public tfTrainerEvaluation() {
    }

    public tfTrainerEvaluation(String trnername, String evlutorname, String dlryqultyrting, String timeatngmnt, LocalDate trningdate) {
        this.trnername = trnername;
        this.evlutorname = evlutorname;
        this.dlryqultyrting = dlryqultyrting;
        this.timeatngmnt = timeatngmnt;
        this.trningdate = trningdate;
    }

    public String getTrnername() {
        return trnername;
    }

    public void setTrnername(String trnername) {
        this.trnername = trnername;
    }

    public String getEvlutorname() {
        return evlutorname;
    }

    public void setEvlutorname(String evlutorname) {
        this.evlutorname = evlutorname;
    }

    public String getDlryqultyrting() {
        return dlryqultyrting;
    }

    public void setDlryqultyrting(String dlryqultyrting) {
        this.dlryqultyrting = dlryqultyrting;
    }

    public String getTimeatngmnt() {
        return timeatngmnt;
    }

    public void setTimeatngmnt(String timeatngmnt) {
        this.timeatngmnt = timeatngmnt;
    }

    public LocalDate getTrningdate() {
        return trningdate;
    }

    public void setTrningdate(LocalDate trningdate) {
        this.trningdate = trningdate;
    }

    @Override
    public String toString() {
        return "tfTrainerEvaluation{" +
                "trnername='" + trnername + '\'' +
                ", evlutorname='" + evlutorname + '\'' +
                ", dlryqultyrting='" + dlryqultyrting + '\'' +
                ", timeatngmnt='" + timeatngmnt + '\'' +
                ", trningdate=" + trningdate +
                '}';
    }
}
