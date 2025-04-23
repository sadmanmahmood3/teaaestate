package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TfTrainerAssignmentController implements Serializable
{
    @javafx.fxml.FXML
    private ComboBox<String> taPreferredTrainingDaysComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> taLocationComboBox;
    @javafx.fxml.FXML
    private Label alertLabel;
    @javafx.fxml.FXML
    private ComboBox<String> taTimeSlotsComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> taTrainerNameComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        taPreferredTrainingDaysComboBox.getItems().addAll("Mon","Wed","Fri");
        taLocationComboBox.getItems().addAll("field zone a", "factory","admin office");
        taTimeSlotsComboBox.getItems().addAll("morning","afternoon");
        taTrainerNameComboBox.getItems().addAll("Josef","Alam","Kalam");
    }

    @javafx.fxml.FXML
    public void taAssignOnAction(ActionEvent actionEvent) {
        String trnername = taTrainerNameComboBox.getSelectionModel().getSelectedItem();
        String location = taLocationComboBox.getSelectionModel().getSelectedItem();
        String trningdays = taPreferredTrainingDaysComboBox.getSelectionModel().getSelectedItem();
        String timeslots = taTimeSlotsComboBox.getSelectionModel().getSelectedItem();


        tfAssignment ac=new tfAssignment(trnername,location,trningdays,timeslots);

        try {
            File f=new File("tfAssignment.bin");
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
            oos.writeObject(ac);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }



    }
}