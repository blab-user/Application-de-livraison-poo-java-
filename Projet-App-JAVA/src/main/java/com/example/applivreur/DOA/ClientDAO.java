package com.example.applivreur.DOA;


import com.example.applivreur.model.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends ClientBaseDAO<Client>{

    public ClientDAO() throws SQLException {
        super();

    }

    @Override
    public void save(Client var1) throws SQLException {
    String request = "insert into Client( name, phone, adress, email, products, delivery) values(? , ?, ?, ?, ?, ?)";
        // maping object table
    this.preparedStatement = this.connection.prepareStatement((request));

    this.preparedStatement.setString(1, var1.getName());

        this.preparedStatement.setString(2, var1.getPhone());
        this.preparedStatement.setString(3, var1.getAdress());
        this.preparedStatement.setString(4, var1.getEmail());

        this.preparedStatement.setString(5, var1.getProducts());
        this.preparedStatement.setString(6, var1.getDelivery());

        this.preparedStatement.execute();

    }

    @Override
    public void update(Client var1) throws SQLException {

    }

    @Override
    public void delete(Client var1) throws SQLException {

    }

    @Override
    public List<Client> getAll() throws SQLException {
        List<Client> mylist = new ArrayList<>();
        String request = "SELECT * FROM Client";

        this.statement = this.connection.createStatement();

        this.resultSet = this.statement.executeQuery(request);

        while(this.resultSet.next()){
            // the mapping tab o
           mylist.add(new Client(this.resultSet.getLong(1),
                   this.resultSet.getString(2),
                   this.resultSet.getString(3),
                   this.resultSet.getString(4),
                   this.resultSet.getString(5),
                   this.resultSet.getString(6),
                   this.resultSet.getString(7)));

        }

        return mylist;
    }
    public Client getOne(Long id) throws SQLException {
        return null;
    }
}
