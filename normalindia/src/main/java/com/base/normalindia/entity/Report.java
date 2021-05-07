package com.base.normalindia.entity;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.base.normalindia.entity.User;



@Entity
@Table(name="report")
@Cacheable(false)
public class Report extends CommonEntity{
	
	

	@Id
	@Column(name="report_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer reportid;
	
	

	@OneToMany(cascade = CascadeType.ALL,mappedBy="report")
	private List<Information> information=new ArrayList<>();

	@Transient
	private User user;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="report")
	private List<Comment> comments=new ArrayList<>();
	




	public Integer getReportid() {
		return reportid;
	}



	public void setReportid(Integer reportid) {
		this.reportid = reportid;
	}



	public List<Information> getInformation() {
		return information;
	}



	public void setInformation(List<Information> information) {
		
		
		this.information = information;
		
		for(Information in:this.information) {
			
		in.setReport(this);
		}
	}



	public List<Comment> getComments() {
		
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
		for(Comment in:this.comments) {
			
		in.setReport(this);
		}
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}


//
//	public List<User> getUser() {
//		return user;
//	}
//
//
//
//	public void setUser(List<User> user) {
//		this.user = user;
//		
//		for(User in:this.user) {
//			
//			in.setReport(this);
//			}
//	}
	
	




	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
