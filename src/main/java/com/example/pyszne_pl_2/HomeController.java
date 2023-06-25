package com.example.pyszne_pl_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private PizzaRepository pizzaRepository;
    public List<Pizza> getPizzas(){
        return pizzaRepository.findAll();
    }
    @GetMapping
    public List<Pizza> home(){
        return getPizzas();
    }
}
