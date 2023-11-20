package com.sprint.forex.dto;

import java.time.LocalDate;

public class ExchangeRateDto {

	private int id;
	private String fromCurrency;

	private String toCurrency;

	private Double rate;

	private LocalDate date;
	
	private Double ourFee;
	
	private Double bankTransferFee;

	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Double getOurFee() {
		return ourFee;
	}
	public void setOurFee(Double ourFee) {
		this.ourFee = ourFee;
	}
	public Double getBankTransferFee() {
		return bankTransferFee;
	}
	public void setBankTransferFee(Double bankTransferFee) {
		this.bankTransferFee = bankTransferFee;
	}

}
