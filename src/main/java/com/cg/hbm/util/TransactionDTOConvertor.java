package com.cg.hbm.util;

import org.springframework.stereotype.Component;

import com.cg.hbm.dto.TransactionDTO;
import com.cg.hbm.dto.TransactionResponseDTO;
import com.cg.hbm.entity.Transaction;


@Component
public class TransactionDTOConvertor {
	
	
	public TransactionResponseDTO getTransactionResponseDTO(Transaction transaction)
	{
		TransactionResponseDTO dto = new TransactionResponseDTO();
		
		dto.setTransactionId(transaction.getTransactionId());
		
		dto.setAmount(transaction.getAmount());
		
		dto.setFromCountry(transaction.getFromCountry());
		
		dto.setConvertedAmount(transaction.getConvertedAmount());
		
		dto.setToCountry(transaction.getToCountry());
		
		dto.setExchangeRate(transaction.getExchangeRate());
	
		dto.setOurFee(transaction.getOurFee());
		
		dto.setBankTransferFee(transaction.getBankTransferFee());
		
		dto.setRecipientType(transaction.getRecipientType());
		
		dto.setRecipientEmail(transaction.getRecipientEmail());
		
		dto.setAccountHolderName(transaction.getAccountHolderName());
		
		dto.setAccountNumber(transaction.getAccountNumber());
		
		dto.setIfscCode(transaction.getIfscCode());
		
		dto.setAccountType(transaction.getAccountType());
		
		dto.setBankType(transaction.getBankType());
		
		dto.setRecipientCountry(transaction.getRecipientCountry());
		
		dto.setRecipientCity(transaction.getRecipientCity());
		
		dto.setRecipientAddress(transaction.getRecipientAddress());
		
		dto.setRecipientPincode(transaction.getRecipientPincode());
		
		dto.setMsge("review saved");
		
		return dto;
		
	}
	public TransactionDTO getTransactionDTO(Transaction t) {
		
		
		TransactionDTO obj = new TransactionDTO(t.getTransactionId(),t.getAmount(),t.getFromCountry(),t.getConvertedAmount(),t.getToCountry(),t.getExchangeRate(),t.getOurFee(),t.getBankTransferFee(),t.getRecipientType(),t.getRecipientEmail(),t.getAccountHolderName(),t.getAccountNumber(),t.getIfscCode(),t.getAccountType(),t.getBankType(),t.getRecipientCountry(),t.getRecipientCity(),t.getRecipientAddress(),t.getRecipientPincode());
				
		return obj;
		
	}

	

}
