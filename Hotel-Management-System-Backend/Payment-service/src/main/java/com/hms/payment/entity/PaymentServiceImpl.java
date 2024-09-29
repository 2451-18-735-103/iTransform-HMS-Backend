package com.hms.payment.entity;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class PaymentServiceImpl {


	String key = "rzp_test_snlafEGVB0JDKh";
	String secret_Key = "PLDGzZEagiozSCPwjSLt2yZw";

	String currency = "INR";

	public TransactionDetails createTransaction(Integer amount) {

		try {

			JSONObject jsonObject = new JSONObject();

			jsonObject.put("amount", amount);

			jsonObject.put("currency", currency);

			RazorpayClient razorpayClient = new RazorpayClient(key, secret_Key);

			Order create = razorpayClient.orders.create(jsonObject);

			TransactionDetails preTransactionDetails = preTransactionDetails(create);

			return preTransactionDetails;

		} catch (RazorpayException e) {

			System.out.println(e.getMessage());

		}

		return null;

	}

	public TransactionDetails preTransactionDetails(Order order) {

		String orderId = order.get("id");

		String currency = order.get("currency");

		Integer amount = order.get("amount");

		TransactionDetails transactionDetails = new TransactionDetails(orderId, currency, amount);

		return transactionDetails;

	}

}
