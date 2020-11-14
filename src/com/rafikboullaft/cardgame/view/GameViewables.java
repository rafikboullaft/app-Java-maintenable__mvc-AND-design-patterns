package com.rafikboullaft.cardgame.view;

import java.util.Vector;
import com.rafikboullaft.cardgame.controller.GameController;
import com.rafikboullaft.cardgame.model.Rank;
import com.rafikboullaft.cardgame.model.suit;

public class GameViewables implements GameView {

	Vector<GameView> views;
	public GameViewables() {
		views= new Vector<GameView>();
	}
	public void addGameView(GameView gameView) {
		views.add(gameView);
	}
	@Override
	public void setController(GameController gc) {
		for(GameView view:views) {
			view.setController(gc);
		}
		
	}

	@Override
	public void promptForPlayerName() {
		for(GameView view: views) {
			view.promptForPlayerName();
		}
		
	}

	@Override
	public void promptForFlip() {
		for(GameView view: views) {
			view.promptForFlip();;
		}
		
	}

	@Override
	public void promptForNewGame() {
		for(GameView view: views) {
			view.promptForNewGame();;
		}
		
	}

	@Override
	public void showPlayerName(int size, String playername) {
		for(GameView view: views) {
			view.showPlayerName(size, playername);
		}
		
	}

	@Override
	public void showFaceDownForPlayer(int index, String playername) {
		for(GameView view: views) {
			view.showFaceDownForPlayer(index, playername);
		}
		
	}

	@Override
	public void showCardforPlayer(int index, String playername, Rank rank, suit suit) {
		for(GameView view: views) {
			view.showCardforPlayer(index, playername, rank, suit);;
		}
		
	}

	@Override
	public void showWinner(String name) {
		for(GameView view: views) {
			view.showWinner(name);
		}
		
	}

}
