package com.cg.hbm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Transaction;


@Service
public interface ITransactionService {
	
	Transaction addTransaction(Transaction transaction);
	List<Transaction> getAllTransactions();
	
//	User getUserById(int userId);
//	User updateUser(int userId);

}
