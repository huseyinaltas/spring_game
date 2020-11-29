package com.gamenumber.validation.userScores;

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
@Table(name="gamers_score")
public class UserScores {
	

	@Id
	@Column(name="gamer_e")
	private String gamerEmail;

	@Column(name="gamer_id")
	private String gamerid;
	
	@Column(name="score")
	private String score;
	
	
	public UserScores() {
		
	}
	

	public UserScores(String gamerid, String score, String gamerEmail) {
		super();
		this.gamerid = gamerid;
		this.score = score;
		this.gamerEmail = gamerEmail;
	}


	public String getGamerid() {
		return gamerid;
	}


	public void setGamerid(String gamerid) {
		this.gamerid = gamerid;
	}


	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}
	
	public String getGamerEmail() {
		return gamerEmail;
	}


	public void setGamerEmail(String gamerEmail) {
		this.gamerEmail = gamerEmail;
	}
	
	
	
	
	
	
	





}
