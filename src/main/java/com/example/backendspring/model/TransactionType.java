package com.example.backendspring.model;

import com.example.backendspring.Repository.ProductsTypeRepository;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public  class TransactionType {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String label ;


}
