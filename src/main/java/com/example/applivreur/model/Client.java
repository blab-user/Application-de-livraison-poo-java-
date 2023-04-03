package com.example.applivreur.model;

import java.util.Date;

public class Client {
    private Long id ;
    private String name ;
    private String phone ;

    private String email ;
    private String products ;
    private String delivery ;

    private String adress;
    public Client( String name,
                   String phone,
                   String email,
                   String products,
                   String delivery,
                   String adress)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;

        this.email = email;
        this.products = products;
        this.delivery = delivery;
        this.adress = adress;
    }

    public Client   (long id,
                     String name,
                     String phone,
                     String email,
                     String products,
                     String delivery,
                     String adress)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.products= products;
        this.delivery = delivery;
        this.adress = adress;
    }

    public Long getId(){ return id;}

    public void setId(Long id){this.id = id;}


    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public String getPhone() {return this.phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getAdress() {return this.adress;}

    public void setAdress(String adress) {this.adress = adress;}

    public String getEmail() {return this.email;}

    public void setEmail(String email) {this.email = email;}

    public String getProducts() {return this.products;}

    public void setProducts(String products) {this.products = products;}

    public String getDelivery() {return this.delivery;}

    public void setDelivery(String delivery) {this.delivery = delivery;}


}