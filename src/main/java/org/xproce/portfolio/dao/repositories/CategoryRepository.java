package org.xproce.portfolio.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.portfolio.dao.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Page<Category> findByNameContains(String keyword, Pageable pageable);

}
