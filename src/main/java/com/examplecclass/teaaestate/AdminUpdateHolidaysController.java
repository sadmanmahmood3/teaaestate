package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class AdminUpdateHolidaysController implements Serializable
{
    @javafx.fxml.FXML
    private ComboBox<String> uhDayTypeComboBox;
    @javafx.fxml.FXML
    private TextField uhUpdatedByField;
    @javafx.fxml.FXML
    private TextField uhOccasionNameField;
    @javafx.fxml.FXML
    private DatePicker uhDatePicker;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
        uhDayTypeComboBox.getItems().addAll("Weekly Off","Working Day","Special Holiday");
        uhDatePicker.setValue(LocalDate.now());

    }

    @javafx.fxml.FXML
    public void uhUpdateButtonOnAction(ActionEvent actionEvent) {
        String name= uhOccasionNameField.getText();
        String updatedBy=uhUpdatedByField.getText();
        String type= uhDayTypeComboBox.getSelectionModel().getSelectedItem();
        LocalDate date= uhDatePicker.getValue();

        if(uhOccasionNameField.getText().isEmpty()||uhUpdatedByField.getText().isEmpty()){
            errorLabel.setText("Fill Up The Form Properly!");
        }

        boolean digitFound = false;
        for (int i = 0; i < uhUpdatedByField.getText().length(); i++) {
            if (uhUpdatedByField.getText().charAt(i) >= '0' && uhUpdatedByField.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (digitFound) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

        boolean digitFoundd = false;
        for (int i = 0; i < uhOccasionNameField.getText().length(); i++) {
            if (uhOccasionNameField.getText().charAt(i) >= '0' && uhOccasionNameField.getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

        adminUpdateHolidays uh=new adminUpdateHolidays(name,updatedBy,type,date);

        try {
            File f=new File("mmUpdateSubCount.bin");
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
            oos.writeObject(uh);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }



    }
}