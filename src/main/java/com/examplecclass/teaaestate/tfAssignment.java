package com.examplecclass.teaaestate;

public class tfAssignment {
    private String trnername;
    private String location;
    private String trningdays;
    private String timeslots;

    public tfAssignment() {
    }

    public tfAssignment(String trnername, String location, String trningdays, String timeslots) {
        this.trnername = trnername;
        this.location = location;
        this.trningdays = trningdays;
        this.timeslots = timeslots;
    }

    public String getTrnername() {
        return trnername;
    }

    public void setTrnername(String trnername) {
        this.trnername = trnername;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTrningdays() {
        return trningdays;
    }

    public void setTrningdays(String trningdays) {
        this.trningdays = trningdays;
    }

    public String getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(String timeslots) {
        this.timeslots = timeslots;
    }

    @Override
    public String toString() {
        return "tfAssignment{" +
                "trnername='" + trnername + '\'' +
                ", location='" + location + '\'' +
                ", trningdays='" + trningdays + '\'' +
                ", timeslots='" + timeslots + '\'' +
                '}';
    }
}
