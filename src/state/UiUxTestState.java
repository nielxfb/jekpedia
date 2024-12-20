package state;

import abstraction.IPhase;
import model.Applicant;

public class UiUxTestState implements IPhase {

	@Override
	public String showPhase() {
		return "Designing Application UI UX";
	}

	@Override
	public void nextPhase(Applicant applicant) {
		applicant.setCurrentPhase(new FinishedState());
	}

}
