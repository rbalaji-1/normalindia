package com.base.normalindia.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.base.normalindia.entity.Organisation;
import com.base.normalindia.entity.Report;
import com.base.normalindia.services.ReportService;

@RestController
public class Reportcontroller {
	
	
	@Autowired
	ReportService reportservice;
	
	@PostMapping("/addreport")
	public ResponseEntity<?> addreport(@RequestBody Organisation org){
		
		
		
		
		reportservice.addreport(org);
		
		
	
		return new ResponseEntity<String>("added",HttpStatus.OK);
		
	}

}
