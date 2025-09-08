package com.smartexpense.categorization.repository;

import com.smartexpense.categorization.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

