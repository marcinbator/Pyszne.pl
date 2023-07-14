package com.example.pyszne_pl_2.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Same as in SearchController

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Authentication auth, Model model){
        if(auth!=null){
            model.addAttribute("name", auth.getName()); //Returns name of logged-in user
        }
        System.out.println(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()
                .toString()); //Returns object MyUser of currently authenticated user
        return "home";
    }

}
