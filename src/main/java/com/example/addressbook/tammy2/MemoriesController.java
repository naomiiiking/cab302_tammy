package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemoriesController {

    public TableView tableView;
    public TableColumn dateColumn;
    public TableColumn hoursColumn;
    public TableColumn creditsColumn;
    @FXML
    private Label pageName;

    public void initialize() {
        tableView.setMaxWidth(700.0);
        tableView.setMaxHeight(1000.0);
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

    // Define a class for MemoryEntry

    /**
     * Creates a memory entry record
     * @param date date of memory
     * @param timeStudied time spent studying
     * @param creditsGained credits gained
     */
        public record MemoryEntry(String date, int timeStudied, double creditsGained) {
    }
}