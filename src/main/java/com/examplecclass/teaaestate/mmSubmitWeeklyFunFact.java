package com.examplecclass.teaaestate;

import java.io.Serializable;
import java.time.LocalDate;

public class mmSubmitWeeklyFunFact implements Serializable {
    private String factTitle,factContent;
    private LocalDate submissionWeek;

    public mmSubmitWeeklyFunFact() {
    }

    public mmSubmitWeeklyFunFact(String factTitle, String factContent, LocalDate submissionWeek) {
        this.factTitle = factTitle;
        this.factContent = factContent;
        this.submissionWeek = submissionWeek;
    }

    public String getFactTitle() {
        return factTitle;
    }

    public void setFactTitle(String factTitle) {
        this.factTitle = factTitle;
    }

    public String getFactContent() {
        return factContent;
    }

    public void setFactContent(String factContent) {
        this.factContent = factContent;
    }

    public LocalDate getSubmissionWeek() {
        return submissionWeek;
    }

    public void setSubmissionWeek(LocalDate submissionWeek) {
        this.submissionWeek = submissionWeek;
    }

    @Override
    public String toString() {
        return "mmSubmitWeeklyFunFact{" +
                "factTitle='" + factTitle + '\'' +
                ", factContent='" + factContent + '\'' +
                ", submissionWeek=" + submissionWeek +
                '}';
    }
}
