package com.br.pipa.rest.scoreGame.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.br.pipa.rest.scoreGame.model.model.PositionVO;
import com.br.pipa.rest.scoreGame.model.model.ScoreVO;
import com.br.pipa.rest.scoreGame.model.model.SimplePositionVO;

public interface ScoreService {

	public void addScore(ScoreVO score);
	
	CompletableFuture<SimplePositionVO> getScore(Integer userId) throws InterruptedException;
	
	CompletableFuture<List<PositionVO>> getPositions() throws InterruptedException;
}
