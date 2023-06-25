package com.example.pyszne_pl_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public HomeController(PizzaRepository pizzaRepository){
        this.pizzaRepository=pizzaRepository;
    }

//    @GetMapping
//    public ResponseEntity<List<Pizza>> home(){
//        return ResponseEntity.ok(this.pizzaRepository.findAll());
//    }
    @GetMapping
    public String home(Model model){
        model.addAttribute("pizzas", this.pizzaRepository.findAll());
        return "home";
    }
}
