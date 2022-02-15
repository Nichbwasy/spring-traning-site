package com.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumController {
    @RequestMapping("/album")
    public String blog(Model model){
        model.addAttribute("title", "Album");
        model.addAttribute("album_header", "Welcome to our album page!");
        return "album";
    }

}
