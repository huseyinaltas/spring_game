package com.gamenumber.validation.game.userGameDetails;

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
public class UserGameDetailsContoller {
	
	
	@Autowired
	public UserGameDetailsService userGameDetails;
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/gamer", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserGameDetails> getAllGamers( ) {
	    return userGameDetails.getAllGamers();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value= "/gamer", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createAGamer(@RequestBody UserGameDetails gamer) {
		userGameDetails.addGamer(gamer);
		return "Gammer "+gamer.getGamerid()+" added!";
	}
	
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/gamer/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deletAllGamer() {
		userGameDetails.deleteAll();
		return "All gamers have been deleted";
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/gamer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteAGamer(@PathVariable String id) {
		
		userGameDetails.deleteGamer(id);
		
	    return "Gamer: "+id+" deleted" ;
	}
	
	
	@CrossOrigin(origins = "*")
	@PutMapping(value= "/gamer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserGameDetails updateFamer(@PathVariable String id, @RequestBody UserGameDetails gamer) {
		 return userGameDetails.updateGamerDetails(id,gamer); 
	
		
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/gamer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Optional<UserGameDetails> getOneRoom(@PathVariable String id) {
		return userGameDetails.getOneGamer(id); 
		
		
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/gameroom/deleteOneDay", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteFiveMinutesPassded() {
		userGameDetails.deleteOneDay();
		return "All rooms have been deleted that no action happened last 5 minutes";
	}
	

}
