package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.form.ReviewEditForm;
import com.example.SpringStart01.form.ReviewRemoveForm;
import com.example.SpringStart01.service.EditService;
import com.example.SpringStart01.service.RemoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class RemoveController {

    private final RemoveService service;

    //レビュー削除リクエスト（from 一覧画面）
    @PostMapping("/remove-review")
    public String removeReview(@Validated @ModelAttribute ReviewRemoveForm form, BindingResult result) {
        //入力エラーがある場合には、レビュー編集画面に戻す
        if(result.hasErrors()) {
            throw new IllegalArgumentException("**removeReview()**");
        }
        //正常な場合にレビュー削除確認画面に遷移する
        return "confirm-remove-review";
    }

    //レビュー削除リクエスト（from 削除確認画面）
    @PostMapping("/confirm-remove-review")
    public String confirmRemoveReview(@Validated ReviewRemoveForm form,
                                      BindingResult result,
                                      RedirectAttributes redirectAttributes){
        //入力エラーがある場合にはレビュー登録画面に戻す
        if(result.hasErrors()) {
            throw new IllegalArgumentException("**removeReview()**");
        }

        //DB登録
        Review review = new Review();
        review.setReviewId(form.getReviewId());
        review.setRestaurantId(form.getRestaurantId());
        review.setUserId(form.getUserId());
        review.setVisitDate(form.getVisitDate());
        review.setRating(form.getRating());
        review.setComment(form.getComment());
        service.remove(review);

        redirectAttributes.addFlashAttribute("msg", "(レビュー削除)");
        return "redirect:/complete";
    }
}
