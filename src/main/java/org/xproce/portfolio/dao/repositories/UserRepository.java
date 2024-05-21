package org.xproce.portfolio.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.portfolio.dao.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByUsernameContaining(String keyword, Pageable pageable);
    Page<User> findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPasswordContainingIgnoreCase(
            String username, String email, String password, Pageable pageable);

}
