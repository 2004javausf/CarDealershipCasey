package com.cardealer.beans;

public class CarOwner {
	private Integer carId;
	private Integer userId;
	
	public CarOwner() {
		super();
	}
	public CarOwner(Integer carId, Integer userId) {
		super();
		this.carId = carId;
		this.userId = userId;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CarOwner [carId=" + carId + ", userId=" + userId + "]";
	}
}
