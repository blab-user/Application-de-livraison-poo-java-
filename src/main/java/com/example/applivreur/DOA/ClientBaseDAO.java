package com.example.applivreur.DOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class ClientBaseDAO<T> {
    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;
    private String url = "jdbc:mysql://localhost:3307/Livraison";
    private String login = "root";
    private String password = "";

    ClientBaseDAO() throws SQLException {
        this.connection = DriverManager.getConnection(this.url, this.login, this.password);
    }

    public static Connection getConnect() {

        return null;
    }

    public abstract void save(T var1) throws SQLException;

    public abstract void update(T var1) throws SQLException;

    public abstract void delete(T var1) throws SQLException;


    public abstract List<T> getAll() throws SQLException;

    public abstract T getOne(Long var1) throws SQLException;
}
