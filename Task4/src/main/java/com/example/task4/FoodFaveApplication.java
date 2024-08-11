package com.example.task4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FoodFaveApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("coverScene.fxml")));
        primaryStage.setTitle("Foodies Fave Queue Management System.\n");
        primaryStage.setScene(new Scene(root,950,600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
