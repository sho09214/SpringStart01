package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.MtRestaurant;
import com.example.SpringStart01.repository.MtRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MtListServiceImpl implements MtListService {

    private final MtRestaurantRepository repository;

    @Override
    public List<MtRestaurant> findByNameWildcard(String restaurantName) {
        List<MtRestaurant> list = repository.selectByNameWildcard(restaurantName);

        return list;
    }
}
