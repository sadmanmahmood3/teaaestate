package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;

import java.awt.*;

public class BuyerLogInController {
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TextField emailAddressTextField;
    @javafx.fxml.FXML
    private TextField passwardTextField;

    @javafx.fxml.FXML
    public void logInOnAction(ActionEvent actionEvent) {
    }

    public TextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public void setPhoneNumberTextField(TextField phoneNumberTextField) {
        this.phoneNumberTextField = phoneNumberTextField;
    }

    public TextField getCustomerNameTextField() {
        return customerNameTextField;
    }

    public void setCustomerNameTextField(TextField customerNameTextField) {
        this.customerNameTextField = customerNameTextField;
    }

    public TextField getEmailAddressTextField() {
        return emailAddressTextField;
    }

    public void setEmailAddressTextField(TextField emailAddressTextField) {
        this.emailAddressTextField = emailAddressTextField;
    }

    public TextField getPasswardTextField() {
        return passwardTextField;
    }

    public void setPasswardTextField(TextField passwardTextField) {
        this.passwardTextField = passwardTextField;
    }
}
