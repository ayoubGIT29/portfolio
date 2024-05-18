package org.xproce.portfolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xproce.portfolio.dao.entities.Project;
import org.xproce.portfolio.metier.ProjectManager;

import java.util.Date;

@Controller
public class ProjectController {

    @Autowired
    ProjectManager projectManager;

    @GetMapping("")
    public String start() {
        return "redirect:indexpage";
    }

    @PostMapping("/ajouter")
    public String ajouterProjectAction(Model model,
                                       @RequestParam(name = "title") String title,
                                       @RequestParam(name = "id", defaultValue =  "") Integer id,
                                       @RequestParam(name = "designation") String designation) {
        Project Project = new Project(id, title, designation,new Date(),new Date());
        projectManager.addProject(Project);
        return "redirect:indexpage";
    }

//    @PostMapping("/ajouterOnce")
//    public String ajouterProject(Model model,
//                                 @Valid Project Project,
//                                 BindingResult bindingResult) {
//        if(bindingResult.hasErrors()){
//            return "ajouterProject" ;
//        }
//        projectManager.addProject(Project);
//        return "redirect:indexpage";
//    }

    @GetMapping("/ajouterProject")
    public String ajouterProject(Model model) {
        model.addAttribute("Project", new Project());
        return "ajouterProject";
    }


    @GetMapping("/indexpage")
    public String listProjects(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "taille", defaultValue = "6") int taille,
                               @RequestParam(name = "search", defaultValue = "") String keyword
    ) {
        Page<Project> projects = projectManager.searchProjects(keyword, page, taille);
        model.addAttribute("listProjects", projects.getContent());
        int[] pages = new int[projects.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping("/deleteProject")
    public String deleteProject(Model model, @RequestParam(name = "id") Integer id) {
        if (projectManager.deleteProject(id)) {
            return "redirect:/indexpage";
        } else {
            return "error";
        }
    }


    @GetMapping("/editProject")
    public String editProject(Model model, @RequestParam(name = "id") Integer id) {
        Project Project = projectManager.getProjectById(id);
        if (Project != null) {
            model.addAttribute("projectToBeUpdated", Project);
            return "updateProject";
        } else {
            return "error";
        }
    }
}
