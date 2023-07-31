package com.quangtt.commoncode.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class KeyValue implements Serializable {
    String key;
    String value;

    @JsonIgnore
    Set<String> refKeys = new HashSet<>();
}
