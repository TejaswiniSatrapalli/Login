package com.cg.hbm.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
	
    private int id;
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
	

}
