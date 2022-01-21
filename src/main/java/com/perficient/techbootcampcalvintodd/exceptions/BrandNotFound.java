package com.perficient.techbootcampcalvintodd.exceptions;

public class BrandNotFound extends RuntimeException{

    public BrandNotFound(Long id) {
        super("The following ID does not exist in the Brand Table: " + id);
    }
}
