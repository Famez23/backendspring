package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Stock {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private Integer quantityStocked;
    private String stockLabel;
    @OneToMany
    List<Stock> productsStocked= new ArrayList<>();

}
