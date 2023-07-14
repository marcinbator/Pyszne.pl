package com.example.pyszne_pl_2.api_controllers;

import com.example.pyszne_pl_2.models.Pizza;
import com.example.pyszne_pl_2.repositories.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Controller for REST API

@RestController
@AllArgsConstructor
@RequestMapping("/api/pizza")
public class PizzaApi {

    private final PizzaRepository pizzaRepository;

    @GetMapping("/pizzas")
    public List<Pizza> pizzas(){
        return pizzaRepository.findAll();
    }

    @GetMapping("/recent")
    public Iterable<Pizza> recentPizzas(){
        PageRequest page = PageRequest.of(0,5, Sort.by("id").descending()); //Paging of results, 5 on page, sorted by id
        return pizzaRepository.findAll(page).getContent();
    }

    @GetMapping("/pizzas/{id}") //{id} - place to add variable in URL
    public ResponseEntity<Pizza> showPizza(@PathVariable String id){ //@Path Variable - reads variable from URL
        Optional<Pizza> pizza=pizzaRepository.findById(Integer.valueOf(id));
        if(pizza.isPresent()){
            return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add", consumes = "application/json") //Type of API data
    @ResponseStatus(HttpStatus.CREATED) //Status of Http response if succeed
    public Pizza addPizza(@RequestBody Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    @GetMapping("/pizzas/not-found")
    public String error(){
        return "Nie znaloz.";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        pizzaRepository.deleteById(id);
    }

}
