package com.gamenumber.validation.game.userGameDetails;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamenumber.validation.game.gamroom.GameRoom;




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
		gamer.setTimeStamp(getTime());
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
		gamer.setTimeStamp(getTime());
		return gamerDetailsRepo.save(gamer);
		
	}
	
	public String getTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;
	}
	
	public static int compareDate(String old) {
		LocalDateTime dateNow = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String date = dateNow.format(myFormatObj);
	    int minuteNow = dateNow.getMinute();
	    int hourNow = dateNow.getHour();
	    LocalDateTime dateOld = LocalDateTime.parse(old, myFormatObj);
	    int diffMin = minuteNow - dateOld.getMinute();
	    int diffDay = dateNow.getDayOfYear() - dateOld.getDayOfYear();
	    int diffHour = hourNow - dateOld.getHour();
	    if(diffDay>0 || diffDay<0) {
	    	return -1;
	    }
	    else if(diffHour >= 12 || diffHour <= -12) {
	    	return -1;
	    }
	    else {
	    	return 1;
	    }
		
	}
	
	public void deleteOneDay() {
		List<UserGameDetails> gamers = new ArrayList<>();
		gamerDetailsRepo.findAll().forEach(gamers::add);
		gamers = gamers.stream().filter(a -> compareDate(a.getTimeStamp())<=0).collect(Collectors.toList());
		if(gamers.size()>0) {
		for(int i=0; i<gamers.size(); i++) {
			gamerDetailsRepo.deleteById(gamers.get(i).getGamerid());
		}
		}
		
			
	}
	
}