package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {
    private final ReviewRepository repository;

    @Override
    public void regist(Review review) {
        repository.add(review);
    }
}
