package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Flow {
    private Integer unitPrice;
    private Integer amountDelivered;
    private Integer amountConsumed;
    private Integer quantityConsumed;
    private Integer quantityDelivered;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Products product;
    @ManyToOne
    private Transaction transaction;
}
