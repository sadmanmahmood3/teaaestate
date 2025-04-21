package com.examplecclass.teaaestate;

import java.time.LocalDate;

public class fcPubFinancialSessions {
    private String teatype;
    private int lfreceived, lfproduced;
    private LocalDate date;

    public fcPubFinancialSessions() {
    }

    public fcPubFinancialSessions(String teatype, int lfreceived, int lfproduced, LocalDate date) {
        this.teatype = teatype;
        this.lfreceived = lfreceived;
        this.lfproduced = lfproduced;
        this.date = date;
    }

    public fcPubFinancialSessions(int lfreceived, int lfproduced, String teatype, LocalDate date) {
    }

    public String getTeatype() {
        return teatype;
    }

    public void setTeatype(String teatype) {
        this.teatype = teatype;
    }

    public int getLfreceived() {
        return lfreceived;
    }

    public void setLfreceived(int lfreceived) {
        this.lfreceived = lfreceived;
    }

    public int getLfproduced() {
        return lfproduced;
    }

    public void setLfproduced(int lfproduced) {
        this.lfproduced = lfproduced;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "fcPubFinancialSessions{" +
                "teatype='" + teatype + '\'' +
                ", lfreceived=" + lfreceived +
                ", lfproduced=" + lfproduced +
                ", date=" + date +
                '}';
    }
}
