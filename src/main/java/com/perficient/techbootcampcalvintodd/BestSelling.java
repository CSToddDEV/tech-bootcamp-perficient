package com.perficient.techbootcampcalvintodd;

public class BestSelling extends Product{

    // Declarations
    String date;

    // Constructor
    public BestSelling(long id, String name, double price, String brand, String date) {
        super(id, name, price, brand, date);
        this.date = date;
    }

    // Getter and Setters
    public String getDate() {
        return this.date;
    }
}
