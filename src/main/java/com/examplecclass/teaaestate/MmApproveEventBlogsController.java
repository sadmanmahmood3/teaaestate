package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class MmApproveEventBlogsController implements Serializable
{
    @javafx.fxml.FXML
    private TextField erbAuthorNameField;
    @javafx.fxml.FXML
    private TextField erbEventNameField;
    @javafx.fxml.FXML
    private TextField erbBlogtitleField;
    @javafx.fxml.FXML
    private DatePicker erbSubmissionDatePicker;
    @javafx.fxml.FXML
    private DatePicker erbPublishDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> erbReviewStatusComboBox;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
        erbReviewStatusComboBox.getItems().addAll("Pending","Reviewed","Rejected");
        erbPublishDatePicker.setValue(LocalDate.now());
        erbSubmissionDatePicker.setValue(LocalDate.now());

    }

    @javafx.fxml.FXML
    public void erbPublishOnAction(ActionEvent actionEvent) {
        String title= erbBlogtitleField.getText();
        String name= erbAuthorNameField.getText();
        String eventName=erbEventNameField.getText();
        String rvwStatus=erbReviewStatusComboBox.getSelectionModel().getSelectedItem();
        LocalDate subDate=erbSubmissionDatePicker.getValue();
        LocalDate pubDate=erbPublishDatePicker.getValue();

        if(erbBlogtitleField.getText().isEmpty()||erbEventNameField.getText().isEmpty()||erbAuthorNameField.getText().isEmpty()) {
            errorLabel.setText("Fill All The Fields");
        }

        boolean digitFound = false;
        for (int i = 0; i < erbBlogtitleField.getText().length(); i++) {
            if (erbBlogtitleField.getText().charAt(i) >= '0' && erbBlogtitleField.getText().charAt(i) <= '9') {
                digitFound = true;
            }
        }
        if (digitFound) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

        boolean digitFoundd = false;
        for (int i = 0; i < erbAuthorNameField.getText().length(); i++) {
            if (erbAuthorNameField.getText().charAt(i) >= '0' && erbAuthorNameField.getText().charAt(i) <= '9') {
                digitFoundd = true;
            }
        }
        if (digitFoundd) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

        boolean digitFounddd = false;
        for (int i = 0; i < erbEventNameField.getText().length(); i++) {
            if (erbEventNameField.getText().charAt(i) >= '0' && erbEventNameField.getText().charAt(i) <= '9') {
                digitFounddd = true;
            }
        }
        if (digitFounddd) {
            errorLabel.setText("No Digits");
            Alert digitfoundAlert = new Alert(Alert.AlertType.ERROR);
            digitfoundAlert.setContentText("No digits!");
            digitfoundAlert.show();}

        mmApproveEventBlogs aeb=new mmApproveEventBlogs(title,name,eventName,rvwStatus,subDate,pubDate);

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
            oos.writeObject(aeb);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}