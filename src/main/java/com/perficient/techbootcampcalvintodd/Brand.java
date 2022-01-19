package com.perficient.techbootcampcalvintodd;

import java.util.HashMap;

public class Brand {

    // Declarations
    String name;
    String url;
    HashMap<String, Product> products;

    // Constructor Method
    public Brand(String name) {
        this.name = name;
    }

    // Getter Methods
    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public int getNumberProducts() {
        return this.products.size();
    }

    // Setter Methods
    public void setUrl(String url) {
        this.url = url;
    }

    public void addProduct(long id, String name, double price, String brand, String type) {
        Product new_product = new Product(id, name, price, brand, type);
        this.products.put(new_product.getName(), new_product);
    }

}
