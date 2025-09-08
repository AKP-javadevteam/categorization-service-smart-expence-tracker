package com.smartexpense.categorization.dto;

import lombok.*;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RuleDto {
    private Long id;
    private UUID userId;
    private String name;
    private int priority;
    private boolean enabled;
    private String categoryCode;
    private String subcategoryCode;
    private String merchantRename;
    private String conditionsJson;
}

