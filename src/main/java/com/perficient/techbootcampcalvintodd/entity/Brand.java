package com.perficient.techbootcampcalvintodd.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name= "brand")
public class Brand {

    // Declarations
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String brand_name;

    @Column(unique = true)
    private String brand_site;

    @Column(unique = true)
    private String phone;

    private Long top_seller;

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Brand.class);

    // Constructor Method
    public Brand() { }

    // Getter/Setter Methods
    public Long getId() { return id; }
    public void setId(Long BrandID ) { this.id = BrandID; }

    public String getBrand_name() { return brand_name; }
    public void setBrand_name(String BrandName ) { this.brand_name = BrandName; }

    public String getBrand_site() { return brand_site; }
    public void setBrand_site(String BrandSite ) { this.brand_site = BrandSite; }

    public String getPhone() { return phone; }
    public void setPhone( String Phone ) { this.phone = Phone; }

    public Long getTop_seller() { return top_seller; }
    public void setTop_seller(Long TopSeller ) { this.top_seller = TopSeller; }
}
