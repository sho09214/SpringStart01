package com.example.SpringStart01.repository;

import com.example.SpringStart01.entity.MtRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MtRestaurantRepositoryImpl implements MtRestaurantRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void add(MtRestaurant r) {

        //DB登録
        String sql =
                "INSERT INTO m_restaurant" +
                "(restaurant_name, catch_phrase)" +
                "VALUES(?, ?)";

        jdbcTemplate.update(sql,
                            r.getRestaurantName(),
                            r.getCatchPhrase());
    }
}
