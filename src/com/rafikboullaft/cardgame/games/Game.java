package com.rafikboullaft.cardgame.games;

import com.rafikboullaft.cardgame.controller.GameController;
import com.rafikboullaft.cardgame.model.Deck;
import com.rafikboullaft.cardgame.view.View;

public class Game {

	public static void main(String[] args) {
		GameController gc=new GameController(new Deck(),new View());
		gc.run();
		

	}

}
