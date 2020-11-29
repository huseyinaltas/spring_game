package com.gamenumber.validation.userScores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class UserScoresController {
	
	
	@Autowired
	public UserScoresService userScores;
	private UserScoresRepository gamerScoreRepo;
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/score", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserScores> getAllScores( ) {
	    return userScores.getAllScores();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value= "/score", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createAGamerScore(@RequestBody UserScores gamer) {
		String message = "Gammer "+gamer.getGamerEmail()+" added!";
		if(userScores.checkName(gamer)!=0) {
			return "{\"message\": \"User is exist!\"}";
		}
		userScores.addGamerScore(gamer);
		return "{\"message\": \""+message+"\"}";
		
	}
	
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/score/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deletAllScores() {
		userScores.deleteAllScores();
		return "All gamers have been deleted";
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/score/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteAScore(@PathVariable String email) {
		
		userScores.deleteScore(email);
		
	    return "Gamer: "+email+" deleted" ;
	}
	
	
	@CrossOrigin(origins = "*")
	@PutMapping(value= "/score/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserScores updateScore(@PathVariable String id, @RequestBody UserScores gamer) {
		 return userScores.updateOneScore(id,gamer); 
	
		
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value= "/score/username/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateUsername(@PathVariable String id, @RequestBody UserScores gamer) {
		
		String message = "Your Username is changed!";
		if(userScores.checkName(gamer)!=0) {
			return "{\"message\": \"Exist! Try another Username!\"}";
		}
		userScores.updateOneUserName(id,gamer); 
		return "{\"message\": \""+message+"\"}";
		
		
		
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/score/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Optional<UserScores> getOneScore(@PathVariable String email) {
		return userScores.getOneScore(email); 
		
		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/scoreTen", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserScores> getAllScoresTen( ) {
	    return userScores.getTenHighestScore();
	}
	

}
