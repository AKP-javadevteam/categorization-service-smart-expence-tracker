package com.smartexpense.categorization.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TransactionDto {
    private UUID id;
    private UUID userId;
    private String merchant;
    private String description;
    private String mcc;
    private BigDecimal amount;
    private LocalDate date;

    private String categoryCode;
    private String subcategoryCode;
}

