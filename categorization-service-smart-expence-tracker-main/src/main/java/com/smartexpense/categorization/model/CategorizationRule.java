package com.smartexpense.categorization.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorization_rules")
public class CategorizationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // pattern to match - plain substring match for MVP (case-insensitive)
    @Column(nullable = false)
    private String pattern;

    @Column(nullable = false)
    private String category;

    private String subCategory;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPattern() { return pattern; }
    public void setPattern(String pattern) { this.pattern = pattern; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getSubCategory() { return subCategory; }
    public void setSubCategory(String subCategory) { this.subCategory = subCategory; }

    public void setPriority(int i) {
    }

    public Integer getPriority() {
        return null;
    }
}

