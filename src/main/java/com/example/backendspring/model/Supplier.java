package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Supplier {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer Id;
    @Column(unique = true)
    private String registrationNumber;
    private String name;
    @OneToMany
    List<Products> products= new ArrayList<>();

}
