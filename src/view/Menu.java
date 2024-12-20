package view;

import java.util.ArrayList;

import database.Database;
import iterator.ApplicantIterator;
import model.Applicant;
import util.Console;
import util.IdRandomizer;
import util.Scan;

public class Menu {
	
	public static void registerNewApplicant() {
		Console.clear();
		
		String name;
		while (true) {
			System.out.print("Input name [cannot be empty]: ");
			name = Scan.nextString();
			if (!name.trim().isEmpty()) break;
		}
		
		int jobExperience;
		while (true) {
			System.out.print("Input job experience [> 1]: ");
			jobExperience = Scan.nextInt();
			if (jobExperience > 1) break;
		}
		
		String jobPreference;
		while (true) {
			System.out.print("Input job preferences [Backend Dev | Frontend Dev]: ");
			jobPreference = Scan.nextString();
			if (jobPreference.equals("Backend Dev") || jobPreference.equals("Frontend Dev")) break;
		}
		
		IdRandomizer idRand = new IdRandomizer();
		String id = idRand.random();
		
		Applicant a = new Applicant(id, name, jobExperience, jobPreference);
		Database db = Database.getInstance();
		db.addApplicant(a);
		
		System.out.println("Data submitted!");
		System.out.print("Press ENTER to continue..");
		Scan.nextString();
	}
	
	public static void viewForm() {
		Console.clear();
		
		Database db = Database.getInstance();
		ArrayList<Applicant> applicants = db.getApplicants();
		if (applicants.isEmpty()) {
			System.out.println("No data submitted yet..");
			Scan.nextString();
			return;
		}
		
		ApplicantIterator iterator = new ApplicantIterator(applicants);
		while (iterator.hasNext()) {
			Applicant curr = iterator.getNext();
			System.out.printf("%-14s : %s\n", "Applicant Code", curr.getId());
			System.out.printf("%-14s : %s\n", "Applicant Name", curr.getName());
			System.out.printf("%-14s : %d\n", "Job Experience", curr.getJobExperience());
			System.out.printf("%-14s : %s\n", "Job Preference", curr.getJobPreference());
			System.out.printf("%-14s : %s\n\n", "Current Phase", curr.getCurrentPhase().showPhase());
			
			String choice = "";
			if (iterator.hasNext()) {
				while (!choice.equals("Q") && !choice.equals("N")) {
					System.out.print("Preview next applicant form? [N for Next | Q to quit][case sensitive]: ");
					choice = Scan.nextString();
				}
			} else {
				System.out.print("Press ENTER to continue..");
				Scan.nextString();
			}
			
			if (choice.equals("Q"))
				break;
			else if (choice.equals("N"))
				continue;
		}
	}

}
