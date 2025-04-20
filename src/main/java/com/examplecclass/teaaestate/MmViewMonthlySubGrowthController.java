package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    }
}