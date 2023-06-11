package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Products {

    private@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String nomenclature;
    private String label ;
    private Integer price;
    private Integer quantityStocked;
    private Integer thresholdMax;
    private Integer thresholdMin;


    @ManyToOne
    private ProductsType productType;
    @ManyToOne
    private Store store;

    @ManyToOne
    private Stock stock;


}
