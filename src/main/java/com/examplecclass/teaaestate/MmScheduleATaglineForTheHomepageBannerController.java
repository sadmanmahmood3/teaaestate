package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    }
}