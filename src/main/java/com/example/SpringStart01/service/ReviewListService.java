package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.Review;

import java.util.List;

public interface ReviewListService {

    List<Review> findByRestaurantId(int restaurantId);
}
