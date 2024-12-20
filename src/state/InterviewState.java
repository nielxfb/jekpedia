package state;

import abstraction.IPhase;
import model.Applicant;

public class InterviewState implements IPhase {

	@Override
	public String showPhase() {
		return "Ongoing Interviews";
	}

	@Override
	public void nextPhase(Applicant applicant) {
		if (applicant.getJobPreference().equals("Backend Dev")) {
			applicant.setCurrentPhase(new ProblemSolvingState());
		} else if (applicant.getJobPreference().equals("Frontend Dev")) {
			
		} else {
			throw new IllegalArgumentException("Job preference doesn't exist!");
		}
	}

}
