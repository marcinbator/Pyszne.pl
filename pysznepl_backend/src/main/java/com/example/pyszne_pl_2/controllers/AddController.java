package com.example.pyszne_pl_2.controllers;

import com.example.pyszne_pl_2.models.MyUser;
import com.example.pyszne_pl_2.models.Pizza;
import com.example.pyszne_pl_2.repositories.PizzaRepository;
import com.example.pyszne_pl_2.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Same as in SearchController

@Controller
@AllArgsConstructor
@RequestMapping("/add")
public class AddController {

    PizzaRepository pizzaRepository;
    UserRepository userRepository;

    @GetMapping
    public String addPizza(Model model){
        model.addAttribute("pizza", new Pizza());
        return "add";
    }

    @PostMapping
    public String addPizza(@Valid @ModelAttribute("pizza") Pizza pizza, //Enables data validation for ModelAttribute
                           //(accessible in template as "pizza", previously added in GET method)
                           BindingResult result){ //Result of validation)
        if(result.hasErrors()){
            return "add";
        }
        Object mayUser=SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal(); //Returns "anonymousUser" or UserDetails object if authenticated
        if(mayUser instanceof UserDetails){
            String username=((UserDetails) mayUser).getUsername();
            MyUser user=userRepository.getUserByUsername(username);
            pizza.setUser(user);
        }
        pizzaRepository.save(pizza); //Add pizza to DB
        return "summary";
    }

}
