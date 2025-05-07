package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.Review;
import com.example.SpringStart01.form.ReviewEditForm;
import com.example.SpringStart01.form.ReviewRegistForm;
import com.example.SpringStart01.service.EditService;
import com.example.SpringStart01.service.RegistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class EditController {

    private final EditService service;

    //レビュー編集画面
    @PostMapping("/show-edit-form")
    public String showEditForm(@ModelAttribute ReviewEditForm form) {
        return "edit-review";
    }

    //レビュー更新リクエスト（from 編集画面）
    @PostMapping("/edit-review")
    public String editReview(@Validated @ModelAttribute ReviewEditForm form, BindingResult result) {
        //入力エラーがある場合には、レビュー編集画面に戻す
        if(result.hasErrors()) {
            return "edit-review";
        }
        //正常な場合にレビュー更新確認画面に遷移する
        return "confirm-edit-review";
    }

    //レビュー更新リクエスト（from 更新確認画面）
    @PostMapping("/confirm-edit-review")
    public String confirmEditReview(@Validated ReviewEditForm form,
                                      BindingResult result,
                                      RedirectAttributes redirectAttributes){
        //入力エラーがある場合にはレビュー登録画面に戻す
        if(result.hasErrors()) {
            return "edit-review";
        }

        //DB登録
        Review review = new Review();
        review.setReviewId(form.getReviewId());
        review.setRestaurantId(form.getRestaurantId());
        review.setUserId(form.getUserId());
        review.setVisitDate(form.getVisitDate());
        review.setRating(form.getRating());
        review.setComment(form.getComment());
        service.edit(review);

        redirectAttributes.addFlashAttribute("msg", "(レビュー更新)");
        return "redirect:/complete";
    }
}
