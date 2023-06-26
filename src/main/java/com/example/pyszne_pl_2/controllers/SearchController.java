package com.example.pyszne_pl_2.controllers;

import com.example.pyszne_pl_2.models.Pizza;
import com.example.pyszne_pl_2.repositories.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {

    PizzaRepository pizzaRepository;

    @GetMapping
    public String search(Model model){
        model.addAttribute("pizza", new Pizza());
        return "search";
    }

    @PostMapping
    public String search(@ModelAttribute(name="pizza") Pizza pizza){
        if(pizzaRepository.findPizzaByName(pizza.getName()).isPresent()){
            pizza.setId(Objects.requireNonNull(pizzaRepository.findPizzaByName(pizza.getName()).orElse(null)).getId());
            System.out.println("no"+pizza.getId());
            return "redirect:/api/pizzas/"+pizza.getId();
        }
        return "redirect:/api/pizzas/not-found";
    }
}
