package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditServiceImple implements EditService {

    private final ReviewRepository repository;

    @Override
    public void edit(Review review) {
        repository.update(review);
    }
}
