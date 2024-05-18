package org.xproce.portfolio.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.xproce.portfolio.dao.entities.Project;
import org.xproce.portfolio.dao.repositories.ProjectRepository;

import java.util.List;

@Service
public class ProjectManagerMetier implements ProjectManager {

    @Autowired
    private ProjectRepository ProjectRepository;

    @Override
    public Project addProject(Project Project) {
        return ProjectRepository.save(Project);
    }

    @Override
    public Page<Project> getAllProjects(int page, int taille) {
        return ProjectRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<Project> searchProjects(String keyword, int page, int taille) {
        return ProjectRepository.findByDesignationContains(keyword, PageRequest.of(page, taille));
    }

    @Override
    public List<Project> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public Project getProjectById(Integer id) {
        return ProjectRepository.findById(id).get();
    }

    @Override
    public Project updateProject(Project Project) {
        return ProjectRepository.save(Project);
    }

    @Override
    public boolean deleteProject(Integer id) {
        try {
            ProjectRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
