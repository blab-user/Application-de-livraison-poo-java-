package com.example.applivreur.model;

import com.example.applivreur.DOA.ProductDAO;

import java.sql.SQLException;
import java.util.List;

public class TestDelivery {
    public static void main(String[] args) {

// trait bloc try catch
        try {


            ProductDAO productDAO = new ProductDAO();


            List<Product> livlist =  productDAO.getAll();

            for (Product liv :livlist) {

                System.out.println(liv);

            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());        }

    }
}
