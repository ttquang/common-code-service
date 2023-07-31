package com.quangtt.commoncode.domain.model.query;

import com.quangtt.commoncode.domain.model.KeyValue;

import java.util.Comparator;

public class Sort {

    public enum Direction {
        ASC {
            @Override
            Comparator<KeyValue> with(Comparator<KeyValue> comparator) {
                return comparator;
            }
        },
        DESC {
            @Override
            Comparator<KeyValue> with(Comparator<KeyValue> comparator) {
                return comparator.reversed();
            }
        };

        abstract Comparator<KeyValue> with(Comparator<KeyValue> comparator);
    }

    public static Comparator<KeyValue> by(Attribute attribute, Direction direction) {
        switch (attribute) {
            case KEY:
                return direction.with(Comparator.comparing(KeyValue::getKey));
            case VALUE:
                return direction.with(Comparator.comparing(KeyValue::getValue));
            default:
                throw new IllegalArgumentException();
        }
    }

}
