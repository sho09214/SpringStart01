package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.MtRestaurant;
import com.example.SpringStart01.form.MtRegistForm;
import com.example.SpringStart01.service.MtRegistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MtRegistController {
    private final MtRegistService service;

    //管理メニュー店舗登録画面
    @PostMapping("/mt-show-regist")
    public String mtShowRegist() {
        return "mt-regist";
    }

    //登録リクエスト（登録画面より）
    @PostMapping("/mt-regist")
    public String mtRegist(@Validated  @ModelAttribute MtRegistForm form,
                           BindingResult result){
        //入力エラーの場合、管理メニュー店舗登録画面に遷移
        if(result.hasErrors()) {
            return "mt-regist";
        }
        //正常の場合には管理メニュー店舗登録確認画面に遷移
        return "mt-confirm-regist";
    }

    //登録リクエスト（登録確認画面より）
    @PostMapping("/mt-confirm-regist")
    public String mtConfirmRegist(@Validated @ModelAttribute MtRegistForm form,
                                  BindingResult result,
                                  RedirectAttributes redirectAttributes){
        //入力エラーの場合
        if(result.hasErrors()){
            return "mt-regist";
        }

        //DB登録
        MtRestaurant r = new MtRestaurant();
        r.setRestaurantName(form.getRestaurantName());
        r.setCatchPhrase(form.getCatchPhrase());
        service.regist(r);

        redirectAttributes.addFlashAttribute("msg", "(店舗登録)");
        return "redirect:/mt-complete";
    }
}
