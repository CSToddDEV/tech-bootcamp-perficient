package com.perficient.techbootcampcalvintodd;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Product {

    // Declarations
    String name;
    double price;

    // Constructor Method
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        LOGGER.info("Product created");
    }

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    // Getter Methods
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
