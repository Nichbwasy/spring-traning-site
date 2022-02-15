package com.site.controllers;

import com.site.models.User;
import com.site.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public String users(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("title", "All users");
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/users/delete", params = {"id"})
    public RedirectView deleteUser(@RequestParam(value = "id") Long deletedId, Model model) {
        userRepository.delete(userRepository.findById(deletedId).get());
        return new RedirectView("/users");
    }
}
