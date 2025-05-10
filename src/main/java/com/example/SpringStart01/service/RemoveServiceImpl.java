package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveServiceImpl implements RemoveService {

    private final ReviewRepository repository;

    @Override
    public void remove(Review review) {
        repository.delete(review);
    }
}
