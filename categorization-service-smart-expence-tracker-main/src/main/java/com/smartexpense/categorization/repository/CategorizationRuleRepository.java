package com.smartexpense.categorization.repository;


import com.smartexpense.categorization.model.CategorizationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorizationRuleRepository extends JpaRepository<CategorizationRule, Long> {
}

