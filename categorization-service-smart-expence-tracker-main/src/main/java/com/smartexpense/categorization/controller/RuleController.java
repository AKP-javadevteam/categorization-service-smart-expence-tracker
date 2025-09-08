package com.smartexpense.categorization.controller;

import com.smartexpense.categorization.domain.Rule;
import com.smartexpense.categorization.repository.RuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/internal/rules")
public class RuleController {

    private final RuleRepository repo;

    public RuleController(RuleRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Rule createRule(@RequestBody Rule rule) {
        return repo.save(rule);
    }

    @GetMapping
    public List<Rule> rulesByUser(@RequestParam UUID userId) {
        return repo.findByUserId(userId);
    }
}
