package iterator;

import java.util.ArrayList;

import abstraction.Iterable;
import model.Applicant;

public class ApplicantIterator implements Iterable<Applicant> {

	private int currentIndex;
	private ArrayList<Applicant> applicants;

	public ApplicantIterator(ArrayList<Applicant> applicants) {
		currentIndex = 0;
		this.applicants = applicants;
	}

	@Override
	public Applicant getNext() {
		Applicant next = applicants.get(currentIndex);
		currentIndex++;
		return next;
	}

	@Override
	public boolean hasNext() {
		return currentIndex < applicants.size();
	}

}
