package org.xproce.portfolio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.xproce.portfolio.dao.entities.User;
import org.xproce.portfolio.metier.UserManager;

@Controller
public class UserController {

    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        // Logic to fetch and pass users to the view
        return "users";
    }

    @GetMapping("/users/{userId}")
    public String showUserDetails(@PathVariable("userId") Long userId, Model model) {
        // Logic to fetch user details by userId and pass to the view
        return "user_details";
    }

    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
        // Logic to prepare data for adding a new user and pass to the view
        return "add_user";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute User user) {
        // Logic to add a new user
        return "redirect:/users";
    }

    @GetMapping("/users/{userId}/edit")
    public String showEditUserForm(@PathVariable("userId") Long userId, Model model) {
        // Logic to fetch user details by userId and pass to the edit form
        return "edit_user";
    }

    @PostMapping("/users/{userId}/edit")
    public String editUser(@PathVariable("userId") Long userId, @ModelAttribute User user) {
        // Logic to update the user details
        return "redirect:/users/{userId}";
    }

    @PostMapping("/users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long userId) {
        // Logic to delete the user
        return "redirect:/users";
    }
}
