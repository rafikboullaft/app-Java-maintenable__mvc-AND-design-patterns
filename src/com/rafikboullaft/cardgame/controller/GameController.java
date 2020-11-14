package com.rafikboullaft.cardgame.controller;

import java.util.ArrayList;

import com.rafikboullaft.cardgame.allgames.GameEvaluator;
import com.rafikboullaft.cardgame.model.Deck;
import com.rafikboullaft.cardgame.model.IPlayer;
import com.rafikboullaft.cardgame.model.Player;
import com.rafikboullaft.cardgame.model.PlayingCard;
import com.rafikboullaft.cardgame.model.WinnerPlayer;
import com.rafikboullaft.cardgame.view.GameView;


public class GameController {
	enum GameState{
		AddingPlayers,
		CardsDealt,
		WinnerRevealed
		
	}
	Deck deck;
	GameView view;
	ArrayList<IPlayer> players;
	IPlayer winner;
	GameState gameState;
	GameEvaluator gameEvaluator;
	public GameController(Deck deck, GameView view,GameEvaluator gameEvaluator) {
		super();
		this.deck = deck;
		this.view =view;
		players = new ArrayList<IPlayer>();
		view.setController(this);
		this.gameState= GameState.AddingPlayers;
		this.gameEvaluator=gameEvaluator;
	}
	public void run() {
		while(true) {
			switch(gameState) {
				case AddingPlayers:
					view.promptForPlayerName();
					break;
				case CardsDealt:
					view.promptForFlip();
					break;
				case WinnerRevealed:
					view.promptForNewGame();
					break;
					
			}
		}
	}
	public void addPlayer(String playername) {
		if(gameState==GameState.AddingPlayers) {
			players.add(new Player(playername));
			view.showPlayerName(players.size(),playername);
			
		}
	}
	public void startGame() {
		if(gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex=1;
			for(IPlayer player:players) {
				player.addCard(deck.rempveTopCard());
				view.showFaceDownForPlayer(playerIndex++,player.getName());
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
				view.showCardforPlayer(playerIndex++,
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
		view.showWinner(winner.getName());	
	}
	private void rebuildDeck() {
		for(IPlayer player:players) {
			deck.returnCardToDeck(player.returnCard());
		}
		
	}
	
	

}
