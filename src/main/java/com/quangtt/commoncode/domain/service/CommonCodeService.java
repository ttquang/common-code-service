package com.quangtt.commoncode.domain.service;

import com.quangtt.commoncode.domain.model.CategoryCode;
import com.quangtt.commoncode.domain.repository.CategoryCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommonCodeService {
    CategoryCodeRepository categoryCodeRepository;
}
