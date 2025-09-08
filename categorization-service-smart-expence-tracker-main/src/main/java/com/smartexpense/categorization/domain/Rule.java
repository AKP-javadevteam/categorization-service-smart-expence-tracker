package com.smartexpense.categorization.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "rules")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false, length = 100)
    private String name;

    private int priority;      // higher priority = applied first
    private boolean enabled;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "subcategory_code")
    private String subcategoryCode;

    @Column(name = "merchant_rename")
    private String merchantRename;

    @Column(name = "conditions_json", columnDefinition = "TEXT")
    private String conditionsJson;
}
