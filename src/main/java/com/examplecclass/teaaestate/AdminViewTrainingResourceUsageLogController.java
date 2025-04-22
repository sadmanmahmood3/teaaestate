package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class AdminViewTrainingResourceUsageLogController
{
    @javafx.fxml.FXML
    private TableColumn<tfResourceUsage,String> vtrulTrainerNameCol;
    @javafx.fxml.FXML
    private TableColumn<tfResourceUsage, LocalDate> vtrulDateOfSessionsCol;
    @javafx.fxml.FXML
    private TableColumn<tfResourceUsage,String> vtrulResouceNameCol;
    @javafx.fxml.FXML
    private TableColumn<tfResourceUsage,Integer> vtrulQualityCol;
    @javafx.fxml.FXML
    private TableView<tfResourceUsage> vtrulTableView;

    @javafx.fxml.FXML
    public void initialize() {
        vtrulTrainerNameCol.setCellValueFactory(new PropertyValueFactory<>("trnername"));
        vtrulResouceNameCol.setCellValueFactory(new PropertyValueFactory<>("resourcename"));
        vtrulQualityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        vtrulDateOfSessionsCol.setCellValueFactory(new PropertyValueFactory<>("sessndate"));
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