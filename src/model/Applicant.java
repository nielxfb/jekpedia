package model;

import abstraction.IPhase;
import state.SubmissionState;

public class Applicant {
	
	private String id;
	private String name;
	private Integer jobExperience;
	private String jobPreference;
	private IPhase currentPhase;
	
	public Applicant(String id, String name, Integer jobExperience, String jobPreference) {
		super();
		this.id = id;
		this.name = name;
		this.jobExperience = jobExperience;
		this.jobPreference = jobPreference;
		this.currentPhase = new SubmissionState();
		new Thread(new PhaseThread(this)).start();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getJobExperience() {
		return jobExperience;
	}

	public void setJobExperience(Integer jobExperience) {
		this.jobExperience = jobExperience;
	}

	public String getJobPreference() {
		return jobPreference;
	}

	public void setJobPreference(String jobPreference) {
		this.jobPreference = jobPreference;
	}

	public IPhase getCurrentPhase() {
		return currentPhase;
	}

	public void setCurrentPhase(IPhase currentPhase) {
		this.currentPhase = currentPhase;
	}
	
}