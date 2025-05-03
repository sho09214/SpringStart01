package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.form.ReviewRegistForm;
import com.example.SpringStart01.service.RegistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final RegistService service;

    //レビュー登録画面
    @GetMapping("/show-review-form")
    public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
        return "regist-review";
    }

    //レビュー登録画面（確認画面からの戻り）
    @PostMapping("/show-review-form-ret")
    public String showReviewRegistRet(@ModelAttribute ReviewRegistForm form) {
        return "regist-review"
    }

    //レビュー登録リクエスト（from 登録画面）
    @PostMapping("/regist-review")
    public String registReview(@Validated @ModelAttribute ReviewRegistForm form, BindingResult result) {
        //入力エラーがある場合には、レビュー登録画面に戻す
        if(result.hasErrors()) {
            return "regist-review";
        }
        //正常な場合にレビュー登録確認画面に遷移する
        return "confirm-regist-review";
    }

    //レビュー登録リクエスト（from 登録確認画面）
    @PostMapping("/confirm-regist-review")
    public String confirmRegistReview(@Validated ReviewRegistForm form, BindingResult result, Model model){
        //入力エラーがある場合にはレビュー登録画面に戻す
        if(result.hasErrors()) {
            return "regist-review";
        }

        //DB登録
        Review r = new Review();
        r.setRestaurantId(form.getRestaurantId());
        r.setUserId(form.getUserId());
        r.setVisitDate(form.getVisitDate());
        r.setRating(form.getRating());
        r.setComment(form.getComment());
        service.regist(r);

        model.addAttribute("msg", "レビュー登録が完了しました。");
        return "complete-regist-review";
    }
}
