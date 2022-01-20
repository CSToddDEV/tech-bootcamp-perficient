package com.perficient.techbootcampcalvintodd.entity;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.persistence.*;

@Entity(name = "product")
public class Product {

    // Declarations
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long brand_id;

    private String product_name;

    @Column(nullable = false)
    private String product_type;

    @Column(nullable = false)
    private Double price;

    private Long sold;

    private Double rating;

    private Long recent_review;

    // Constructor
    public Product() {}

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    // Getter/Setter Methods
    public Long getId() { return id; }
    public void setId(Long ProductID ) { this.id = ProductID; }

    public Long getBrand() { return brand_id; }
    public void setBrand_id(Long BrandID ) { this.id = BrandID; }

    public String getProduct_name() { return product_name; }
    public void setProduct_name(String ProductName ) { this.product_name = ProductName; }

    public String getProduct_type() { return product_type; }
    public void setProduct_type(String ProductType ) { this.product_type = ProductType; }

    public Double getPrice() { return price; }
    public void setPrice( Double Price ) { this.price = Price; }

    public Long getSold() { return sold; }
    public void setSold( Long Sold ) { this.sold = Sold; }

    public Double getRating() { return rating; }
    public void setRating( Double Rating ) { this.price = Rating; }

    public Long getRecent_review() { return recent_review; }
    public void setRecent_review(Long RecentReview ) { this.recent_review = RecentReview; }

}
