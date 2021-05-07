package com.base.normalindia.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.normalindia.entity.Information;
import com.base.normalindia.entity.Organisation;
import com.base.normalindia.entity.Report;
import com.base.normalindia.entity.User;
import com.base.normalindia.repository.InformationRepository;
import com.base.normalindia.repository.OrganisationRepository;
import com.base.normalindia.repository.ReportRepository;
import com.base.normalindia.repository.UserRepository;
import com.base.normalindia.util.OrganisationSpecification;
import com.base.normalindia.util.SearchCriteria;

@Service
public class ReportService {
	
	
	
	@Autowired
	ReportRepository reportrepo;
	
	@Autowired
	OrganisationRepository orgrepo;
	
	@Autowired
	InformationRepository inforepo;
	
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
	public List<Organisation> getdetailsbystate(String state) {
		// TODO Auto-generated method stub
		
		OrganisationSpecification opsec=new OrganisationSpecification(new SearchCriteria("state", ":", state));
		
		
		
		return orgrepo.findAll(Specification.where(opsec));
		
		//return orgrepo.findByStateContaining(state);
		
	}
	@Transactional
	public Information  updateInformation(Information info) {
		// TODO Auto-generated method stub
		
		
		
		  if (inforepo.findByinformationid(info.getInformation_id()).get()!=null) {
			  
			 Information infoexist= inforepo.findByinformationid(info.getInformation_id()).get();
			  
			 Report r= inforepo.findByinformationid(info.getInformation_id()).get().getReport();
			  info.setModifiedon(new Date());
			  info.setReport(r);
			  if(info.getUpvote()==1) {
			  Integer sum=info.getUpvote()+infoexist.getUpvote();
			  info.setUpvote(sum);
			  }
			  if(info.getDownvote()==1) {
				  Integer sum=info.getDownvote()+infoexist.getDownvote();
				  info.setDownvote(sum);;
				  }
			  
	           Information inof=inforepo.save(info);
	           
	          return inof;
	        }
		return null;
	}

}
