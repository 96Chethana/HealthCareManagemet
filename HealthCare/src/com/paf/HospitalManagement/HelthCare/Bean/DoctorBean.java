/**
 * 
 */
package com.paf.HospitalManagement.HelthCare.Bean;

/**
 * @author Shashini
 *
 */
public class DoctorBean {
	
	int id;
	String f_name;
	String l_name;
	int age;
	String email;	
	int phoneNo;
	String nic;
	String Specialization;
	
	public DoctorBean() {
		
	}
	
	//Parameterized constructor
	public DoctorBean(int id, String f_name, String l_name, int age, String email, int phoneNo, String nic,
			String specialization) {
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.age = age;
		this.email = email;
		this.phoneNo = phoneNo;
		this.nic = nic;
		Specialization = specialization;
	}

	//Create Getters and Setters Methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

}
