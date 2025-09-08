package com.smartexpense.categorization.service;

import com.smartexpense.categorization.model.Transaction;
import com.smartexpense.categorization.repository.CategorizationRuleRepository;
import com.smartexpense.categorization.repository.RuleRepository;
import com.smartexpense.categorization.repository.TransactionRepository;
import org.apache.tomcat.util.digester.Rule;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategorizationService {

    private final RuleRepository ruleRepository;
    private final TransactionRepository transactionRepository;

    public CategorizationService(RuleRepository ruleRepository, TransactionRepository transactionRepository) {
        this.ruleRepository = ruleRepository;
        this.transactionRepository = transactionRepository;
    }

    public CategorizationService(CategorizationRuleRepository repo, RuleRepository ruleRepository, TransactionRepository transactionRepository) {
        this.ruleRepository = ruleRepository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Classify a transaction by applying stored rules.
     * @param transaction the raw transaction to classify
     * @return transaction with updated category/subCategory
     */
    public Transaction categorize(String transaction) {
        List<Rule> rules = ruleRepository.findAll();

        for (Rule rule : rules) {
            // Simple SQL-like matching: check if merchant/description contains the pattern
            if (transaction.getChars().toLowerCase().contains(rule.getDigester()
                    || ((transaction.endsWith() != null) && transaction.endsWith().toLowerCase().contains(rule.getDigester().toLowerCase()))) {

                transaction.setCategory(String.valueOf(rule.getClass()));
                transaction.setSubCategory(String.valueOf(rule.getDigester()));
                break; // first match wins (can be adjusted to priority-based later)
            }
        }

        // Set/update timestamps
        transaction.setUpdatedAt(LocalDateTime.now());
        if (transaction.getCreatedAt() == null) {
            transaction.setCreatedAt(LocalDateTime.now());
        }
            return transactionRepository.save(transaction);
        }

    public int categorizeAll(List<Transaction> filter) {
    }
}


