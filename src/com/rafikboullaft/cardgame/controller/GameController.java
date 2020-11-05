package com.rafikboullaft.cardgame.controller;

import java.util.ArrayList;

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
	
	public GameController(Deck deck, View view) {
		super();
		this.deck = deck;
		this.view = view;
		players = new ArrayList<Player>();
		view.setController(this);
		this.gameState= GameState.AddingPlayers;
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
		Player bestPlayer=null;
		int bestRank = -1;
		int bestSuit = -1;
		
		for(Player player:players) {
			boolean newBestPlayer=false;
			if(bestPlayer==null) {
				newBestPlayer=true;
			}
			else {
			PlayingCard pl=player.getCard(0);
			int currentRank = pl.getRank().value();
			if (currentRank >= bestRank) {
				if(currentRank>bestRank) {
					newBestPlayer=true;
				}
				else {
					if(pl.getSuit().value()>bestSuit) {
						newBestPlayer=true;
					}
				}
			}
			}
			if(newBestPlayer) {
				bestPlayer=player;
				bestRank=player.getCard(0).getRank().value();
				bestSuit=player.getCard(0).getSuit().value();
			}
			
			
		}
		winner = bestPlayer;
		
		
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
