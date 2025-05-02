package com.example.SpringStart01.service;

import org.springframework.stereotype.Service;

@Service
public class RegistServiceImpl implements RegistService {
    @Override
    public String regist() {
        return "レビュー登録が完了しました。";
    }
}
