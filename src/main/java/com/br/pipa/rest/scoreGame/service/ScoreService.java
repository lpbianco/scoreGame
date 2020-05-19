package com.br.pipa.rest.scoreGame.service;

import java.util.List;

import com.br.pipa.rest.scoreGame.model.model.PositionVO;
import com.br.pipa.rest.scoreGame.model.model.ScoreVO;
import com.br.pipa.rest.scoreGame.model.model.SimplePositionVO;

public interface ScoreService {

	public void addScore(ScoreVO score);
	
	public SimplePositionVO getScore(Integer userId);
	
	public List<PositionVO> getPositions();
}
