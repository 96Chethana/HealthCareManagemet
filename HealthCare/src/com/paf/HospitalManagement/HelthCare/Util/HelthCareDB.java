/**
 * 
 */
package com.paf.HospitalManagement.HelthCare.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shashini
 *
 */
public class HelthCareDB   {
	
	//A common method to connect to the DB 
		Connection con = null; 
		public Connection getCon() {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				//Provide the correct details: DBServer/DBName, username, password 
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","Shashini702*");
				
			} catch (ClassNotFoundException e) {
				
				 e.printStackTrace();
				 
			}catch (SQLException e) {	
				
				 e.printStackTrace();
			}
			
		return con;  //if Connection is already created return it
			
		}
 

}
