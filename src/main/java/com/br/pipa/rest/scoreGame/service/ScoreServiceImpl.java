package com.br.pipa.rest.scoreGame.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.br.pipa.rest.scoreGame.business.ScoreGameBusiness;
import com.br.pipa.rest.scoreGame.model.model.PositionVO;
import com.br.pipa.rest.scoreGame.model.model.ScoreVO;
import com.br.pipa.rest.scoreGame.model.model.SimplePositionVO;
import com.br.pipa.rest.scoreGame.repository.ScoreGameRepository;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Resource(name = "scoreGameRepository")
	ScoreGameRepository repository;

	@Value("${score.game.pipa.limit}")
	private Integer limit;
	
	ScoreGameBusiness business = new ScoreGameBusiness();
	
	@Async
	public void addScore(ScoreVO score) {
		business.addPoints(score, repository);
	}
	
	
	public SimplePositionVO getScore(Integer userId) {
		return business.selectScore(userId, repository);
	}

	public List<PositionVO> getPositions() {
		return business.mountScores(repository,limit);
	}
}
