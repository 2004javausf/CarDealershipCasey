package com.cardealer.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cardealer.beans.UserCreds;
import com.cardealer.dao.UserCredsDAO;
import com.cardealer.util.ConnFactory;

public class UserCredsDAOImpl implements UserCredsDAO {

	private static ConnFactory cf=ConnFactory.getInstance();
	
	public void createUser(String username, String password) throws SQLException {
		Connection conn=cf.getConnection();
		String sql= "{ call INSERT INTO AUTHENTICATION VALUES(ID_GEN.NEXTVAL, ?, ?,1)";
		CallableStatement call=conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.execute();
	}

	@Override
	public boolean checkUser(String username) throws SQLException { //return true if username is a duplicate
		Connection conn=cf.getConnection();
		String sql= "SELECT USERNAME FROM AUTHENTICATION WHERE USERNAME=?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, username);
		ResultSet rs = p.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		
		return false;
	}

	@Override
	public UserCreds idReturn(String username, String password) throws SQLException { //return ID of 
		Connection conn=cf.getConnection();
		String sql= "SELECT * FROM AUTHENTICATION WHERE USERNAME=? AND PASSWORD=?";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, username);
		p.setString(2, password);
		ResultSet rs = p.executeQuery();
		
		if(rs.next()) {
			UserCreds uc = new UserCreds(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			return uc;
		}
		
		return null;
	}

}
