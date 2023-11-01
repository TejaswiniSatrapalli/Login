package com.cg.hbm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TransactionModule")
@Data
@NoArgsConstructor

public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	 @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	
	
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
	
	
	public Transaction(int transactionId, User user, double amount, String fromCountry, double convertedAmount,
			String toCountry, double exchangeRate, double ourFee, double bankTransferFee, String recipientType,
			String recipientEmail, String accountHolderName, String accountNumber, String ifscCode, String accountType,
			String bankType, String recipientCountry, String recipientCity, String recipientAddress,
			String recipientPincode) {
		super();
		this.transactionId = transactionId;
		this.user = user;
		this.amount = amount;
		this.fromCountry = fromCountry;
		this.convertedAmount = convertedAmount;
		this.toCountry = toCountry;
		this.exchangeRate = exchangeRate;
		this.ourFee = ourFee;
		this.bankTransferFee = bankTransferFee;
		this.recipientType = recipientType;
		this.recipientEmail = recipientEmail;
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.accountType = accountType;
		this.bankType = bankType;
		this.recipientCountry = recipientCountry;
		this.recipientCity = recipientCity;
		this.recipientAddress = recipientAddress;
		this.recipientPincode = recipientPincode;
	}
	
	
	

}
