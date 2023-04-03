package com.example.applivreur.model;

public class Product {

    public Long id;
    public String name;
    public Long price;
    public Long stock;


    public Product()
    {
        super();
    }
    public Product(String xName,
                   Long xPrice,
                   Long xStock)
    {
        this.name = xName;
        this.stock = xStock;
        this.price = xPrice;
    }

    public Product(Long xId,
                   String xName,
                   Long xPrice,
                   Long xStock)
    {
        this.id = xId;
        this.name = xName;
        this.stock = xStock;
        this.price = xPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }



}
