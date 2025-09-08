package com.smartexpense.categorization.controller;

import com.smartexpense.categorization.dto.TransactionDto;
import com.smartexpense.categorization.service.CategorizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/internal/categorize")
public class CategorizationController {

    private final CategorizationService service;

    public CategorizationController(CategorizationService service) {
        this.service = service;
    }

    // Categorize provided transactions
    @PostMapping
    public List<TransactionDto> categorize(
            @RequestParam UUID userId,
            @RequestBody List<TransactionDto> transactions) {
        return service.categorizeTransactions(userId, transactions);
    }

    // Categorize using Transactions Service
    @PostMapping("/user/{userId}")
    public List<TransactionDto> categorizeByUser(@PathVariable UUID userId) {
        return service.categorizeTransactionsForUser(userId);
    }
}
