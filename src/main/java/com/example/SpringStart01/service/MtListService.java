package com.example.SpringStart01.service;

import com.example.SpringStart01.entity.MtRestaurant;
import java.util.List;

public interface MtListService {

    List<MtRestaurant> findByNameWildcard(String restaurantName);
}
