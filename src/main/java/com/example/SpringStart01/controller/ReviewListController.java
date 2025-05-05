package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.form.ReviewSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReviewListController {

    @PostMapping("/serch-review")
    private String searchReview(@ModelAttribute ReviewSearchForm form,
                                Model model) {
        //テストデータ
        List<Review> list = new ArrayList<>();

        Review review = new Review();
        review.setReviewId(1);
        review.setRestaurantId(1);
        review.setUserId("user1");
        review.setVisitDate(Date.valueOf("2025-05-05"));
        review.setRating(3);
        review.setComment("comment1");

        list.add(review);

        if (list.size() > 0) {
            model.addAttribute("reviewList", list);
        }

        return "review-list";
    }
}
