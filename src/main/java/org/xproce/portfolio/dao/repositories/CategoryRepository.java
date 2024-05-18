package org.xproce.portfolio.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.portfolio.dao.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Define custom query methods if needed
}
