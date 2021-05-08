package com.base.normalindia.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.normalindia.entity.Hospital;
import com.base.normalindia.repository.hospitalRepository;
import com.base.normalindia.services.ReportService;
import com.base.normalindia.util.GenericResponse;
import com.base.normalindia.util.MessageResponse;

@RestController
public class HospitalController {
	
	
	@Autowired
	hospitalRepository hrepo;
	
	
	@Autowired
	ReportService reportservice;
	
//
//	@Autowired
//    private MessageSource messages;
	
	
	@PostMapping("/addhospital")
	public ResponseEntity<?> addhospital(@RequestParam("state")String state,@RequestBody List<Hospital> hos){
		
		try {
			
			System.out.println("hos");
			
		hos.parallelStream().forEach(e->
		{
			e.setState(state);
			if(!e.getHospital_phone().isEmpty())
			{
	
	if((hrepo.findHospitalbyphone(e.getHospital_phone())==null)){
		
		hrepo.save(e);
		
		}
		}
			else {
			hrepo.save(e);
			}
		}
	
		);
		
		GenericResponse  gr= new GenericResponse("Success");
		
		return new ResponseEntity<>(gr,HttpStatus.OK);
		
		}
		
		catch(Exception e) {
			

			GenericResponse  gr= new GenericResponse(e.getMessage());
		
			return new ResponseEntity<>(gr,HttpStatus.OK);
		
	}
	}
	
	
	@GetMapping("/gethospitaldata")

	public ResponseEntity<?> gethospitaldata(final HttpServletRequest request,@RequestParam("state") String state){
		
		//GenericResponse gr=null;
		
		try {
		List<Hospital> list=reportservice.gethospitallistbystate(state);
		
//
//		   gr= new GenericResponse(
//		  	      messages.getMessage("success", null, 
//		  	      request.getLocale()));
		   
		   
			
	
		return new ResponseEntity<>(list,HttpStatus.OK);
		}
		
			
			catch(Exception e) {
				
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse(e.getStackTrace().toString()));
			}
		}
	
	@GetMapping("/gethospitaldatabypin")

	public ResponseEntity<?> gethospitaldataByPin(final HttpServletRequest request,@RequestParam("pincode") String pincode){
		
		//GenericResponse gr=null;
		
		try {
		List<Hospital> list=reportservice.gethospitallistbypin(pincode);
		
//
//		   gr= new GenericResponse(
//		  	      messages.getMessage("success", null, 
//		  	      request.getLocale()));
		   
		   
			
	
		return new ResponseEntity<>(list,HttpStatus.OK);
		}
		
			
			catch(Exception e) {
				e.printStackTrace();
				
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse(e.getMessage()));
			}
		}

	
	
}
