package com.example.pyszne_pl_2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min=5)
    private String name;

    private BigDecimal price;

    @ManyToOne
    private MyUser user;
}
