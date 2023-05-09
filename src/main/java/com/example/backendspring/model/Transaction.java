package com.example.backendspring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Transaction {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private Date dateTransaction;
    @ManyToOne
    TransactionType transactionType;

}