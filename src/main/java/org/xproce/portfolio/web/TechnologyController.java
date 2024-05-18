package org.xproce.portfolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.portfolio.dao.entities.Technology;
import org.xproce.portfolio.metier.TechnologyManager;

import java.util.Date;

@Controller
public class TechnologyController {
    @Autowired
    TechnologyManager technologyManager;

    @GetMapping("/technologies")
    public String showTechnologies(Model model
            ,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "taille", defaultValue = "6") int taille,
                                   @RequestParam(name = "search", defaultValue = "") String keyword) {
        Page<Technology> technologies = technologyManager.searchTechnologies(keyword, page, taille);
        model.addAttribute("listTechnologies", technologies.getContent());
        int[] pages = new int[technologies.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);



        // Logic to fetch and pass technologies to the view
        return "technologies";
    }

    @GetMapping("/technologies/{technologyId}")
    public String showTechnologyDetails(@PathVariable("technologyId") Long technologyId, Model model) {
        // Logic to fetch technology details by technologyId and pass to the view
        return "technology_details";
    }

    @GetMapping("/technologies/add")
    public String showAddTechnologyForm(Model model) {
        // Logic to prepare data for adding a new technology and pass to the view
        model.addAttribute("technology", new Technology());
        return "add_technology";
    }

    @PostMapping("/ajouterTechnologie")
    public String ajouterTechnologieAction(Model model,
                                       @RequestParam(name = "title") String title,
                                       @RequestParam(name = "id", defaultValue =  "") Integer id) {
        Technology technology  = new Technology(id, title,new Date(),new Date());
        technologyManager.addTechnology(technology);
        return "redirect:indexpage";
    }

    @PostMapping("/technologies")
    public String addTechnology(@ModelAttribute Technology technology) {
        // Logic to add a new technology
        return "redirect:/technologies";
    }

    @GetMapping("/technologies/{technologyId}/edit")
    public String showEditTechnologyForm(@PathVariable("technologyId") Long technologyId, Model model) {
        // Logic to fetch technology details by technologyId and pass to the edit form
        return "edit_technology";
    }

    @PostMapping("/technologies/{technologyId}/edit")
    public String editTechnology(@PathVariable("technologyId") Long technologyId, @ModelAttribute Technology technology) {
        // Logic to update the technology details
        return "redirect:/technologies/{technologyId}";
    }

    @PostMapping("/technologies/{technologyId}/delete")
    public String deleteTechnology(@PathVariable("technologyId") Long technologyId) {
        // Logic to delete the technology
        return "redirect:/technologies";
    }
}
