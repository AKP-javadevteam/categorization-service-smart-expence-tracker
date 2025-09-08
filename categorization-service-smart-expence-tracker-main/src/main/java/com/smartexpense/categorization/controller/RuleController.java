package com.smartexpense.categorization.controller;

import com.smartexpense.categorization.model.CategorizationRule;
import com.smartexpense.categorization.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class RuleController {
    private final RuleService service;

    public RuleController(RuleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorizationRule> get(@PathVariable Long id){
        return service.get(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategorizationRule create(@RequestBody CategorizationRule r){ return service.create(r); }

    @PutMapping("/{id}")
    public ResponseEntity<CategorizationRule> update(@PathVariable Long id, @RequestBody CategorizationRule r){
        CategorizationRule updated = service.update(id, r);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

