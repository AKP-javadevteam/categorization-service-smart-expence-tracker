package com.smartexpense.categorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/internal/health")
    public String health() {
        return "OK";
    }
}

