package com.cardealer.driver;

import java.util.Scanner;

import com.cardealer.menu.UserLogin;
import com.cardealer.util.LogThis;

public class Driver {

	public static void main(String[] args) {
		LogThis.LogIt("info", "program run");
		Scanner in = new Scanner(System.in);
		UserLogin.login(in);
		in.close();
	}

}
