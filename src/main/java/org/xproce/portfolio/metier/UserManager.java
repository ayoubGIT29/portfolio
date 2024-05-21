package org.xproce.portfolio.metier;

import org.springframework.data.domain.Page;
import org.xproce.portfolio.dao.entities.User;

import java.util.List;

public interface UserManager {
    User addUser(User user);
    Page<User> getAllUsers(int page, int size);
    public Page<User> searchUsers(String keyword, int page, int taille);
    Page<User> advancedSearchUsers(String username, String email, String password, int page, int taille);
    public List<User> getByKeyword(String keyword);
    User getUserById(Integer id);
    User updateUser(User user);
    boolean deleteUser(Integer id);
}
