package org.xproce.portfolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.portfolio.dao.entities.User;
import org.xproce.portfolio.metier.UserManager;

import java.util.Date;

@Controller
public class UserController {
    @Autowired
    UserManager userManager;

    @GetMapping("/users")
    public String showUsers(Model model,
                            @RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "taille", defaultValue = "6") int taille,
                            @RequestParam(name = "search", defaultValue = "") String keyword) {
        Page<User> users = userManager.searchUsers(keyword, page, taille);
        model.addAttribute("listUsers", users.getContent());
        int[] pages = new int[users.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);

        return "users";
    }

    @GetMapping("/users/{userId}")
    public String showUserDetails(@PathVariable("userId") Integer userId, Model model) {
        User user = userManager.getUserById(userId);
        if (user != null) {
            model.addAttribute("user", user);
            return "user_details";
        } else {
            return "error";
        }
    }

    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        user.setCreatedAt(new Date());
        userManager.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUser(Model model, @RequestParam(name = "id") Integer id) {
        User user = userManager.getUserById(id);
        if (user != null) {
            model.addAttribute("userToBeUpdated", user);
            return "update_user";
        } else {
            return "error";
        }
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Model model, @RequestParam(name = "id") Integer id) {
        if (userManager.deleteUser(id)) {
            return "redirect:/users";
        } else {
            return "error";
        }
    }
}
