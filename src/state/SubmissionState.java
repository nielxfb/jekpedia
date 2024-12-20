package state;

import abstraction.IPhase;
import model.Applicant;

public class SubmissionState implements IPhase {

	@Override
	public String showPhase() {
		return "Going Through Paperwork";
	}

	@Override
	public void nextPhase(Applicant applicant) {
		applicant.setCurrentPhase(new InterviewState());
	}

}
