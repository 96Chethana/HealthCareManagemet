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
import com.paf.HealthCare.Model.DoctorModel;

@Path("/Doctor")
public class DoctorController {

	//Convert the input string to an HTML document  
	DoctorModel modelObj = new DoctorModel(); 
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
		public String ReadDoctorDetails()
		{
			return modelObj.readDoctorDetails();
			
		}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN) 
		public String insertDoctorDeatails(
				
				@FormParam("f_name")String f_name,
				@FormParam("l_name") String l_name,
				@FormParam("age") String age,
				@FormParam("email") String email,
				@FormParam("phoneNo") String phoneNo,
				@FormParam("nic") String nic,
				@FormParam("hospital_name") String hospital_name,
				@FormParam("specialization") String specialization
				
				)
		{
			//Read the values from the JSON object  
			String output = modelObj.insertDoctorDeatails(f_name, l_name, age, email, phoneNo, nic,hospital_name, specialization);
			return output;
		}
		
	@PUT 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 

		public String updateItem(String itemData) 
		{  
			//Convert the input string to a JSON object  
			JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject(); 
		 
		 		//Read the values from the JSON object  
				String id = itemObject.get("id").getAsString();  
				String f_name = itemObject.get("f_name").getAsString();  
				String l_name = itemObject.get("l_name").getAsString();  
				String age = itemObject.get("age").getAsString();  
				String email = itemObject.get("email").getAsString(); 
				String phoneNo = itemObject.get("phoneNo").getAsString(); 
				String nic = itemObject.get("nic").getAsString(); 
				String hospital_name = itemObject.get("hospital_name").getAsString(); 
				String specialization = itemObject.get("specialization").getAsString(); 
				 
				String output = modelObj.updateDoctorDetails(id,f_name,l_name,age,email,phoneNo,nic,hospital_name,specialization);  
				return output; 
		} 
		

		@DELETE 
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 

		public String deleteItem(String docData) 
		{  
				//Convert the input string to an XML document  
				Document doc = Jsoup.parse(docData, "", Parser.xmlParser());    
				
				//Read the value from the element <id>  
				String id = doc.select("id").text(); 
				 
				 String output = modelObj.deleteDoctorDetails(id); 
				 
				 return output;
		 }

	
	
}
