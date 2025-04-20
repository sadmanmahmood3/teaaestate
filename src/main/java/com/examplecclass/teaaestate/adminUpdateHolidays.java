package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class adminUpdateHolidays implements Serializable {
    private String name,updatedBy,type;
    private LocalDate date;

    public adminUpdateHolidays() {
    }

    public adminUpdateHolidays(String name, String updatedBy, String type, LocalDate date) {
        this.name = name;
        this.updatedBy = updatedBy;
        this.type = type;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "adminUpdateHolidays{" +
                "name='" + name + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
