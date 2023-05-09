package com.example.backendspring.service;

import com.example.backendspring.Repository.TransactionRepository;
import com.example.backendspring.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
       return transactionRepository.findAll();
    }
    public Transaction getById(Integer id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
    }
    public Transaction addTransaction(Transaction transaction){
        transaction.setDateTransaction(transaction.getDateTransaction());
        transaction.setTransactionType(transaction.getTransactionType());
        return transactionRepository.save(transaction);
    }
    public ResponseEntity<?> updateTransaction(Transaction transaction, Integer id){
        Transaction updatedTransaction = getById(id);
        updatedTransaction.setDateTransaction(transaction.getDateTransaction());
        updatedTransaction.setTransactionType(transaction.getTransactionType());
        transactionRepository.save(updatedTransaction);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<?> deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
