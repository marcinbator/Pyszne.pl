package com.example.pyszne_pl_2.repositories;

import com.example.pyszne_pl_2.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Same as UserRepository

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    public Optional<Pizza> findPizzaByName(String name); //Optional - can be empty or not
}
