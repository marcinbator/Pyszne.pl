package com.example.pyszne_pl_2.controllers;

import com.example.pyszne_pl_2.models.Pizza;
import com.example.pyszne_pl_2.repositories.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

//Controller for template

@Controller //Controller bean
@RequestMapping("/search") //Active on /search urls
@AllArgsConstructor
public class SearchController {

    private PizzaRepository pizzaRepository; //Required to perform DB actions

    @GetMapping//Services GET requests
    public String search(Model model){
        model.addAttribute("pizza", new Pizza()); //adds Pizza object to template as "pizza"
        return "search"; //Returns "search" HTML template
    }

    @PostMapping//Services POST requests
    public String search(Pizza pizza){
        if(pizzaRepository
                .findPizzaByName(pizza
                        .getName())
                .isPresent()){ //checks if Optional<Pizza> is empty or not
            pizza
                    .setId(Objects
                    .requireNonNull(pizzaRepository
                            .findPizzaByName(pizza.getName())
                            .orElse(null))
                    .getId()); //Set id for founded pizza
            return "redirect:/api/pizza/pizzas/"+pizza.getId(); //redirect to API with proper id
        }
        return "redirect:/api/pizza/pizzas/not-found";
    }
}
