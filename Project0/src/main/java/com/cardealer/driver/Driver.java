package com.cardealer.driver;

import java.util.Scanner;

import com.cardealer.menu.UserLogin;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		UserLogin.login(in);
	}

}
