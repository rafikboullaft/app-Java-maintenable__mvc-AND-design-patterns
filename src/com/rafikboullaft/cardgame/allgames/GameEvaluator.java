package com.rafikboullaft.cardgame.allgames;

import java.util.ArrayList;

import com.rafikboullaft.cardgame.model.Player;

public interface GameEvaluator {
	public Player evaluateWinner(ArrayList<Player> players);	
}
