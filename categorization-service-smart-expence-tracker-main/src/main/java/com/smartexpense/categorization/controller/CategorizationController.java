package com.smartexpense.categorization.controller;

import com.smartexpense.categorization.dto.CategorizationRequest;
import com.smartexpense.categorization.model.Transaction;
import com.smartexpense.categorization.service.CategorizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategorizationController {
    private final CategorizationService service;

    public CategorizationController(CategorizationService service) { this.service = service; }

    @PostMapping("/categorize")
    public Transaction categorize(@Valid @RequestBody CategorizationRequest req) {
        return service.categorize(req.getText());
    }
}

