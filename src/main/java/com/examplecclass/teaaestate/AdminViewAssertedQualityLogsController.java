package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class AdminViewAssertedQualityLogsController
{
    @javafx.fxml.FXML
    private TableColumn<adminAssertQualityLogs, LocalDate> qaDateCol;
    @javafx.fxml.FXML
    private TableColumn<adminAssertQualityLogs,String> qaFactoryNameCol;
    @javafx.fxml.FXML
    private TableColumn<adminAssertQualityLogs,String> qaBatchIDCol;
    @javafx.fxml.FXML
    private TableView<adminAssertQualityLogs> qualityLogsTableView;
    @javafx.fxml.FXML
    private TableColumn<adminAssertQualityLogs,String> qaShiftCol;
    @javafx.fxml.FXML
    private TableColumn<adminAssertQualityLogs,String> qaTeaTypeCol;

    @javafx.fxml.FXML
    public void initialize() {
        qaBatchIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        qaFactoryNameCol.setCellValueFactory(new PropertyValueFactory<>("factoryName"));
        qaShiftCol.setCellValueFactory(new PropertyValueFactory<>("shift"));
        qaTeaTypeCol.setCellValueFactory(new PropertyValueFactory<>("teaType"));
        qaDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        //private String id;
        //    private String factoryName,shift,teaType;
        //    private LocalDate date;

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