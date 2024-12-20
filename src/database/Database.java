package database;

import java.util.ArrayList;

import model.Applicant;

public class Database {

	private ArrayList<Applicant> applicants;

	private Database() {
		applicants = new ArrayList<>();
	}
	
	private static Database instance;
	
	public static Database getInstance() {
		return instance = (instance == null) ? new Database() : instance;
	}
	
	public void addApplicant(Applicant a) {
		applicants.add(a);
	}
	
	public ArrayList<Applicant> getApplicants() {
		return applicants;
	}
	
}
