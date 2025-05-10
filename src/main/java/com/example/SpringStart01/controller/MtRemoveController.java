package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.MtRestaurant;
import com.example.SpringStart01.form.MtRemoveForm;
import com.example.SpringStart01.service.MtRemoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MtRemoveController {

    private final MtRemoveService service;

    //削除リクエスト（from 店舗一覧画面）
    @PostMapping("/mt-remove")
    private String mtRemove(@Validated @ModelAttribute MtRemoveForm form,
                            BindingResult result) {
        //エラーの場合
        if(result.hasErrors()) {
            throw new IllegalArgumentException("**removeRestaurant()**");
        }
        //正常の場合、削除確認画面に遷移
        return "mt-confirm-remove";
    }

    //削除リクエスト(from 削除確認画面)
    @PostMapping("/mt-confirm-remove")
    private String mtConfirmRemove(@Validated @ModelAttribute MtRemoveForm form,
                                   BindingResult result,
                                   RedirectAttributes redirectAttributes) {
        //入力エラーの場合
        if(result.hasErrors()) {
            throw new IllegalArgumentException("**removeRestaurant()**");
        }

        //DB処理
        MtRestaurant mtRestaurant = new MtRestaurant();
        mtRestaurant.setRestaurantId(form.getRestaurantId());
        mtRestaurant.setRestaurantName(form.getRestaurantName());
        mtRestaurant.setCatchPhrase(form.getCatchPhrase());
        service.remove(mtRestaurant);

        redirectAttributes.addFlashAttribute("msg", "(店舗削除)");

        return "redirect:/mt-complete";
    }
}
