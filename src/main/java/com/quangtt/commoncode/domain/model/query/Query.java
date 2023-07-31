package com.quangtt.commoncode.domain.model.query;

import com.quangtt.commoncode.domain.model.KeyValue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Query {
    String categoryCode;
    List<Predicate<KeyValue>> predicates = new ArrayList<>();
    List<Comparator<KeyValue>> comparators = new ArrayList<>();
    String language;

    private Query(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Query filter(Predicate<KeyValue> predicate) {
        this.predicates.add(predicate);
        return this;
    }

    public Query sort(Comparator<KeyValue> comparator) {
        this.comparators.add(comparator);
        return this;
    }

    public Query language(String language) {
        this.language = language;
        return this;
    }

    public static Query of(String categoryCode) {
        return new Query(categoryCode);
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public List<Predicate<KeyValue>> getPredicates() {
        return predicates;
    }

    public List<Comparator<KeyValue>> getComparators() {
        return comparators;
    }

    public String getLanguage() {
        return language;
    }
}
