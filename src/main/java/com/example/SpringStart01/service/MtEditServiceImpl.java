package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.MtRestaurant;
import com.example.SpringStart01.repository.MtRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MtEditServiceImpl implements  MtEditService {

    private final MtRestaurantRepository repository;

    @Override
    public void edit(MtRestaurant mtRestaurant) {
        repository.update(mtRestaurant);
    }
}
