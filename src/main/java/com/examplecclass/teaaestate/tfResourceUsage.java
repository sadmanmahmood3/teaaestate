package com.examplecclass.teaaestate;

import java.time.LocalDate;

public class tfResourceUsage {
    private String trnername, resourcename;
    private int quantity;
    private LocalDate sessndate;

    public tfResourceUsage() {
    }

    public tfResourceUsage(String trnername, String resourcename, int quantity, LocalDate sessndate) {
        this.trnername = trnername;
        this.resourcename = resourcename;
        this.quantity = quantity;
        this.sessndate = sessndate;
    }

    public String getTrnername() {
        return trnername;
    }

    public void setTrnername(String trnername) {
        this.trnername = trnername;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getSessndate() {
        return sessndate;
    }

    public void setSessndate(LocalDate sessndate) {
        this.sessndate = sessndate;
    }

    @Override
    public String toString() {
        return "tfResourceUsage{" +
                "trnername='" + trnername + '\'' +
                ", resourcename='" + resourcename + '\'' +
                ", quantity=" + quantity +
                ", sessndate=" + sessndate +
                '}';
    }
}
