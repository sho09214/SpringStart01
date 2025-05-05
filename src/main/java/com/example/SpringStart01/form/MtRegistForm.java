package com.example.SpringStart01.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MtRegistForm {

    @Size(min = 1, max = 32, message = "1文字から32文字で入力してください。")
    private String restaurantName;

    @Size(min = 1, max = 64, message = "1文字から64文字で入力してください。")
    private String catchPhrase;
}
