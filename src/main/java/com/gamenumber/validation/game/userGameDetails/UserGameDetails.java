package com.gamenumber.validation.game.userGameDetails;

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
@Table(name="gamer_game_details")
public class UserGameDetails {
	

	@Id
	@Column(name="gamer_id")
	private String gamerid;
	
	@Column(name="game_room")
	private String gameroom;
	
	@Column(name="set_num_to_opponent")
	private String setnumto;
	
	@Column(name="ready")
	private String ready;
	
	@Column(name="time_stamp")
	private String timeStamp;
	
	
	
	
	
	public String getTimeStamp() {
		return timeStamp;
	}




	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}




	public String getGamerid() {
		return gamerid;
	}




	public void setGamerid(String gamerid) {
		this.gamerid = gamerid;
	}




	public String getGameroom() {
		return gameroom;
	}




	public void setGameroom(String gameroom) {
		this.gameroom = gameroom;
	}




	public String getSetnumto() {
		return setnumto;
	}




	public void setSetnumto(String setnumto) {
		this.setnumto = setnumto;
	}




	public String getReady() {
		return ready;
	}




	public void setReady(String ready) {
		this.ready = ready;
	}




	public UserGameDetails() {
		
	}
	
	
	

	public UserGameDetails(String gamerid, String gameroom, String setnumto, 
			String ready, String timeStamp) {
		super();
		this.gamerid = gamerid;
		this.gameroom = gameroom;
		this.setnumto = setnumto;
		this.ready = ready;
		this.timeStamp = timeStamp;
	}
	
	
	
	





}
