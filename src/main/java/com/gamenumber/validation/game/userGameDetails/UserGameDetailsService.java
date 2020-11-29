package com.gamenumber.validation.game.userGameDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserGameDetailsService {
	

	@Autowired
	private UserGameDetailsRepository gamerDetailsRepo;
	
	
	public List<UserGameDetails> getAllGamers() {
		
		List<UserGameDetails> gamers = new ArrayList<>();
//		return topics;
		gamerDetailsRepo.findAll().forEach(gamers::add);
		 return gamers;
	
}
	
	public void addGamer(UserGameDetails gamer) {
//		topics.add(topic);
		gamerDetailsRepo.save(gamer);
		
	}
	
	
	public void deleteAll() {
//		topics.add(topic);
		gamerDetailsRepo.deleteAll();
		
	}

	
	public void deleteGamer(String id) {
//		topics.add(topic);
		gamerDetailsRepo.deleteById(id);
	
}
	
	
	public Optional<UserGameDetails> getOneGamer(String id) {
//		topics.add(topic);
		return gamerDetailsRepo.findById(id);
		
	}
	
	
	public UserGameDetails updateGamerDetails(String id, UserGameDetails gamer) {
//		topics.add(topic);
//		gameRoomRepo.deleteById(id);
		return gamerDetailsRepo.save(gamer);
		
	}
	
}