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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="organisation")
@Cacheable(false)
public class Organisation {
	

	@Id
	@Column(name="org_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer org_id;
	
	
	
	private String org_name;
	
	
	
	private String Address;
	
	private String state;
	
	private String city;
	
	private String country;
	

	@OneToOne
	private Report report;
	
	
	
	public Report getReport() {
		return report;
	}


	public void setReport(Report report) {
		this.report = report;
	}


	@Size(max=13)
	private String phonenumber;
	
	


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Integer getOrg_id() {
		return org_id;
	}


	public void setOrg_id(Integer org_id) {
		this.org_id = org_id;
	}


	public String getOrg_name() {
		return org_name;
	}


	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	
	
	

}
