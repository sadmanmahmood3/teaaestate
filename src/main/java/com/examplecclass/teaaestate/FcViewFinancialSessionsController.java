package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FcViewFinancialSessionsController
{
    @javafx.fxml.FXML
    private TableColumn viewDateTableColumn;
    @javafx.fxml.FXML
    private TableView viewFinancialSessionsTableView;
    @javafx.fxml.FXML
    private TableColumn viewTeaProducedTableColumn;
    @javafx.fxml.FXML
    private TableColumn viewTeaTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn viewTotalCostTableColumn;
    @javafx.fxml.FXML
    private TableColumn viewLeafReceivedTbleColumn;

    @javafx.fxml.FXML
    public void initialize() {
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