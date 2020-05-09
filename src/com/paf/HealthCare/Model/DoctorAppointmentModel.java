package com.paf.HealthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.paf.HealthCare.Util.HealthCareDB;

public class DoctorAppointmentModel {

	
	HealthCareDB db = new HealthCareDB();
	Connection connection = db.getCon();
	
	//Create Method For Insert Doctor appoitment Details
	public String insertDoctorAppointment(String patient_number, String patient_name, String doctor_name,String time,String date, String status)
	{
		
		String output = ""; 
		
		try {
			
			// create a prepared statement    
			String query = " insert into doctorAppointment (`appoinement_id`,`patient_number`,`patient_name`,`doctor_name`,`time`,`date`,`status`)" 
			+ " values (?,?,?,?,?,?,?)"; 
			
			PreparedStatement preparedStmt = connection.prepareStatement(query); 
			
			//binding values    
			preparedStmt.setInt(1, 0);      
			preparedStmt.setInt(2, Integer.parseInt(patient_number)); 
			preparedStmt.setString(3,patient_name);       
			preparedStmt.setString(4,doctor_name);       
			preparedStmt.setString(5,time);
			preparedStmt.setString(6,date);
			preparedStmt.setString(7,status);			
			
			// execute the statement    
			preparedStmt.execute();    
			
			output = "Inserted successfully"; 
			
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while inserting the Doctor Appointment Details.";   
			System.err.println(e.getMessage()); 
			
		}
		return output; 
		
	}
	
		//Create method for view Doctor appointment Deatils
	public String readDoctorAppointment()  
	{
		String output = ""; 
		
		try {
			
			// Prepare the html table to be displayed 
			   output = "<table border=\"1\">"
			   		+ "<tr>"
			   		+ "<th>Patient_number</th>"
			   		+ "<th>patient_name</th>"
			   		+ "<th>Doctor_name</th>"
			   		+ "<th>time</th>"
			   		+ "<th>date</th>"
			   		+ "<th>status</th>"
			   		+ "<th>Update</th>"
			   		+ "<th>Remove</th>"
			   		+ "</tr>"; 
			
			   String query = "select * from doctorAppointment";    
			   Statement stmt = connection.createStatement();    
			   ResultSet rs = stmt.executeQuery(query); 
			   
			
			// iterate through the rows in the result set   
			   while (rs.next()) {
				   String appoinement_id = Integer.toString(rs.getInt("appoinement_id"));     
				   String Patient_number = Integer.toString(rs.getInt("Patient_number"));     
				   String patient_name = rs.getString("patient_name");         
				   String doctor_name = rs.getString("doctor_name");         
				   String time = rs.getString("time"); 
				   String date = rs.getString("date"); 
				   String status = rs.getString("status"); 
				   
				   
				// Add into the html table     
				   output += "<tr><td>" + Patient_number + "</td>";     
				   output += "<td>" + patient_name + "</td>";     
				   output += "<td>" + doctor_name + "</td>";     
				   output += "<td>" + time + "</td>";     
				   output += "<td>" + date + "</td>"; 
				   output += "<td>" + status + "</td>"; 
				   
				// buttons     
				   output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"      
						+ "<td><form method=\"post\" action=\"items.jsp\">" 
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"      
				   		+"<input name=\"appoinement_id\" type=\"hidden\" value=\"" + appoinement_id + "\">" + "</form></td></tr>"; 				   
				   
			   }
			   
			// Complete the html table   
			   output += "</table>";   
			   
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while reading the doctorAppointment details.";    
			System.err.println(e.getMessage()); 
		}
		return output; 
	}

		
		//Create method for update Doctor appointment Deatils
		public String updateDoctorAppointment(String appoinement_id,String patient_number, String patient_name,String doctor_name ,String time,String date, String status)  
		{   
			String output = "";
			
			try {
					// create a prepared statement    
					String query = "UPDATE doctorAppointment SET patient_number=?,patient_name=?,doctor_name=?,time=?,date=?,status=? WHERE appoinement_id=?"; 
					 
					PreparedStatement preparedStmt = connection.prepareStatement(query); 
					 
					//binding values   
					preparedStmt.setInt(1, Integer.parseInt(patient_number)); 
					preparedStmt.setString(2,patient_name);       
					preparedStmt.setString(3,doctor_name);       
					preparedStmt.setString(4,time);
					preparedStmt.setString(5,date);
					preparedStmt.setString(6,status);
					preparedStmt.setInt(7, Integer.parseInt(appoinement_id));  
					
					// execute the statement    
					preparedStmt.execute();    
					
					output = "Updated successfully"; 
					
			} catch (Exception e) {
				// TODO: handle exception
				
				output = "Error while updating the DoctorAppointment Details.";    
				System.err.println(e.getMessage()); 
				
			}
			   return output; 	
		}
	
		//Create method for Delete Doctor appointment Deatils
		public String deleteDoctorAppointment(String appoinement_id)  {   
			
			String output = ""; 
			
			try {
				 	// create a prepared statement    
					String query = "delete from doctorAppointment where appoinement_id=?"; 
					
					PreparedStatement preparedStmt = connection.prepareStatement(query); 
					 
					 // binding values    
					preparedStmt.setInt(1, Integer.parseInt(appoinement_id)); 
					
					// execute the statement    
					preparedStmt.execute();    
					
					output = "Deleted successfully"; 
					
				
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the DoctorAppointment Detials.";    
				System.err.println(e.getMessage());   
				
			}
			   return output; 		
		}
	
	
	
}
