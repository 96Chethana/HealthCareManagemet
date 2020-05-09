package com.paf.HealthCare.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paf.HealthCare.Model.DoctorAppointmentModel;

@Path("/DoctorAppointment")
public class DoctorAppointmentController {

	
	
	//Create object from DoctorFeedbackModel class
	DoctorAppointmentModel modelObj = new DoctorAppointmentModel(); 
		
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)	
			//Convert the input string to an HTML document  
			public String insertDoctorAppointment()
			{
				return modelObj.readDoctorAppointment();
				
			}
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN) 
			public String readDoctorAppointment(
					
					@FormParam("patient_number")String patient_number,
					@FormParam("patient_name") String patient_name,
					@FormParam("doctor_name") String doctor_name,
					@FormParam("time") String time,
					@FormParam("date") String date,
					@FormParam("status") String status
					
					)
			{
				//Read the values from the JSON object  
				String output = modelObj.insertDoctorAppointment(patient_number, patient_name,doctor_name,time,date,status);
				return output;
			}
			
		
		@PUT 
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 

		public String updateDoctorFeedback(String feddbackData) 
		{  
			//Convert the input string to a JSON object  
			JsonObject Object = new JsonParser().parse(feddbackData).getAsJsonObject(); 
		 
		 		//Read the values from the JSON object  
				String appoinement_id = Object.get("appoinement_id").getAsString();  
				String patient_number = Object.get("patient_number").getAsString();  
				String patient_name = Object.get("patient_name").getAsString();  
				String doctor_name = Object.get("doctor_name").getAsString();  
				String time = Object.get("time").getAsString();  
				String date = Object.get("date").getAsString();  
				String status = Object.get("status").getAsString();  
							 
				String output = modelObj.updateDoctorAppointment(appoinement_id, patient_number, patient_name,doctor_name,time,date,status);  
				return output; 
		} 


		@DELETE 
		@Path("/") 
		//@Consumes(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_XML) 

		public String deleteDoctorFeedback(String appoitmentData) 
		{  
				//Convert the input string to an XML document  
				Document doc = Jsoup.parse(appoitmentData, "", Parser.xmlParser());    
				
				//Read the value from the element <appoinement_id>  
				String appoinement_id = doc.select("appoinement_id").text(); 
				 
				 String output = modelObj.deleteDoctorAppointment(appoinement_id); 
				 
				 return output;
		 }
	
	
}
