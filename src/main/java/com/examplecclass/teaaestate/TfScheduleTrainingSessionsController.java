package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class TfScheduleTrainingSessionsController implements Serializable
{
    @javafx.fxml.FXML
    private ComboBox<String> stsLocationComboBox;
    @javafx.fxml.FXML
    private Label alertLabel;
    @javafx.fxml.FXML
    private TextField stsMaxParticipanttextfield;
    @javafx.fxml.FXML
    private ComboBox<String> stsTainingCategoryComboBox;
    @javafx.fxml.FXML
    private DatePicker stsTrainingdateDatePicker;
    @javafx.fxml.FXML
    private TextField stsTrainingTitletextfield;
    @javafx.fxml.FXML
    private TextField stsTrainerNametextfield;

    @javafx.fxml.FXML
    public void initialize() {
        stsLocationComboBox.getItems().addAll("field zone a","factory","admin office");
        stsTainingCategoryComboBox.getItems().addAll("Technical","Physical");
        stsTrainingdateDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void stsScheduleTrainingSessionsOnAction(ActionEvent actionEvent) {
        String trningctgry = stsTainingCategoryComboBox.getSelectionModel().getSelectedItem();
        String location = stsLocationComboBox.getSelectionModel().getSelectedItem();
        String trningtitl = stsTrainingTitletextfield.getText();
        String trnername = stsTrainerNametextfield.getText();
        int mxprtcpnt = Integer.parseInt(stsMaxParticipanttextfield.getText());
        LocalDate trningdate = stsTrainingdateDatePicker.getValue();


        if (stsTrainingTitletextfield.getText().isEmpty() || stsTrainerNametextfield.getText().isEmpty()||
                stsMaxParticipanttextfield.getText().isEmpty()
                ||stsTrainingdateDatePicker.getValue().isAfter(LocalDate.now()));{

            alertLabel.setText("Fill up all sections");


        }

        boolean digitFound = false;
        for (int i = 0; i < stsTrainingTitletextfield.getText().length(); i++) {
            if (stsTrainingTitletextfield.getText().charAt(i) >= '0' && stsTrainingTitletextfield.getText().charAt(i) <= '9') {
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
        for (int i = 0; i < stsTrainerNametextfield.getText().length(); i++) {
            if (stsTrainerNametextfield.getText().charAt(i) >= '0' && stsTrainerNametextfield.getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }
        boolean digitFounddd = true;
        for (int i = 0; i < stsMaxParticipanttextfield.getText().length(); i++) {
            if (stsMaxParticipanttextfield.getText().charAt(i) >= '0' && stsMaxParticipanttextfield.getText().charAt(i) <= '9') {
                digitFounddd = false;
            }
        }
        if (digitFounddd) {
            alertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }
        tfScheduleSessions sts=new tfScheduleSessions(trningctgry,location,trningtitl,trnername,mxprtcpnt,trningdate);

        try {
            File f=new File("tfScheduleSessions.bin");
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
            oos.writeObject(sts);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}