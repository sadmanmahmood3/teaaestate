package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class mmProposeNewSlogan implements Serializable {

    private String name,slogan,theme;
    private LocalDate date;

    public mmProposeNewSlogan() {
    }

    public mmProposeNewSlogan(String name, String slogan, String theme, LocalDate date) {
        this.name = name;
        this.slogan = slogan;
        this.theme = theme;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "mmProposeNewSlogan{" +
                "name='" + name + '\'' +
                ", slogan='" + slogan + '\'' +
                ", theme='" + theme + '\'' +
                ", date=" + date +
                '}';
    }
}
