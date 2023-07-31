package com.quangtt.commoncode.application;

import com.quangtt.commoncode.domain.model.KeyValue;
import com.quangtt.commoncode.domain.model.KeyValueService;
import com.quangtt.commoncode.domain.model.query.Attribute;
import com.quangtt.commoncode.domain.model.query.Filter;
import com.quangtt.commoncode.domain.model.query.Query;
import com.quangtt.commoncode.domain.model.query.Sort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/key-values")
@AllArgsConstructor
public class KeyValueController {

    KeyValueService keyValueService;

    @GetMapping("category/{code}")
    public List<KeyValue> get(
            @PathVariable String code,
            @RequestParam(name = "sort-by", defaultValue = "VALUE") Attribute sortAttribute,
            @RequestParam(name = "sort-direction", defaultValue = "ASC") Sort.Direction sortDirection
    ) {
        Query query = Query
                .of(code)
                .sort(Sort.by(sortAttribute, sortDirection));
        return keyValueService.list(query);
    }

    @GetMapping("category/{code}/ref-key/{ref-key}")
    public List<KeyValue> getByRefKey(
            @PathVariable String code,
            @PathVariable("ref-key") String refKey,
            @RequestParam(name = "sort-by", defaultValue = "VALUE") Attribute sortAttribute,
            @RequestParam(name = "sort-direction", defaultValue = "ASC") Sort.Direction sortDirection
    ) {
        Query query = Query
                .of(code)
                .filter(Filter.contain(Attribute.REF_KEY, refKey))
                .sort(Sort.by(sortAttribute, sortDirection));
        return keyValueService.list(query);
    }

}
