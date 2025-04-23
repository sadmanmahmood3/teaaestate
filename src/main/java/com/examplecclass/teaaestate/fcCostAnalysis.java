package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class fcCostAnalysis implements Serializable {
    private String teatype;
    private Integer lbrCost,pkingCost,tptCost;
    private LocalDate date;

    public fcCostAnalysis() {
    }

    public fcCostAnalysis(String teatype, Integer lbrCost, Integer pkingCost, Integer tptCost, LocalDate date) {
        this.teatype = teatype;
        this.lbrCost = lbrCost;
        this.pkingCost = pkingCost;
        this.tptCost = tptCost;
        this.date = date;
    }

    public String getTeatype() {
        return teatype;
    }

    public void setTeatype(String teatype) {
        this.teatype = teatype;
    }

    public Integer getLbrCost() {
        return lbrCost;
    }

    public void setLbrCost(Integer lbrCost) {
        this.lbrCost = lbrCost;
    }

    public Integer getPkingCost() {
        return pkingCost;
    }

    public void setPkingCost(Integer pkingCost) {
        this.pkingCost = pkingCost;
    }

    public Integer getTptCost() {
        return tptCost;
    }

    public void setTptCost(Integer tptCost) {
        this.tptCost = tptCost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "fcCostAnalysis{" +
                "teatype='" + teatype + '\'' +
                ", lbrCost=" + lbrCost +
                ", pkingCost=" + pkingCost +
                ", tptCost=" + tptCost +
                ", date=" + date +
                '}';
    }
}
