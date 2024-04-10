package com.example.addressbook.tammy2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;


import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //Instantiating the BorderPane class
        BorderPane bPane = new BorderPane();

        //Load image and set as image view
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResource("/assets/1.png").toString()));
        imageView.setFitWidth(500);
        imageView.setCache(true);
        imageView.setPreserveRatio(true);

        bPane.setTop(new TextField("Top"));
        bPane.setBottom(new TextField("Bottom"));
        bPane.setLeft(new TextField("Left"));
        bPane.setRight(new TextField("Right"));
        bPane.setCenter(imageView);

        //Creating a scene object
        Scene scene = new Scene(bPane, 1000, 600);

        //Setting title to the Stage
        stage.setTitle("BorderPane Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}