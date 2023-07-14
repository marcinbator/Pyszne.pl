package com.example.pyszne_pl_2.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Configuration of secure authentication process

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final AuthenticationConfiguration authConfiguration; //Used to authenticate based on User model (API)

    @Bean
    public PasswordEncoder passwordEncoder() { //Bean that is urgent for registration process (hashes)
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception { //Used to authenticate based on User model (API)
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    @Order(1) //Order of using filterChains
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception { //Config of URLs that require authentication
        http
                .securityMatcher("/api/pizza/**") //URLs
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest() //POST, GET etc
                        .authenticated() //Needs to be authenticated
                )
//                .formLogin((formLogin)->formLogin //Settings of login form
//                        .loginPage("/login") //Custom login URL (page specified in WebConfig)
//                        .loginProcessingUrl("/api/user/login")
//                        .defaultSuccessUrl("/")); //Custom success URL
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception { //Same as above but for any other URLs
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()
                        .permitAll() //Open, does not require authentication
                )
//                .formLogin((formLogin)->formLogin
//                        .loginPage("/login")
//                        .loginProcessingUrl("/api/user/login"))
//                .logout(logout->logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login"))
                .csrf(AbstractHttpConfigurer::disable); //On Postman purposes
        return http.build();
    }

}
