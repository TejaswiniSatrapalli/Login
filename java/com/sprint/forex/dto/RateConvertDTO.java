package com.sprint.forex.dto;



public class RateConvertDTO {
    private Double amount;
    private String fromCurrency;
    private String toCurrency;
    private Double ourFee;
	private Double bankTransferFee;

    public RateConvertDTO() {
    }

    public RateConvertDTO(Double amount, String fromCurrency, String toCurrency) {
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
