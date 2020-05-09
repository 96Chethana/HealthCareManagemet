package com.paf.HealthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.paf.HealthCare.Util.HealthCareDB;

public class DoctorPrescriptionModel {

	HealthCareDB db = new HealthCareDB();
	Connection connection = db.getCon();
	
	//Create method for insert prescription details
	public String inserDoctorPrescrtiption(String patient_name, String doctor_name, String medicine, String description)  
	{   
		
		String output = ""; 
		
		try {
			
			// create a prepared statement    
			String query = " insert into doctorprescription (`prescription_id`,`patient_name`,`doctor_name`,`medicine`,`description`)" + " values (?, ?, ?, ?, ?)"; 
			
			
			PreparedStatement preparedStmt = connection.prepareStatement(query); 
			
			//binding values    
			preparedStmt.setInt(1, 0);    
			preparedStmt.setString(2, patient_name);    
			preparedStmt.setString(3, doctor_name);     
			preparedStmt.setString(4, medicine); 
			preparedStmt.setString(5, description); 
			
			// execute the statement    
			preparedStmt.execute();    
			
			output = "Inserted successfully"; 
			
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while inserting the Doctor Prescription.";   
			System.err.println(e.getMessage()); 
			
		}
		return output; 
		
	}
	
	//Create method for View prescription details
	public String readDoctorPrescription()  
	{
		String output = ""; 
		
		try {
	
				// Prepare the html table to be displayed 
				   output = "<table border=\"1\"><tr><th>Patient_name</th><th>Doctor_name</th><th>Medicine</th><th> Description</th><th>Update</th><th>Remove</th></tr>"; 
				
				   String query = "select * from doctorprescription";    
				   Statement stmt = connection.createStatement();    
				   ResultSet rs = stmt.executeQuery(query); 
				   
				
				// iterate through the rows in the result set   
				   while (rs.next()) {
					   String prescription_id = Integer.toString(rs.getInt("prescription_id"));     
					   String patient_name = rs.getString("patient_name");     
					   String doctor_name = rs.getString("doctor_name");     
					   String medicine = rs.getString("medicine"); 
					   String description = rs.getString("description"); 
					   
					   
					// Add into the html table     
					   output += "<tr><td>" + patient_name + "</td>";     
					   output += "<td>" + doctor_name + "</td>";     
					   output += "<td>" + medicine + "</td>";     
					   output += "<td>" + description + "</td>"; 
					   
					   
					// buttons     
					   output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"      
							+ "<td><form method=\"post\" action=\"items.jsp\">" 
							+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"      
					   		+ "<input name=\"prescription_id\" type=\"hidden\" value=\"" + prescription_id + "\">" + "</form></td></tr>"; 				   
					   
			   }
			   
			// Complete the html table   
			   output += "</table>";   
			   
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while reading the prescription details.";    
			System.err.println(e.getMessage()); 
		}
		return output; 
	}

	
	
	public String updateDoctorPrescription(String prescription_id, String patient_name, String doctor_name, String medicine, String description)  
	{   
		String output = "";
		
		try {

			
				// create a prepared statement    
				String query = "UPDATE doctorprescription SET patient_name=?,doctor_name=?,medicine=?,description=? WHERE prescription_id=?"; 
				 
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				 
			
				preparedStmt.setString(1, patient_name);    
				preparedStmt.setString(2, doctor_name);    
				preparedStmt.setString(3, medicine);    
				preparedStmt.setString(4, description);    
				preparedStmt.setInt(5, Integer.parseInt(prescription_id));  
				
				// execute the statement    
				preparedStmt.execute();    
				
				output = "Updated successfully"; 
			
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "Error while updating the Details.";    
			System.err.println(e.getMessage()); 
			
		}
		   return output; 	
	}
	
	
	public String deleteDoctorPrescription(String prescription_id)  {   
		
		String output = ""; 
		
		try {
				// create a prepared statement    
				String query = "delete from doctorprescription where prescription_id=?"; 
				
				
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				 
				// binding values    
				preparedStmt.setInt(1, Integer.parseInt(prescription_id)); 
				
				// execute the statement    
				preparedStmt.execute();    
				
				output = "Deleted successfully"; 
				
			
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while deleting the prescription details.";    
			System.err.println(e.getMessage());   
			
		}

		   return output; 		
	}
	
}
