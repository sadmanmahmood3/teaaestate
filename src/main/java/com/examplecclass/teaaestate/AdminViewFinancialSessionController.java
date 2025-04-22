package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class AdminViewFinancialSessionController
{
    @javafx.fxml.FXML
    private TableView<fcPubFinancialSessions> viewFinancialSessionsTableView;
    @javafx.fxml.FXML
    private TableColumn<fcPubFinancialSessions,String> viewTeaTypeTableColoumn;
    @javafx.fxml.FXML
    private TableColumn<fcPubFinancialSessions, LocalDate> viewDateTableColoumn;
    @javafx.fxml.FXML
    private TableColumn<fcPubFinancialSessions,Integer> viewLeafReceivedTableColoumn;
    @javafx.fxml.FXML
    private TableColumn<fcPubFinancialSessions,Integer> viewTeaProducedTableColoumn;

    @javafx.fxml.FXML
    public void initialize() {
        viewTeaTypeTableColoumn.setCellValueFactory(new PropertyValueFactory<>("teatype"));
        viewLeafReceivedTableColoumn.setCellValueFactory(new PropertyValueFactory<>("lfreceived"));
        viewTeaProducedTableColoumn.setCellValueFactory(new PropertyValueFactory<>("lfproduced"));
        viewDateTableColoumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @javafx.fxml.FXML
    public void viewFinancialSessionsButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("fcPubFinancialSessions.bin");
            if(f.exists()) {
                fis = new FileInputStream(f);
            }
            else {

            }
            if (fis != null) ois =new ObjectInputStream(fis);

            viewFinancialSessionsTableView.getItems().clear();

            while (true) {
                viewFinancialSessionsTableView.getItems().add((fcPubFinancialSessions) ois.readObject());

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