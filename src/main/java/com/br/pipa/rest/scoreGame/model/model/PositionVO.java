package com.br.pipa.rest.scoreGame.model.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionVO {

	private ArrayList<ScoreVO> scoreVO;
	private Integer position;

	@Override
	public String toString() {
		 
	      String scoreJson = "";  
	      		for(int i =0; i<scoreVO.size(); i++) {
		  			scoreJson +="{" + scoreVO.get(i).toString() 
		  			 	+ " \"position\":"
		            + this.position;
		  			if(i<scoreVO.size()-1) {
		  				scoreJson +=" },";
		  			}else {
		  				scoreJson +=" }";
		  			}
				}
	 return scoreJson;
	}
}
