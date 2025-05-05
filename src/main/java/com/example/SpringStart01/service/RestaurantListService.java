package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.Restaurant;

import java.util.List;

public interface RestaurantListService {
    List<Restaurant> findByNameWildcard(String restaurantName);
}
