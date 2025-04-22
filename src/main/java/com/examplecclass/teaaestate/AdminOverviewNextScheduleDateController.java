package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class AdminOverviewNextScheduleDateController
{
    @javafx.fxml.FXML
    private TableColumn<fcScdleNxtRvwDt,String> scndTitleCol;
    @javafx.fxml.FXML
    private TableColumn<fcScdleNxtRvwDt, LocalDate> scndDateCol;
    @javafx.fxml.FXML
    private TableColumn<fcScdleNxtRvwDt,String> scndSessionCol;
    @javafx.fxml.FXML
    private TableColumn<fcScdleNxtRvwDt,String> scndLocationCol;
    @javafx.fxml.FXML
    private TableView<fcScdleNxtRvwDt> scndTableView;
    @javafx.fxml.FXML
    private TableColumn<fcScdleNxtRvwDt,String> scndAssertedReviewerCol;

    @javafx.fxml.FXML
    public void initialize() {
        scndAssertedReviewerCol.setCellValueFactory(new PropertyValueFactory<>("rvwr"));
        scndSessionCol.setCellValueFactory(new PropertyValueFactory<>("sessnprdcr"));
        scndLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        scndTitleCol.setCellValueFactory(new PropertyValueFactory<>("rvwrtitl"));
        scndDateCol.setCellValueFactory(new PropertyValueFactory<>("rvwrdate"));
    }

    @javafx.fxml.FXML
    public void scndButtonOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("fcScdleNxtRvwDt.bin");
            if(f.exists()) {
                fis = new FileInputStream(f);
            }
            else {

            }
            if (fis != null) ois =new ObjectInputStream(fis);

            scndTableView.getItems().clear();

            while (true) {
                scndTableView.getItems().add((fcScdleNxtRvwDt) ois.readObject());

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