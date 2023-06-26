package com.example.pyszne_pl_2.repositories;

import com.example.pyszne_pl_2.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
