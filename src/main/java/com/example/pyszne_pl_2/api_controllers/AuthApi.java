package com.example.pyszne_pl_2.api_controllers;

import com.example.pyszne_pl_2.models.MyUser;
import com.example.pyszne_pl_2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class AuthApi {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @PostMapping(value = "/register", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MyUser register(@RequestBody MyUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @PostMapping(value="/login")
    public ResponseEntity<HttpStatus> login(@RequestBody MyUser user){ //Authentication based on model
        Authentication auth=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())); //Authentication
        SecurityContextHolder.getContext().setAuthentication(auth); //Assign auth status
        System.out.println(auth);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
