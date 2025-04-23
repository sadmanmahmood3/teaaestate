package com.examplecclass.teaaestate.controllers;

import com.examplecclass.teaaestate.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import java.io.IOException;
import com.examplecclass.teaaestate.helpers.SceneHelper;
import com.examplecclass.teaaestate.models.User;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Label errorLabel;

    @FXML
    public void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter both username and password");
            errorLabel.setTextFill(Color.RED);
            return;
        }
        
        try {
            User user = null;
            for (User u : SceneHelper.getAllUsers()) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    user = u;
                    break;
                }
            }

            if (user != null) {
                if (username.contains("Lawyer")) {
                    SceneHelper.switchScene("DashboardForLawyer.fxml", event);
                } 
                else if (username.contains("Community")) {
                    SceneHelper.switchScene("CommunityDashboard.fxml", event);
                }
            } else {
                errorLabel.setText("Wrong username or password");
                errorLabel.setTextFill(Color.RED);
            }
        } catch (IOException e) {
            errorLabel.setText("Login failed: " + e.getMessage());
            errorLabel.setTextFill(Color.RED);
        }
    }

    @FXML
    private void switchToRegister(ActionEvent event) {
        try {
            SceneHelper.switchScene("Register.fxml", event);
        } catch (IOException e) {
            errorLabel.setText("Could not switch to register page");
            errorLabel.setTextFill(Color.RED);
        }
    }

    @FXML
    public void goToMainMenuButton(ActionEvent actionEvent) throws IOException {
            Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userLogIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
}