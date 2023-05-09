package com.example.backendspring.controller;

import com.example.backendspring.model.Transaction;
import com.example.backendspring.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transaction")
@RestController
@AllArgsConstructor
public class TransactionController {
    TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAll(){
       return transactionService.getAllTransactions();
    }
    @GetMapping("/{id}")
    public Transaction getById(@PathVariable Integer id){
        return transactionService.getById(id);
    }
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction){
       return transactionService.addTransaction(transaction);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@RequestBody Transaction transaction,@PathVariable Integer id){
        return transactionService.updateTransaction(transaction,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Integer id){
       return transactionService.deleteTransaction(id);
    }
}
