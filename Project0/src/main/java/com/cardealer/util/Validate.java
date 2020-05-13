package com.cardealer.util;

import java.util.Scanner;

public class Validate {

	public static int numVal( int MAXVAL, Scanner in) {
		int userIn = in.nextInt();
		FlushScanner.flush(in);
		if(userIn>0 && userIn <= MAXVAL) {
			return userIn;
		}
		System.out.println("Invalid response. Please enter a number between 1 and " + MAXVAL);
		return numVal(MAXVAL, in);
	}
	
	public static char yn (String ask, Scanner in) {
		System.out.println(ask);
		String userIn = in.next();
		FlushScanner.flush(in);
		if (userIn.equalsIgnoreCase("y")) {			
			return 'y';
		}else if(userIn.equalsIgnoreCase("n")) {
			return 'n';
		}else {
			System.out.println("Invalid answer. Please answer y/n");
			FlushScanner.flush(in);
			return yn(ask, in);
		}
	}
}
