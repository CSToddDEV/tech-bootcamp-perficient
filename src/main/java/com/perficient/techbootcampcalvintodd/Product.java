package com.perficient.techbootcampcalvintodd;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Product {

    // Declarations
    long id;
    String name;
    String brand;
    double price;
    String type;

    // Constructor Method
    public Product(long id, String name, double price, String brand, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.type = type;
        LOGGER.info("Product created");
    }

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    // Getter Methods
    public long getId() { return this.id; }

    public String getBrand() { return this.brand; }

    public String getType() { return this.type; }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        if (this.price < 0) {
            LOGGER.error("Item Price is negative");
        }
        return this.price;
    }

    public Product getProduct() {
        return this;
    }
}
