package com.example.pyszne_pl_2.controllers;

import com.example.pyszne_pl_2.models.Pizza;
import com.example.pyszne_pl_2.repositories.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@PreAuthorize("TRUE")
public class PizzaApi {

    private final PizzaRepository pizzaRepository;

    @GetMapping("/api/pizzas")
    public List<Pizza> pizzas(){
        return pizzaRepository.findAll();
    }

    @GetMapping("/api/pizzas/{id}")
    public Optional<Pizza> showPizza(@PathVariable String id){
        return pizzaRepository.findById(Integer.valueOf(id));
    }

    @GetMapping("api/pizzas/not-found")
    public String error(){
        return "Nie znaloz.";
    }

}
