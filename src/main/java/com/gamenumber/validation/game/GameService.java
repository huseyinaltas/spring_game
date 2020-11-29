package com.gamenumber.validation.game;

import java.util.Iterator;

import org.springframework.stereotype.Service;

@Service
public class GameService {
	
	
	
	public String returnResult(int setNum, int guessNum){
		
		String setNumS= setNum+"";
		String guessNumS= guessNum+"";
		
	    if(checkIfFiveDigits(guessNumS)==false && checkSameDigits(guessNumS)==false) {
			return "Please enter 5 unique digits number";
		}
		
	    else if(checkIfFiveDigits(guessNumS)==false) {
			return "Please enter 5 digits number";
		}
		
		else if(checkSameDigits(guessNumS)==false) {
			return "Please don't enter same digits in guess";
		}
	    
		else {
			return givePlusNigative(setNumS, guessNumS);
			
		}
		
		
	}
	
	
	
	public boolean checkSameDigits(String str) {
		
		for(int i=0; i<str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(i)==str.charAt(j) && i!=j) {
					return false;
				}
			}
			
		}
		return true;
		
	}
	
	public boolean checkIfFiveDigits(String str) {
		
		if(str.length()==5) {
			return true;
		}
		
		else {
		return false;
		}
		
	}
	
	public String givePlusNigative(String setNum, String guessNum) {
		String result = "";
		String resultOrdered = "";
		
		for(int i=0; i<setNum.length(); i++) {
			for (int j = 0; j < guessNum.length(); j++) {
				if(setNum.charAt(i)==guessNum.charAt(j) && i!=j) {
					result = result+"- ";
				}
				else if(setNum.charAt(i)==guessNum.charAt(j) && i==j) {
					result = result+"+ ";
				}
			}
			
		}
		if(result.equals("")) {
			return "No Matching";
		}
		for (int i = 0; i < result.length(); i++) {
			if(result.charAt(i)=='+') {
				resultOrdered = result.charAt(i)+resultOrdered;
			}
			else if(result.charAt(i)=='-') {
				resultOrdered = resultOrdered+result.charAt(i);
			}
			
		}
		
		
		return resultOrdered;
		
	}

}
