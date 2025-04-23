package com.examplecclass.teaaestate.models;

public class Notice {
    private int id;
    private String date;
    private String template;
    private String status;

    public Notice(int id, String date, String template, String status) {
        this.id = id;
        this.date = date;
        this.template = template;
        this.status = status;
    }

    public int getId() { return id; }
    public String getDate() { return date; }
    public String getTemplate() { return template; }
    public String getStatus() { return status; }
} 