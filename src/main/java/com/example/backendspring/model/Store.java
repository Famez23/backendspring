package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Store {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String  name;
    private String address;

}
