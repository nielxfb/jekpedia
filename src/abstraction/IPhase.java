package abstraction;

import model.Applicant;

public interface IPhase {
	
	public String showPhase();
	public void nextPhase(Applicant applicant);

}
