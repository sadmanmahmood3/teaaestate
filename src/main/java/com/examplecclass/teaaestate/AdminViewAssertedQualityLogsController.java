package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class AdminViewAssertedQualityLogsController
{
    @javafx.fxml.FXML
    private TableColumn qaDateCol;
    @javafx.fxml.FXML
    private TableColumn qaFactoryNameCol;
    @javafx.fxml.FXML
    private TableColumn qaBatchIDCol;
    @javafx.fxml.FXML
    private TableView qualityLogsTableView;
    @javafx.fxml.FXML
    private TableColumn qaShiftCol;
    @javafx.fxml.FXML
    private TableColumn qaTeaTypeCol;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void qaViewAssertedQualityLogsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("adminAssertQualityLogs.bin");
            if(f.exists()) {
                fis = new FileInputStream(f);
            }
            else {

            }
            if (fis != null) ois =new ObjectInputStream(fis);

            qualityLogsTableView.getItems().clear();

            while (true) {
                qualityLogsTableView.getItems().add((adminAssertQualityLogs) ois.readObject());

            }


        }
        catch (Exception e) {
            try {
                if (ois != null) ois.close();
            }catch (Exception e2){

            }
        }
    }
}