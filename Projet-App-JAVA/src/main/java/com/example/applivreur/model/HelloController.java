package com.example.applivreur.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.example.applivreur.DOA.ClientDAO;
import org.w3c.dom.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private Button btnAdd;
    @FXML
    private Button PageAdmins;
    @FXML
    private Button close;
    @FXML
    private Button btnExport;

    @FXML
    private Button refreshTable;

    // TABLE CLIENT
    @FXML
    private TableView<Client> tbVClient;

    @FXML
    private TableColumn<Client, Long> tcId;

    @FXML
    private TableColumn<Client, String> tcName;

    @FXML
    private TableColumn<Client, String> tcPhone;
    @FXML
    private TableColumn<Client, String> tcEmail;

    @FXML
    private TableColumn<Client, String> tcProducts;

    @FXML
    private TableColumn<Client, Date> tcDelivery;

    @FXML
    private TableColumn<Client, String> tcDate;
    @FXML
    private TableColumn<Client, String> tcAdress;

    // WINDOWS ADMINISTRATION PAGE
    @FXML
    void PageAdmins(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AllMenu/home-viewProductsDelivery.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("WINDOW -> Add Products");
        stage.show();
    }

    // OPEN PAGE IMPORT COMMAND
    public void btnExport(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ImportCommand/Command.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("WINDOW -> Importation");
        stage.show();
    }

    @FXML
    private void close(MouseEvent event) {
            Stage stage = (Stage) ((Stage) (Node) event.getSource()).getScene().getWindow();
            stage.close();
    }
        // AJOUTER NOUVELLE FENETRE
    @FXML
    private void getaddview(MouseEvent event) throws IOException {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Clients/addnew.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("WINDOW -> Gestion of Command Clients");;
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleButtonClick(ActionEvent event) {

    }

    @FXML
    void print(MouseEvent event) {

    }

  
    public void refreshTable() throws SQLException {
    ObservableList<Client> data = FXCollections.observableArrayList();
        ClientDAO clientDAO = new ClientDAO();
        for (Client client : clientDAO.getAll()){
            data.add(client);
        }
        tcId.setCellValueFactory(new PropertyValueFactory<Client, Long>("id"));
        tcName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<Client,String>("Phone"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
        tcDate.setCellValueFactory(new PropertyValueFactory<Client,String>("products"));
        tcProducts.setCellValueFactory(new PropertyValueFactory<Client,String>("delivery"));
        tcAdress.setCellValueFactory(new PropertyValueFactory<Client, String>("adress"));

        tbVClient.setItems(data);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


}
