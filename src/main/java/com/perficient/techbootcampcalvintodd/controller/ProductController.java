package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.aspect.LogExecutionTime;
import com.perficient.techbootcampcalvintodd.aspect.LogExecutionTimeInt;
import com.perficient.techbootcampcalvintodd.entity.Product;
import com.perficient.techbootcampcalvintodd.exceptions.ProductNotFound;
import com.perficient.techbootcampcalvintodd.service.BOBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    BOBService service;

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(LogExecutionTime.class);

    ProductController() { }

    @GetMapping("/products")
    @LogExecutionTimeInt
    public List<Product> getAll() {
        return (List<Product>) service.findAllProducts();
    }

    @GetMapping("/products/{id}")
    @LogExecutionTimeInt
    public Product getProduct(@PathVariable Long id) {
        return service.findProduct(id)
                .orElseThrow(() -> new ProductNotFound(id));
    }

    @PostMapping("/products")
    @LogExecutionTimeInt
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        if (service.createProduct(product).getClass() == Product.class) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/{id}")
    @LogExecutionTimeInt
    void replaceProduct(@PathVariable Long id, @RequestBody Product new_product) {
        service.changeProduct(id, new_product); }

    @DeleteMapping("/products/{id}")
    @LogExecutionTimeInt
    void deleteProduct(@PathVariable Long id) { service.deleteProduct(id); }

    @GetMapping("/products/{id}/reviews")
    @LogExecutionTimeInt
    List<?> productReviews(@PathVariable Long id) {return service.productReviews(id);}

}
