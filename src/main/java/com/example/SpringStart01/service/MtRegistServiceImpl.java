package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.MtRestaurant;
import com.example.SpringStart01.repository.MtRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MtRegistServiceImpl implements MtRegistService {
    private final MtRestaurantRepository repository;

    @Override
    public void regist(MtRestaurant r) {
        repository.add(r);
    }
}
