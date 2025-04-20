package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;

public class MmSubmitWeeklyFunFactController implements Serializable
{
    @javafx.fxml.FXML
    private TextField wffTitleField;
    @javafx.fxml.FXML
    private TextField wffContentField;
    @javafx.fxml.FXML
    private DatePicker wffSubmissionDatePicker;
    @javafx.fxml.FXML
    private Label alertLabel;

    @javafx.fxml.FXML
    public void initialize() {
        wffSubmissionDatePicker.setValue(LocalDate.now());

    }

    @javafx.fxml.FXML
    public void wffSubmitButtonOnAction(ActionEvent actionEvent) {
        String factTitle=wffTitleField.getText();
        String factContent=wffContentField.getText();
        LocalDate submissionWeek = wffSubmissionDatePicker.getValue();

        if (factTitle.isEmpty()) {
            alertLabel.setText("Title Required");
            wffTitleField.requestFocus();
            return;
        }

        if (factContent.isEmpty()) {
            alertLabel.setText("Content Required");
            wffContentField.requestFocus();
            return;
        }

        if (submissionWeek == null) {
            alertLabel.setText("Date Required");
            return;
        }

        mmSubmitWeeklyFunFact swf=new mmSubmitWeeklyFunFact(factTitle,factContent,submissionWeek);

        try {
            File f=new File("mmSubmitWeeklyFunFact.bin");
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
            oos.writeObject(swf);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}