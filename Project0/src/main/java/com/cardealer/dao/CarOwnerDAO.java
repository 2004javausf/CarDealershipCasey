package com.cardealer.dao;

import java.sql.SQLException;

public interface CarOwnerDAO {
	
	public void createCar(int carId, int customerId) throws SQLException;

}
