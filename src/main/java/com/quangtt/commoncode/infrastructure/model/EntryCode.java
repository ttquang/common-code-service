package com.quangtt.commoncode.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Parent;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class EntryCode {
    String code;
    String name;
    String refCode;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @Parent
    CategoryCode category;
}
