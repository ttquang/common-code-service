package com.quangtt.commoncode.common.api;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Pagination {
    int count;
    int offset;
    int limit;
    int total;
}
