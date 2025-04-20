package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class MmManageEventCalanderController
{
    @javafx.fxml.FXML
    private DatePicker ecuEventDateDatePicker;
    @javafx.fxml.FXML
    private TextField ecuOrganizernameTextField;
    @javafx.fxml.FXML
    private TextField ecuEventTitleTextField;
    @javafx.fxml.FXML
    private ComboBox<String> ecuLocationComboBox;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
        ecuLocationComboBox.getItems().addAll("Main Office","Sub Office","Company","tea Department");
        ecuEventDateDatePicker.setValue(LocalDate.now());

    }

    @javafx.fxml.FXML
    public void eventCalendarUpdateOnAction(ActionEvent actionEvent) {

        String title= ecuEventTitleTextField.getText();
        String name= ecuOrganizernameTextField.getText();
        String location=ecuLocationComboBox.getSelectionModel().getSelectedItem();
        LocalDate date=ecuEventDateDatePicker.getValue();

        if(ecuEventTitleTextField.getText().isEmpty()||ecuOrganizernameTextField.getText().isEmpty()||ecuEventDateDatePicker.getValue().isAfter(LocalDate.now()))
        {errorLabel.setText("Fill up all the fields");}


        boolean digitFound = false;
        for (int i = 0; i < ecuOrganizernameTextField.getText().length(); i++) {
            if (ecuOrganizernameTextField.getText().charAt(i) >= '0' && ecuOrganizernameTextField.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (digitFound) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

        boolean digitFoundd = false;
        for (int i = 0; i < ecuEventTitleTextField.getText().length(); i++) {
            if (ecuEventTitleTextField.getText().charAt(i) >= '0' && ecuEventTitleTextField
                    .getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

        mmManageEventCalender mec=new mmManageEventCalender(title,name,location,date);

        try {
            File f=new File("mmApproveEventBlogs.bin");
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
            oos.writeObject(mec);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}