package com.rafikboullaft.cardgame.view;

import com.rafikboullaft.cardgame.controller.GameController;
import com.rafikboullaft.cardgame.model.Rank;
import com.rafikboullaft.cardgame.model.suit;

public interface GameView {
	public void setController(GameController gc) ;
	public void promptForPlayerName() ;
	public void promptForFlip() ;
	public void promptForNewGame() ;
	public void showPlayerName(int size, String playername) ;
	public void showFaceDownForPlayer(int index, String playername) ;
	public void showCardforPlayer(int index, String playername, Rank rank, suit suit);
	public void showWinner(String name) ;
}
