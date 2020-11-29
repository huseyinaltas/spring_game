package com.gamenumber.validation.game.gamroom;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamenumber.validation.game.GameService;

@RestController
public class GameRoomController {
	
	
	@Autowired
	public GameRoomService gameRoomService;
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/gameroom", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<GameRoom> getAllRooms( ) {
	    return gameRoomService.getAllRooms();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/available", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<GameRoom> getAvailableRoom( ) {
	    return gameRoomService.getAllRoomsAvailable();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value= "/gameroom", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String example(@RequestBody GameRoom game) {
		gameRoomService.addRoom(game);
		return "Room "+game.getroomId()+" added!";
	}
	
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/gameroom/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String delete() {
		gameRoomService.deleteAll();
		return "All rooms have been deleted";
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/gameroom/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteRoom(@PathVariable String id) {
		
		gameRoomService.deleteRoom(id);
		
	    return "Room "+id+" deleted" ;
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/gameroom/deleteFiveMinutes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteFiveMinutesPassded() {
		gameRoomService.deleteFiveMinutes();
		return "All rooms have been deleted that no action happened last 5 minutes";
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value= "/gameroom/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public GameRoom updateGuess(@PathVariable String id, @RequestBody GameRoom game) {
		 return gameRoomService.updateGuess(id,game); 
	
		
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/gameroom/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Optional<GameRoom> getOneRoom(@PathVariable String id) {
		return gameRoomService.getOneRoom(id); 
		
		
	}
	

}
