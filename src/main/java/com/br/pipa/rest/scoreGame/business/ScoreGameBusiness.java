package com.br.pipa.rest.scoreGame.business;

import java.util.ArrayList;
import java.util.List;

import com.br.pipa.rest.scoreGame.model.model.PositionVO;
import com.br.pipa.rest.scoreGame.model.model.ScoreVO;
import com.br.pipa.rest.scoreGame.model.model.SimplePositionVO;
import com.br.pipa.rest.scoreGame.repository.ScoreGameRepository;

public class ScoreGameBusiness {

	public synchronized void addPoints(ScoreVO score, ScoreGameRepository repository) {
		ScoreVO oldScore = repository.getRepository().get(score.getUserId());
		if (oldScore != null && score.getPoints() != null) {
			score.setPoints(score.getPoints() + oldScore.getPoints());
		}
		if (score.getUserId() != null) {
			repository.getRepository().put(score.getUserId(), score);
		}
	}

	public SimplePositionVO selectScore(Integer userId, ScoreGameRepository repository) {
		PositionVO position = null;
		ArrayList<ArrayList<ScoreVO>> values = new ArrayList<ArrayList<ScoreVO>>(
				repository.getOrderToPoints().values());

		for (int i = 0; values.size() > i; i++) {
			position = new PositionVO(values.get(i), values.size() - i);
			for (ScoreVO score : position.getScoreVO()) {
				if (score.getUserId().equals(userId)) {
					return new SimplePositionVO(score, position.getPosition());
				}
			}
		}
		return new SimplePositionVO();
	}

	public List<PositionVO> mountScores(ScoreGameRepository repository, Integer limit) {
		List<PositionVO> positions = new ArrayList<PositionVO>();
		ArrayList<ArrayList<ScoreVO>> values = new ArrayList<ArrayList<ScoreVO>>(
				repository.getOrderToPoints().values());
		for (int i = 0; values.size() > i; i++) {
			PositionVO position = new PositionVO(values.get(values.size() - (i + 1)), (i + 1));
			positions.add(position);
			if (positions.size() == limit) {
				break;
			}
		}
		return positions;
	}

}
