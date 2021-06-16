package com.oneskool.restaurants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private RestaurantRepository repository;


    @GetMapping("")
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = repository.getAllRestaurant();
        log.info("restaurants " + restaurants);

        return restaurants;
    }


    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable("id") String id) {
        return repository.getRestaurant(id);
    }



}
