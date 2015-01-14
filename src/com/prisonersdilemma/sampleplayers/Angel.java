package com.prisonersdilemma.sampleplayers;

import java.util.ArrayList;

public class Angel {
	
	/** play() is a required function */
	public boolean play(ArrayList<Boolean> yourHistory, ArrayList<Boolean> oppHistory, long yourScore, long enemyScore) {
		// ... Do what you want where ever you want
		boolean decision = think();
		
		// Give me your choice
		return decision;
	}
	
	private boolean think() {
		return true;
	}

}
