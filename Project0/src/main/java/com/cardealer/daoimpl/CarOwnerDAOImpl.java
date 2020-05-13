package com.cardealer.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cardealer.beans.CarOwner;
import com.cardealer.dao.CarOwnerDAO;
import com.cardealer.util.ConnFactory;

public class CarOwnerDAOImpl implements CarOwnerDAO{
	
	private static ConnFactory cf=ConnFactory.getInstance();
	
	public void createCar() throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "{ call INSERT INTO CAR_OWNER VALUES(CAR_ID_GEN, 0)";
		CallableStatement call=conn.prepareCall(sql);
		call.execute();
	}
	
	public ArrayList<CarOwner> getLot() throws SQLException{
		ArrayList<CarOwner> lot = new ArrayList<CarOwner>(); 
		Connection conn=cf.getConnection();
		String sql= "SELECT * FROM CAR_OWNER WHERE USER_ID=0";
		PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		
		if(rs.next()) {
			CarOwner co = new CarOwner(rs.getInt(1), rs.getInt(2));
			lot.add(co);
		}
		return lot;
	}
	
	public ArrayList<CarOwner> getOwned(int userId) throws SQLException{
		ArrayList<CarOwner> owned = new ArrayList<CarOwner>(); 
		Connection conn=cf.getConnection();
		String sql= "SELECT * FROM CAR_OWNER WHERE USER_ID=?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, userId);
		ResultSet rs = p.executeQuery();
		
		if(rs.next()) {
			CarOwner co = new CarOwner(rs.getInt(1), rs.getInt(2));
			owned.add(co);
		}
		return owned;
	}	
	
}
