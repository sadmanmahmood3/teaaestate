package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class FcPublishingTheFinancialSessionsController implements Serializable
{
    @javafx.fxml.FXML
    private TextField publisteaproducedtextfield;
    @javafx.fxml.FXML
    private TextField publishleafreceivedtextfield;
    @javafx.fxml.FXML
    private ComboBox<String> publishteatypeComboBox;
    @javafx.fxml.FXML
    private DatePicker publishdateFSDatePicker;
    @javafx.fxml.FXML
    private Label alertLabel;

    @javafx.fxml.FXML
    public void initialize() {
        publishdateFSDatePicker.setValue(LocalDate.now());
        publishteatypeComboBox.getItems().addAll("black","green");
    }

    @javafx.fxml.FXML
    public void publishfinancialsessionsOnAction(ActionEvent actionEvent) {
        String teatype = publishteatypeComboBox.getSelectionModel().getSelectedItem();
        int lfreceived = Integer.parseInt(publishleafreceivedtextfield.getText());
        int lfproduced = Integer.parseInt(publisteaproducedtextfield.getText());
        LocalDate date = publishdateFSDatePicker.getValue();

        if (publishleafreceivedtextfield.getText().isEmpty() || publisteaproducedtextfield.getText().isEmpty()
                || publishdateFSDatePicker.getValue().isAfter(LocalDate.now())) ;
        {

            alertLabel.setText("Fill up all sections");


        }

        boolean digitFound = true;
        for (int i = 0; i < publishleafreceivedtextfield.getText().length(); i++) {
            if (publishleafreceivedtextfield.getText().charAt(i) >= '0' && publishleafreceivedtextfield.getText().charAt(i) <= '9') {
                digitFound = false;
            }
        }
        if (digitFound) {
            alertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }

        boolean digitFoundd = true;
        for (int i = 0; i < publisteaproducedtextfield.getText().length(); i++) {
            if (publisteaproducedtextfield.getText().charAt(i) >= '0' && publisteaproducedtextfield.getText().charAt(i) <= '9') {
                digitFoundd = false;
            }
        }
        if (digitFoundd) {
            alertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }
        fcPubFinancialSessions pfs=new fcPubFinancialSessions(teatype,lfreceived,lfproduced,date);

        try {
            File f=new File("fcPubFinancialSessions.bin");
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
            oos.writeObject(pfs);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}