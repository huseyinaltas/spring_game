package com.gamenumber.validation.userScores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

class SortbyScores implements Comparator<UserScores> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(UserScores a, UserScores b) 
    { 
        return Integer.parseInt(b.getScore()) - Integer.parseInt(a.getScore()); 
    } 
} 


@Service
public class UserScoresService {
	

	@Autowired
	private UserScoresRepository gamerScoreRepo;
	
	
	public List<UserScores> getAllScores() {
		
		List<UserScores> gamers = new ArrayList<>();
//		return topics;
		gamerScoreRepo.findAll().forEach(gamers::add);
		 return gamers;
	
}
	
	public void addGamerScore(UserScores gamer) {
//		topics.add(topic);
		
		gamerScoreRepo.save(gamer);
		
	}
	
	public long checkName(UserScores gamer) {
		List<UserScores> gamers = new ArrayList<>();
		gamerScoreRepo.findAll().forEach(gamers::add);
		long num = gamers.stream().filter(a -> a.getGamerid().equals(gamer.getGamerid())).count();
       
			return num;
		
		
	}
	
	
	public void deleteAllScores() {
//		topics.add(topic);
		gamerScoreRepo.deleteAll();
		
	}

	
	public void deleteScore(String email) {
//		topics.add(topic);
		gamerScoreRepo.deleteById(email);
	
}
	
	
	public Optional<UserScores> getOneScore(String email) {
//		topics.add(topic);
		return gamerScoreRepo.findById(email);
		
	}
	
	
	public UserScores updateOneScore(String id, UserScores gamer) {
//		topics.add(topic);
//		gameRoomRepo.deleteById(id);
		gamer.setGamerid(gamerScoreRepo.findById(id).get().getGamerid());
		gamer.setGamerEmail(id);
		return gamerScoreRepo.save(gamer);
		
	}
	
	public UserScores updateOneUserName(String id, UserScores gamer) {
//		topics.add(topic);
//		gameRoomRepo.deleteById(id);
		gamer.setScore(gamerScoreRepo.findById(id).get().getScore());
		gamer.setGamerEmail(id);
		return gamerScoreRepo.save(gamer);
		
	}
	
	
	public List<UserScores> getTenHighestScore(){
		List<UserScores> gamers = new ArrayList<>();
//		return topics;
		gamerScoreRepo.findAll().forEach(gamers::add);
		Collections.sort(gamers, new SortbyScores());
		List<UserScores> tenGamers = new ArrayList<>();
		tenGamers = gamers.stream().limit(10).collect(Collectors.toList());
		 return tenGamers;
		
	}
	
}