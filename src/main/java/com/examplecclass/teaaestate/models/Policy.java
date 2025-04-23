package com.examplecclass.teaaestate.models;

public class Policy {
    private int id;
    private String name;
    private String details;
    private String status;
    private String lastReview;

    public Policy(int id, String name, String details, String status, String lastReview) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.status = status;
        this.lastReview = lastReview;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDetails() { return details; }
    public String getStatus() { return status; }
    public String getLastReview() { return lastReview; }
    
    public void setStatus(String status) { this.status = status; }
} 