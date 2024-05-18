package org.xproce.portfolio.metier;

import org.springframework.data.domain.Page;
import org.xproce.portfolio.dao.entities.User;

public interface UserManager {
    User addUser(User user);
    Page<User> getAllUsers(int page, int size);
    User getUserById(Long id);
    User updateUser(User user);
    boolean deleteUser(Long id);
}
