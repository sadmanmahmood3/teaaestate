package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class adminAssertQualityLogs implements Serializable {
    private String id;
    private String factoryName,shift,teaType;
    private LocalDate date;

    public adminAssertQualityLogs() {
    }

    public adminAssertQualityLogs(String id, String factoryName, String shift, LocalDate date, String teaType) {
        this.id = id;
        this.factoryName = factoryName;
        this.shift = shift;
        this.date = date;
        this.teaType = teaType;
    }

    public adminAssertQualityLogs(String id, String factoryName, String shift, String teaType, LocalDate date) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "adminAssertQualityLogs{" +
                "id='" + id + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", shift='" + shift + '\'' +
                ", teaType='" + teaType + '\'' +
                ", date=" + date +
                '}';
    }
}
