package com.br.pipa.rest.scoreGame.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
	
	@Async("asyncExecutor")
	public void addScore(ScoreVO score) {
		business.addPoints(score, repository);
	}
	
    @Async("asyncExecutor")
    public CompletableFuture<SimplePositionVO> getScore(Integer userId) throws InterruptedException
    {
        return CompletableFuture.completedFuture(business.selectScore(userId, repository));
    }
    
    @Async("asyncExecutor")
    public CompletableFuture<List<PositionVO>> getPositions() throws InterruptedException
    {
        return CompletableFuture.completedFuture(business.mountScores(repository,limit));
    }
}
	
