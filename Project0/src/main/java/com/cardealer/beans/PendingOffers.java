package com.cardealer.beans;

public class PendingOffers {
	private Integer offerId;
	private Integer carId;
	private Integer customerId;
	private Double offer;
	
	public PendingOffers() {
		super();
	}

	public PendingOffers(Integer offerId, Integer carId, Integer customerId, Double offer) {
		super();
		this.offerId = offerId;
		this.carId = carId;
		this.customerId = customerId;
		this.offer = offer;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
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

	public Double getOffer() {
		return offer;
	}

	public void setOffer(Double offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "PendingOffers [offerId=" + offerId + ", carId=" + carId + ", customerId=" + customerId + ", offer="
				+ offer + "]";
	}
	
}
