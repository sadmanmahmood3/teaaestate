package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class FcRecordCapitalExpenditureRequestController
{
    @javafx.fxml.FXML
    private DatePicker capexExpectedDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> capexApprovalStatusComboBox;
    @javafx.fxml.FXML
    private TextField capexRequestIdtextfield;
    @javafx.fxml.FXML
    private ComboBox<String> capexDepartmentComboBox;
    @javafx.fxml.FXML
    private Label alertLabel;
    @javafx.fxml.FXML
    private TextField capexSuppliertextfield;
    @javafx.fxml.FXML
    private ComboBox<String> capexPriorityComboBox;
    @javafx.fxml.FXML
    private TextField capexRequestBytextfield;

    @javafx.fxml.FXML
    public void initialize() {
        capexApprovalStatusComboBox.getItems().addAll("pending","approved","rejected");
        capexPriorityComboBox.getItems().addAll("high","medium","low");
        capexDepartmentComboBox.getItems().addAll("production","admin");
        capexExpectedDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void capexProceedOnAction(ActionEvent actionEvent) {
        String apprvl = capexApprovalStatusComboBox.getSelectionModel().getSelectedItem();
        String dprtmt = capexDepartmentComboBox.getSelectionModel().getSelectedItem();
        String prty = capexPriorityComboBox.getSelectionModel().getSelectedItem();
        String supplr = capexSuppliertextfield.getText();
        String rqstby = capexRequestBytextfield.getText();
        int rqstiD = Integer.parseInt(capexRequestIdtextfield.getText());
        LocalDate expdate = capexExpectedDatePicker.getValue();


        if (capexSuppliertextfield.getText().isEmpty() || capexRequestBytextfield.getText().isEmpty()||
                capexRequestIdtextfield.getText().isEmpty()
                ||capexExpectedDatePicker.getValue().isAfter(LocalDate.now()));{

            alertLabel.setText("Fill up all sections");


        }
        boolean digitFound = false;
        for (int i = 0; i < capexSuppliertextfield.getText().length(); i++) {
            if (capexSuppliertextfield.getText().charAt(i) >= '0' && capexSuppliertextfield.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (digitFound) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }
        boolean digitFoundd = false;
        for (int i = 0; i < capexRequestBytextfield.getText().length(); i++) {
            if (capexRequestBytextfield.getText().charAt(i) >= '0' && capexRequestBytextfield.getText().charAt(i) <= '9') {
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
        for (int i = 0; i < capexRequestIdtextfield.getText().length(); i++) {
            if (capexRequestIdtextfield.getText().charAt(i) >= '0' && capexRequestIdtextfield.getText().charAt(i) <= '9') {
                digitFounddd = false;
            }
        }
        if (digitFounddd) {
            alertLabel.setText("Only Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only Digits!");
            digitfoundAlert.show();
        }

        fcRcdCapExRqst rce=new fcRcdCapExRqst(apprvl,dprtmt,prty,supplr,rqstby,rqstiD,expdate);

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
            oos.writeObject(rce);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}