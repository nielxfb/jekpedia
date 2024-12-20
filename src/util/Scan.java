package util;

import java.util.Scanner;

public class Scan {
	
	private static Scanner s = new Scanner(System.in);
	
	public static int nextInt() {
		int res;
		try {
			res = Integer.parseInt(s.nextLine());
		} catch (Exception e) {
			res = -1;
		}
		return res;
	}
	
	public static String nextString() {
		String res;
		try {
			res = s.nextLine();
		} catch (Exception e) {
			res = "";
		}
		return res;
	}
}
