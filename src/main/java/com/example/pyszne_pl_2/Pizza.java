package com.example.pyszne_pl_2;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Pizza {
    @Size(min=5, message="Nazwa zła xD")
    private String name;
}
