package com.br.pipa.rest.scoreGame.model.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer points;
	
	@Override
	public String toString() {
		  return "\"userId\":"
	            + this.userId 
	            + ", \"points\":"
	            + this.points
	            +","; 
	}
}
