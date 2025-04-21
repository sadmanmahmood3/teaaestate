package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TfViewTrainingResourceUsageLogController
{
    @javafx.fxml.FXML
    private TableColumn vtrulResourceNameCol;
    @javafx.fxml.FXML
    private TableColumn vtrulTrainerNameCol;
    @javafx.fxml.FXML
    private TableColumn vtrulDateOfSessionsCol;
    @javafx.fxml.FXML
    private TableColumn vtrulQualityCol;
    @javafx.fxml.FXML
    private TableView vtrulTableView;
    @javafx.fxml.FXML
    private TableColumn vtrulStockRefillCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void tfUsageLogOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("tfResourceUsage.bin");
            if(f.exists()) {
                fis = new FileInputStream(f);
            }
            else {

            }
            if (fis != null) ois =new ObjectInputStream(fis);

            vtrulTableView.getItems().clear();

            while (true) {
                vtrulTableView.getItems().add((tfResourceUsage) ois.readObject());

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