package com.examplecclass.teaaestate.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import com.examplecclass.teaaestate.models.Policy;
import com.examplecclass.teaaestate.helpers.SceneHelper;
import javafx.scene.control.cell.PropertyValueFactory;


public class ComplianceController {
    @FXML private TableView<Policy> policyTable;
    @FXML private TableColumn<Policy, Integer> policyIdColumn;
    @FXML private TableColumn<Policy, String> policyNameColumn;
    @FXML private TableColumn<Policy, String> policyStatusColumn;
    @FXML private TableColumn<Policy, String> lastReviewColumn;
    @FXML private TextArea policyDetails;
    @FXML private ComboBox<String> statusComboBox;
    
    private ObservableList<Policy> policies = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setupPolicyTable();
        setupStatusComboBox();
        loadPolicies();
    }

    private void setupPolicyTable() {
        policyIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        policyNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        policyStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        lastReviewColumn.setCellValueFactory(new PropertyValueFactory<>("lastReview"));
        
        policyTable.setItems(policies);
        
        policyTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    policyDetails.setText(newValue.getDetails());
                }
            }
        );
    }

    private void setupStatusComboBox() {
        statusComboBox.getItems().addAll(
            "Compliant",
            "Non-Compliant",
            "Under Review"
        );
    }

    private void loadPolicies() {
        policies.addAll(
            new Policy(1, "Data Protection Policy", "Guidelines for handling sensitive data...", "Compliant", "2024-03-15"),
            new Policy(2, "Anti-Corruption Policy", "Procedures to prevent corruption...", "Under Review", "2024-03-10"),
            new Policy(3, "Ethics Policy", "Standards for ethical conduct...", "Non-Compliant", "2024-03-01")
        );
    }

    @FXML
    private void updateComplianceStatus() {
        Policy selectedPolicy = policyTable.getSelectionModel().getSelectedItem();
        String newStatus = statusComboBox.getValue();
        
        if (selectedPolicy != null && newStatus != null) {
            selectedPolicy.setStatus(newStatus);
            policyTable.refresh();
            
            if (newStatus.equals("Non-Compliant")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Non-Compliance Alert");
                alert.setHeaderText("Policy Non-Compliance Detected");
                alert.setContentText("Policy '" + selectedPolicy.getName() + 
                                   "' has been marked as non-compliant. Immediate review required.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void backToDashboard(ActionEvent event) throws IOException {
        SceneHelper.switchScene("DashboardForLawyer.fxml", event);
    }
} 