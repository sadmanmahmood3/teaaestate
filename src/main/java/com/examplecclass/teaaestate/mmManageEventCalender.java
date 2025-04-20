package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class mmManageEventCalender implements Serializable {
    private String title,name,location;
    private LocalDate date;

    public mmManageEventCalender() {
    }

    public mmManageEventCalender(String title, String name, String location, LocalDate date) {
        this.title = title;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "mmManageEventCalender{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                '}';
    }
}
