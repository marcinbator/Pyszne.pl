package com.example.pyszne_pl_2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

//DB data model

@Data //Data - creates constructors, getters and setters
@Entity //JPA entity - creates, updates or accommodates to DB model (specified in application.jml)
public class Pizza {

    @Id //Required - id marking
    @GeneratedValue(strategy = GenerationType.AUTO) //Auto - generated value with selected strategy
    private Integer id;

    @Size(min=5) //Data validation
    private String name;

    private BigDecimal price;

    @ManyToOne //Foreign key - many-to-one relation
    private MyUser user;
}
