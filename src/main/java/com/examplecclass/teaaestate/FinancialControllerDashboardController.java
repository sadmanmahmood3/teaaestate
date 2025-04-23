package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class FinancialControllerDashboardController
{
    @javafx.fxml.FXML
    private BorderPane financialControllerBorderpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void subBudgetAllocationOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fcEnterMonthlyBudget Allocation.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void recordCapitalExpOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fcRecordCapitalExpenditureRequest.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void backToLogInOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userLogIn.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void publishfinancialSesOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fcPublishingTheFinancialSessions.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void viewFinancialSessionOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fcViewFinancialSessions.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void viewCostAnalysisOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fcViewCostAnalysis.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void scheduleNextReviewOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fcSchedualNextReviewDate.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void viewNextReviewOnAcion(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fcViewSchedualedNextReviewDate.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void subCostAnalysisOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fcPublishCostAnalysis.fxml"));
            financialControllerBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }
}