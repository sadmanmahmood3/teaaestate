package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class TfMonitorTrainingCompletionController
{
    @javafx.fxml.FXML
    private DatePicker mtcDateDatePicker;
    @javafx.fxml.FXML
    private TextField mtcWorkerNametextfield;
    @javafx.fxml.FXML
    private Label alertLabel;
    @javafx.fxml.FXML
    private ComboBox<String> mtcTrainingSessionsComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> mtcCompletionStatusComboBox;
    @javafx.fxml.FXML
    private TextField mtcWorkerIdtextfield;

    @javafx.fxml.FXML
    public void initialize() {
        mtcTrainingSessionsComboBox.getItems().addAll("tea harvesting techniques");
        mtcCompletionStatusComboBox.getItems().addAll("completed","incomplete");
        mtcDateDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void mtcProceedOnAction(ActionEvent actionEvent) {
        String trningsession = mtcTrainingSessionsComboBox.getSelectionModel().getSelectedItem();
        String cmptnstatus = mtcCompletionStatusComboBox.getSelectionModel().getSelectedItem();
        String wrkrname = mtcWorkerNametextfield.getText();
        int wrkrid = Integer.parseInt(mtcWorkerIdtextfield.getText());
        LocalDate date = mtcDateDatePicker.getValue();

        if (mtcWorkerNametextfield.getText().isEmpty() || mtcWorkerIdtextfield.getText().isEmpty()
                ||mtcDateDatePicker.getValue().isAfter(LocalDate.now()));
        {

            alertLabel.setText("Fill up all sections");


        }

        boolean digitFound = false;
        for (int i = 0; i < mtcWorkerNametextfield.getText().length(); i++) {
            if (mtcWorkerNametextfield.getText().charAt(i) >= '0' && mtcWorkerNametextfield.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (digitFound) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }

        boolean digitFoundd = true;
        for (int i = 0; i < mtcWorkerIdtextfield.getText().length(); i++) {
            if (mtcWorkerIdtextfield.getText().charAt(i) >= '0' && mtcWorkerIdtextfield.getText().charAt(i) <= '9') {
                digitFoundd = false;
            }
        }
        if (digitFoundd) {
            alertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }
        tfMonitorCompletion mc=new tfMonitorCompletion(trningsession,cmptnstatus,wrkrname,wrkrid,date);

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
            oos.writeObject(mc);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}