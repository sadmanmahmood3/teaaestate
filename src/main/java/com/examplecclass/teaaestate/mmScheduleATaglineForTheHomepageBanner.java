package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class mmScheduleATaglineForTheHomepageBanner implements Serializable {

    private String tagline,priority,status;
    private LocalDate start,end;

    public mmScheduleATaglineForTheHomepageBanner() {
    }

    public mmScheduleATaglineForTheHomepageBanner(String tagline, LocalDate end, LocalDate start, String status, String priority) {
        this.tagline = tagline;
        this.end = end;
        this.start = start;
        this.status = status;
        this.priority = priority;
    }

    public mmScheduleATaglineForTheHomepageBanner(String tagline, String priority, String status, LocalDate start, LocalDate end) {
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "mmScheduleATaglineForTheHomepageBanner{" +
                "tagline='" + tagline + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
