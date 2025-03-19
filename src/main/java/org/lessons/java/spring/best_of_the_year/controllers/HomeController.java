package org.lessons.java.spring.best_of_the_year.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("/")
    public String getHomePage(Model model, @RequestParam(name = "name") String name) {
        model.addAttribute("name", name);
        return "homepage";
    }
    
}
