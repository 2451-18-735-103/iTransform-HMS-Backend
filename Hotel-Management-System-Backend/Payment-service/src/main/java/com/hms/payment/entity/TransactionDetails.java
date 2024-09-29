package com.hms.payment.entity;

public class TransactionDetails {

	private String orderId;

	private String currency;

	private Integer amount;

	public TransactionDetails() {

		super();

	}

	public TransactionDetails(String orderId, String currency, Integer amount) {

		super();

		this.orderId = orderId;

		this.currency = currency;

		this.amount = amount;

	}

	public String getOrderId() {

		return orderId;

	}

	public void setOrderId(String orderId) {

		this.orderId = orderId;

	}

	public String getCurrency() {

		return currency;

	}

	public void setCurrency(String currency) {

		this.currency = currency;

	}

	public double getAmount() {

		return amount;

	}

	public void setAmount(Integer amount) {

		this.amount = amount;

	}

}
