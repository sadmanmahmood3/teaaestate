package com.examplecclass.teaaestate.models;

import java.time.LocalDate;

public class Campaign {
    private int id;
    private String name;
    private String description;
    private double targetAmount;
    private double currentAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    public Campaign(int id, String name, String description, double targetAmount, 
                   double currentAmount, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getTargetAmount() { return targetAmount; }
    public double getCurrentAmount() { return currentAmount; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setTargetAmount(double amount) { this.targetAmount = amount; }
    public void setCurrentAmount(double amount) { this.currentAmount = amount; }
    public void setStartDate(LocalDate date) { this.startDate = date; }
    public void setEndDate(LocalDate date) { this.endDate = date; }
} 