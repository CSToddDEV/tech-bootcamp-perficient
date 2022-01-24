package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.aspect.LogExecutionTimeInt;
import com.perficient.techbootcampcalvintodd.entity.Brand;
import com.perficient.techbootcampcalvintodd.exceptions.BrandNotFound;
import com.perficient.techbootcampcalvintodd.service.BOBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    BOBService service;

    BrandController() { }

    @GetMapping("/brands")
    @LogExecutionTimeInt
    List<Brand> getAll() {
        return (List<Brand>) service.findAllBrands();
    }

    @GetMapping("/brands/{id}")
    @LogExecutionTimeInt
    Brand getBrand(@PathVariable Long id) {
        return service.findBrand(id)
                .orElseThrow(() -> new BrandNotFound(id));
    }

    @PostMapping("/brands")
    @LogExecutionTimeInt
    void createBrand(@RequestBody Brand brand) { service.createBrand(brand); }

    @PutMapping("/brands/{id}")
    @LogExecutionTimeInt
    void updateBrand(@PathVariable Long id, @RequestBody Brand new_brand) { service.updateBrand(id, new_brand);}

//    @DeleteMapping("/brands/{id}")
//    @LogExecutionTimeInt
//    void deleteBrand(@PathVariable Long id) { repository.deleteById(id); }

}

