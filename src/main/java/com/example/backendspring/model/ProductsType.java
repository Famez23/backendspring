package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class ProductsType {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String familyLabel;


    public ProductsType() {

    }
}
