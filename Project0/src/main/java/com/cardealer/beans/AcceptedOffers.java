package com.cardealer.beans;

public class AcceptedOffers {
	
	Integer carId;
	Integer customerId;
	Integer MonthsLeft;
	Double AmountOwed;
	public AcceptedOffers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AcceptedOffers(Integer carId, Integer customerId, Integer monthsLeft, Double amountOwed) {
		super();
		this.carId = carId;
		this.customerId = customerId;
		MonthsLeft = monthsLeft;
		AmountOwed = amountOwed;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getMonthsLeft() {
		return MonthsLeft;
	}
	public void setMonthsLeft(Integer monthsLeft) {
		MonthsLeft = monthsLeft;
	}
	public Double getAmountOwed() {
		return AmountOwed;
	}
	public void setAmountOwed(Double amountOwed) {
		AmountOwed = amountOwed;
	}
	@Override
	public String toString() {
		return "AcceptedOffers [carId=" + carId + ", customerId=" + customerId
				+ ", MonthsLeft=" + MonthsLeft + ", AmountOwed=" + AmountOwed + "]";
	}
	
	

}
