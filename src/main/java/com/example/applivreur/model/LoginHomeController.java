package com.example.applivreur.model;

import com.example.applivreur.Login;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginHomeController implements Initializable {

    @FXML
    private Button connectuser;

    @FXML
    private ImageView imageuser;

    @FXML
    private ImageView loginuser;

    @FXML
    private TextField nameuser;

    @FXML
    private TextField passuser;

    @FXML
    private Label answer;

    @FXML
    private Button resetuser;
    @FXML
    private Label ErrorPassword;
    private String Errorpassword = "";
    // traitement mot de passe incorrecte
    private boolean isFieldFilled(){

        boolean isFilled = true;
        if(nameuser.getText().isEmpty()){
            isFilled = false;
            Errorpassword = "Username is Empty!";
        }

        if (passuser.getText().isEmpty()){
            isFilled = true;
            if (Errorpassword.isEmpty()){
                Errorpassword = "Password is Empty!";
            }else {
                Errorpassword += "\nPassword is Empty!";
            }
        }
    ErrorPassword.setText(Errorpassword);
        return isFilled;
    }
    // si le code admin correct
    private boolean isValid(){
        boolean isValid = true;
        if (nameuser.getText().equals(Login.USERNAME)){
            isValid = false;
            Errorpassword = "Correct Username!";
        }
        if (passuser.getText().equals(Login.PASSWORD)){
            isValid = false;
            if (Errorpassword.isEmpty()){
                Errorpassword = "Correct Password!";
            }else {
                Errorpassword += "\nCorrect Password!";
            }
        }
        ErrorPassword.setText(Errorpassword);
        return isValid;
    }
    // ici
    private void startHomewindow(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Clients/hello-view.fxml"));
            Stage stage = new Stage();
            stage.setMaximized(true);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //jusque la appel de la nouvelle scene
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetuser.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });
        connectuser.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Errorpassword = "";
                if (isFieldFilled() && isValid()){
                    //faire quelque chose pour la nouvelle fenetre
                    startHomewindow();
                }
            }
        });
    }

    public void admin(MouseEvent mouseEvent) {
        answer.setText("Login");
    }

    public void log(MouseEvent mouseEvent) {
        answer.setText("Password");
    }
}
