package com.bankingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapp.model.Transaction;
import com.bankingapp.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Optional<Transaction> getTransactionById(Long id) {
		return transactionRepository.findById(id);
	}

	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public void deleteTransaction(Long id) {
		transactionRepository.deleteById(id);
	}
	
	
	
	
}
