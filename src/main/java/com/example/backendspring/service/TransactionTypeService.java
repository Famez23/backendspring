package com.example.backendspring.service;

import com.example.backendspring.Repository.TransactionTypeRepository;
import com.example.backendspring.model.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class TransactionTypeService {
    TransactionTypeRepository transactionTypeRepository;

    public List<TransactionType> getAll(){
       return transactionTypeRepository.findAll();
    }
    public TransactionType getById(Integer id){
        return transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction type not found with id:"+id));
    }
    public TransactionType addTransactionType(TransactionType transactionType){
        return transactionTypeRepository.save(transactionType);
    }
    public ResponseEntity<?> updateTransactionType(TransactionType transactionType, Integer id){
        TransactionType updatedTransactionType= getById(id);
        updatedTransactionType.setLabel(transactionType.getLabel());

        transactionTypeRepository.save(updatedTransactionType);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<?> deleteTransactionType(Integer id) {
        transactionTypeRepository.deleteById(id);
        return  ResponseEntity.ok().build();
    }
}
