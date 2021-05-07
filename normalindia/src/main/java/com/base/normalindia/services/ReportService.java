package com.base.normalindia.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.normalindia.entity.Organisation;
import com.base.normalindia.entity.Report;
import com.base.normalindia.entity.User;
import com.base.normalindia.repository.OrganisationRepository;
import com.base.normalindia.repository.ReportRepository;
import com.base.normalindia.repository.UserRepository;

@Service
public class ReportService {
	
	
	
	@Autowired
	ReportRepository reportrepo;
	
	@Autowired
	OrganisationRepository orgrepo;
	
	@Autowired
	UserRepository usr;
	public String addreport(Organisation org) {
		
		User us=org.getReport().getUser();
		if(!usr.findByphonenumber(us.getPhonenumber()).isPresent()){
			

			us.setCreatedOn(new Date());
			us.setCreatedBy(us.getFirstname());
			usr.save(us);
			
		}
		org.getReport().setCreatedOn(new Date());
		org.getReport().setCreatedBy(us.getPhonenumber());
		
		orgrepo.save(org);
		return "added";
		
		
	}

}
