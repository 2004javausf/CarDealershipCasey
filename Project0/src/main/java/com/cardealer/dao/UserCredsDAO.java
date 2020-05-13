package com.cardealer.dao;

import java.sql.SQLException;

import com.cardealer.beans.UserCreds;

public interface UserCredsDAO {
	public void createUser(String username, String password) throws SQLException;
	public boolean checkUser(String username) throws SQLException;
	public UserCreds idReturn(String username, String password) throws SQLException;
}
