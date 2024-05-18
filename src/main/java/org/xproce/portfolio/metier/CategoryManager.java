package org.xproce.portfolio.metier;

import org.springframework.data.domain.Page;
import org.xproce.portfolio.dao.entities.Category;

public interface CategoryManager {
    Category addCategory(Category category);
    Page<Category> getAllCategories(int page, int size);
    Category getCategoryById(Long id);
    Category updateCategory(Category category);
    boolean deleteCategory(Long id);
}
