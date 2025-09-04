package com.smartexpense.categorization.service;

import com.smartexpense.categorization.model.Rule;
import com.smartexpense.categorization.repository.RuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleService {
    private final RuleRepository repo;
    public RuleService(RuleRepository repo) { this.repo = repo; }

    public Rule create(Rule rule) { return repo.save(rule); }
    public Rule update(Long id, Rule updated) {
        Optional<org.apache.tomcat.util.digester.Rule> r = repo.findById(id);
        if (r.isEmpty()) return null;
        Rule ex = r.get();
        ex.setPattern(updated.getPattern());
        ex.setCategory(updated.getCategory());
        ex.setSubCategory(updated.getSubCategory());
        return repo.save(ex);
    }
    public void delete(Long id){ repo.deleteById(id); }
    public List<Rule> list(){ return repo.findAll(); }
    public Optional<Rule> get(Long id){ return repo.findById(id); }
}

}
