package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.Restaurant;
import com.example.SpringStart01.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantListServiceImpl implements RestaurantListService{

    private final RestaurantRepository repository;

    @Override
    public List<Restaurant> findByNameWildcard(String restaurantName) {

        List<Restaurant> list = repository.selectByNameWildcard(restaurantName);

        return list;
//        return repository.selectByNameWildcard(restaurantName);
    }
}
