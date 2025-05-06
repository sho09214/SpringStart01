package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewListServiceImpl implements ReviewListService {

    private final ReviewRepository repository;

    @Override
    public List<Review> findByRestaurantId(int restaurantId) {
        List<Review> list = repository.selectByRestaurantId(restaurantId);
        return list;
    }
}
