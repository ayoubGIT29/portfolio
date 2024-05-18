package org.xproce.portfolio.dao.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.portfolio.dao.entities.Project;

@Transactional
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Page<Project> findByDesignationContains(String keyword, Pageable pageable);
}