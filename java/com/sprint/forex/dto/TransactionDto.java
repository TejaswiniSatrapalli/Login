package com.sprint.forex.dto;

import java.time.LocalDate;

import com.sprint.forex.entity.Transaction;

public class TransactionDto {

	private int transactionId;

	private String fromCountry;

	private String toCountry;

	private String senderName;
	
	private String senderIfscCode;

	private String receiverName;
	
	private String receiverIfscCode;

	private long senderAccNo;

	private long receiverAccNo;
	
	

	private String sendingCurrency;

	private String receivingCurrency;

	private long sendingAmount;

	private LocalDate transactionDate;



	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromCountry() {
		return fromCountry;
	}

	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}

	public String getToCountry() {
		return toCountry;
	}

	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderIfscCode() {
		return senderIfscCode;
	}

	public void setSenderIfscCode(String senderIfscCode) {
		this.senderIfscCode = senderIfscCode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverIfscCode() {
		return receiverIfscCode;
	}

	public void setReceiverIfscCode(String receiverIfscCode) {
		this.receiverIfscCode = receiverIfscCode;
	}

	public long getSenderAccNo() {
		return senderAccNo;
	}

	public void setSenderAccNo(long senderAccNo) {
		this.senderAccNo = senderAccNo;
	}

	public long getReceiverAccNo() {
		return receiverAccNo;
	}

	public void setReceiverAccNo(long receiverAccNo) {
		this.receiverAccNo = receiverAccNo;
	}

	
	public String getSendingCurrency() {
		return sendingCurrency;
	}

	public void setSendingCurrency(String sendingCurrency) {
		this.sendingCurrency = sendingCurrency;
	}

	public String getReceivingCurrency() {
		return receivingCurrency;
	}

	public void setReceivingCurrency(String receivingCurrency) {
		this.receivingCurrency = receivingCurrency;
	}

	public long getSendingAmount() {
		return sendingAmount;
	}

	public void setSendingAmount(long sendingAmount) {
		this.sendingAmount = sendingAmount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionDto(Transaction transaction) {
		
		 this.transactionId = transaction.getTransactionId();
		 this.transactionDate = transaction.getTransactionDate();
		 this.fromCountry = transaction.getFromCountry();
		 this.toCountry = transaction.getToCountry();
		 this.senderName = transaction.getSenderName();
		 this.receiverName = transaction.getReceiverName();
		 this.senderAccNo = transaction.getSenderAccNo();
		 this.senderIfscCode=transaction.getSenderIfscCode();
		 this.receiverAccNo = transaction.getReceiverAccNo();
		 this.receiverIfscCode=transaction.getReceiverIfscCode();
		this.sendingCurrency = transaction.getSendingCurrency();
		 this.receivingCurrency = transaction.getReceivingCurrency();
		 this.sendingAmount = transaction.getSendingAmount();
		
	}

		public TransactionDto() {
		 // Default constructor
		}

}
