package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Products {

    private@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String nomenclature;
    private String label ;

    @ManyToOne
    private ProductsType productType;


    public ProductsType getProductType() {
        return productType;
    }
}
