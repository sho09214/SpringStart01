package com.example.SpringStart01.form;

import lombok.Data;

import java.sql.Date;

@Data
public class ReviewRegistForm {
    private Integer restaurantId;
    private String userId;
    private Date visitDate;
    private Integer rating;
    private String comment;
}
