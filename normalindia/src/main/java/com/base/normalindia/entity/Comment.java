package com.base.normalindia.entity;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="Comment")
@Cacheable(false)
public class Comment {
	

	public Comment(Integer like_count) {
		super();
		this.like_count = like_count;
	}

	public Comment(String text_message, Timestamp timestamp, User user,Integer like_count) {
		super();
		this.text_message = text_message;
		this.insert_ts = timestamp;
		this.user = user;
		this.like_count=like_count;
	}
	
	public Comment() {}

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer comment_id;
	
	
	@Column(name="text_message")
	private String text_message;
	
	@Column(name="Insert_ts")
	@DateTimeFormat(pattern = "dd MMMM yyyy zzzz")
	private Timestamp insert_ts;
	@Column(name="like_count")
	private Integer like_count;
	
	@ManyToOne
	private User user;
	

	@ManyToOne
	private Report report;

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public String getText_message() {
		return text_message;
	}

	public void setText_message(String text_message) {
		this.text_message = text_message;
	}

	public Timestamp getInsert_ts() {
		return insert_ts;
	}

	public void setInsert_ts(Timestamp insert_ts) {
		this.insert_ts = insert_ts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Integer getLike_count() {
		return like_count;
	}

	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	
	

	

}
