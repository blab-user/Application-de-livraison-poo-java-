package com.example.applivreur.model;

import com.example.applivreur.model.Client;
import com.example.applivreur.DOA.ClientDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addnewController implements Initializable {


        @FXML
        private TextField adressFild;


        @FXML
        private TextField deliveryFild;

        @FXML
        private TextField emailFild;

        @FXML
        private TextField nameFild;

        @FXML
        private TextField phoneFild;

        @FXML
        private TextField productsFild;

        @FXML
        private Button saveBtn;
        @FXML
        private Label labelFild;

        @FXML
        void adressFild(ActionEvent event) {}

        @FXML
        void clean(MouseEvent event) {}

        @FXML
        void cleanBtn(ActionEvent event) {}

        @FXML
        void deliveryFild(ActionEvent event) {}

        @FXML
        void emailFild(ActionEvent event) {}

        @FXML
        void nameFild(ActionEvent event) {}

        @FXML
        void phoneFild(ActionEvent event) {}

        @FXML
        void productsFild(ActionEvent event) {}

        @FXML
        public void fieldsaveBtn(ActionEvent event) throws SQLException {
                ClientDAO clientDAO = new ClientDAO();
                Client client = new Client(nameFild.getText().toString(),
                        phoneFild.getText().toString(),
                        emailFild.getText().toString(),
                        productsFild.getText().toString(),
                        deliveryFild.getText().toString(),
                        adressFild.getText().toString());
                clientDAO.save(client);
              labelFild.setText("successfully registered thanks!");
              nameFild.setText("");
                phoneFild.setText("");
                emailFild.setText("");
                productsFild.setText("");
                deliveryFild.setText("");
                adressFild.setText("");

        }




        String query = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Client client = null;
        private boolean update = false;
        private int clientId;

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }


}

