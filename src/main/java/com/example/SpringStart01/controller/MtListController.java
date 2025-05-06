package com.example.SpringStart01.controller;

import com.example.SpringStart01.entity.MtRestaurant;
import com.example.SpringStart01.form.MtSearchForm;
import com.example.SpringStart01.service.MtListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MtListController {

    private final MtListService service;

    //検索画面
    @PostMapping("/mt-show-list")
    private String mtShowList(@ModelAttribute MtSearchForm form) {
        return "mt-list";
    }

    //検索リクエスト
    @PostMapping("/mt-search")
    private String mtSearch(@ModelAttribute MtSearchForm form,
                            Model model) {

        List<MtRestaurant> list = service.findByNameWildcard(form.getRestaurantName());

        if (list.size() > 0) {
            model.addAttribute("mtRestaurantList", list);
        }

        return "mt-list";
    }
}
