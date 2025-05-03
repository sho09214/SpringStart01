package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.repository.RegistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {
    private final RegistRepository repository;

    @Override
    public void regist(Review review) {
        repository.add(review);
    }
}
