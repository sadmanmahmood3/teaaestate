package com.examplecclass.teaaestate.helpers;

import com.examplecclass.teaaestate.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.examplecclass.teaaestate.models.User;

public class SceneHelper {
    private static final String USER_DATA_FILE = "users.dat";
    
    public static void switchScene(String fxmlFile, ActionEvent event) throws IOException {
        String fullPath = "/" + HelloApplication.class.getPackageName().replace(".", "/") + "/" + fxmlFile;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fullPath));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void saveUser(User user) {
        List<User> users = getAllUsers();
        users.add(user);
        try {
            File file = new File(USER_DATA_FILE);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(users);
            }
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Could not save user data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(USER_DATA_FILE);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                users = (List<User>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Could not read user data: " + e.getMessage());
            }
        }
        return users;
    }
} 