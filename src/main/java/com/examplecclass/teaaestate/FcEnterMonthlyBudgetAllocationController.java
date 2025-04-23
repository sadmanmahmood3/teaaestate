package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class FcEnterMonthlyBudgetAllocationController
{
    @javafx.fxml.FXML
    private Label allertLabel;
    @javafx.fxml.FXML
    private TextField mbaTransporttextfield;
    @javafx.fxml.FXML
    private TextField mbaRawMaterialstextfield;
    @javafx.fxml.FXML
    private DatePicker mbaPeriodDatePicker;
    @javafx.fxml.FXML
    private TextField mbaSubmittedtextfield;
    @javafx.fxml.FXML
    private TextField mbaLabourtextfield;

    @javafx.fxml.FXML
    public void initialize() {
        mbaPeriodDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void mbaAllocateButtonOnAction(ActionEvent actionEvent) {
        int rmBudget = Integer.parseInt(mbaRawMaterialstextfield.getText());
        int lbrBudget = Integer.parseInt(mbaLabourtextfield.getText());
        int tptBudget = Integer.parseInt(mbaTransporttextfield.getText());
        String submittedBy = mbaSubmittedtextfield.getText();
        LocalDate period = mbaPeriodDatePicker.getValue();

        boolean digitFound = false;
        for (int i = 0; i < mbaSubmittedtextfield.getText().length(); i++) {
            if (mbaSubmittedtextfield.getText().charAt(i) >= '0' && mbaSubmittedtextfield.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (digitFound) {
            allertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }
        boolean digitFoundd = true;
        for (int i = 0; i < mbaRawMaterialstextfield.getText().length(); i++) {
            if (mbaRawMaterialstextfield.getText().charAt(i) >= '0' && mbaRawMaterialstextfield.getText().charAt(i) <= '9') {
                digitFoundd = false;
            }
        }
        if (digitFoundd) {
            allertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }

        boolean digitFounddd = true;
        for (int i = 0; i < mbaLabourtextfield.getText().length(); i++) {
            if (mbaLabourtextfield.getText().charAt(i) >= '0' && mbaLabourtextfield.getText().charAt(i) <= '9') {
                digitFounddd = false;
            }
        }
        if (digitFounddd) {
            allertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }
        boolean digitFoundddd = true;
        for (int i = 0; i < mbaTransporttextfield.getText().length(); i++) {
            if (mbaTransporttextfield.getText().charAt(i) >= '0' && mbaTransporttextfield.getText().charAt(i) <= '9') {
                digitFoundddd = false;
            }
        }
        if (digitFoundddd) {
            allertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }



        fcMonthlyBudgetAllocation msg=new fcMonthlyBudgetAllocation(rmBudget,lbrBudget,tptBudget,submittedBy,period);

        try {
            File f=new File("fcMonthlyBudgetAllocation.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }  else {
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            allertLabel.setText("Successfully Submitted");
            oos.writeObject(msg);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}