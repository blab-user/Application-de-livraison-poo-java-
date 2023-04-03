package com.example.applivreur.DOA;

import com.example.applivreur.model.Delivery;
import com.example.applivreur.model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends  BaseDAO<Product> {

    public ProductDAO() throws SQLException {
        super();
    }

    @Override
    public void save(Product object) throws SQLException {
        String request = "insert into produit (nom , stock, prix) values (? , ? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getName());

        this.preparedStatement.setLong(2 , object.getStock());

        this.preparedStatement.setLong(3 , object.getPrice());
        this.preparedStatement.execute();

    }

    @Override
    public void update(Product object) throws SQLException {

    }

    @Override
    public void delete(Product object) throws SQLException {

    }

    @Override
    public void update(Delivery object) throws SQLException {

    }

    @Override
    public void delete(Delivery object) throws SQLException {

    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> list = new ArrayList<>();

        String request = "select * from produit";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            list.add(new Product(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) ,
                    this.resultSet.getLong(3),
                    this.resultSet.getLong(4)));
        }
        return list;
    }

    @Override
    public Product getOne(Long id) throws SQLException {
        return null;
    }


}
