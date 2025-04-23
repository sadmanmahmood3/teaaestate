package com.examplecclass.teaaestate.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import com.examplecclass.teaaestate.models.Event;
import com.examplecclass.teaaestate.helpers.SceneHelper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventManagementController {
    @FXML private TableView<Event> eventTable;
    @FXML private TableColumn<Event, Integer> idColumn;
    @FXML private TableColumn<Event, String> nameColumn;
    @FXML private TableColumn<Event, LocalDate> dateColumn;
    @FXML private TableColumn<Event, String> locationColumn;
    
    @FXML private TextField nameField;
    @FXML private DatePicker datePicker;
    @FXML private TextField locationField;
    @FXML private ListView<String> upcomingEventsList;
    
    private ObservableList<Event> eventList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setupTable();
        loadSampleData();
        setupTableSelection();
        updateCalendarView();
    }

    private void setupTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        
        eventTable.setItems(eventList);
    }

    private void setupTableSelection() {
        eventTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nameField.setText(newSelection.getName());
                datePicker.setValue(newSelection.getDate());
                locationField.setText(newSelection.getLocation());
            }
        });
    }

    @FXML
    public void addEvent() {
        if (validateInput()) {
            int newId = eventList.size() + 1;
            Event newEvent = new Event(
                newId,
                nameField.getText(),
                datePicker.getValue(),
                locationField.getText()
            );
            eventList.add(newEvent);
            clearForm();
            updateCalendarView();
        }
    }

    @FXML
    public void updateEvent() {
        Event selectedEvent = eventTable.getSelectionModel().getSelectedItem();
        if (selectedEvent != null && validateInput()) {
            selectedEvent.setName(nameField.getText());
            selectedEvent.setDate(datePicker.getValue());
            selectedEvent.setLocation(locationField.getText());
            
            eventTable.refresh();
            clearForm();
            updateCalendarView();
        }
    }

    @FXML
    public void deleteEvent() {
        Event selectedEvent = eventTable.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            eventList.remove(selectedEvent);
            clearForm();
            updateCalendarView();
        }
    }

    @FXML
    public void clearForm() {
        nameField.clear();
        datePicker.setValue(null);
        locationField.clear();
        eventTable.getSelectionModel().clearSelection();
    }

    private boolean validateInput() {
        if (nameField.getText().isEmpty() || 
            datePicker.getValue() == null || 
            locationField.getText().isEmpty()) {
            
            showAlert("Error", "Missing Information", "Please fill all fields");
            return false;
        }
        return true;
    }

    private void updateCalendarView() {
        ObservableList<String> upcomingEvents = FXCollections.observableArrayList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        
        eventList.stream()
                .filter(event -> event.getDate().isAfter(LocalDate.now().minusDays(1)))
                .sorted((e1, e2) -> e1.getDate().compareTo(e2.getDate()))
                .forEach(event -> {
                    String eventString = String.format("%s - %s at %s",
                            event.getDate().format(formatter),
                            event.getName(),
                            event.getLocation());
                    upcomingEvents.add(eventString);
                });
        
        upcomingEventsList.setItems(upcomingEvents);
    }

    private void loadSampleData() {
        eventList.addAll(
            new Event(1, "Anti-Corruption Workshop", LocalDate.now().plusDays(7), "KKTA Main Office"),
            new Event(2, "Community Meeting", LocalDate.now().plusDays(14), "Community Center"),
            new Event(3, "Legal Awareness Seminar", LocalDate.now().plusDays(21), "City Convention Center")
        );
        updateCalendarView();
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void backToDashboard(ActionEvent event) {
        try {
            SceneHelper.switchScene("CommunityDashboard.fxml", event);
        } catch (Exception e) {
            showAlert("Error", "Navigation Error", "Could not return to dashboard");
        }
    }
} 