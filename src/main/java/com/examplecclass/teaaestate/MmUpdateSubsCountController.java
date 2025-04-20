package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class MmUpdateSubsCountController implements Serializable
{
    @javafx.fxml.FXML
    private TextField msgNewSubsField;
    @javafx.fxml.FXML
    private TextField msgUnsubsField;
    @javafx.fxml.FXML
    private DatePicker msgDatePicker;
    @javafx.fxml.FXML
    private Label alertLabel;

    @javafx.fxml.FXML
    public void initialize() {
        msgDatePicker.setValue(LocalDate.now());


    }

    @javafx.fxml.FXML
    public void msgUpdateOnAction(ActionEvent actionEvent) {

        int newSubs=Integer.parseInt(msgNewSubsField.getText());
        int unsubs=Integer.parseInt(msgUnsubsField.getText());
        LocalDate date=msgDatePicker.getValue();





        boolean digitFound = true;
        for (int i = 0; i < msgNewSubsField.getText().length(); i++) {
            if (msgNewSubsField.getText().charAt(i) >= '0' && msgNewSubsField.getText().charAt(i) <= '9') {
                digitFound = false;
            }
        }
        if (digitFound) {
            alertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only digits!");
            digitfoundAlert.show();}

        boolean digitFoundd = true;
        for (int i = 0; i < msgUnsubsField.getText().length(); i++) {
            if (msgUnsubsField.getText().charAt(i) >= '0' && msgUnsubsField.getText().charAt(i) <= '9') {
                digitFoundd = false;
            }
        }
        if (digitFoundd) {
            alertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only digits!");
            digitfoundAlert.show();}





        mmUpdateSubCount msg=new mmUpdateSubCount(newSubs,unsubs,date);

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
            alertLabel.setText("Successfully Submitted");
            oos.writeObject(msg);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}