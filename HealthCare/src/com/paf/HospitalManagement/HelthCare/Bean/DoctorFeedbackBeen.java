package com.paf.HospitalManagement.HelthCare.Bean;

/**
 * @author Shashini
 *
 */
public class DoctorFeedbackBeen {
	
	int feedbackId;
	int dId;
	String name;
	String message;
	
	public DoctorFeedbackBeen() {
		
	}
	
	/**
	 * @param feedbackId
	 * @param dId
	 * @param name
	 * @param message
	 */
	public DoctorFeedbackBeen(int feedbackId, int dId, String name, String message) {
		this.feedbackId = feedbackId;
		this.dId = dId;
		this.name = name;
		this.message = message;
	}

	//Create Getters and Setters
	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
