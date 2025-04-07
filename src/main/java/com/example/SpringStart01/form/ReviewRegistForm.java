package com.example.SpringStart01.form;

import lombok.Data;

import java.sql.Date;

@Data
public class ReviewRegistForm {
    private Integer resutaurantId;
    private String userId;
    private Date visitDate;
    private Integer rating;
    private String comment;
}
