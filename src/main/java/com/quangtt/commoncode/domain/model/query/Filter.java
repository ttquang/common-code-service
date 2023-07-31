package com.quangtt.commoncode.domain.model.query;

import com.quangtt.commoncode.domain.model.KeyValue;

import java.util.function.Predicate;

public class Filter {

    public static Predicate<KeyValue> equal(Attribute attribute, String value) {
        switch (attribute) {
            case KEY:
                return item -> item.equals(value);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static Predicate<KeyValue> contain(Attribute attribute, String value) {
        switch (attribute) {
            case REF_KEY:
                return item -> item.getRefKeys().contains(value);
            default:
                throw new IllegalArgumentException();
        }
    }

//    public static Predicate<Entry> like(Attribute attribute, String value) {
//        switch (attribute) {
//            case REF_ENTRY_CODE:
//                return entry -> entry.getRefEntries().stream().findFirst().orElse("").startsWith(value);
//            default:
//                throw new IllegalArgumentException();
//        }
//    }
//
//    public static Predicate<Entry> exclude(Attribute attribute, List<String> excludedList) {
//        switch (attribute) {
//            case ENTRY_CODE:
//                return entry -> !excludedList.contains(entry.getEntryCode());
//            default:
//                throw new IllegalArgumentException();
//        }
//    }
//
//    public static Predicate<Entry> include(Attribute attribute, List<String> includedList) {
//        switch (attribute) {
//            case ENTRY_CODE:
//                return entry -> includedList.contains(entry.getEntryCode());
//            default:
//                throw new IllegalArgumentException();
//        }
//    }
}
