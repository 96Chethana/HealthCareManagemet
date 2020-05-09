package com.paf.HospitalManagement.HelthCare.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.paf.HospitalManagement.HelthCare.Bean.DoctorBean;
import com.paf.HospitalManagement.HelthCare.Util.HelthCareDB;

/**
 * @author Shashini
 *
 */
public class DoctorModel {

	HelthCareDB db = new HelthCareDB();
	Connection con = db.getCon();
	
	//Create method for addDoctorDetails
	public String addDoctorDetails(DoctorBean dBean) {

		String output = null;

		try { 		
				// create a prepared statement    
				String query = "INSERT INTO doctor (id,f_name, l_name,age, email,phoneNo,nic,Specialization)"
						+ " VALUE(?,?,?,?,?,?,?,?)";
				
				//Create object for binding values
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				
				//binding values    
				preparedStmt.setInt(1, dBean.getId());
				preparedStmt.setString(2, dBean.getF_name());
				preparedStmt.setString(3, dBean.getL_name());
				preparedStmt.setInt(4, dBean.getAge());
				preparedStmt.setString(5, dBean.getEmail());
				preparedStmt.setInt(6, dBean.getPhoneNo());
				preparedStmt.setString(7, dBean.getNic());
				preparedStmt.setString(8, dBean.getSpecialization());
				 	
				// execute the statement 
				System.out.print(preparedStmt);
				preparedStmt.execute();    
				
				output = "Inserted successfully"; //Display Inserted Sucessfully message
				
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while inserting the Doctor Details.";   
				System.err.println(e.getMessage()); 
				
			}
			return output; 		
	}

	//Create method for view the Details
	public String viewDoctorDetails()  
	{
		String output = ""; 
		
		try {
			
			   String sql = "select * from doctor";    
			   Statement stmt = con.createStatement();    
			   ResultSet rs = stmt.executeQuery(sql); 
			 
			   // Prepare the html table to be displayed 
			   output = "<table border=\"1\">"
			   		+ "<tr>"
			   		+ "<th> Doctor Id </th>"
			   		+ "<th>First Name</th>"
			   		+ "<th>Last Name</th>"
			   		+ "<th>Age</th>"
			   		+ "<th>Email</th>"
			   		+ "<th>Contact Number</th>"
			   		+ "<th>NIC</th>"
			   		+ "<th>Speciallization</th>"
			   		+ "</tr>"; 
			   
			// iterate through the rows in the result set   
			   while (rs.next()) {
				   
				   output +=  "<tr>"
		     				+ "<td>"+rs.getInt("id")+"</td>"
		     				+ "<td>"+rs.getString("f_name")+"</td>"
		     				+ "<td>"+rs.getString("l_name")+"</td>"
		     				+ "<td>"+rs.getInt("age")+"</td>"
		     				+ "<td>"+rs.getString("email")+"</td>"
		     				+ "<td>"+rs.getString("phoneNo")+"</td>"
		     				+ "<td>"+rs.getString("nic")+"</td>"	     							 
		     				+ "<td>"+rs.getString("speciallization")+"</td>"	     							 
		     				+ "</tr>";
				   
			   }
			   // Complete the html table   
			   output += "</table>";   
			   
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while reading the doctor Details.";    
			System.err.println(e.getMessage()); 
		}  
		return output;	   
	}
	
	//Create method for  updateDoctorDetails
	public String updatedoctorDetails(DoctorBean doctorBean)  
	{   
		String output = "";
		
		try {
				// create a prepared statement    
				String query = "UPDATE doctor SET "
						+ " f_name=?,"
						+ "l_name=?,"
						+ "age=?,"
						+ "email=?,"
						+ "phoneNo=?,"
						+ "nic=?,"
						+ "Specialization=?  WHERE id=?"; 
				 
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				preparedStmt.setString(1, doctorBean.getF_name());
				preparedStmt.setString(2, doctorBean.getL_name());
				preparedStmt.setInt(3, doctorBean.getAge());
				preparedStmt.setString(4, doctorBean.getEmail());
				preparedStmt.setInt(5, doctorBean.getPhoneNo());
				preparedStmt.setString(6, doctorBean.getNic());
				preparedStmt.setString(7, doctorBean.getSpecialization());    
				preparedStmt.setInt(8, doctorBean.getId());  
			
				// execute the statement    
				preparedStmt.execute();    
				
				output = "Updated successfully"; //Display Updated Sucessfully message
			
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "Error while updating the item.";    
			System.err.println(e.getMessage()); 
			
		}
		   return output; 	
	}
	
	//Create method for Delete Doctor detils
	public String deleteDoctorDetails(int id)  {   
			
			String output = ""; 
			
			try {
					// create a prepared statement    
					String query = "delete from doctor where id=?"; 
					
				
					PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					// binding values    
					preparedStmt.setInt(1, id); 
					
					// execute the statement    
					preparedStmt.execute();    
				 
					output = "Deleted successfully"; //Display deleted Sucessfully message
						
			 } catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the item.";    
				System.err.println(e.getMessage());   	
			}
			   return output; 		
		}
		
}
