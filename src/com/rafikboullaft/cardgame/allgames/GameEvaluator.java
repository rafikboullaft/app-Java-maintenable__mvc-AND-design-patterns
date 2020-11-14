package com.rafikboullaft.cardgame.allgames;

import java.util.ArrayList;

import com.rafikboullaft.cardgame.model.IPlayer;

public interface GameEvaluator {
	public IPlayer evaluateWinner(ArrayList<IPlayer> players);	
}
