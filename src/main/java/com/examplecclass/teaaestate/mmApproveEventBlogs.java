package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class mmApproveEventBlogs implements Serializable {
    private String title,name,eventName,rvwStatus;
    private LocalDate subDate,pubDate;

    public mmApproveEventBlogs() {
    }

    public mmApproveEventBlogs(String title, String name, String eventName, String rvwStatus, LocalDate subDate, LocalDate pubDate) {
        this.title = title;
        this.name = name;
        this.eventName = eventName;
        this.rvwStatus = rvwStatus;
        this.subDate = subDate;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRvwStatus() {
        return rvwStatus;
    }

    public void setRvwStatus(String rvwStatus) {
        this.rvwStatus = rvwStatus;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getSubDate() {
        return subDate;
    }

    public void setSubDate(LocalDate subDate) {
        this.subDate = subDate;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "mmApproveEventBlogs{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", eventName='" + eventName + '\'' +
                ", rvwStatus='" + rvwStatus + '\'' +
                ", subDate=" + subDate +
                ", pubDate=" + pubDate +
                '}';
    }
}
