package com.smartexpense.categorization.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Pattern or keyword to match transaction descriptions or merchants.
     * Example: "%Starbucks%", "%Uber%"
     */
    @Column(nullable = false)
    private String pattern;

    /**
     * Normalized category that this rule maps to.
     * Example: "Food & Drink", "Transport"
     */
    @Column(nullable = false)
    private String category;

    /**
     * Optional sub-category.
     * Example: "Coffee Shops" under "Food & Drink"
     */
    private String subCategory;
}
