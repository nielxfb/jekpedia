package state;

import abstraction.IPhase;
import model.Applicant;

public class ProblemSolvingState implements IPhase {

	@Override
	public String showPhase() {
		return "Solving Algorithm Problems";
	}

	@Override
	public void nextPhase(Applicant applicant) {
		applicant.setCurrentPhase(new FinishedState());
	}

}
