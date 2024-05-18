package org.xproce.portfolio.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.xproce.portfolio.dao.entities.Technology;
import org.xproce.portfolio.dao.repositories.TechnologyRepository;

@Service
public class TechnologyManagerMetier implements TechnologyManager {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public Technology addTechnology(Technology technology) {
        return technologyRepository.save(technology);
    }

    public Page<Technology> searchTechnologies(String keyword, int page, int taille){
        return technologyRepository.findByNameContains(keyword, PageRequest.of(page, taille));
    }


    @Override
    public Page<Technology> getAllTechnologies(int page, int size) {
        return technologyRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Technology getTechnologyById(Integer id) {
        return technologyRepository.findById(id).orElse(null);
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        return technologyRepository.save(technology);
    }

    @Override
    public boolean deleteTechnology(Integer id) {
        try {
            technologyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
