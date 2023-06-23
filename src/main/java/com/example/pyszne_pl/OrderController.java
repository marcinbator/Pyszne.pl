package com.example.pyszne_pl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String order(Model model){
        model.addAttribute("order", new Pizza());
        return "order";
    }

    @PostMapping
    public String order(@Valid Pizza pizza, Model model, Errors errors){
        if(!errors.hasErrors()){
            model.addAttribute("pizza", pizza);
            return "summary";
        }
        model.addAttribute("errors", errors);
        return "order";
    }

}
