package com.oneskool.restaurants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
@ControllerAdvice
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final Logger log = LogManager.getLogger(this.getClass());

    private List<Restaurant> restaurants = List.of(
            new Restaurant("1", Restaurant.REST_TYPE.INDIAN, "Paradise Biryani", "We have best Hyderabadi dishes...."),
            new Restaurant("2", Restaurant.REST_TYPE.INDIAN,"Authentic Kashmiri Cuisine", "Flavors of the great state of Jammu and Kashmir...."),
            new Restaurant("3", Restaurant.REST_TYPE.CHINESE,"China 88", "Real Szechuan dishes ...."),
            new Restaurant("4", Restaurant.REST_TYPE.CHINESE, "Yen's Cafe", "Taiwanese-style Chinese food ...")
    );


    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurants;
    }

    @Override
    public Restaurant getRestaurant(String id) {
        //try {
            return restaurants.stream()
                    .filter(r -> {
                        log.info("R.id=" + r.getId() + " id=" + id);
                        return r.getId().equals(id);
                    })
                    .collect(toList())
                    .get(0);
//        } catch (Exception e) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Restaurant Not Found for the Id " + id, e);
//        }
    }
}
