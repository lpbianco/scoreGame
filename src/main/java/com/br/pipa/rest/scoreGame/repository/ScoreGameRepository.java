package com.br.pipa.rest.scoreGame.repository;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.br.pipa.rest.scoreGame.model.model.ScoreVO;

public class ScoreGameRepository {

	private Map<Integer, ScoreVO> repository;

	public ScoreGameRepository() {
		repository = new ConcurrentHashMap<Integer, ScoreVO>();
	}

	public Map<Integer, ScoreVO> getRepository() {
		return repository;
	}

	public void setRepository(ConcurrentHashMap<Integer, ScoreVO> repository) {
		this.repository = repository;
	}

	public TreeMap<Integer, ArrayList<ScoreVO>> getOrderToPoints() {
		TreeMap<Integer, ArrayList<ScoreVO>> tree = new TreeMap<Integer, ArrayList<ScoreVO>>();
		this.repository.forEach((k, v) -> {
			if(v.getPoints()!=null) {
				if (tree.get(v.getPoints()) == null) {
					tree.put(v.getPoints(), new ArrayList<ScoreVO>());
				}
				tree.get(v.getPoints()).add(v);
			}});
		return tree;
	}
}
