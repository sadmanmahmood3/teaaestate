package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TfTrainingBudgetAllocationController
{
    @javafx.fxml.FXML
    private TextField tbaVenuetextfield;
    @javafx.fxml.FXML
    private Label alertLabel;
    @javafx.fxml.FXML
    private TextField tbaRefreshmentstextfield;
    @javafx.fxml.FXML
    private TextField tbaParticipantstextfield;
    @javafx.fxml.FXML
    private TextField tbaProgramNametextfield;
    @javafx.fxml.FXML
    private TextField tbaMaterialCosttextfield;
    @javafx.fxml.FXML
    private TextField tbaFeetextfield;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void tbaAllocateOnAction(ActionEvent actionEvent) {
        String trningprgmname = tbaProgramNametextfield.getText();
        int prtcpnt = Integer.parseInt(tbaParticipantstextfield.getText());
        int trnerfee = Integer.parseInt(tbaFeetextfield.getText());
        int mtrlcost = Integer.parseInt(tbaMaterialCosttextfield.getText());
        int venuecost = Integer.parseInt(tbaVenuetextfield.getText());
        int rfrshmts = Integer.parseInt(tbaRefreshmentstextfield.getText());

        if (tbaProgramNametextfield.getText().isEmpty() || tbaParticipantstextfield.getText().isEmpty()||
                tbaFeetextfield.getText().isEmpty()
                ||tbaMaterialCosttextfield.getText().isEmpty()||tbaVenuetextfield.getText().isEmpty()||
                tbaRefreshmentstextfield.getText().isEmpty());{

            alertLabel.setText("Fill up all sections");


        }

        boolean digitFound = false;
        for (int i = 0; i < tbaProgramNametextfield.getText().length(); i++) {
            if (tbaProgramNametextfield.getText().charAt(i) >= '0' && tbaProgramNametextfield.getText().charAt(i) <= '9') {
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
        for (int i = 0; i < tbaParticipantstextfield.getText().length(); i++) {
            if (tbaParticipantstextfield.getText().charAt(i) >= '0' && tbaParticipantstextfield.getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }

        boolean digitFounddd = false;
        for (int i = 0; i < tbaFeetextfield.getText().length(); i++) {
            if (tbaFeetextfield.getText().charAt(i) >= '0' && tbaFeetextfield.getText().charAt(i) <= '9') {
                digitFounddd = true;
            }
        }
        if (digitFounddd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }

        boolean digitFoundddd = false;
        for (int i = 0; i < tbaMaterialCosttextfield.getText().length(); i++) {
            if (tbaMaterialCosttextfield.getText().charAt(i) >= '0' && tbaMaterialCosttextfield.getText().charAt(i) <= '9') {
                digitFoundddd = true;
            }
        }
        if (digitFoundddd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }

        boolean digitFounddddd = false;
        for (int i = 0; i < tbaVenuetextfield.getText().length(); i++) {
            if (tbaVenuetextfield.getText().charAt(i) >= '0' && tbaVenuetextfield.getText().charAt(i) <= '9') {
                digitFounddddd = true;
            }
        }
        if (digitFounddddd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }

        boolean digitFoundddddd = false;
        for (int i = 0; i < tbaRefreshmentstextfield.getText().length(); i++) {
            if (tbaRefreshmentstextfield.getText().charAt(i) >= '0' && tbaRefreshmentstextfield.getText().charAt(i) <= '9') {
                digitFoundddddd = true;
            }
        }
        if (digitFoundddddd) {
            alertLabel.setText("Only String");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("Only String!");
            digitfoundAlert.show();


        }
        tfBudgetAllocation ba=new tfBudgetAllocation(trningprgmname,prtcpnt,trnerfee,mtrlcost,venuecost,rfrshmts);

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
            oos.writeObject(ba);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}