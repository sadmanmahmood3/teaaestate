package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MmViewApprovedBlogsController
{
    @javafx.fxml.FXML
    private TableColumn erbPublishDateCol;
    @javafx.fxml.FXML
    private TableColumn erbSubDateCol;
    @javafx.fxml.FXML
    private TableColumn erbAuthorNameCol;
    @javafx.fxml.FXML
    private TableColumn erbTitleCol;
    @javafx.fxml.FXML
    private TableView erbTableView;
    @javafx.fxml.FXML
    private TableColumn erbReviewCol;
    @javafx.fxml.FXML
    private TableColumn erbEventNameCol;

    @javafx.fxml.FXML
    public void initialize() {



    }

    @javafx.fxml.FXML
    public void erbViewButtonOnAction(ActionEvent actionEvent) {



        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("mmApproveEventBlogs.bin");
            if(f.exists()) {
                fis = new FileInputStream(f);
            }
            else {

            }
            if (fis != null) ois =new ObjectInputStream(fis);

            erbTableView.getItems().clear();

            while (true) {
                erbTableView.getItems().add((mmApproveEventBlogs) ois.readObject());

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