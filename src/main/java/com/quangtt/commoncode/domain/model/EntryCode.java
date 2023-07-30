package com.quangtt.commoncode.domain.model;

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

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Parent
    CategoryCode category;
}
