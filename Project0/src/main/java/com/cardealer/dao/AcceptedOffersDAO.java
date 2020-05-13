package com.cardealer.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cardealer.beans.AcceptedOffers;

public interface AcceptedOffersDAO {
	public void createAcceptedOffer(int carId, int customerId, int monthsLeft, double amountOwed) throws SQLException;
	public AcceptedOffers getPaymentId(int carId) throws SQLException;
	public ArrayList<AcceptedOffers> getPayment(int customerId) throws SQLException;

}
