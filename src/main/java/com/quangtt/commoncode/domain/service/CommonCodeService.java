package com.quangtt.commoncode.domain.service;

import com.quangtt.commoncode.common.error.CategoryNotFoundException;
import com.quangtt.commoncode.infrastructure.model.CategoryCode;
import com.quangtt.commoncode.infrastructure.repository.CategoryCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommonCodeService {
    CategoryCodeRepository categoryCodeRepository;

    public CategoryCode getByCode(String code) {
        return categoryCodeRepository.getByCode(code).orElseThrow(CategoryNotFoundException::new);

    }
}
