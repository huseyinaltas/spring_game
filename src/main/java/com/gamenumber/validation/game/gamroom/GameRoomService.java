package com.gamenumber.validation.game.gamroom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class GameRoomService {
	

	@Autowired
	private GameRoomRepository gameRoomRepo;
	
	
	public List<GameRoom> getAllRooms() {
		
		List<GameRoom> rooms = new ArrayList<>();
//		return topics;
		gameRoomRepo.findAll().forEach(rooms::add);
		 return rooms;
	}	 
		 
	public List<GameRoom> getAllRoomsAvailable() {
				
		List<GameRoom> rooms = new ArrayList<>();
//		return topics;
		gameRoomRepo.findAll().forEach(rooms::add);
		rooms = rooms.stream().filter(a -> (a.getfirstGamerId()==null || a.getsecondGamerId()==null) && a.getFriend().equals("0")).collect(Collectors.toList());
		return rooms;
		 		 
	
     }
	
	public void addRoom(GameRoom room) {
//		topics.add(topic);
		room.setTimeStamp(getTime());
		gameRoomRepo.save(room);
		
	}
	
	
	public void deleteAll() {
//		topics.add(topic);
		gameRoomRepo.deleteAll();
		
	}
	
	public void deleteFiveMinutes() {
		List<GameRoom> rooms = new ArrayList<>();
		gameRoomRepo.findAll().forEach(rooms::add);
		rooms = rooms.stream().filter(a -> compareDate(a.getTimeStamp())<=0).collect(Collectors.toList());
		if(rooms.size()>0) {
		for(int i=0; i<rooms.size(); i++) {
			gameRoomRepo.deleteById(rooms.get(i).getroomId());
		}
		}
		
			
	}

	
	public void deleteRoom(String id) {
//		topics.add(topic);
		gameRoomRepo.deleteById(id);
	
}
	
	
	public Optional<GameRoom> getOneRoom(String id) {
//		topics.add(topic);
		return gameRoomRepo.findById(id);
		
	}
	
	
	public GameRoom updateGuess(String id, GameRoom game) {
//		topics.add(topic);
//		gameRoomRepo.deleteById(id);
		game.setTimeStamp(getTime());
		return gameRoomRepo.save(game);
		
	}
	
	public String getTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;
	}
	
	public static int compareDate(String old) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String date = myDateObj.format(myFormatObj);
	    int beforeFiveMinutes = myDateObj.getMinute();
	    LocalDateTime myDateObj2 = LocalDateTime.parse(old, myFormatObj);
	    int diffMin = beforeFiveMinutes - myDateObj2.getMinute();
	    int diffDay = myDateObj.getDayOfYear() - myDateObj2.getDayOfYear();
	    if(diffDay>0) {
	    	return -1;
	    }
	    else if(diffMin >= 5 || diffMin<0) {
	    	return -1;
	    }
	    else {
	    	return 1;
	    }
		
	}
	
}