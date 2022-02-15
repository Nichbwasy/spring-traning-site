package com.site.controllers;

import com.site.models.User;
import com.site.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AddUserController {

    @Autowired(required = true)
    private UserRepository userRepository;

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Add user");
        return "add-user";
    }

    @RequestMapping(value = "/add/adding", method = RequestMethod.POST)
    public RedirectView addUser(@ModelAttribute("user") User user, Model model) {
        userRepository.save(user);
        return new RedirectView("/");
    }

}
