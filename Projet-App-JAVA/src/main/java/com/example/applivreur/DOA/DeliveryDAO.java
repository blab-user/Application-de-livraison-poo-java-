package com.example.applivreur.DOA;

import com.example.applivreur.model.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DeliveryDAO extends BaseDAO<Delivery>{
    public DeliveryDAO() throws SQLException {


        super();
    }

    @Override
    public void save(Delivery object) throws SQLException {

        String request = "insert into livreur (nom , telephone) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getNom());

        this.preparedStatement.setString(2 , object.getTelephone());


        this.preparedStatement.execute();

    }

    @Override
    public void update(Delivery object) throws SQLException {

    }

    @Override
    public void delete(Delivery object) throws SQLException {

    }

    @Override
    public List<Delivery> getAll()  throws SQLException {

        List<Delivery> mylist = new ArrayList<Delivery>();

        String request = "select * from livreur ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Delivery(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) ,
                    this.resultSet.getString(3)));
        }


        return mylist;

    }

    @Override
    public Delivery getOne(Long id) throws SQLException {
        return null;
    }
}
