package org.xproce.portfolio.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.xproce.portfolio.dao.entities.User;
import org.xproce.portfolio.dao.repositories.UserRepository;

import java.util.List;

@Service
public class UserManagerMetier implements UserManager {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAllUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<User> searchUsers(String keyword, int page, int taille) {
        return userRepository.findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPasswordContainingIgnoreCase(
                keyword, keyword, keyword, PageRequest.of(page, taille));
    }

    @Override
    public Page<User> advancedSearchUsers(String username, String email, String password, int page, int taille) {
        return userRepository.findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPasswordContainingIgnoreCase(
                username, email, password, PageRequest.of(page, taille));
    }
    @Override
    public List<User> getByKeyword(String keyword) {
        // Since you have no implementation for getByKeyword, you can return null
        return null;
    }
    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
