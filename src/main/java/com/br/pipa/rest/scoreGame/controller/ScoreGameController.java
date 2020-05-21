package com.br.pipa.rest.scoreGame.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.pipa.rest.scoreGame.model.model.PositionVO;
import com.br.pipa.rest.scoreGame.model.model.ScoreVO;
import com.br.pipa.rest.scoreGame.model.model.SimplePositionVO;
import com.br.pipa.rest.scoreGame.service.ScoreService;

@RestController
public class ScoreGameController {

	@Autowired
	ScoreService scoreService;
	
	@Value("${score.game.pipa.sucesso}")
	private String sucesso;
	

	@ResponseBody
	@RequestMapping(value = "/score", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> addScore(@RequestBody ScoreVO score) {
		try {
			scoreService.addScore(score);
			return ResponseEntity.ok().body(sucesso);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.toString());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/{userId}/position", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getPosition(@PathVariable("userId") Integer userId) {
		try {
		    	CompletableFuture<SimplePositionVO> retorno = scoreService.getScore(userId);
				CompletableFuture.completedFuture(retorno);
			
			return ResponseEntity.ok().body(retorno.toString().equals("null")?"":retorno.get().toString());
		} catch (Exception e) {	
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/highscorelist", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getHighscore() {
		try {
			CompletableFuture<List<PositionVO>> retorno = scoreService.getPositions();
			CompletableFuture.completedFuture(retorno);
			 return ResponseEntity.ok().body(retorno==null?"":"{ \"highscores\":" + retorno.get().toString() +"}");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
