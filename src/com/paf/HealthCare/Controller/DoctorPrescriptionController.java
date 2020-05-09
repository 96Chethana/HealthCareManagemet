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

import com.paf.HealthCare.Model.DoctorPrescriptionModel;

@Path("/Prescription")
public class DoctorPrescriptionController {
	
	DoctorPrescriptionModel modelObj = new DoctorPrescriptionModel();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)	
		//Convert the input string to an HTML document  
		public String readDoctorPrescription()
		{
			return modelObj.readDoctorPrescription();
			
		}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN) 
		public String inserDoctorPrescrtiption(
				
				@FormParam("patient_name")String patient_name,
				@FormParam("doctor_name") String doctor_name,
				@FormParam("medicine") String medicine,
				@FormParam("description") String description
				
				)
		{
			//Read the values from the JSON object  
			String output = modelObj.inserDoctorPrescrtiption(patient_name, doctor_name, medicine,description);
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
			String prescription_id = Object.get("prescription_id").getAsString();  
			String patient_name = Object.get("patient_name").getAsString();  
			String doctor_name = Object.get("doctor_name").getAsString();  
			String medicine = Object.get("medicine").getAsString();  
			String description = Object.get("description").getAsString();  
						 
			String output = modelObj.updateDoctorPrescription(prescription_id, patient_name, doctor_name, medicine,description);  
			return output; 
	} 


	@DELETE 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
/*	@Produces(MediaType.APPLICATION_JSON)*/

	public String deleteDoctorFeedback(String prescriptionData) 
	{  
			//Convert the input string to an XML document  
			Document doc = Jsoup.parse(prescriptionData, "", Parser.xmlParser());    
			
			//Read the value from the element <prescription_id>  
			String prescription_id = doc.select("prescription_id").text(); 
			 
			String output = modelObj.deleteDoctorPrescription(prescription_id); 
			 
			return output;
		
		
	 }

}
