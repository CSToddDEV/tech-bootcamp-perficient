package com.perficient.techbootcampcalvintodd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BestSellingController {

    @GetMapping("/bestselling")
    public String bestSelling(Model model) {
        // FUNCTIONS TO PULL DATA FROM DB THIS IS SAMPLE DATA
        long id = 42;
        String name = "Clasic";
        double price = 12.26;
        String brand = "Honest Amish";
        String date = "2015-05-03";
        String type = "Beard Oil";

        // Add Attributes to Model
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("price", price);
        model.addAttribute("name", name);
        model.addAttribute("brand", brand);
        model.addAttribute("date", date);

        // Return View
        return "best";
    }
}
