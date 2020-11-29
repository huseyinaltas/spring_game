package com.gamenumber.validation.game;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;


public class Game {
	
	private int setNum;
	
	
	public Game() {
	}
	
	public Game(int setNum) {
		super();
		this.setNum=setNum;
	}

	public int getSetNum() {
		return setNum;
	}

	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}

}
