package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.time.LocalDate;

public class AdminManageInternalAnnouncementController implements Serializable
{
    @javafx.fxml.FXML
    private DatePicker iaEndDatePicker;
    @javafx.fxml.FXML
    private TextField iaTitleField;
    @javafx.fxml.FXML
    private ComboBox<String> iaAudienceComboBox;
    @javafx.fxml.FXML
    private DatePicker iaStartDatePicker;
    @javafx.fxml.FXML
    private TextField iaBodyField;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
        iaAudienceComboBox.getItems().addAll("All","Facilitator","Media Team");
        iaStartDatePicker.setValue(LocalDate.now());
        iaEndDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void adminAdmitOnAction(ActionEvent actionEvent) {
        String body=iaBodyField.getText();
        String title=iaTitleField.getText();
        String audience= iaAudienceComboBox.getSelectionModel().getSelectedItem();
        LocalDate start= iaStartDatePicker.getValue();
        LocalDate end= iaEndDatePicker.getValue();

        if(iaBodyField.getText().isEmpty()||iaTitleField.getText().isEmpty()){
            errorLabel.setText("Fill up the fields properly");
        }

    }
}