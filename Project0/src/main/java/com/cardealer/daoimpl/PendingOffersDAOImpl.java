package com.cardealer.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.cardealer.dao.PendingOffersDAO;
import com.cardealer.util.ConnFactory;

public class PendingOffersDAOImpl implements PendingOffersDAO{

	public static ConnFactory cf=ConnFactory.getInstance();
	
	public void createOffer(int carId, int customerId, double offer) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "{ call INSERT INTO PENDING_OFFERS VALUES(OFFER_ID_GEN.NEXTVAL, ?, ?,?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setInt(1, carId);
		call.setInt(2, customerId);
		call.setDouble(3, offer);
		call.execute();
	}
}
