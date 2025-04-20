package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class adminManageInternalAnnouncement implements Serializable {
    private String body,title,audience;
    private LocalDate start,end;

    public adminManageInternalAnnouncement() {
    }

    public adminManageInternalAnnouncement(String body, String title, String audience, LocalDate start, LocalDate end) {
        this.body = body;
        this.title = title;
        this.audience = audience;
        this.start = start;
        this.end = end;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
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
        return "adminManageInternalAnnouncement{" +
                "body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", audience='" + audience + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
