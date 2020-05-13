package com.cardealer.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cardealer.beans.PendingOffers;

public interface PendingOffersDAO {
	public void createOffer(int carId, int customerId, double offer) throws SQLException;

	public void deleteOffer(int carId) throws SQLException;

	public void deleteOfferId(int offerId) throws SQLException;

	public ArrayList<PendingOffers> allPending() throws SQLException;

	public ArrayList<PendingOffers> onePending(Integer carId) throws SQLException;
}
