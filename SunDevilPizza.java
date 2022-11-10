package com.example.phase3final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SunDevilPizza extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent loginScreen = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(loginScreen, 600, 600);
        stage.setTitle("SunDevil Pizza");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
