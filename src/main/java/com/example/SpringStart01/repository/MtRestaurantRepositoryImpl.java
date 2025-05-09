package com.example.SpringStart01.repository;

import com.example.SpringStart01.entity.MtRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<MtRestaurant> selectByNameWildcard(String restaurantName) {

        String sql =
                "SELECT mr.restaurant_id, mr.restaurant_name, mr.catch_phrase, COUNT(tr.rating) rating_cnt" +
                " FROM m_restaurant mr" +
                " LEFT OUTER JOIN t_review tr ON mr.restaurant_id = tr.restaurant_id" +
                " WHERE mr.restaurant_name LIKE ?" +
                " GROUP BY mr.restaurant_id, mr.restaurant_name, mr.catch_phrase" +
                " ORDER BY mr.restaurant_id" ;

        String p = "%" + restaurantName + "%"; //プレースホルダ値

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, p);

        List<MtRestaurant> result = new ArrayList<>();
        for(Map<String, Object> one : list) {
            MtRestaurant mtRestaurant = new MtRestaurant();
            mtRestaurant.setRestaurantId((int)one.get("restaurant_id"));
            mtRestaurant.setRestaurantName((String)one.get("restaurant_name"));
            mtRestaurant.setCatchPhrase((String)one.get("catch_phrase"));
            mtRestaurant.setReviewCnt(((Long)one.get("rating_cnt")).intValue());
            result.add(mtRestaurant);
        }

        return result;
    }

    @Override
    public void update(MtRestaurant mtRestaurant) {
        String sql =
                "UPDATE m_restaurant" +
                " SET restaurant_name = ?, catch_phrase = ?" +
                " WHERE restaurant_id = ?" ;

        jdbcTemplate.update(
                sql,
                mtRestaurant.getRestaurantName(),
                mtRestaurant.getCatchPhrase(),
                mtRestaurant.getRestaurantId()
        );
    }
}
