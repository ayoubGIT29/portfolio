package org.xproce.portfolio.metier;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.xproce.portfolio.dao.entities.Project;

import java.util.List;

@Component
public interface ProjectManager {
    public Project addProject(Project Project);
    public Page<Project> getAllProjects(int page, int taille);
    public Page<Project> searchProjects(String keyword, int page, int taille);
    public List<Project> getByKeyword(String keyword);
    public Project getProjectById(Integer id);
    public Project updateProject(Project Project);
    public boolean deleteProject(Integer id);
}
