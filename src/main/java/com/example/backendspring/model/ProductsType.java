package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class ProductsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String familyLabel;



}
