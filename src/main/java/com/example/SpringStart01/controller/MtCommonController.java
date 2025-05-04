package com.example.SpringStart01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MtCommonController {

    //管理メニュー画面
    @GetMapping("/mt-top")
    private String mtTop(){ return "mt-top"; }

    //完了後のリダイレクト先
    @GetMapping("/mt-complete")
    private String mtComplete() { return "mt-complete"; }
}
