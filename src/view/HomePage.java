package view;

import util.Console;
import util.Scan;

public class HomePage {
	
	public HomePage() {
		while (true) {
			Console.clear();
			System.out.println("JekPedia");
			System.out.println("=".repeat(8));
			System.out.println("1. Register New Applicant Form");
			System.out.println("2. View Form");
			System.out.println("3. Exit");
			System.out.print(">> ");
			int choice = Scan.nextInt();
			if (choice == 1)
				Menu.registerNewApplicant();
			else if (choice == 2)
				Menu.viewForm();
			else if (choice == 3)
				break;
		}
	}

}
