package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class fcScdleNxtRvwDt implements Serializable {
    private String rvwr, sessnprdcr,location,rvwrtitl;
    private LocalDate rvwrdate;

    public fcScdleNxtRvwDt() {
    }

    public fcScdleNxtRvwDt(String rvwr, String sessnprdcr, String location, String rvwrtitl, LocalDate rvwrdate) {
        this.rvwr = rvwr;
        this.sessnprdcr = sessnprdcr;
        this.location = location;
        this.rvwrtitl = rvwrtitl;
        this.rvwrdate = rvwrdate;
    }

    public String getRvwr() {
        return rvwr;
    }

    public void setRvwr(String rvwr) {
        this.rvwr = rvwr;
    }

    public String getSessnprdcr() {
        return sessnprdcr;
    }

    public void setSessnprdcr(String sessnprdcr) {
        this.sessnprdcr = sessnprdcr;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRvwrtitl() {
        return rvwrtitl;
    }

    public void setRvwrtitl(String rvwrtitl) {
        this.rvwrtitl = rvwrtitl;
    }

    public LocalDate getRvwrdate() {
        return rvwrdate;
    }

    public void setRvwrdate(LocalDate rvwrdate) {
        this.rvwrdate = rvwrdate;
    }

    @Override
    public String toString() {
        return "fcScdleNxtRvwDt{" +
                "rvwr='" + rvwr + '\'' +
                ", sessnprdcr='" + sessnprdcr + '\'' +
                ", location='" + location + '\'' +
                ", rvwrtitl='" + rvwrtitl + '\'' +
                ", rvwrdate=" + rvwrdate +
                '}';
    }
}
