package com.example.SpringStart01.controller;

import com.example.SpringStart01.form.ReviewRegistForm;
import com.example.SpringStart01.mock.RegistServiceMock;
import com.example.SpringStart01.service.RegistService;
import com.example.SpringStart01.service.RegistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {
    private final RegistService service;

    @Autowired
    public ReviewController(RegistService service) {
        this.service = service;
    }


    /* --- レビュー登録画面 ---*/
    @GetMapping("/show-review-form")
    public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
        return "regist-review";
    }

    /* --- レビュー登録画面（確認画面からの戻り） --- */
    @PostMapping("/show-review-form-ret")
    public String showReviewFormRet(@ModelAttribute ReviewRegistForm form) {
        return "regist-review";
    }

    /* --- レビュー登録リクエスト（登録画面より） --- */
    @PostMapping("/regist-review")
    public String registReview(@Validated @ModelAttribute ReviewRegistForm form, BindingResult result) {
        //入力エラーがある場合には、レビュー登録画面に戻す
        if (result.hasErrors()) {
            return "show-review-form";
        }

        //正常な場合に、レビュー登録画面に遷移する
        return "confirm-regist-review";
    }

    /* --- レビュー登録リクエスト（登録確認画面より） --- */
    @PostMapping("/confirm-regist-review")
    public String confirmRegistReview(@Validated ReviewRegistForm form, BindingResult result, Model model) {
        //入力エラーがある場合にはレビュー登録画面に戻す
        if (result.hasErrors()) {
            return "regist-review";
        }

        // ここでDB登録を行う

//        RegistService service = new RegistServiceImpl();
//        RegistService service = new RegistServiceMock();
        String msg = service.regist();

        model.addAttribute("msg", msg);
        return "complete-regist-review";
    }
}
