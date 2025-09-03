package com.smartexpense.categorization.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Raw merchant name as seen in bank statement.
     */
    @Column(nullable = false)
    private String merchant;

    /**
     * Transaction description (sometimes contains additional keywords).
     */
    private String description;

    /**
     * Merchant Category Code (MCC), optional but useful for classification.
     */
    private String mcc;

    /**
     * Amount of transaction.
     */
    private Double amount;

    /**
     * Normalized category result after classification.
     */
    private String category;

    /**
     * Sub-category (if applicable).
     */
    private String subCategory;

    /**
     * Timestamp of when the transaction was ingested.
     */
    private LocalDateTime createdAt;

    /**
     * Timestamp of when categorization was last updated.
     */
    private LocalDateTime updatedAt;

}
