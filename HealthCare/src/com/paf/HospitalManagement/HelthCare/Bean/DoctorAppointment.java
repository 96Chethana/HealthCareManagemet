/**
 * 
 */
package com.paf.HospitalManagement.HelthCare.Bean;

/**
 * @author Shashini
 *
 */
public class DoctorAppointment {
	
	int appointmentId;
	String pName;
	String time;
	String date;
	
	public DoctorAppointment() {
		
	}
	
	/**
	 * @param appointmentId
	 * @param pName
	 * @param time
	 * @param date
	 */
	public DoctorAppointment(int appointmentId, String pName, String time, String date) {
		this.appointmentId = appointmentId;
		this.pName = pName;
		this.time = time;
		this.date = date;
	}

	//Create Getters and Setters
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
