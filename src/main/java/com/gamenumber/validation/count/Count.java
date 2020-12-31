package com.gamenumber.validation.count;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="game_count")
public class Count {
	

	@Id
	@Column(name="count")
	private long count;
	
	
	
	public Count() {
		
	}
	

	public Count(int count, String time) {
		super();
		this.count = count;
		this.time = time;
	}


	public long getCount() {
		return count;
	}


	public void setCount(long count) {
		this.count = count;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Column(name="time")
	private String time;
	
	
	
	
	
	
	
	
	





}
