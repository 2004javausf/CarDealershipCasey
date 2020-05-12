package com.cardealer.util;

import java.util.Scanner;

public class Validate {

	
	public static char yn (String ask, Scanner in) {
		System.out.println(ask);
		String userIn = in.next();
		if (userIn.equalsIgnoreCase("y")) {
			FlushScanner.flush(in);
			return 'y';
		}else if(userIn.equalsIgnoreCase("n")) {
			FlushScanner.flush(in);
			return 'n';
		}else {
			System.out.println("Invalid answer. Please answer y/n");
			FlushScanner.flush(in);
			return yn(ask, in);
		}
	}
}
