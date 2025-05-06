package com.example.SpringStart01.entity;

import lombok.Data;

@Data
public class MtRestaurant {
    private int restaurantId;
    private String restaurantName;
    private String catchPhrase;
    private int reviewCnt;
}
