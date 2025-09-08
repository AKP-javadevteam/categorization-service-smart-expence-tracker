package com.smartexpense.categorization.service;

import com.smartexpense.categorization.dto.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "transactions-service", url = "${clients.transactions.base-url}")
public interface TransactionsClient {

    @GetMapping("/internal/transactions-by-user/{userId}")
    List<TransactionDto> getTransactionsByUser(@PathVariable("userId") UUID userId);
}

public class TransactionsClient {
}
