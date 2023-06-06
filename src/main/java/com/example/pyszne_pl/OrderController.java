package com.example.pyszne_pl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    Pizza pizza;

    @GetMapping
    public String order(Model model){
        Application.logger.info("Order page routed.");
        model.addAttribute("order", pizza);
        return "order";
    }

    @PostMapping
    public String add(Model model){
        model.addAttribute("order", pizza);
        return "order";
    }
}
