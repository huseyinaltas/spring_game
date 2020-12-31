package com.gamenumber.validation.count;

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
public class CountController {
	
	
	@Autowired
	public CountService countService;
	private CountRepository countRepo;
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Count> getAllCount( ) {
	    return countService.getAllCount();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value= "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createAGamerScore() {
		
		countService.addCount();
		return "{\"message\": \""+"one gamer just joined!"+"\"}";
		
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value= "/count/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deletAllCount() {
		countService.deleteAllCount();
		return "All count have been deleted";
	}
	

}
