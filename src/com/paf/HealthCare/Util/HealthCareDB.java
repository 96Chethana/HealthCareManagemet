package com.paf.HealthCare.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HealthCareDB {
	
	Connection connection = null; 
	public Connection getCon() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HealthCareDB","root","Shashini702*");
			
		} catch (ClassNotFoundException e) {
			
			 e.printStackTrace();
			 
		}catch (SQLException e) {	
			
			 e.printStackTrace();
		}
		
	return connection;
		
	}

}
