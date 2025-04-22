package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.EventObject;

public class AdminLogInController
{
    @FXML
    private PasswordField passField;
    @FXML
    private TextField mailField;
    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
    }

    @FXML
    public void enterOnAction(ActionEvent actionEvent) throws IOException {
        String mail=mailField.getText();
        String password=passField.getText();

        if (!userAccounts.CheckAdminAccount(mail)){errorLabel.setText("Invalid ");
            return;}

        if (!userAccounts.adminMailPasswordMatch(mail,password)){errorLabel.setText("Invalid ");
            return;}


        EventObject event = null;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adminDashboard.fxml"));
        Parent root = loader.load();
        AdminDashboardController ctrl = loader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();




    }
}