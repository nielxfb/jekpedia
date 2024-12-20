package state;

import abstraction.IPhase;
import model.Applicant;

public class FinishedState implements IPhase {

	@Override
	public String showPhase() {
		return "Applicant Successfully Saved";
	}

	@Override
	public void nextPhase(Applicant applicant) {
		applicant.setCurrentPhase(new SubmissionState());
	}

}
