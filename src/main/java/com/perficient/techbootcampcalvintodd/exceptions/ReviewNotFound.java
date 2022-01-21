package com.perficient.techbootcampcalvintodd.exceptions;

public class ReviewNotFound extends RuntimeException{

    public ReviewNotFound(Long id) {
        super("The following ID does not exist in the Review Table: " + id);
    }
}
