package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class TfTrainerPerformanceEvaluationController
{
    @javafx.fxml.FXML
    private ComboBox<String> tpeDelivaryQualityRatingComboBox;
    @javafx.fxml.FXML
    private DatePicker tpeDateoftrainingDatePicker;
    @javafx.fxml.FXML
    private Label alertLabel;
    @javafx.fxml.FXML
    private TextField tpeEvaluatortextfield;
    @javafx.fxml.FXML
    private TextField tpeTrainerNametextfield;
    @javafx.fxml.FXML
    private ComboBox<String> tpeTimeManagementComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        tpeDelivaryQualityRatingComboBox.getItems().addAll("one","two","three","four","five");
        tpeTimeManagementComboBox.getItems().addAll("on time","over time","under time");
        tpeDateoftrainingDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void tpeSubmitOnAction(ActionEvent actionEvent) {
        String trnername = tpeTrainerNametextfield.getText();
        String evlutorname = tpeEvaluatortextfield.getText();
        String dlryrqultyrting = tpeDelivaryQualityRatingComboBox.getSelectionModel().getSelectedItem();
        String timeatngmnt = tpeTimeManagementComboBox.getSelectionModel().getSelectedItem();
        LocalDate trningdate = tpeDateoftrainingDatePicker.getValue();

        if (tpeTrainerNametextfield.getText().isEmpty() || tpeEvaluatortextfield.getText().isEmpty()||
                tpeDateoftrainingDatePicker.getValue().isAfter(LocalDate.now()));
        {

            alertLabel.setText("Fill up all sections");
        }
        boolean digitFound = false;
        for (int i = 0; i < tpeTrainerNametextfield.getText().length(); i++) {
            if (tpeTrainerNametextfield.getText().charAt(i) >= '0' && tpeTrainerNametextfield.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (digitFound) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }
        boolean digitFoundd = false;
        for (int i = 0; i < tpeEvaluatortextfield.getText().length(); i++) {
            if (tpeEvaluatortextfield.getText().charAt(i) >= '0' && tpeEvaluatortextfield.getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }

        tfTrainerEvaluation te=new tfTrainerEvaluation(trnername,evlutorname,dlryrqultyrting,timeatngmnt,trningdate);

        try {
            File f=new File("mmUpdateSubCount.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }  else {
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            alertLabel.setText("Successfully Submitted");
            oos.writeObject(te);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }



    }
}