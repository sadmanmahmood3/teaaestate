package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class AdminSignUpController
{
    @javafx.fxml.FXML
    private TextField mobField;
    @javafx.fxml.FXML
    private PasswordField passField;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField mailField;
    @javafx.fxml.FXML
    private DatePicker dobDatePicker;
    @javafx.fxml.FXML
    private TextField nidField;
    @javafx.fxml.FXML
    private Label erroLabel;

    @javafx.fxml.FXML
    public void initialize() {
        dobDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        String name= nameField.getText();
        String nid= nidField.getText();
        String mobile=mobField.getText();
        String mail= mailField.getText();
        String password=passField.getText();
        LocalDate date=dobDatePicker.getValue();

        if(nameField.getText().isEmpty()||nidField.getText().isEmpty()||mobField.getText().isEmpty()||mailField.getText().isEmpty()||
        passField.getText().isEmpty()){
            erroLabel.setText("Fill Up The Form Properly!");
        return;}
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        if (!mail.matches(emailPattern)) {
            erroLabel.setText("Please enter a valid email address.");
            return;
        }
        adminSignUp as = new adminSignUp(name,nid,mobile,mail,password,date);

        userAccounts.createAdminAccount(as);



    }

    @javafx.fxml.FXML
    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminLogIn.fxml"));
        Parent root = loader.load();
        AdminLogInController y = loader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}