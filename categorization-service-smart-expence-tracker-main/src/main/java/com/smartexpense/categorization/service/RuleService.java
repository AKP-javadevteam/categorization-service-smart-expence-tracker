package com.smartexpense.categorization.service;

import com.smartexpense.categorization.dto.RuleRequest;
import com.smartexpense.categorization.dto.RuleResponse;
import com.smartexpense.categorization.exception.ResourceNotFoundException;
import com.smartexpense.categorization.model.CategorizationRule;
import com.smartexpense.categorization.repository.RuleRepository;
import org.apache.tomcat.util.digester.Rule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RuleService {
    private final RuleRepository repo;
    public RuleService(RuleRepository repo) {
        this.repo = repo;
    }


    public RuleResponse create(RuleRequest req) {
        CategorizationRule r = new CategorizationRule();
        r.setPattern(req.getPattern());
        r.setCategory(req.getCategory());
        r.setSubCategory(req.getSubCategory());
        r.setPriority(req.getPriority() == null ? 0 : req.getPriority());
        CategorizationRule saved = repo.save(r);
        return toDto(saved);
    }

    public List<RuleResponse> list() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public RuleResponse get(Long id) {
        CategorizationRule r = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rule not found: " + id));
        return toDto(r);
    }

    public RuleResponse update(Long id, RuleRequest req) {
        CategorizationRule r = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rule not found: " + id));
        r.setPattern(req.getPattern());
        r.setCategory(req.getCategory());
        r.setSubCategory(req.getSubCategory());
        r.setPriority(req.getPriority() == null ? 0 : req.getPriority());
        return toDto(repo.save(r));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Rule not found: " + id);
        repo.deleteById(id);
    }

    private RuleResponse toDto(CategorizationRule r) {
        RuleResponse dto = new RuleResponse();
        dto.setId(r.getId());
        dto.setPattern(r.getPattern());
        dto.setCategory(r.getCategory());
        dto.setSubCategory(r.getSubCategory());
        dto.setPriority(r.getPriority());
        return dto;
    }
}

