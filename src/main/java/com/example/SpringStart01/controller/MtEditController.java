package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.MtRestaurant;
import com.example.SpringStart01.form.MtEditForm;
import com.example.SpringStart01.service.MtEditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MtEditController {

    private final MtEditService service;

    //店舗編集画面リクエスト
    @PostMapping("/mt-show-edit")
    private String mtShowEdit(@ModelAttribute MtEditForm form) {
        return "mt-edit";
    }

    //更新リクエスト（from 店舗編集画面）
    @PostMapping("/mt-edit")
    private String mtEdit(@Validated @ModelAttribute MtEditForm form,
                   BindingResult result) {
        //入力エラーの場合
        if(result.hasErrors()) {
            return "mt-edit";
        }

        //正常の場合、店舗編集確認画面に遷移
        return "mt-confirm-edit";
    }

    //更新リクエスト（from 店舗編集確認画面）
    @PostMapping("/mt-confirm-edit")
    private String mtConfirmEdit(@Validated @ModelAttribute MtEditForm form,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes) {
        //入力エラーの場合
        if(result.hasErrors()) {
            return "mt-edit";
        }

        //DB処理
        MtRestaurant mtRestaurant = new MtRestaurant();
        mtRestaurant.setRestaurantId(form.getRestaurantId());
        mtRestaurant.setRestaurantName(form.getRestaurantName());
        mtRestaurant.setCatchPhrase(form.getCatchPhrase());
        service.edit(mtRestaurant);

        redirectAttributes.addFlashAttribute("mag", "（店舗更新）");
        return "redirect:/mt-complete";
    }
}
