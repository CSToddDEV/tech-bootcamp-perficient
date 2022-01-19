package com.perficient.techbootcampcalvintodd;

//import com.fasterxml.jackson.databind.util.JSONPObject;
//import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BestSellingRestController {

    @GetMapping("/bestsellingrest")
    public BestSelling bestSellingRest() {
        // FUNCTIONS TO PULL DATA FROM DB THIS IS SAMPLE DATA
//        JSONObject data = new JSONObject();
//        data.put("id", 42);
//        data.put("name", "Clasic");
//        data.put("price", 12.26);
//        data.put("brand", "Honest Amish");
//        data.put("date", "2015-05-03");
//        data.put("type", "Beard Oil");

        // Return View
        return new BestSelling(42, "Classic", 12.26, "Honest Amish", "2015-05-03");
    }
}
