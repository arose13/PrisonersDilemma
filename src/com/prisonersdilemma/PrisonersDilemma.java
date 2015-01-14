package com.prisonersdilemma;

import java.util.ArrayList;

import com.prisonersdilemma.sampleplayers.Angel;
import com.prisonersdilemma.sampleplayers.Asshole;

import me.anthonyrose.statistics.NormalDistn;

public class PrisonersDilemma {
	
	/**
	 * If both play cooperate (true) add 300 to both players
	 * If both play defected (false) remove 100 to both players
	 * If players play opposite (true and false) the one that plays false gets 500 and the one that plays true gets 0
	 * If player runs out of money then they lose.
	 */

	public static void main(String[] args) {
		
		NormalDistn mDistn = new NormalDistn();
		
		//PLAYER 1
		Angel player1 = new Angel();
		
		//PLAYER 2
		Asshole player2 = new Asshole();
		
		long player1score = Math.round(mDistn.getRandomNumberFromDistn(3000, 1000));
		long player2score = Math.round(mDistn.getRandomNumberFromDistn(3000, 1000));
		logger("Player 1 starting: $" + player1score);
		logger("Player 2 starting: $" + player2score);
		
		ArrayList<Boolean> p1history = new ArrayList<Boolean>();
		ArrayList<Boolean> p2history = new ArrayList<Boolean>();
		
		double numberOfRounds = Math.round(mDistn.getRandomNumberFromDistn(1000, 200));
		logger("Number of Rounds: " + numberOfRounds);
		
		// Run the game below
		for (double i = 0; i < numberOfRounds; i++) {
			boolean p1d = player1.play(p1history, p2history, player1score, player2score);
			boolean p2d = player2.play(p2history, p1history, player2score, player1score);
			
			p1history.add(p1d);
			p2history.add(p2d);
			
			// Play round
			if ((p1d == true) && (p2d == true)) {
				player1score = player1score + 300;
				player2score = player2score + 300;
				
			} else if ((p1d == false) && (p2d == false)) {
				player1score = player1score - 100;
				player2score = player2score - 100;
				
			} else if ((p1d == true) && (p2d == false)) {
				player1score = player1score + 0;
				player2score = player2score + 500;
				
			} else if ((p1d == false) && (p2d == true)) {
				player1score = player1score + 500;
				player2score = player2score + 0;
				
			}
			
			// Check for loser
			if (player1score <= 0) break;			
			if (player2score <= 0) break;
			
		}
		// Game is now over
		
		checkWinner(player1score, player2score);
		
	}
	
	private static void checkWinner(long player1score, long player2score) {
		if (player1score > player2score) {
			logger("Player 1 Wins");
		} else if (player1score < player2score) {
			logger("Player 2 Wins");
		} else if (player1score == player2score) {
			logger("It's a tie!");
		}
		
		logger("Player 1: $" + player1score);
		logger("Player 2: $" + player2score);
	}

	private static void logger(Object msg) {
		System.out.println(msg);
	}

}
