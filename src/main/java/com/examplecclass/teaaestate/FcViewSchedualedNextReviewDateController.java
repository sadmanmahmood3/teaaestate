package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FcViewSchedualedNextReviewDateController
{
    @javafx.fxml.FXML
    private TableColumn scndReviewDateCol;
    @javafx.fxml.FXML
    private TableColumn scndReviewTitleCol;
    @javafx.fxml.FXML
    private TableColumn scndAssignedReviewerCol;
    @javafx.fxml.FXML
    private TableColumn scndSessionPeriodCoveredCol;
    @javafx.fxml.FXML
    private TableColumn scndLocationCol;
    @javafx.fxml.FXML
    private TableColumn scndNotesCol;
    @javafx.fxml.FXML
    private TableView scndTableView;

    @javafx.fxml.FXML
    public void initialize() {
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