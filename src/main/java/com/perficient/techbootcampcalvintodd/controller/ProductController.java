package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.repository.ProductRepository;
import com.perficient.techbootcampcalvintodd.entity.Product;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> all() {
        return repository.findAll();
    }

}
