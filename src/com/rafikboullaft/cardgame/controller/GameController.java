package com.rafikboullaft.cardgame.controller;

import java.util.ArrayList;

import com.rafikboullaft.cardgame.allgames.GameEvaluator;
import com.rafikboullaft.cardgame.allgames.HighCardGameEvaluator;
import com.rafikboullaft.cardgame.allgames.LowCardGameEvaluator;
import com.rafikboullaft.cardgame.model.Deck;
import com.rafikboullaft.cardgame.model.IPlayer;
import com.rafikboullaft.cardgame.model.Player;
import com.rafikboullaft.cardgame.model.PlayingCard;
import com.rafikboullaft.cardgame.model.WinnerPlayer;
import com.rafikboullaft.cardgame.view.GameView;
import com.rafikboullaft.cardgame.view.GameViewables;


public class GameController {
	enum GameState{
		AddingPlayers,
		CardsDealt,
		WinnerRevealed,
		AddingView	
	}
	Deck deck;
	GameViewables views;
	ArrayList<IPlayer> players;
	IPlayer winner;
	GameState gameState;
	GameEvaluator gameEvaluator;
	public GameController(Deck deck, GameView view,GameEvaluator gameEvaluator) {
		super();
		views = new GameViewables();
		this.deck = deck;
		this.gameEvaluator=gameEvaluator;
		this.gameEvaluator=new LowCardGameEvaluator();// you can change it to highCardGmeEvaluator;
		players = new ArrayList<IPlayer>();
		this.gameState= GameState.AddingPlayers;
		addViewable(view);
			
	}
	public void addViewable(GameView newView) {
		GameState curState=gameState;
		gameState = GameState.AddingView;
		newView.setController(this);
		views.addGameView(newView);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		gameState =curState;
		
	}
	public void run() {
		while(true) {
			switch(gameState) {
				case AddingPlayers:
					views.promptForPlayerName();
					break;
				case CardsDealt:
					views.promptForFlip();
					break;
				case WinnerRevealed:
					views.promptForNewGame();
					break;
				case AddingView:
					break;
					
			}
		}
	}
	public void addPlayer(String playername) {
		if(gameState==GameState.AddingPlayers) {
			players.add(new Player(playername));
			views.showPlayerName(players.size(),playername);
			
		}
	}
	public void startGame() {
		if(gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex=1;
			for(IPlayer player:players) {
				player.addCard(deck.rempveTopCard());
				views.showFaceDownForPlayer(playerIndex++,player.getName());
			}
			gameState=GameState.CardsDealt;
			
		}
	}
	public void restartGame() {
		rebuildDeck();
		gameState=GameState.AddingPlayers;
	}
	public void flipCards() {
		int playerIndex=1;
		for (IPlayer player:players) {
				PlayingCard card= player.getCard(0);
				card.flip();
				views.showCardforPlayer(playerIndex++,
						player.getName(),card.getRank(),card.getSuit());
			}
		evaluateWinner();
		displaywinner();
		rebuildDeck();
		gameState=GameState.WinnerRevealed;
		
	}
	
	private void evaluateWinner() {	
		winner = new WinnerPlayer(gameEvaluator.evaluateWinner(players));
	
	}
	private void displaywinner() {
		views.showWinner(winner.getName());	
	}
	private void rebuildDeck() {
		for(IPlayer player:players) {
			deck.returnCardToDeck(player.returnCard());
		}
		
	}
	
	

}
