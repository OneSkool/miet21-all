package com.oneskool.restaurants;


import java.util.List;

interface RestaurantRepository {

   List<Restaurant> getAllRestaurant();

   Restaurant getRestaurant(String id);
}
