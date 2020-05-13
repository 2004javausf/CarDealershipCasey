package com.cardealer.dao;

import java.sql.SQLException;

public interface PaymentHistoryDAO {
	public void createPayment(int carId, int customerId, double offer) throws SQLException;

}
