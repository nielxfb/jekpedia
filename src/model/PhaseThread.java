package model;

public class PhaseThread implements Runnable {
	
	private Applicant applicant;
	
	public PhaseThread(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			applicant.getCurrentPhase().nextPhase(applicant);
		}
	}
	
}
