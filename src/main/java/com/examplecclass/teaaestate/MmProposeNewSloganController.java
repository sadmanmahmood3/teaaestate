package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class MmProposeNewSloganController
{
    @javafx.fxml.FXML
    private DatePicker mmSubmittedDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> mmThemeComboBox;
    @javafx.fxml.FXML
    private TextField mmCampaignNameField;
    @javafx.fxml.FXML
    private TextField mmSloganField;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
        mmThemeComboBox.getItems().addAll("Seasonal","Heritage","Modern","Youth");
        mmSubmittedDatePicker.setValue(LocalDate.now());

    }

    @javafx.fxml.FXML
    public void mmNewSloganAdmitOnAction(ActionEvent actionEvent) {
        String name=mmCampaignNameField.getText();
        String slogan=mmSloganField.getText();
        String theme= mmThemeComboBox.getSelectionModel().getSelectedItem();
        LocalDate date=mmSubmittedDatePicker.getValue();

        if(mmCampaignNameField.getText().isEmpty()||mmSloganField.getText().isEmpty()||mmSubmittedDatePicker.getValue().isAfter(LocalDate.now()))
        {errorLabel.setText("Fill up all the fields");}

        boolean digitFound = false;
        for (int i = 0; i < mmSloganField.getText().length(); i++) {
            if (mmSloganField.getText().charAt(i) >= '0' && mmSloganField.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (digitFound) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

        boolean digitFoundd = false;
        for (int i = 0; i < mmCampaignNameField.getText().length(); i++) {
            if (mmCampaignNameField.getText().charAt(i) >= '0' && mmCampaignNameField.getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

    }
}