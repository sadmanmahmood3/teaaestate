package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class TfTrainingResourceUsageLogController
{
    @javafx.fxml.FXML
    private TextField trulQualitytextfield;
    @javafx.fxml.FXML
    private DatePicker trulDateOfSessionsDatePicker;
    @javafx.fxml.FXML
    private TextField trulResourceNametextfield;
    @javafx.fxml.FXML
    private ComboBox<String> trulTrainerNameComboBox;
    @javafx.fxml.FXML
    private Label alertLabel;

    @javafx.fxml.FXML
    public void initialize() {
        trulTrainerNameComboBox.getItems().addAll("Azad","Sazad","Kamal");
        trulDateOfSessionsDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void trulProceedOnAction(ActionEvent actionEvent) {
        String trnername = trulTrainerNameComboBox.getSelectionModel().getSelectedItem();
        String resourcename = trulResourceNametextfield.getText();
        int quantity = Integer.parseInt(trulQualitytextfield.getText());
        LocalDate sessndate = trulDateOfSessionsDatePicker.getValue();

        if (trulQualitytextfield.getText().isEmpty() || trulResourceNametextfield.getText().isEmpty()||
                trulDateOfSessionsDatePicker.getValue().isAfter(LocalDate.now()));{

            alertLabel.setText("Fill up all sections");


        }

        boolean digitFoundd = false;
        for (int i = 0; i < trulResourceNametextfield.getText().length(); i++) {
            if (trulResourceNametextfield.getText().charAt(i) >= '0' && trulResourceNametextfield.getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }
        boolean digitFounddd = true;
        for (int i = 0; i <trulQualitytextfield .getText().length(); i++) {
            if (trulQualitytextfield.getText().charAt(i) >= '0' && trulQualitytextfield.getText().charAt(i) <= '9') {
                digitFounddd = false;
            }
        }
        if (digitFounddd) {
            alertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }
        tfResourceUsage i=new tfResourceUsage(trnername,resourcename,quantity,sessndate);

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
            oos.writeObject(i);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}