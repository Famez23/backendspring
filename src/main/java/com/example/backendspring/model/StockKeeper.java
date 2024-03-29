package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StockKeeper {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String lastname;
    private String name;

    @ManyToOne
    AccessType accessType ;


}
