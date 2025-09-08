package com.smartexpense.categorization.dto;

public class RuleResponse {
    private Long id;
    private String pattern;
    private String category;
    private String subCategory;
    private Integer priority;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPattern() { return pattern; }
    public void setPattern(String pattern) { this.pattern = pattern; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getSubCategory() { return subCategory; }
    public void setSubCategory(String subCategory) { this.subCategory = subCategory; }
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }
}


