package com.examplecclass.teaaestate;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class MmViewApprovedBlogsController
{
    @javafx.fxml.FXML
    private TableColumn<mmApproveEventBlogs, LocalDate> erbPublishDateCol;
    @javafx.fxml.FXML
    private TableColumn<mmApproveEventBlogs, LocalDate> erbSubDateCol;
    @javafx.fxml.FXML
    private TableColumn<mmApproveEventBlogs,String> erbAuthorNameCol;
    @javafx.fxml.FXML
    private TableColumn<mmApproveEventBlogs,String> erbTitleCol;
    @javafx.fxml.FXML
    private TableView<mmApproveEventBlogs> erbTableView;
    @javafx.fxml.FXML
    private TableColumn<mmApproveEventBlogs,String> erbReviewCol;
    @javafx.fxml.FXML
    private TableColumn<mmApproveEventBlogs,String> erbEventNameCol;

    @javafx.fxml.FXML
    public void initialize() {
        erbTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        erbAuthorNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        erbEventNameCol.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        erbReviewCol.setCellValueFactory(new PropertyValueFactory<>("rvwStatus"));
        erbSubDateCol.setCellValueFactory(new PropertyValueFactory<>("subDate"));
        erbPublishDateCol.setCellValueFactory(new PropertyValueFactory<>("pubDate"));





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