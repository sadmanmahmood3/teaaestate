package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class MmViewMonthlySubGrowthController
{
    @javafx.fxml.FXML
    private TableColumn<mmUpdateSubCount,Integer> msgUnsubCol;
    @javafx.fxml.FXML
    private TableView<mmUpdateSubCount> msgTableView;
    @javafx.fxml.FXML
    private TableColumn<mmUpdateSubCount,Integer> msgNewSubCol;
    @javafx.fxml.FXML
    private TableColumn<mmUpdateSubCount, LocalDate> msgDateCol;

    @javafx.fxml.FXML
    public void initialize() {
        msgNewSubCol.setCellValueFactory(new PropertyValueFactory<>("newSubs"));
        msgUnsubCol.setCellValueFactory(new PropertyValueFactory<>("unsubs"));
        msgDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        //private int newSubs,unsubs;
        //    private LocalDate date;


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