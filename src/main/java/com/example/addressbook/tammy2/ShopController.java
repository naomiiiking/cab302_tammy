package com.example.addressbook.tammy2;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ShopController {

    public HBox bottomButtons;

    public void initialise() {
        // Submit and cancel buttons
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setSpacing(10);
    }

    @FXML
    private void handleBackButtonClicked(){
        try {
            HelloApplication.showHomePage(); //needs a username
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
