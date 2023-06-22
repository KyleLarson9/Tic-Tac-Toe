package ticTacToe;

import java.util.HashMap;

public class ScoringSystem {
	
	public HashMap<Character, Integer> xScore;
	public HashMap<Character, Integer> yScore;
	
	int xScoreCount = 0;
	int yScoreCount = 0;

	public ScoringSystem() {
		xScore = new HashMap<>();
		yScore = new HashMap<>();

		xScore.put('X', 0);
		yScore.put('Y', 0);

	}
	
	public void updatexScore() {
		xScore.put('X', xScoreCount);
	}
	
	public void updateyScore() {
		yScore.put('Y', yScoreCount);
	}
	
	public void printScores() {
		System.out.println(xScore);
		System.out.println(yScore);
	}
}

