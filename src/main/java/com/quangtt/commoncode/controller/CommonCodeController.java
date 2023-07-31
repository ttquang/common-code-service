package com.quangtt.commoncode.controller;

import com.quangtt.commoncode.common.error.InternalServerError;
import com.quangtt.commoncode.domain.model.CategoryCode;
import com.quangtt.commoncode.domain.service.CommonCodeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/common-codes")
@AllArgsConstructor
public class CommonCodeController {

    CommonCodeService commonCodeService;

    @GetMapping
    public Page<CategoryCode> getAll() {
        Page<CategoryCode> page = new PageImpl<>(List.of(new CategoryCode(), new CategoryCode(), new CategoryCode()));
        return page;
    }

    @GetMapping("{code}")
    public CategoryCode get(@PathVariable String code) {
        return commonCodeService.getByCode(code);
    }

    @GetMapping("/errors/500")
    public List<CategoryCode> error500() {
        throw new InternalServerError("Internal Server Error");
    }

}
