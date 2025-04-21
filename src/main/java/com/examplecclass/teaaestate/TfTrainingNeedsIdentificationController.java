package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class TfTrainingNeedsIdentificationController
{
    @javafx.fxml.FXML
    private DatePicker tniRequestdateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> tniRequestByComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> tniPriorityComboBox;
    @javafx.fxml.FXML
    private TextField tniTrainingTopictextfield;
    @javafx.fxml.FXML
    private Label alertLabel;
    @javafx.fxml.FXML
    private TextField tniParticipantstextfield;
    @javafx.fxml.FXML
    private ComboBox<String> tniDepartmentComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        tniDepartmentComboBox.getItems().addAll("production","factory");
        tniPriorityComboBox.getItems().addAll("high","medium","low");
        tniRequestByComboBox.getItems().addAll("Alam","Blam");
    }

    @javafx.fxml.FXML
    public void tniProceedOnAction(ActionEvent actionEvent) {
        String rqstby = tniRequestByComboBox.getSelectionModel().getSelectedItem();
        String dprtmnt = tniDepartmentComboBox.getSelectionModel().getSelectedItem();
        String prorty = tniPriorityComboBox.getSelectionModel().getSelectedItem();
        String trningtopicnd = tniTrainingTopictextfield.getText();
        String sgstedprcpnt = tniParticipantstextfield.getText();
        LocalDate rqstdate = tniRequestdateDatePicker.getValue();


        if (tniTrainingTopictextfield.getText().isEmpty() || tniParticipantstextfield.getText().isEmpty()
                ||tniRequestdateDatePicker.getValue().isAfter(LocalDate.now()));{

            alertLabel.setText("Fill up all sections");


        }

        boolean digitFound = false;
        for (int i = 0; i <tniTrainingTopictextfield.getText().length(); i++) {
            if (tniTrainingTopictextfield.getText().charAt(i) >= '0' && tniTrainingTopictextfield.getText().charAt(i) <= '9') {
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
        for (int i = 0; i < tniParticipantstextfield.getText().length(); i++) {
            if (tniParticipantstextfield.getText().charAt(i) >= '0' && tniParticipantstextfield.getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }
        tfNeedsIdentification n=new tfNeedsIdentification(rqstby,dprtmnt,prorty,trningtopicnd,sgstedprcpnt,rqstdate);

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
            oos.writeObject(n);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}