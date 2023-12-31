package com.sprint.forex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.TransactionDto;
import com.sprint.forex.entity.Transaction;
import com.sprint.forex.service.TransactionService;
@CrossOrigin("http://localhost:4200")
@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	
	
	@PostMapping("/transaction/save")
	public ResponseEntity<TransactionDto> addTransaction( @RequestBody TransactionDto transactionDto) {
		TransactionDto newTransaction = transactionService.saveTransaction(transactionDto);
		ResponseEntity<TransactionDto> responseEntity = new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/transaction/byId/{id}")
	public ResponseEntity<Transaction> fetchTransactionDetails(@PathVariable("id") int transactionId) {
		Transaction transaction = transactionService.getTransactionById(transactionId);
		ResponseEntity<Transaction> responseEntity = new ResponseEntity<>(transaction, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/transaction/all")
	public List<Transaction> fetchAllTransactions() {
		List<Transaction> list = transactionService.getAllTransactions();
		return list;
	}
	@GetMapping("/transaction/byUserId/{userId}")
	public List<Transaction> fetchMyTransaction(@PathVariable("userId") int userId) {
		return transactionService.getTransactionByUserId(userId);
	}
	

}
