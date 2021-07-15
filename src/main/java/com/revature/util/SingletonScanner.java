package com.revature.util;

import java.util.Scanner;

public class SingletonScanner {
	private static SingletonScanner instance;

	private static Scanner scan;

	private SingletonScanner() {
		scan = new Scanner(System.in);
	}

	public static synchronized SingletonScanner getScanner() {
		if (instance == null) {
			instance = new SingletonScanner();
		}
		return instance;
	}

	public static Scanner getScan() {
		return scan;
	}
	
	public String getNext() {
		return scan.nextLine();
	}
}