package com.example.pyszne_pl_2.services;

import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(@NotNull ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }
}
