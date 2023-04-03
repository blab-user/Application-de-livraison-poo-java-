package com.example.applivreur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login  extends Application {

    public static final String USERNAME = "ADMIN";
    public static final Object PASSWORD = "ADMIN";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AllMenu/Login-home.fxml"));
        stage.setScene(new Scene(root));
        stage.show();

    }
    public static void main (String[] args){launch(args);}
}
