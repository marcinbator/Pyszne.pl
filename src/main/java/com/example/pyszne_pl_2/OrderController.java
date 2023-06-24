package com.example.pyszne_pl_2;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String order(Model model){
        model.addAttribute("pizza", new Pizza());
        return "order";
    }

    @PostMapping
    public String order(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult result){
        if(result.hasErrors()){
            return "order";
        }
        return "summary";
    }

}
