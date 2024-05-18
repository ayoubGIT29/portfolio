package org.xproce.portfolio.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.portfolio.dao.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
