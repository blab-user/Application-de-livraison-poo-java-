package com.example.applivreur;


import com.example.applivreur.model.Delivery;
import com.example.applivreur.DOA.DeliveryDAO;
import com.example.applivreur.model.Product;
import com.example.applivreur.DOA.ProductDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GestionProductsDelivery extends Application implements Initializable{

    //Ajout de produit
    @FXML  private TextField fxname;
    @FXML private TextField fxprice;
    @FXML private TextField fxquantity;
    @FXML private Label fxLabelAddProduct;

    //Tableau de produits
    @FXML
    private Button add_produit;


    @FXML
    private TableColumn<Product, Long> fxProductID;

    @FXML
    private TableColumn<Product, String> fxProductName;

    @FXML
    private TableColumn<Product, Long> fxProductPrice;

    @FXML
    private TableColumn<Product, Long> fxProductStock;

    @FXML
    private TableView<Product> fxTableProduct;

    @FXML
    private Button fxrefrechListProduct;

    // Propriétés  Livreurs
    @FXML private Label fxLabelAddLivreur;
    @FXML private TextField fxtelephone;

    @FXML
    private TableColumn<Delivery, Long> fxLivreurID;

    @FXML
    private TableColumn<Delivery, String> fxLivreurName;
    @FXML
    private TableColumn<Delivery, String> fxLivreurTelephone;
    @FXML
    private TableView<Delivery> fxTableLivreur;


    public void refrechListLivreur() throws SQLException {
        ObservableList<Delivery> data = FXCollections.observableArrayList();
        DeliveryDAO deliveryDAO = new DeliveryDAO();
        for (Delivery delivery : deliveryDAO.getAll())
        {
            data.add(delivery);
        }

        fxLivreurID.setCellValueFactory(new PropertyValueFactory<Delivery, Long>("id_livreur"));
        fxLivreurName.setCellValueFactory(new PropertyValueFactory<Delivery, String>("nom"));
        fxLivreurTelephone.setCellValueFactory(new PropertyValueFactory<Delivery, String>("telephone"));
        fxTableLivreur.setItems(data);
    }
    @FXML
    public void addLivreur() throws SQLException {
        DeliveryDAO deliveryDAO = new DeliveryDAO();
        Delivery delivery = new Delivery(fxname.getText().toString(), fxtelephone.getText().toString());
        deliveryDAO.save(delivery);
        fxLabelAddLivreur.setText("Product added successfully");
        fxname.setText("");
        fxtelephone.setText("");
    }
        // OPEN OF WINDOWS
    @FXML
    public void fieldAddLivreur(ActionEvent event) throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/livreurs/add-viewDelivery.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("WINDOW -> Add Delivery ");
        stage.show();
    }


    //public ObservableList<Product> data = FXCollections.observableArrayList();
    // OPEN OF WINDOWS
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AllMenu/home-viewProductsDelivery.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("WINDOW -> Tack on Way");
        stage.show();
    }




    @FXML
    protected AnchorPane anchorPane ;
    @FXML
    public void menuLivreur(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/livreurs/Delivery.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("WINDOW -> Delivery");
        stage.show();

    }
     /*
    @FXML
    public void menuCommande(ActionEvent event) throws IOException {
        System.out.println("Commande");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/orders/order-view.fxml"));
        anchorPane.getChildren().add(pane);
    }
*/
    // AFFICHE MENU PRODUCTS
    @FXML
    public void menuProduit(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Products/product.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("WINDOW -> Products");
        stage.show();


    }
        // FENETRE AJOUTER PRODUCTS
    @FXML
    public void fieldAddProduit(ActionEvent event) throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Products/add-viewProducts.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("WINDOW -> Add Products");
        stage.show();
    }
        // APPEL SUR AJOUTER PRODUIT
    @FXML
    public void addProduct(ActionEvent event) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(fxname.getText().toString(),
                Long.valueOf(fxprice.getText()),
                Long.valueOf(fxquantity.getText()));
        productDAO.save(product);
        fxLabelAddProduct.setText("added successfully!");
        fxname.setText("");
        fxprice.setText("");
        fxquantity.setText("");
    }

    public void refrechListProduct() throws SQLException {
        ObservableList<Product> data = FXCollections.observableArrayList();
        ProductDAO productDAO = new ProductDAO();
        for (Product product : productDAO.getAll())
        {
            data.add(product);
        }

        fxProductID.setCellValueFactory(new PropertyValueFactory<Product, Long>("id"));
        fxProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        fxProductPrice.setCellValueFactory(new PropertyValueFactory<Product, Long>("price"));
        fxProductStock.setCellValueFactory(new PropertyValueFactory<Product, Long>("stock"));
        fxTableProduct.setItems(data);
    }
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}