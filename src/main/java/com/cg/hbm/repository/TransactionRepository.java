package com.cg.hbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entity.Transaction;
import com.cg.hbm.entity.User;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

//	Transaction addTransaction(Transaction transaction);
//	List<Transaction> getAllTransactions();

//	List<Transaction> findById(int userId);
	
}
