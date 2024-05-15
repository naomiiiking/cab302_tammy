package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Memorylogs.StudyLogsDAO;
import Memorylogs.MemoryEntry;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class MemoriesController {

    @FXML
    private TableView<MemoryEntry> tableView;

    @FXML
    private TableColumn<MemoryEntry, String> dateColumn;

    @FXML
    private TableColumn<MemoryEntry, Integer> hoursColumn;

    @FXML
    private TableColumn<MemoryEntry, Double> creditsColumn;

    private final StudyLogsDAO studyLogsDAO = new StudyLogsDAO();

    public void initialize() {
        tableView.setMaxWidth(700.0);
        tableView.setMaxHeight(1000.0);

        // Set up cell value factories for table columns
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        hoursColumn.setCellValueFactory(new PropertyValueFactory<>("hoursStudied"));
        creditsColumn.setCellValueFactory(new PropertyValueFactory<>("creditsGained"));

        // Fetch study logs data from the database and populate the table
        populateTable();

        // Load the CSS file and add it to the TableView's stylesheets
        URL cssUrl = getClass().getResource("stylesheet.css");
        if (cssUrl != null) {
            String css = cssUrl.toExternalForm();
            tableView.getStylesheets().add(css);
        } else {
            System.err.println("CSS file not found!");
        }
    }

    /**
     * Populates the table with study logs data from the database
     */
    private void populateTable() {
        try {
            List<MemoryEntry> memoryEntries = studyLogsDAO.getAllStudyLogs();
            tableView.getItems().clear(); // Clear the existing items
            tableView.getItems().addAll(memoryEntries); // Add new items
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns to homepage
     */
    @FXML
    private void handleCancelButtonClicked() {
        try {
            HelloApplication.showHomePage(); //needs a username
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
