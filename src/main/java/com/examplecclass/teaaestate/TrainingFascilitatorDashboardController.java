package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class TrainingFascilitatorDashboardController
{
    @javafx.fxml.FXML
    private BorderPane trainingFascilitatorBorderpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void trainingBudgetAllocationOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tfTrainingBudgetAllocation.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void scheduleTrainingsessionOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tfScheduleTrainingSessions.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void monitorTrainingCompletionOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tfMonitorTrainingCompletion.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void ViewTrainingUsageLogsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tfViewTrainingResourceUsageLog.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void trainerPerformanceOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tfTrainerPerformanceEvaluation.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void backToLogInOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userLogIn.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void trainerassignmentOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tfTrainerAssignment.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void trainingNeedsOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tfTrainingNeedsIdentification.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }

    @javafx.fxml.FXML
    public void submitTrainingResourceUsageOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tfTrainingResourceUsageLog.fxml"));
            trainingFascilitatorBorderpane.setCenter(fxmlLoader.load());
        }
        catch(Exception e){}
    }
}