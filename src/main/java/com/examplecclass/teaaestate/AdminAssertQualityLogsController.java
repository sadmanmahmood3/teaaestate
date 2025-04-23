package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class AdminAssertQualityLogsController implements Serializable
{
    @javafx.fxml.FXML
    private ComboBox<String> qaTeaTypeComboBox;
    @javafx.fxml.FXML
    private TextField qabatchIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> qaFactoryNameComboBox;
    @javafx.fxml.FXML
    private ComboBox <String>qaShiftComboBox;
    @javafx.fxml.FXML
    private DatePicker qaDateDatePicker;
    @javafx.fxml.FXML
    private Label alertLabel;

    @javafx.fxml.FXML
    public void initialize() {
        qaFactoryNameComboBox.getItems().addAll("Chittagong Factory","demra Factory","Munshigonj Factory");
        qaShiftComboBox.getItems().addAll("Morning","Noon","Evening","Night");
        qaTeaTypeComboBox.getItems().addAll("Black","Green");
        qaDateDatePicker.setValue(LocalDate.now());

    }

    @javafx.fxml.FXML
    public void qaAssertButtonOnAction(ActionEvent actionEvent) {
        String id=qabatchIdTextField.getText();
        String factoryName= qaFactoryNameComboBox.getSelectionModel().getSelectedItem();
        String shift= qaShiftComboBox.getSelectionModel().getSelectedItem();
        String teaType= qaTeaTypeComboBox.getSelectionModel().getSelectedItem();
        LocalDate date=qaDateDatePicker.getValue();


        if(qabatchIdTextField.getText().isEmpty()){
            alertLabel.setText("Fill up the fields properly");
        }
        if(qaDateDatePicker.getValue().isAfter(LocalDate.now())){
            alertLabel.setText("Invalid Date");
        }

        adminAssertQualityLogs aql=new adminAssertQualityLogs(id,factoryName,shift,teaType,date);

        try {
            File f=new File("adminAssertQualityLogs.bin");
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
            oos.writeObject(aql);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}