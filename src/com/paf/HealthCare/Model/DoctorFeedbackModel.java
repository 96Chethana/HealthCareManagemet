package com.paf.HealthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.paf.HealthCare.Util.HealthCareDB;

public class DoctorFeedbackModel {
	
	HealthCareDB db = new HealthCareDB();
	Connection connection = db.getCon();
	
	public String insertDoctorFeedback(String f_name, String date, String message)  
	{   
		
		String output = ""; 
		
		try {
			
				// create a prepared statement    
				String query = " insert into doctorfeedback (`feedback_id`,`f_name`,`date`,`message`)" + " values (?, ?, ?, ?)"; 
				
				
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				
				//binding values    
				preparedStmt.setInt(1, 0);    
				preparedStmt.setString(2, f_name);    
				preparedStmt.setString(3, date);     
				preparedStmt.setString(4, message); 
				
				// execute the statement    
				preparedStmt.execute();    
				
				output = "Inserted successfully"; 
				
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while inserting the doctor feedback.";   
			System.err.println(e.getMessage()); 
			
		}
		return output; 
		
	}
	
	
	public String readDoctorFeedback()  
	{
		String output = ""; 
		
		try {
		
				// Prepare the html table to be displayed 
				   output = "<table border=\"1\">"
				   		+ "<tr>"
				   		+ "<th>Name</th>"
				   		+ "<th>Date</th>"
				   		+ "<th>Message</th>"
				   		+ "<th>Update</th>"
				   		+ "<th>Remove</th>"
				   		+ "</tr>"; 
				
				   String query = "select * from doctorfeedback";    
				   Statement stmt = connection.createStatement();    
				   ResultSet rs = stmt.executeQuery(query); 
				   
				
				// iterate through the rows in the result set   
				   while (rs.next()) {
					   String feedback_id = Integer.toString(rs.getInt("feedback_id"));     
					   String f_name = rs.getString("f_name");     
					   String date = rs.getString("date");       
					   String message = rs.getString("message"); 
					   
					   
					// Add into the html table        
					   output += "<td>" + f_name + "</td>";     
					   output += "<td>" + date + "</td>";     
					   output += "<td>" + message + "</td>"; 
					   
					   
					// buttons     
					   output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"      
							+ "<td><form method=\"post\" action=\"items.jsp\">" 
							+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"      
					   		+ "<input name=\"feedback_id\" type=\"hidden\" value=\"" + feedback_id + "\">" + "</form></td></tr>"; 				   
				   
			   }
			   
			// Complete the html table   
			   output += "</table>";   
			   
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while reading the doctor feedback.";    
			System.err.println(e.getMessage()); 
		}
		return output; 
	}

	
	public String updateDoctorFeedback(String feedback_id, String f_name, String date, String message)  
	{   
		String output = "";
		
		try {
			
				// create a prepared statement    
				String query = "UPDATE doctorfeedback SET f_name=?,date=?,message=? WHERE feedback_id=?"; 
				 
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				 
			
				preparedStmt.setString(1, f_name);    
				preparedStmt.setString(2, date);    
				preparedStmt.setString(3, message);    
				preparedStmt.setInt(4, Integer.parseInt(feedback_id));  
				
				// execute the statement    
				preparedStmt.execute();    
				
				output = "Updated successfully"; 
				
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "Error while updating the feedback Details.";    
			System.err.println(e.getMessage()); 
			
		}
		   return output; 	
	}
	
	
	public String deleteDoctorFeedback(String feedback_id)  {   
		
		String output = ""; 
		
		try {
			 
				// create a prepared statement    
				String query = "delete from doctorfeedback where feedback_id=?"; 	
				
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				 
				 // binding values    
				preparedStmt.setInt(1, Integer.parseInt(feedback_id)); 
				
				// execute the statement    
				preparedStmt.execute();    
				 
				output = "Deleted successfully"; 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while deleting the feddback details.";    
			System.err.println(e.getMessage());   
			
		}

		   return output; 		
	}
	
	
	

}
