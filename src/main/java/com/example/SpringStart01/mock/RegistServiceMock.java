package com.example.SpringStart01.mock;

import com.example.SpringStart01.service.RegistService;
import org.springframework.stereotype.Service;

//@Service
public class RegistServiceMock implements RegistService {
    @Override
    public String regist() {
        return "テスト的に動きました。";
    }
}
