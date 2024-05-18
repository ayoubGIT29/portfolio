package org.xproce.portfolio.metier;

import org.springframework.data.domain.Page;
import org.xproce.portfolio.dao.entities.Technology;

public interface TechnologyManager {
    Technology addTechnology(Technology technology);
    Page<Technology> getAllTechnologies(int page, int size);
    public Page<Technology> searchTechnologies(String keyword, int page, int taille);

    Technology getTechnologyById(Integer id);
    Technology updateTechnology(Technology technology);
    boolean deleteTechnology(Integer id);
}
