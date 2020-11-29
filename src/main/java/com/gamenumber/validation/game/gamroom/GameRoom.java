package com.gamenumber.validation.game.gamroom;

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
@Table(name="game_room")
public class GameRoom {
	
	
	@Id
	@Column(name="room_id")
	private String roomId;
	
	@Column(name="firstgamer_id")
	private String firstGamerId;
	
	@Column(name="secondgamer_id")
	private String secondGamerId;
	
	@Column(name="firstnumber_set")
	private String firstGamerNumberSetNum;
	
	@Column(name="secondnumber_set")
	private String secondGamerNumberSetNum;
	
	@Column(name="firstg_guess")
	private String firstGamerGuess;
	
	@Column(name="secondg_guess")
	private String secondGamerGuess;
	
	@Column(name="who_next")
	private String whoNext;
	
	@Column(name="who_won")
	private String whoWon;

	@Column(name="time_stamp")
	private String timeStamp;
	
	@Column(name="friend")
	private String friend;
	
	
	
	




















	public GameRoom() {
	}



	


	public GameRoom(String roomId, String firstGamerId, String secondGamerId, String firstGamerNumberSetNum,
			String secondGamerNumberSetNum, String firstGamerGuess, String secondGamerGuess, String whoNext,
			String whoWon, String timeStamp, String friend) {
		super();
		this.roomId = roomId;
		this.firstGamerId = firstGamerId;
		this.secondGamerId = secondGamerId;
		this.firstGamerNumberSetNum = firstGamerNumberSetNum;
		this.secondGamerNumberSetNum = secondGamerNumberSetNum;
		this.firstGamerGuess = firstGamerGuess;
		this.secondGamerGuess = secondGamerGuess;
		this.whoNext=whoNext;
		this.whoWon=whoWon;
		this.timeStamp = timeStamp;
		this.friend = friend;
	}






	public String getroomId() {
		return roomId;
	}



	public void setroomId(String roomId) {
		this.roomId = roomId;
	}



	public String getfirstGamerId() {
		return firstGamerId;
	}



	public void setfirstGamerId(String firstGamerId) {
		this.firstGamerId = firstGamerId;
	}



	public String getsecondGamerId() {
		return secondGamerId;
	}



	public void setsecondGamerId(String secondGamerId) {
		this.secondGamerId = secondGamerId;
	}



	public String getfirstGamerNumberSetNum() {
		return firstGamerNumberSetNum;
	}



	public void setfirstGamerNumberSetNum(String firstGamerNumberSetNum) {
		this.firstGamerNumberSetNum = firstGamerNumberSetNum;
	}



	public String getsecondGamerNumberSetNum() {
		return secondGamerNumberSetNum;
	}



	public void setsecondGamerNumberSetNum(String secondGamerNumberSetNum) {
		this.secondGamerNumberSetNum = secondGamerNumberSetNum;
	}
	
	public String getFirstGamerGuess() {
		return firstGamerGuess;
	}



	public void setFirstGamerGuess(String firstGamerGuess) {
		this.firstGamerGuess = firstGamerGuess;
	}



	public String getSecondGamerGuess() {
		return secondGamerGuess;
	}




	public String getTimeStamp() {
		return timeStamp;
	}






	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	

	public void setSecondGamerGuess(String secondGamerGuess) {
		this.secondGamerGuess = secondGamerGuess;
	}



	public String getWhoNext() {
		return whoNext;
	}




	public void setWhoNext(String whoNext) {
		this.whoNext = whoNext;
	}
	
	

	public String getWhoWon() {
		return whoWon;
	}



	public void setWhoWon(String whoWon) {
		this.whoWon = whoWon;
	}
	

	public String getFriend() {
		return friend;
	}



	public void setFriend(String friend) {
		this.friend = friend;
	}


}
