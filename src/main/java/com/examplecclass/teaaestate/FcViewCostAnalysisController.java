package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class FcViewCostAnalysisController
{
    @javafx.fxml.FXML
    private TableColumn<fcCostAnalysis,String> caTeaTypeCol;
    @javafx.fxml.FXML
    private TableColumn<fcCostAnalysis,Integer> caTransportCostCol;
    @javafx.fxml.FXML
    private TableView<fcCostAnalysis> viewCostAnalysisTableView;
    @javafx.fxml.FXML
    private TableColumn<fcCostAnalysis,Integer> caLabourCostCol;
    @javafx.fxml.FXML
    private TableColumn<fcCostAnalysis,Integer> caPackingCostCol;
    @javafx.fxml.FXML
    private TableColumn<fcCostAnalysis, LocalDate> caDateCol;

    @javafx.fxml.FXML
    public void initialize() {
        caTeaTypeCol.setCellValueFactory(new PropertyValueFactory<>("teatype"));
        caLabourCostCol.setCellValueFactory(new PropertyValueFactory<>("lbrCost"));
        caPackingCostCol.setCellValueFactory(new PropertyValueFactory<>("pkingCost"));
        caTransportCostCol.setCellValueFactory(new PropertyValueFactory<>("tptCost"));
        caDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    @javafx.fxml.FXML
    public void viewCostAnalysisButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("fcCostAnalysis.bin");
            if(f.exists()) {
                fis = new FileInputStream(f);
            }
            else {

            }
            if (fis != null) ois =new ObjectInputStream(fis);

            viewCostAnalysisTableView.getItems().clear();

            while (true) {
                viewCostAnalysisTableView.getItems().add((fcCostAnalysis) ois.readObject());

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