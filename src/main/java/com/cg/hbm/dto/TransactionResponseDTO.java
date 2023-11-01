package com.cg.hbm.dto;


import lombok.Data;

@Data
public class TransactionResponseDTO {
	
private int transactionId;
	
	private double amount;
	private String fromCountry;
	private double convertedAmount;
	private String toCountry;
	private double exchangeRate;
	private double ourFee;
	private double bankTransferFee;
	private String recipientType;
	private String recipientEmail;
	private String accountHolderName;
	private String accountNumber;
	private String ifscCode;
	private String accountType;
	private String bankType;
	private String recipientCountry;
	private String recipientCity;
	private String recipientAddress;
	private String recipientPincode;
	 
	private String msge;

}
