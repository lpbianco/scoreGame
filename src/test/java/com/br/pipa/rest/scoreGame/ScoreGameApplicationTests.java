package com.br.pipa.rest.scoreGame;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.pipa.rest.scoreGame.business.ScoreGameBusiness;
import com.br.pipa.rest.scoreGame.model.model.PositionVO;
import com.br.pipa.rest.scoreGame.model.model.ScoreVO;
import com.br.pipa.rest.scoreGame.model.model.SimplePositionVO;
import com.br.pipa.rest.scoreGame.repository.ScoreGameRepository;

@SpringBootTest
public class ScoreGameApplicationTests {

	
	@Test
	public void testAddPoints() {
		ScoreGameBusiness business = new ScoreGameBusiness();
		ScoreGameRepository repository = new ScoreGameRepository();
		
		business.addPoints(new ScoreVO(1,1), repository);
		business.addPoints(new ScoreVO(1,1), repository);
		
		assertEquals("2", repository.getRepository().get(1).getPoints().toString());
	}

	
	@Test
	public void testGetScore() {
		ScoreGameBusiness business = new ScoreGameBusiness();
		ScoreGameRepository repository = new ScoreGameRepository();
		
		business.addPoints(new ScoreVO(1,1), repository);
		business.addPoints(new ScoreVO(2,2), repository);
		
		SimplePositionVO position = business.selectScore(2, repository);
		assertEquals("1", position.getPosition()+"");
	}
	
	
	@Test
	public void testMountScore() {
		ScoreGameBusiness business = new ScoreGameBusiness();
		ScoreGameRepository repository = new ScoreGameRepository();
		
		business.addPoints(new ScoreVO(1,1), repository);
		business.addPoints(new ScoreVO(2,2), repository);
		
		List<PositionVO> position = business.mountScores(repository, 20000);
		assertEquals("1", position.get(0).getPosition()+"");
		assertEquals("2", position.get(1).getPosition()+"");
	}
}
