package com.base.normalindia.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.normalindia.entity.Information;
import com.base.normalindia.entity.Organisation;
import com.base.normalindia.entity.Report;
import com.base.normalindia.services.ReportService;
import com.base.normalindia.util.GenericResponse;
import com.base.normalindia.util.MessageResponse;

@RestController
public class Reportcontroller {
	
	
	@Autowired
	ReportService reportservice;
	

	@Autowired
    private MessageSource messages;
	
	@PostMapping("/addreport")
	public ResponseEntity<?> addreport(final HttpServletRequest request,@RequestBody Organisation org){
		
		GenericResponse gr=null;
		
		try {
		reportservice.addreport(org);
		

		   gr= new GenericResponse(
		  	      messages.getMessage("message.addedrecord", null, 
		  	      request.getLocale()));
			
	
		return new ResponseEntity<GenericResponse>(gr,HttpStatus.OK);
		}
		
			
			catch(Exception e) {
				
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse(e.getStackTrace().toString()));
			}
		}
	
	
	@GetMapping("/SearchByState")
	public ResponseEntity<?> search(final HttpServletRequest request,@RequestParam("state") String state){
		
		GenericResponse gr=null;
		
		try {
		List<Organisation> list=reportservice.getdetailsbystate(state);
		

		   gr= new GenericResponse(
		  	      messages.getMessage("message.addedrecord", null, 
		  	      request.getLocale()));
		   
		   
			
	
		return new ResponseEntity<>(list,HttpStatus.OK);
		}
		
			
			catch(Exception e) {
				
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse(e.getStackTrace().toString()));
			}
		}
	
	@PutMapping("/updateinfo")
	public ResponseEntity<?> updateInformation(final HttpServletRequest request,@RequestBody Information info){
		
		GenericResponse gr=null;
		
		try {
		Information info1=reportservice.updateInformation(info);
		

		   gr= new GenericResponse(
		  	      messages.getMessage("message.addedrecord", null, 
		  	      request.getLocale()));
		   
		   
			
	
		return new ResponseEntity<>(info1,HttpStatus.OK);
		}
		
			
			catch(Exception e) {
				
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse(e.getStackTrace().toString()));
			}
		}
		
	}


