package com.example.pyszne_pl_2.controllers;

import com.example.pyszne_pl_2.models.MyUser;
import com.example.pyszne_pl_2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Same as in Search Controller

@Controller
@AllArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private UserRepository userRepository; //for DB actions
    private PasswordEncoder passwordEncoder; //for password encoding

    @GetMapping
    public String register(){
        return "register";
    }

    @PostMapping
    public String registerProcess(MyUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user); //Adding new user to DB
        return "redirect:/login";
    }

}
