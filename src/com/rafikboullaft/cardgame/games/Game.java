package com.rafikboullaft.cardgame.games;

import com.rafikboullaft.cardgame.allgames.LowCardGameEvaluator;
import com.rafikboullaft.cardgame.controller.GameController;
import com.rafikboullaft.cardgame.games.DeckFactory.DeckType;
import com.rafikboullaft.cardgame.model.Deck;
import com.rafikboullaft.cardgame.view.CommandLineView;
import com.rafikboullaft.cardgame.view.GameSwing;

public class Game {

	public static void main(String[] args) {
	GameSwing gs=new GameSwing();
	gs.createAndShowGUI();
		GameController gc=new GameController(DeckFactory.makeDeck(DeckType.normal),
											gs,
											new LowCardGameEvaluator());
		gc.run();
		

	}

}
