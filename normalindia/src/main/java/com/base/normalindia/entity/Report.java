package com.base.normalindia.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity
@Table(name="report")
@Cacheable(false)
public class Report {
	
	

	@Id
	@Column(name="report_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer reportid;
	
	

	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="report")
	private Set<Information> information=new HashSet<>();
	
	

	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="report")
	private Set<Comment> comments=new HashSet<>();
	
	
	@OneToOne(cascade=CascadeType.PERSIST,mappedBy="report")
	private Organisation org;



	public Integer getReportid() {
		return reportid;
	}



	public void setReportid(Integer reportid) {
		this.reportid = reportid;
	}



	public Set<Information> getInformation() {
		return information;
	}



	public void setInformation(Set<Information> information) {
		this.information = information;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
