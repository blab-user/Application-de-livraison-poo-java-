module com.example.applivreur {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.applivreur to javafx.fxml;
    exports com.example.applivreur;
    exports com.example.applivreur.model;
    exports com.example.applivreur.DOA;
    opens com.example.applivreur.model to javafx.fxml;

}