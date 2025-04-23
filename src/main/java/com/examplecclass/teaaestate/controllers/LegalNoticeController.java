package com.examplecclass.teaaestate.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.time.LocalDate;
import com.examplecclass.teaaestate.models.Notice;
import com.examplecclass.teaaestate.helpers.SceneHelper;
import javafx.scene.control.cell.PropertyValueFactory;

public class LegalNoticeController {
    @FXML private ComboBox<String> templateComboBox;
    @FXML private TextArea noticePreview;
    @FXML private TableView<Notice> noticeTable;
    @FXML private TableColumn<Notice, Integer> idColumn;
    @FXML private TableColumn<Notice, String> dateColumn;
    @FXML private TableColumn<Notice, String> templateColumn;
    @FXML private TableColumn<Notice, String> noticeStatusColumn;
    
    private ObservableList<Notice> notices = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setupTemplateComboBox();
        setupNoticeTable();
    }

    private void setupTemplateComboBox() {
        templateComboBox.getItems().addAll(
            "Corruption Complaint Notice",
            "Legal Warning Notice",
            "Investigation Request",
            "Transparency Violation Notice"
        );
        templateComboBox.setOnAction(e -> updatePreview());
    }

    private void setupNoticeTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        templateColumn.setCellValueFactory(new PropertyValueFactory<>("template"));
        noticeStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        noticeTable.setItems(notices);
    }

    private void updatePreview() {
        String selectedTemplate = templateComboBox.getValue();
        if (selectedTemplate != null) {
            noticePreview.setText(getTemplateText(selectedTemplate));
        }
    }

    private String getTemplateText(String template) {
        switch (template) {
            case "Corruption Complaint Notice":
                return "NOTICE OF CORRUPTION COMPLAINT\n\nDate: [Current Date]\n\nDear [Recipient],\n\nThis notice serves to formally address corrupt practices observed...";
            case "Legal Warning Notice":
                return "LEGAL WARNING\n\nDate: [Current Date]\n\nTo whom it may concern,\n\nThis is a formal warning regarding legal violations...";
            default:
                return "Select a template to view preview";
        }
    }

    @FXML
    private void saveDraft() {
        if (templateComboBox.getValue() != null) {
            Notice notice = new Notice(
                notices.size() + 1,
                LocalDate.now().toString(),
                templateComboBox.getValue(),
                "Draft"
            );
            notices.add(notice);
        }
    }

    @FXML
    private void sendNotice() {
        if (templateComboBox.getValue() != null) {
            Notice notice = new Notice(
                notices.size() + 1,
                LocalDate.now().toString(),
                templateComboBox.getValue(),
                "Sent"
            );
            notices.add(notice);
        }
    }

    @FXML
    private void backToDashboard(ActionEvent event) throws IOException {
        SceneHelper.switchScene("DashboardForLawyer.fxml", event);
    }
} 