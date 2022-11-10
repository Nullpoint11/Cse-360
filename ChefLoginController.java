package com.example.phase3final;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ChefLoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String usernamestr;
    private String passwordstr;

    @FXML
    private PasswordField userName;

    @FXML
    private PasswordField passwordEnter;

    @FXML
    private Label incorrect;

    public void onUserNameEnter(){
        usernamestr = userName.getText();
        userName.setVisible(true);
    }
    public void onPasswordEnter(){
        passwordstr = passwordEnter.getText();
    }

    public void signIn(){
        //check password
        if(false){

        }else{
            incorrect.setText("incorrect username or password");
        }
    }
}
