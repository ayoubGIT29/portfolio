package org.xproce.portfolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.portfolio.dao.entities.Category;
import org.xproce.portfolio.metier.CategoryManager;

import java.util.Date;

@Controller
public class CategoryController {
    @Autowired
    CategoryManager categoryManager;

    @GetMapping("/categories")
    public String showCategories(Model model,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "taille", defaultValue = "6") int taille,
                                 @RequestParam(name = "search", defaultValue = "") String keyword) {
        Page<Category> categories = categoryManager.searchCategories(keyword, page, taille);
        model.addAttribute("listCategories", categories.getContent());
        int[] pages = new int[categories.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);

        // Logic to fetch and pass categories to the view
        return "categories";
    }

    @GetMapping("/categories/{categoryId}")
    public String showCategoryDetails(@PathVariable("categoryId") Integer categoryId, Model model) {
        Category category = categoryManager.getCategoryById(categoryId);
        if (category != null) {
            model.addAttribute("category", category);
            return "category_details";
        } else {
            return "error";
        }
    }

    @GetMapping("/categories/add")
    public String showAddCategoryForm(Model model) {
        // Logic to prepare data for adding a new category and pass to the view
        model.addAttribute("category", new Category());
        return "add_category";
    }

    @PostMapping("/ajouterCategorie")
    public String ajouterCategorieAction(Model model,
                                         @RequestParam(name = "title") String title,
                                         @RequestParam(name = "id", defaultValue = "") Integer id) {
        Category category = new Category(id, title, new Date(), new Date());
        categoryManager.addCategory(category);
        return "redirect:categories";
    }

    @PostMapping("/categories")
    public String addCategory(@ModelAttribute Category category) {
        // Logic to add a new category
        categoryManager.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/editCategory")
    public String editCategory(Model model, @RequestParam(name = "id") Integer id) {
        Category Category = categoryManager.getCategoryById(id);
        if (Category != null) {
            model.addAttribute("categoryToBeUpdated", Category);
            return "updateCategory";
        } else {
            return "error";
        }
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute Category category) {
        categoryManager.updateCategory(category);
        return "redirect:/categories";
    }


    @GetMapping("/deleteCategory")
    public String deleteCategory(Model model, @RequestParam(name = "id") Integer id) {
        if (categoryManager.deleteCategory(id)) {
            return "redirect:/categories";
        } else {
            return "error";
        }
    }
}
