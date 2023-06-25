package com.example.pyszne_pl_2;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="pizzas")
public class Pizza {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    @Size(min=5, message="Nazwa zła xD")
    private String name;
}
