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
import com.paf.HealthCare.Model.DoctorFeedbackModel;

@Path("/Feedback")
public class DoctorFeedbackController {
	
	//Create object from DoctorFeedbackModel class
	DoctorFeedbackModel modelObj = new DoctorFeedbackModel(); 
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)	
		//Convert the input string to an HTML document  
		public String InsertDoctorFeedback()
		{
			return modelObj.readDoctorFeedback();
			
		}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN) 
		public String insertDoctorFeedback(
				
				@FormParam("f_name")String f_name,
				@FormParam("date") String date,
				@FormParam("message") String message
				
				)
		{
			//Read the values from the JSON object  
			String output = modelObj.insertDoctorFeedback(f_name, date, message);
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
			String feedback_id = Object.get("feedback_id").getAsString();  
			String f_name = Object.get("f_name").getAsString();  
			String date = Object.get("date").getAsString();  
			String message = Object.get("message").getAsString();  
						 
			String output = modelObj.updateDoctorFeedback(feedback_id, f_name, date, message);  
			return output; 
	} 


	@DELETE 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 

	public String deleteDoctorFeedback(String feedbackData) 
	{  
			//Convert the input string to an XML document  
			Document doc = Jsoup.parse(feedbackData, "", Parser.xmlParser());    
			
			//Read the value from the element <feedback_id>  
			String feedback_id = doc.select("feedback_id").text(); 
			 
			 String output = modelObj.deleteDoctorFeedback(feedback_id); 
			 
			 return output;
	 }
		
}
