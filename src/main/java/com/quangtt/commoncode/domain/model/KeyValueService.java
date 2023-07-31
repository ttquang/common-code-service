package com.quangtt.commoncode.domain.model;

import com.quangtt.commoncode.common.error.CategoryNotFoundException;
import com.quangtt.commoncode.domain.model.query.Query;
import com.quangtt.commoncode.infrastructure.model.CategoryCode;
import com.quangtt.commoncode.infrastructure.model.EntryCode;
import com.quangtt.commoncode.infrastructure.repository.CategoryCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class KeyValueService {

    CategoryCodeRepository categoryCodeRepository;

    private Map<String, KeyValueCategory> store;

    public void refreshCodeCategory() {
        store = new HashMap<>();

        List<CategoryCode> categoryCodes = categoryCodeRepository.findAll();
        for (CategoryCode categoryCode : categoryCodes) {
            KeyValueCategory category = new KeyValueCategory();
            category.code = categoryCode.getCode();

            for (EntryCode entryCode : categoryCode.getEntryCodes()) {
                KeyValue keyValue = new KeyValue();
                keyValue.key = entryCode.getCode();
                keyValue.value = entryCode.getName();

                category.keyValues.add(keyValue);
            }

            store.put(category.code, category);
        }

    }

    private Stream<KeyValue> byCategory(String category) {
        return Optional.ofNullable(store.get(category)).orElseThrow(CategoryNotFoundException::new).keyValues.stream();
    }

    public List<KeyValue> list(Query query) {
        Stream<KeyValue> stream = this.byCategory(query.getCategoryCode());

        Iterator<Predicate<KeyValue>> predicateIterator = query.getPredicates().iterator();
        if (predicateIterator.hasNext()) {
            Predicate predicate = predicateIterator.next();
            while (predicateIterator.hasNext()) {
                predicate = predicate.and(predicateIterator.next());
            }
            stream = stream.filter(predicate);
        }

        Iterator<Comparator<KeyValue>> comparatorIterator = query.getComparators().iterator();
        if (comparatorIterator.hasNext()) {
            Comparator<KeyValue> comparator = comparatorIterator.next();
            while (comparatorIterator.hasNext()) {
                comparator = comparator.thenComparing(comparatorIterator.next());
            }
            stream = stream.sorted(comparator);
        }

        return stream.collect(Collectors.toList());
    }
}
