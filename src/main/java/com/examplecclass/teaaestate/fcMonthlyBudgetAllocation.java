package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class fcMonthlyBudgetAllocation implements Serializable {
    private int rmBudget,lbrBudget,tptBudget;
    private String submittedBy;
    private LocalDate period;

    public fcMonthlyBudgetAllocation() {
    }

    public fcMonthlyBudgetAllocation(int rmBudget, int lbrBudget, int tptBudget, String submittedBy, LocalDate period) {
        this.rmBudget = rmBudget;
        this.lbrBudget = lbrBudget;
        this.tptBudget = tptBudget;
        this.submittedBy = submittedBy;
        this.period = period;
    }

    public int getRmBudget() {
        return rmBudget;
    }

    public void setRmBudget(int rmBudget) {
        this.rmBudget = rmBudget;
    }

    public int getLbrBudget() {
        return lbrBudget;
    }

    public void setLbrBudget(int lbrBudget) {
        this.lbrBudget = lbrBudget;
    }

    public int getTptBudget() {
        return tptBudget;
    }

    public void setTptBudget(int tptBudget) {
        this.tptBudget = tptBudget;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public LocalDate getPeriod() {
        return period;
    }

    public void setPeriod(LocalDate period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "fcMonthlyBudgetAllocation{" +
                "rmBudget=" + rmBudget +
                ", lbrBudget=" + lbrBudget +
                ", tptBudget=" + tptBudget +
                ", submittedBy='" + submittedBy + '\'' +
                ", period=" + period +
                '}';
    }
}
