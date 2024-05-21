package org.xproce.portfolio.metier;

import org.springframework.data.domain.Page;
import org.xproce.portfolio.dao.entities.Category;

public interface CategoryManager {
    Category addCategory(Category category);
    Page<Category> getAllCategories(int page, int size);

    public Page<Category> searchCategories(String keyword, int page, int taille);

    Category getCategoryById(Integer id);
    Category updateCategory(Category category);
    boolean deleteCategory(Integer id);
}
