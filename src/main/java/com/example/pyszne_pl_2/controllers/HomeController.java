package com.example.pyszne_pl_2.controllers;

import com.example.pyszne_pl_2.models.MyUser;
import com.example.pyszne_pl_2.models.Pizza;
import com.example.pyszne_pl_2.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Authentication auth, Model model){
        if(auth!=null){
            model.addAttribute("name", auth.getName());
        }
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return "home";
    }

}
