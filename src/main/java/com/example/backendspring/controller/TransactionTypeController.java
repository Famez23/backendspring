package com.example.backendspring.controller;

import com.example.backendspring.model.TransactionType;
import com.example.backendspring.service.TransactionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/transactiontypes")
@RestController
public class TransactionTypeController {
    TransactionTypeService transactionTypeService;

    @PostMapping
    public TransactionType addTransactionType(@RequestBody TransactionType transactionType){
        return transactionTypeService.addTransactionType(transactionType);
    }
    @GetMapping
    public List<TransactionType> getAllTransactions(){
      return transactionTypeService.getAll();
    }
    @GetMapping("{id}")
    public TransactionType getTransactionTypeById(@PathVariable Integer id){
        return transactionTypeService.getById(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateTransactionType(@RequestBody TransactionType transactionType, @PathVariable Integer id){
       return transactionTypeService.updateTransactionType(transactionType,id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTransactionType(@PathVariable Integer id){
       return transactionTypeService.deleteTransactionType(id);
    }
}
