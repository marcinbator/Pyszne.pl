package com.example.pyszne_pl;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Pizza {
    private int id;
    @NotNull
    @Size(min=5, message = "Too small size.")
    private String name;
    private enum size{SMALL, MEDIUM, LARGE};
    private ArrayList<String> ingredients;
}
