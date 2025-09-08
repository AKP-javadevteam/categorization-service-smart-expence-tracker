package com.smartexpense.categorization.dto;

import jakarta.validation.constraints.NotBlank;

public class CategorizationRequest {
    @NotBlank
    private String text;

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}

