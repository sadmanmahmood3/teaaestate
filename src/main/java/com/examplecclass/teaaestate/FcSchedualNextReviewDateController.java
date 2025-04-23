package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class FcSchedualNextReviewDateController implements Serializable
{
    @javafx.fxml.FXML
    private TextField scndTitletextfield;
    @javafx.fxml.FXML
    private Label alertLabel;
    @javafx.fxml.FXML
    private DatePicker scndreviewdateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> scndreviewerComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> scndLocationComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> scndPeriodCoverdComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        scndLocationComboBox.getItems().addAll("in person","online","headoffice");
        scndPeriodCoverdComboBox.getItems().addAll("Jan-June","July-August");
        scndreviewerComboBox.getItems().addAll("Mizan","Munira","Rabeya");
        scndreviewdateDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void scndUploadOnAction(ActionEvent actionEvent) {

        String rvwr = scndreviewerComboBox.getSelectionModel().getSelectedItem();
        String sessnprdcr = scndPeriodCoverdComboBox.getSelectionModel().getSelectedItem();
        String location = scndLocationComboBox.getSelectionModel().getSelectedItem();
        String rvwrtitl = scndTitletextfield.getText();
        LocalDate rvwrdate = scndreviewdateDatePicker.getValue();


        if (scndTitletextfield.getText().isEmpty() ||
                scndreviewdateDatePicker.getValue().isAfter(LocalDate.now()));{

            alertLabel.setText("Fill up all sections");


        }

        boolean digitFound = false;
        for (int i = 0; i <scndTitletextfield.getText().length(); i++) {
            if (scndTitletextfield.getText().charAt(i) >= '0' && scndTitletextfield.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }

        if (digitFound) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }

        fcScdleNxtRvwDt snr=new fcScdleNxtRvwDt(rvwr,sessnprdcr,location,rvwrtitl,rvwrdate);

        try {
            File f=new File("fcScdleNxtRvwDt.bin");
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
            oos.writeObject(snr);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}