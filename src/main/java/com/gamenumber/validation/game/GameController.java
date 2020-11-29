package com.gamenumber.validation.game;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	
	@Autowired
	public GameService gameService;
	
	
	
	@CrossOrigin(origins = "*")
	@PostMapping(value= "/guess", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getValidation(@RequestParam int guessNum, @RequestBody Game game ) {
	    return gameService.returnResult(game.getSetNum(), guessNum);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value= "/example", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String example() {
		return "Example";
	}
	

}
