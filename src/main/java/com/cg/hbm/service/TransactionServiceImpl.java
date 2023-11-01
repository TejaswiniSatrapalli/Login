package com.cg.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Transaction;
import com.cg.hbm.repository.TransactionRepository;


@Service
public class TransactionServiceImpl implements ITransactionService {
	
	
	@Autowired
	TransactionRepository transactionRepository;

	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		
		return transactionRepository.save(transaction);
		
	}

	@Override
	public List<Transaction> getAllTransactions() {
		
		return transactionRepository.findAll();
	}


}
