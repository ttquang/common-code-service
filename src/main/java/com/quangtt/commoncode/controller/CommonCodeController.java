package com.quangtt.commoncode.controller;

import com.quangtt.commoncode.domain.model.CategoryCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/common-codes")
public class CommonCodeController {

    @GetMapping
    public CategoryCode get() {
        return new CategoryCode();
    }

}
