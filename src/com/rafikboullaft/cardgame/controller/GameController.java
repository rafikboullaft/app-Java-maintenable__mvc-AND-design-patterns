package com.rafikboullaft.cardgame.controller;

import java.util.ArrayList;

import com.rafikboullaft.cardgame.allgames.GameEvaluator;
import com.rafikboullaft.cardgame.model.Deck;
import com.rafikboullaft.cardgame.model.Player;
import com.rafikboullaft.cardgame.model.PlayingCard;
import com.rafikboullaft.cardgame.model.Rank;
import com.rafikboullaft.cardgame.model.suit;
import com.rafikboullaft.cardgame.view.View;


public class GameController {
	enum GameState{
		AddingPlayers,
		CardsDealt,
		WinnerRevealed
		
	}
	Deck deck;
	View view;
	ArrayList<Player> players;
	Player winner;
	GameState gameState;
	GameEvaluator gameEvaluator;
	public GameController(Deck deck, View view,GameEvaluator gameEvaluator) {
		super();
		this.deck = deck;
		this.view = view;
		players = new ArrayList<Player>();
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
			for(Player player:players) {
				player.addCard(deck.rempveTopCard());
				view.showFaceDownForPlayer(playerIndex++,player.getName());
			}
			gameState=GameState.CardsDealt;
			
		}
	}
	public void flipCards() {
		int playerIndex=1;
		for (Player player:players) {
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
		winner =gameEvaluator.evaluateWinner(players);
	
	}
	private void displaywinner() {
		view.showWinner(winner.getName());	
	}
	private void rebuildDeck() {
		for(Player player:players) {
			deck.returnCardToDeck(player.returnCard());
		}
		
	}
	
	

}
