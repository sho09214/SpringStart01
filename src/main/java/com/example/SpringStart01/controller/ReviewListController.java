package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.form.ReviewSearchForm;
import com.example.SpringStart01.service.ReviewListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewListController {

    private final ReviewListService service;

    @PostMapping("/search-review")
    private String searchReview(@ModelAttribute ReviewSearchForm form,
                                Model model) {
        //テストデータ
        List<Review> list = service.findByRestaurantId(form.getRestaurantId());

        if (list.size() > 0) {
            model.addAttribute("reviewList", list);
        }

        return "review-list";
    }
}
