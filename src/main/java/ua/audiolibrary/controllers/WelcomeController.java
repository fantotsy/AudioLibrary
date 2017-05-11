package ua.audiolibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/")
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, user!");
        return "home";
    }
}