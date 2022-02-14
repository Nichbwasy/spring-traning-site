package com.site.controlers;

import com.site.models.User;
import com.site.repsitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AddUserController {

    @Autowired
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
