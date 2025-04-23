package com.examplecclass.teaaestate.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import com.examplecclass.teaaestate.helpers.SceneHelper;
import com.examplecclass.teaaestate.models.Expense;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExpenseAnalysisController {
    @FXML private TableView<Expense> expenseTable;
    @FXML private TableColumn<Expense, Integer> idColumn;
    @FXML private TableColumn<Expense, String> dateColumn;
    @FXML private TableColumn<Expense, String> categoryColumn;
    @FXML private TableColumn<Expense, Double> amountColumn;
    @FXML private Label totalExpensesLabel;
    @FXML private Label averageExpenseLabel;
    
    private ObservableList<Expense> expenses = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setupExpenseTable();
        loadExpenses();
        updateStatistics();
    }

    private void setupExpenseTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        expenseTable.setItems(expenses);
    }

    private void loadExpenses() {
        expenses.addAll(
            new Expense(1, "2024-03-15", "Legal Fees", 1500.00),
            new Expense(2, "2024-03-14", "Office Supplies", 250.00),
            new Expense(3, "2024-03-13", "Travel", 800.00),
            new Expense(4, "2024-03-12", "Training", 1200.00)
        );
    }

    private void updateStatistics() {
        double total = expenses.stream()
            .mapToDouble(Expense::getAmount)
            .sum();
        
        double average = expenses.isEmpty() ? 0 : total / expenses.size();
        
        totalExpensesLabel.setText(String.format("Total Expenses: $%.2f", total));
        averageExpenseLabel.setText(String.format("Average Expense: $%.2f", average));
    }

    @FXML
    private void backToDashboard(ActionEvent event) throws IOException {
        SceneHelper.switchScene("DashboardForLawyer.fxml", event);
    }
} 