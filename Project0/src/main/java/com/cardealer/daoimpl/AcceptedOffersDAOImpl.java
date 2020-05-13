package com.cardealer.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cardealer.beans.AcceptedOffers;
import com.cardealer.dao.AcceptedOffersDAO;
import com.cardealer.util.ConnFactory;

public class AcceptedOffersDAOImpl implements AcceptedOffersDAO {

	private static ConnFactory cf = ConnFactory.getInstance();

	public void createAcceptedOffer(int carId, int customerId, int monthsLeft, double amountOwed) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERT INTO ACCEPTED_OFFERS VALUES(?, ?, ?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, carId);
		call.setInt(2, customerId);
		call.setInt(3, monthsLeft);
		call.setDouble(4, amountOwed);
		call.execute();
	}

	public AcceptedOffers getPaymentId(int carId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ACCEPTED_OFFERS WHERE CAR_ID=?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, carId);
		ResultSet rs = p.executeQuery();
		AcceptedOffers ao=null;
		if (rs.next()) {
			ao = new AcceptedOffers(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
		}
		return ao;

	}

	public ArrayList<AcceptedOffers> getPayment(int customerId) throws SQLException {
		ArrayList<AcceptedOffers> payment = new ArrayList<AcceptedOffers>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ACCEPTED_OFFERS WHERE CUSTOMER_ID=?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, customerId);
		ResultSet rs = p.executeQuery();

		while (rs.next()) {
			AcceptedOffers ao = new AcceptedOffers(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
			payment.add(ao);
		}
		return payment;
	}

}
