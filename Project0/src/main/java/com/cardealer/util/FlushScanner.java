package com.cardealer.util;

import java.util.Scanner;

public class FlushScanner {
	
	@SuppressWarnings("resource")
	public static void flush (Scanner in) {
		in = new Scanner(System.in);
	}

}
