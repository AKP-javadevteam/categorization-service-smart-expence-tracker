package com.smartexpense.categorization.dto;

import lombok.*;

@Setter
@Getter
public class CategorizationResponse {
    private boolean matched;
    private Long ruleId;
    private String category;
    private String subCategory;
    private String matchedPattern;

}


