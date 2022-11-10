package com.example.phase3final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchStudentSelect(ActionEvent event) throws IOException {
        Parent loginScreen = FXMLLoader.load(getClass().getResource("studentpizzaselection.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loginScreen);
        stage.setScene(scene);
        stage.show();
    }

    public void switchChefLogin(ActionEvent event) throws IOException {
        Parent loginScreen = FXMLLoader.load(getClass().getResource("cheflogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loginScreen);
        stage.setScene(scene);
        stage.show();
    }

    public void switchAgentLogin(ActionEvent event) throws IOException {
        Parent loginScreen = FXMLLoader.load(getClass().getResource("agentlogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loginScreen);
        stage.setScene(scene);
        stage.show();
    }

}
