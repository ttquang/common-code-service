package com.quangtt.commoncode.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CategoryCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String code;
    String name;

    @ElementCollection
    @CollectionTable(
            name = "ENTRY_CODE",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"))
    List<EntryCode> pledgors = new ArrayList<>();
}
