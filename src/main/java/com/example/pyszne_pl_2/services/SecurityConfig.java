package com.example.pyszne_pl_2.services;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    DataSource dataSource;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource);
    }

}
