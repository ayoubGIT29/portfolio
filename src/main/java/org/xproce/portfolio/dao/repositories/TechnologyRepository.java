package org.xproce.portfolio.dao.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.portfolio.dao.entities.Technology;

@Transactional
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    Page<Technology> findByNameContains(String keyword, Pageable pageable);
}