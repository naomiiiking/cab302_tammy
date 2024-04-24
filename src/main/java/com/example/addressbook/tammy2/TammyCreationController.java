package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TammyCreationController {

    @FXML
    private TextField firstNameTextField;

    private final Map<String, Integer> CharacOption = new HashMap<String, Integer>(){{
        put("Fitness", 3);
        put("Sleep", 1);
        put("Study", 2);
    }};

    //https://www.geeksforgeeks.org/javafx-combobox-with-examples/ for combobox methods in particular
    // getting the contents in box
    private ComboBox comboBox = new ComboBox();

    public void onAdd(){

    }


}

