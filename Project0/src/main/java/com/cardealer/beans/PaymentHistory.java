package com.cardealer.beans;

public class PaymentHistory {
	Integer TransactionId;
	Integer CarId;
	Integer UserId;
	Double AmountPaid;
	public PaymentHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentHistory(Integer transactionId, Integer carId, Integer userId, Double amountPaid) {
		super();
		TransactionId = transactionId;
		CarId = carId;
		UserId = userId;
		AmountPaid = amountPaid;
	}
	public Integer getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(Integer transactionId) {
		TransactionId = transactionId;
	}
	public Integer getCarId() {
		return CarId;
	}
	public void setCarId(Integer carId) {
		CarId = carId;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Double getAmountPaid() {
		return AmountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		AmountPaid = amountPaid;
	}
	@Override
	public String toString() {
		return "PaymentHistory [TransactionId=" + TransactionId + ", CarId=" + CarId + ", UserId=" + UserId
				+ ", AmountPaid=" + AmountPaid + "]";
	}
}
