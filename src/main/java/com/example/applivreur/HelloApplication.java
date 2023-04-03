package com.example.applivreur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Clients/hello-view.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("WINDOW -> ajouter livreur !");
        stage.show();

    }
    public static void main (String[] args){launch(args);}
}
