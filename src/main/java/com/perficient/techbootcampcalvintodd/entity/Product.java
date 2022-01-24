package com.perficient.techbootcampcalvintodd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity(name = "product")
public class Product {

    // Declarations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand_id;

    @Transient
    private Long brand;

    private String product_name;

    @Column(nullable = false)
    private String product_type;

    @Column(nullable = false)
    private Double price;

    private Long sold;

    private Double rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;

    // Constructor
    public Product() {}

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    // Getter/Setter Methods
    public Long getId() { return this.id; }
    public void setId(Long ProductID ) { this.id = ProductID; }

    public Brand getBrand_id() { return this.brand_id; }
    public void setBrand_id (Brand BrandID ) {this.brand_id = BrandID;}

    public Long getBrand() { return this.brand; }
    public void setBrand (Long brand) {this.brand = brand;}

    public String getProduct_name() { return this.product_name; }
    public void setProduct_name(String ProductName ) { this.product_name = ProductName; }

    public String getProduct_type() { return this.product_type; }
    public void setProduct_type(String ProductType ) { this.product_type = ProductType; }

    public Double getPrice() { return this.price; }
    public void setPrice( Double price ) { this.price = price; }

    public Long getSold() { return this.sold; }
    public void setSold( Long sold ) { this.sold = sold; }

    public Double getRating() { return this.rating; }
    public void setRating( Double rating ) { this.rating = rating; }

}
