package com.cardealer.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cardealer.beans.PendingOffers;
import com.cardealer.dao.PendingOffersDAO;
import com.cardealer.util.ConnFactory;

public class PendingOffersDAOImpl implements PendingOffersDAO{

	private static ConnFactory cf=ConnFactory.getInstance();
	
	public void createOffer(int carId, int customerId, double offer) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "{ call INSERT INTO PENDING_OFFERS VALUES(OFFER_ID_GEN.NEXTVAL, ?, ?,?)";
		CallableStatement call=conn.prepareCall(sql);
		call.setInt(1, carId);
		call.setInt(2, customerId);
		call.setDouble(3, offer);
		call.execute();
	}
	
	public void deleteOffer(int carId) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "{ call DELETE FROM PENDING_OFFERS WHERE CAR_ID=?";
		CallableStatement call=conn.prepareCall(sql);
		call.setInt(1, carId);
		call.execute();
	}
	
	public void deleteOfferId(int offerId) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "{ call DELETE FROM PENDING_OFFERS WHERE OFFER_ID=?";
		CallableStatement call=conn.prepareCall(sql);
		call.setInt(1, offerId);
		call.execute();
	}
	
	public ArrayList<PendingOffers> allPending() throws SQLException{
		ArrayList<PendingOffers> offers = new ArrayList<PendingOffers>(); 
		Connection conn=cf.getConnection();
		String sql= "SELECT * FROM PENDING_OFFERS ORDER BY OFFER DESC";
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		
		while(rs.next()) {
			PendingOffers offer = new PendingOffers(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
			offers.add(offer);
		}
		return offers;
		
	}	public ArrayList<PendingOffers> onePending(Integer carId) throws SQLException{
			ArrayList<PendingOffers> offers = new ArrayList<PendingOffers>(); 
			Connection conn=cf.getConnection();
			String sql= "SELECT * FROM PENDING_OFFERS WHERE CAR_ID = ? ORDER BY OFFER DESC";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, carId);
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				PendingOffers offer = new PendingOffers(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
				offers.add(offer);
			}
			return offers;
	}
}
