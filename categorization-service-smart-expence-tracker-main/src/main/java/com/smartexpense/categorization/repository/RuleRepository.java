package com.smartexpense.categorization.repository;

import org.apache.tomcat.util.digester.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {

    List<com.smartexpense.categorization.domain.Rule> findByUserId(UUID userId);
}
