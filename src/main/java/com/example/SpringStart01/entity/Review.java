package com.example.SpringStart01.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Review {
    private Integer reviewId;
    private Integer restaurantId;
    private String userId;
    private Date visitDate;
    private Integer rating;
    private String comment;
}
