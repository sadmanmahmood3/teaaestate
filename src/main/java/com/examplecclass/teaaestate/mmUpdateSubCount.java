package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class mmUpdateSubCount implements Serializable {
    private int newSubs,unsubs;
    private LocalDate date;

    public mmUpdateSubCount() {
    }

    public mmUpdateSubCount(int newSubs, int unsubs, LocalDate date) {
        this.newSubs = newSubs;
        this.unsubs = unsubs;
        this.date = date;
    }

    public int getNewSubs() {
        return newSubs;
    }

    public void setNewSubs(int newSubs) {
        this.newSubs = newSubs;
    }

    public int getUnsubs() {
        return unsubs;
    }

    public void setUnsubs(int unsubs) {
        this.unsubs = unsubs;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "mmUpdateSubCount{" +
                "newSubs=" + newSubs +
                ", unsubs=" + unsubs +
                ", date=" + date +
                '}';
    }
}
