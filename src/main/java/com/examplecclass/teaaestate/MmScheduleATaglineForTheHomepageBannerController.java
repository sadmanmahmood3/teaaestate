package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class MmScheduleATaglineForTheHomepageBannerController
{
    @javafx.fxml.FXML
    private DatePicker tfthEndDatePicker;
    @javafx.fxml.FXML
    private TextField tfthTaglineTextField;
    @javafx.fxml.FXML
    private DatePicker tfthStartDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> tfthStatusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> tfthDisplayComboBox;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
        tfthDisplayComboBox.getItems().addAll("High","Medium","Low");
        tfthStatusComboBox.getItems().addAll("Activated","Archived","Scheduled");
        tfthStartDatePicker.setValue(LocalDate.now());
        tfthEndDatePicker.setValue(LocalDate.now()
        );
    }

    @javafx.fxml.FXML
    public void tfthProceedOnAction(ActionEvent actionEvent) {
        String tagline=tfthTaglineTextField.getText();
        String priority=tfthDisplayComboBox.getSelectionModel().getSelectedItem();
        String status=tfthStatusComboBox.getSelectionModel().getSelectedItem();
        LocalDate start=tfthStartDatePicker.getValue();
        LocalDate end=tfthEndDatePicker.getValue();

        if(tfthTaglineTextField.getText().isEmpty()){errorLabel.setText("Fill up the form properly");}

        mmScheduleATaglineForTheHomepageBanner shb=new mmScheduleATaglineForTheHomepageBanner(tagline,priority,status,start,end);

        try {
            File f=new File("mmScheduleATaglineForTheHomepageBanner.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }  else {
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            errorLabel.setText("Successfully Submitted");
            oos.writeObject(shb);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}