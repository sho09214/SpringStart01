package com.example.SpringStart01.repository;

import com.example.SpringStart01.entity.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> selectByNameWildcard(String restaurantName);
}
