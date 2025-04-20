package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MmViewMonthlySubGrowthController
{
    @javafx.fxml.FXML
    private TableColumn msgUnsubCol;
    @javafx.fxml.FXML
    private TableView msgTableView;
    @javafx.fxml.FXML
    private TableColumn msgNewSubCol;
    @javafx.fxml.FXML
    private TableColumn msgDateCol;

    @javafx.fxml.FXML
    public void initialize() {
        msgMonthCol.setCellValueFactory(new PropertyValueFactory<>());

    }

    @javafx.fxml.FXML
    public void msgViewButtonOnAction(ActionEvent actionEvent) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("mmUpdateSubCount.bin");
            if(f.exists()) {
                fis = new FileInputStream(f);
            }
            else {

            }
            if (fis != null) ois =new ObjectInputStream(fis);

            msgTableView.getItems().clear();

            while (true) {
                msgTableView.getItems().add((mmUpdateSubCount) ois.readObject());

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