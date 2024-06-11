package com.bankingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.model.Transaction;
import com.bankingapp.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

 @Autowired
 private TransactionService transactionService;
 
 @GetMapping
 public List<Transaction> getAllTransactions() {
     return transactionService.getAllTransactions();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
     Optional<Transaction> transaction = transactionService.getTransactionById(id);
     return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }

 @PostMapping
 public Transaction createTransaction(@Validated @RequestBody Transaction transaction) {
     return transactionService.createTransaction(transaction);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
     Optional<Transaction> transaction = transactionService.getTransactionById(id);
     if (transaction.isPresent()) {
         transactionService.deleteTransaction(id);
         return ResponseEntity.noContent().build();
     } else {
         return ResponseEntity.notFound().build();
     }
 }

}
