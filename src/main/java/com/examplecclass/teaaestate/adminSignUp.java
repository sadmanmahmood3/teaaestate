package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class adminSignUp implements Serializable {
    private String name,nid,mobile,mail,password;
    private LocalDate date;

    public adminSignUp() {
    }

    public adminSignUp(String name, LocalDate date, String password, String mail, String mobile, String nid) {
        this.name = name;
        this.date = date;
        this.password = password;
        this.mail = mail;
        this.mobile = mobile;
        this.nid = nid;
    }

    public adminSignUp(String name, String nid, String mobile, String mail, String password, LocalDate date) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    @Override
    public String toString() {
        return "adminSignUp{" +
                "name='" + name + '\'' +
                ", nid='" + nid + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
