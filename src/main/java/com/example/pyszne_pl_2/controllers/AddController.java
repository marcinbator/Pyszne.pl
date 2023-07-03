package com.example.pyszne_pl_2.controllers;

import com.example.pyszne_pl_2.models.Pizza;
import com.example.pyszne_pl_2.repositories.PizzaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/order")
public class AddController {

    PizzaRepository pizzaRepository;

    @GetMapping
    public String addPizza(Model model){
        model.addAttribute("pizza", new Pizza());
        return "order";
    }

    @PostMapping
    public String addPizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult result){
        if(result.hasErrors()){
            return "order";
        }
        pizzaRepository.save(pizza);
        return "summary";
    }

}
