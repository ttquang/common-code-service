package com.quangtt.commoncode.domain.repository;

import com.quangtt.commoncode.domain.model.CategoryCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryCodeRepository extends JpaRepository<CategoryCode,Long> {
    Optional<CategoryCode> getByCode(String code);
}
