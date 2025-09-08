package com.smartexpense.categorization.dto;

import jakarta.validation.constraints.NotBlank;

public class RuleRequest {
    @NotBlank
    private String pattern;
    @NotBlank
    private String category;
    private String subCategory;
    private Integer priority = 0;

    public String getPattern() { return pattern; }
    public void setPattern(String pattern) { this.pattern = pattern; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getSubCategory() { return subCategory; }
    public void setSubCategory(String subCategory) { this.subCategory = subCategory; }
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }
}



