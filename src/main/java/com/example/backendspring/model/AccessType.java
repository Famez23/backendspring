package com.example.backendspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AccessType {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String label;
}
