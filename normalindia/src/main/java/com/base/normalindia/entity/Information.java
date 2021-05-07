package com.base.normalindia.entity;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="information")
@Cacheable(false)
public class Information extends CommonEntity{
	
	
	

	@Id
	@Column(name="information_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer information_id;
	
	
	private String type;
	
	private Boolean available;
	
	private Integer total;
	
	private Integer current;
	
	private Integer upvote;
	
	private Integer downvote;
	
	@ManyToOne(targetEntity=Report.class,fetch=FetchType.LAZY)
	@JoinColumn(name="report_id")
	private Report report;

	public Integer getInformation_id() {
		return information_id;
	}

	public void setInformation_id(Integer information_id) {
		this.information_id = information_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Integer getUpvote() {
		return upvote;
	}

	public void setUpvote(Integer upvote) {
		this.upvote = upvote;
	}

	public Integer getDownvote() {
		return downvote;
	}

	public void setDownvote(Integer downvote) {
		this.downvote = downvote;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
