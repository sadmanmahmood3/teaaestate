package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class FcPublishCostAnalysisController
{
    @javafx.fxml.FXML
    private ComboBox<String> caTeaTypeComboBox;
    @javafx.fxml.FXML
    private TextField caTransportCosttextfield;
    @javafx.fxml.FXML
    private TextField caLabourCosttextfield;
    @javafx.fxml.FXML
    private DatePicker caDateCADatePicker;
    @javafx.fxml.FXML
    private Label alerLabel;
    @javafx.fxml.FXML
    private TextField caPackingCosttextfield;

    @javafx.fxml.FXML
    public void initialize() {
        caTeaTypeComboBox.getItems().addAll("black","green");
        caDateCADatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void publishcostanalysisOnAction(ActionEvent actionEvent) {

        String teatype = caTeaTypeComboBox.getSelectionModel().getSelectedItem();
        int lbrCost = Integer.parseInt(caLabourCosttextfield.getText());
        int pkingCost = Integer.parseInt(caPackingCosttextfield.getText());
        int tptCost = Integer.parseInt(caTransportCosttextfield.getText());
        LocalDate date = caDateCADatePicker.getValue();

        if (caLabourCosttextfield.getText().isEmpty() || caPackingCosttextfield.getText().isEmpty()||
                caTransportCosttextfield.getText().isEmpty()
                ||caDateCADatePicker.getValue().isAfter(LocalDate.now()));{

            alerLabel.setText("Fill up all sections");


        }

        boolean digitFound = true;
        for (int i = 0; i < caLabourCosttextfield.getText().length(); i++) {
            if (caLabourCosttextfield.getText().charAt(i) >= '0' && caLabourCosttextfield.getText().charAt(i) <= '9') {
                digitFound = false;
            }
        }
        if (digitFound) {
            alerLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }

        boolean digitFoundd = true;
        for (int i = 0; i < caPackingCosttextfield.getText().length(); i++) {
            if (caPackingCosttextfield.getText().charAt(i) >= '0' && caPackingCosttextfield.getText().charAt(i) <= '9') {
                digitFoundd = false;
            }
        }
        if (digitFoundd) {
            alerLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }

        boolean digitFounddd = true;
        for (int i = 0; i < caTransportCosttextfield.getText().length(); i++) {
            if (caTransportCosttextfield.getText().charAt(i) >= '0' && caTransportCosttextfield.getText().charAt(i) <= '9') {
                digitFounddd = false;
            }
        }
        if (digitFounddd) {
            alerLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }

        fcCostAnalysis pca=new fcCostAnalysis(teatype,lbrCost,pkingCost,tptCost,date);

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
            alerLabel.setText("Successfully Submitted");
            oos.writeObject(pca);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}