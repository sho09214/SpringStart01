package com.example.SpringStart01.repository;

import com.example.SpringStart01.entity.Review;

import java.util.List;

public interface ReviewRepository {
    void add(Review review);

    List<Review> selectByRestaurantId(int restaurantId);

    void update(Review review);
}
