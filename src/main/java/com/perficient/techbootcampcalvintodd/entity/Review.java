package com.perficient.techbootcampcalvintodd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity(name="review")
public class Review {

    // Declarations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long rating;

    @Column(nullable = false)
    private String review_date;

    private String review;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Transient
    private Long product_id;

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Review.class);

    // Constructor Method
    public Review() { }

    // Getter/Setter Methods
    public Long getId() { return this.id; }
    public void setId(Long id ) { this.id = id; }

    public Long getRating() { return this.rating; }
    public void setRating(Long rating ) { this.rating = rating; }

    public String getReview_date() { return this.review_date; }
    public void setReview_date(String review_date ) { this.review_date = review_date; }

    public String getReview() { return this.review; }
    public void setReview(String review ) { this.review = review; }

    public Long getProduct_id() { return this.product_id; }
    public void setProduct_id(Long product_id ) { this.product_id = product_id; }

    public Product getProduct() { return this.product; }
    public void setProduct( Product product ) { this.product = product; }

}
