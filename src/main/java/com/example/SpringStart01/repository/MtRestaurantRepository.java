package com.example.SpringStart01.repository;

import com.example.SpringStart01.entity.MtRestaurant;

import java.util.List;

public interface MtRestaurantRepository {
    void add(MtRestaurant r);

    List<MtRestaurant> selectByNameWildcard(String restaurantName);
}
