package com.examplecclass.teaaestate;

import java.time.LocalDate;

public class tfScheduleSessions {
    private String trningctgry,location, trningtitl, trnername;
    private int mxprtcpnt;
    private LocalDate trningdate;

    public tfScheduleSessions() {
    }

    public tfScheduleSessions(String trningctgry, String location, String trningtitl, String trnername, int mxprtcpnt, LocalDate trningdate) {
        this.trningctgry = trningctgry;
        this.location = location;
        this.trningtitl = trningtitl;
        this.trnername = trnername;
        this.mxprtcpnt = mxprtcpnt;
        this.trningdate = trningdate;
    }


    public String getTrningctgry() {
        return trningctgry;
    }

    public void setTrningctgry(String trningctgry) {
        this.trningctgry = trningctgry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTrningtitl() {
        return trningtitl;
    }

    public void setTrningtitl(String trningtitl) {
        this.trningtitl = trningtitl;
    }

    public String getTrnername() {
        return trnername;
    }

    public void setTrnername(String trnername) {
        this.trnername = trnername;
    }

    public int getMxprtcpnt() {
        return mxprtcpnt;
    }

    public void setMxprtcpnt(int mxprtcpnt) {
        this.mxprtcpnt = mxprtcpnt;
    }

    public LocalDate getTrningdate() {
        return trningdate;
    }

    public void setTrningdate(LocalDate trningdate) {
        this.trningdate = trningdate;
    }

    @Override
    public String toString() {
        return "tfScheduleSessions{" +
                "trningctgry='" + trningctgry + '\'' +
                ", location='" + location + '\'' +
                ", trningtitl='" + trningtitl + '\'' +
                ", trnername='" + trnername + '\'' +
                ", mxprtcpnt=" + mxprtcpnt +
                ", trningdate=" + trningdate +
                '}';
    }
}
