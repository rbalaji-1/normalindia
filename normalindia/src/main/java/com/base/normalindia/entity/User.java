/**
 * 
 */
package com.base.normalindia.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



/**
 * @author balajir
 *
 */
@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "phonenumber"),
		
		})
public class User extends CommonEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 13)
	private String phonenumber;
	
	@Size(max=20)
	private String firstname;
	
	@Size(max=20)
	
	private String lastname;
	
	
	private Boolean active;
	

//	
//
//	@ManyToOne(targetEntity=Report.class,fetch=FetchType.LAZY)
//	@JoinColumn(name="report_id")
//	private Report report;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




//
//	public Report getReport() {
//		return report;
//	}
//
//
//	public void setReport(Report report) {
//		this.report = report;
//	}


	
	


}