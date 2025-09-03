package com.smartexpense.categorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<com.smartexpense.categorization.repository.Transaction, Long> {

}
