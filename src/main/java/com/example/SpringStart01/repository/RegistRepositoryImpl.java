package com.example.SpringStart01.repository;

import com.example.SpringStart01.entity.Review;
import org.springframework.stereotype.Repository;

@Repository
public class RegistRepositoryImpl implements RegistRepository{
    @Override
    public void add(Review review) {
        //DB登録
    }
}
