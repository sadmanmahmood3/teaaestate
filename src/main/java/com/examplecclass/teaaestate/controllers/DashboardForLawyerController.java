package com.examplecclass.teaaestate.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import com.examplecclass.teaaestate.helpers.SceneHelper;

public class DashboardForLawyerController {
    @FXML private Label welcomeLabel;
    @FXML private Label memberCountLabel;
    @FXML private Label ongoingCasesLabel;
    @FXML private Label resolvedCasesLabel;
    @FXML private Label successRateLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Welcome, Lawyer!");
        updateMetrics();
    }

    private void updateMetrics() {
        memberCountLabel.setText("Total Members: 150");
        ongoingCasesLabel.setText("Ongoing Cases: 45");
        resolvedCasesLabel.setText("Resolved Cases: 30");
        successRateLabel.setText("Success Rate: 75.5%");
    }

    @FXML
    private void showLegalNotices(ActionEvent event) throws IOException {
        SceneHelper.switchScene("LegalNotice.fxml", event);
    }

    @FXML
    private void showCompliance(ActionEvent event) throws IOException {
        SceneHelper.switchScene("Compliance.fxml", event);
    }

    @FXML
    private void showExpenseAnalysis(ActionEvent event) throws IOException {
        SceneHelper.switchScene("ExpenseAnalysis.fxml", event);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        SceneHelper.switchScene("User-Login.fxml", event);
    }
} 