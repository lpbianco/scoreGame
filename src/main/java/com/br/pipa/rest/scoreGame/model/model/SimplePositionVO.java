package com.br.pipa.rest.scoreGame.model.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplePositionVO {

	private ScoreVO scoreVO;
	private Integer position;
	
	@Override
	public String toString() {
		if(scoreVO == null) {
			return "{}";
		}else {
			return "{"
					+ this.scoreVO.toString() 
					+ " \"position\":"
					+ this.position
					+" }"; 
		}
	}
}
