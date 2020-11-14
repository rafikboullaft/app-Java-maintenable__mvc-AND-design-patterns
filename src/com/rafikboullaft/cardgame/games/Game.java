package com.rafikboullaft.cardgame.games;

import com.rafikboullaft.cardgame.allgames.HighCardGameEvaluator;
import com.rafikboullaft.cardgame.controller.GameController;
import com.rafikboullaft.cardgame.games.DeckFactory.DeckType;
import com.rafikboullaft.cardgame.view.GameSwing;

public class Game {

	public static void main(String[] args) {
	GameSwing gs=new GameSwing();
	gs.createAndShowGUI();
		GameController gc=new GameController(DeckFactory.makeDeck(DeckType.normal),
											gs,
											new HighCardGameEvaluator());
		gc.run();
		

	}

}
