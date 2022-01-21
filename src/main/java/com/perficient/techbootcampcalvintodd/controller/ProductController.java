package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.aspect.LogExecutionTimeInt;
import com.perficient.techbootcampcalvintodd.exceptions.ProductNotFound;
import com.perficient.techbootcampcalvintodd.repository.ProductRepository;
import com.perficient.techbootcampcalvintodd.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    @LogExecutionTimeInt
    List<Product> getAll() {
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    @LogExecutionTimeInt
    Product getProduct(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));
    }

    @PostMapping("/products")
    @LogExecutionTimeInt
    Product createProduct(@RequestBody Product product) { return repository.save(product); }

    @PutMapping("/products/{id}")
    @LogExecutionTimeInt
    Product replaceProduct(@PathVariable Long id, @RequestBody Product new_product) {
        return repository.findById(id)
                .map( product -> {
                    product.setProduct_name(new_product.getProduct_name());
                    product.setBrand_id(new_product.getBrand());
                    product.setProduct_type(new_product.getProduct_type());
                    product.setPrice(new_product.getPrice());
                    product.setSold(new_product.getSold());
                    product.setRating(new_product.getRating());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    new_product.setId(id);
                    return repository.save(new_product);
                });
    }

    @DeleteMapping("/products/{id}")
    @LogExecutionTimeInt
    void deleteProduct(@PathVariable Long id) { repository.deleteById(id); }

}
