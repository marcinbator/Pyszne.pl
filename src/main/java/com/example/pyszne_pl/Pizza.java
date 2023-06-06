package com.example.pyszne_pl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class Pizza {

    private final int id;
    private final String name;
    private enum size{SMALL, MEDIUM, LARGE};
    private ArrayList<String> ingredients;
}
