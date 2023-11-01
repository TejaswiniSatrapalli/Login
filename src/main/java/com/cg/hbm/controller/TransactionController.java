package com.cg.hbm.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.TransactionDTO;
import com.cg.hbm.dto.TransactionResponseDTO;
import com.cg.hbm.entity.Transaction;
import com.cg.hbm.exceptions.InvalidInputDataException;
import com.cg.hbm.service.ITransactionService;
import com.cg.hbm.util.TransactionDTOConvertor;

@RestController
@RequestMapping("/transaction")

//@CrossOrigin(origins = {"http://localhost:4200/","http://localhost:2004/"},allowedHeaders = "*")


public class TransactionController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ITransactionService transactionService;
	
	@Autowired
	TransactionDTOConvertor transactionDTOConvertor;

	public TransactionController() {
		
	logger.info("---Transaction Controller Called --");
	logger.warn("---Transaction Controller Called --");
	
	System.err.println("Transaction Controller Called");
    }
	
	@PostMapping("/add")
	
	public ResponseEntity<TransactionResponseDTO> addTransaction(@RequestBody Transaction transaction)
			throws Exception {

		Transaction newTransaction = transactionService.addTransaction(transaction);
		logger.info("---->> transaction saved"+newTransaction);
		
		if(newTransaction != null) {

			TransactionResponseDTO responseDTO = transactionDTOConvertor.getTransactionResponseDTO(newTransaction);
			return new ResponseEntity<TransactionResponseDTO>(responseDTO,HttpStatus.OK);
		}
			return null;
		
		
		
//		TransactionResponseDTO responseDTO = transactionDTOConvertor.getTransactionResponseDTO(newTransaction);
//		
//		return new ResponseEntity<Transaction>(newTransaction, HttpStatus.OK);
	}

	@GetMapping("/allTransactions")
	public ResponseEntity<List<TransactionDTO>> getAllTransactions() throws InvalidInputDataException {

		List<Transaction> allTransaction = transactionService.getAllTransactions(); 
		
		List<TransactionDTO> allTransactionDTO = new ArrayList<>();

		for (Transaction transactions : allTransaction) {

			allTransactionDTO.add(transactionDTOConvertor.getTransactionDTO(transactions));

		}

		return new ResponseEntity<List<TransactionDTO>>(allTransactionDTO, HttpStatus.OK);

	}

}
