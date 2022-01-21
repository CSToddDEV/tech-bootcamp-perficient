package com.perficient.techbootcampcalvintodd.exceptions;

public class ProductNotFound extends RuntimeException{

    public ProductNotFound(Long id) {
        super("The following ID does not exist in the Product Table: " + id);
    }
}
