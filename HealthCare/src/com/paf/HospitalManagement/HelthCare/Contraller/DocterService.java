package com.paf.HospitalManagement.HelthCare.Contraller;

import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON 
import com.google.gson.*;



import com.paf.HospitalManagement.HelthCare.Bean.DoctorBean;
import com.paf.HospitalManagement.HelthCare.Model.DoctorModel;

/**
 * @author Shashini
 *
 */
@Path("/Doctor")
public class DocterService {

	//Convert the input string to an HTML document  
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String ViewDoctorDetails() {
			
			DoctorModel model = new DoctorModel();
			String output = model.viewDoctorDetails();
			
			return output;
		}
	
		@POST 
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		public String addDoctorDetails(String docDetails) 
		{  
			//Convert the input string to a JSON object  
			JsonObject docObject = new JsonParser().parse(docDetails).getAsJsonObject(); 
		 
			System.out.println("............................called");
			String f_name = docObject.get("f_name").getAsString();
			String l_name = docObject.get("l_name").getAsString();
			int age = docObject.get("age").getAsInt(); 
			String email = docObject.get("email").getAsString();
			int phoneNo = docObject.get("phoneNo").getAsInt(); 
			String nic = docObject.get("nic").getAsString(); 
			String Specialization = docObject.get("Specialization").getAsString(); 
			
			DoctorBean doctor = new DoctorBean();	
			
			doctor.setF_name(f_name);
			doctor.setL_name(l_name);
			doctor.setAge(age);
			doctor.setEmail(email);
			doctor.setPhoneNo(phoneNo);
			doctor.setNic(nic);
			doctor.setSpecialization(Specialization);
			
			DoctorModel model = new DoctorModel();
			
			//Read the values from the JSON object  
			String output = model.addDoctorDetails(doctor); 
			
			return output;
		} 
		@PUT 
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		public String updateDoCtorDetails(String docDetails) 
		{  
			//Convert the input string to a JSON object  
			JsonObject docObject = new JsonParser().parse(docDetails).getAsJsonObject(); 
		 
			int id = docObject.get("id").getAsInt();
			String f_name = docObject.get("f_name").getAsString();
			String l_name = docObject.get("l_name").getAsString();
			int age = docObject.get("age").getAsInt(); 
			String email = docObject.get("email").getAsString();
			int phoneNo = docObject.get("phoneNo").getAsInt(); 
			String nic = docObject.get("nic").getAsString(); 
			String Specialization = docObject.get("Specialization").getAsString(); 
		
			DoctorBean doctor = new DoctorBean();	
			
			doctor.setId(id);
			doctor.setF_name(f_name);
			doctor.setL_name(l_name);
			doctor.setAge(age);
			doctor.setEmail(email);
			doctor.setPhoneNo(phoneNo);
			doctor.setNic(nic);
			doctor.setSpecialization(Specialization);
			
			DoctorModel model = new DoctorModel();
			
			//Read the values from the JSON object  
			String output = model.updatedoctorDetails(doctor); 
			
			return output;
		} 
		
		@DELETE 
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON) 
		public String deleteItem(String data) 
		{  
				//Convert the input string to an Jason document  
			JsonObject docObj = new JsonParser().parse(data).getAsJsonObject();   
				
				//Read the value from the element <id>  
			int docId = docObj.get("id").getAsInt();
				 
				DoctorModel model = new DoctorModel();
				String output = model.deleteDoctorDetails(docId); 
				 
				 return output;
		 }
	
}
