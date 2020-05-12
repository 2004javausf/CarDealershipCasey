package com.cardealer.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.cardealer.daoimpl.UserCredsDAOImpl;
import com.cardealer.util.FlushScanner;

public class UserCreation {

	public static UserCredsDAOImpl ucdi = new UserCredsDAOImpl();
	
	public static void newAccount (Scanner in) {
		String username;
		String password;
		System.out.println("Please select a username.");
		username = in.next();
		FlushScanner.flush(in);
		try {
			if(ucdi.checkUser(username)) {//check desired username doesn't exist
				System.out.println("Username taken. Please try a different username.");
				newAccount(in);
				return;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		System.out.println("Username available. Please select a password:");
		password = in.next();
		FlushScanner.flush(in);
		try {
			ucdi.createUser(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Account successfully created.");
		return;
	}
}
