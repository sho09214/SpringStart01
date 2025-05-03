package com.example.SpringStart01.repository;

import com.example.SpringStart01.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void add(Review review) {

        String sql =
                "INSERT INTO t_review" +
                "(restaurant_id, user_id, visit_date, rating, comment)" +
                "VALUES(?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                            review.getRestaurantId(),
                            review.getUserId(),
                            review.getVisitDate(),
                            review.getRating(),
                            review.getComment());
    }
}
