package com.rafikboullaft.cardgame.model;

public class Player implements IPlayer{

	String name;
	Hand hand;
	public Player(String name) {
		super();
		this.name = name;
		hand = new Hand();
	}
	public void addCard(PlayingCard card) {
		hand.addCardToHand(card);
	}
	public PlayingCard getCard(int index) {
		return hand.getCard(index);
	}
	public PlayingCard returnCard() {
		return hand.returntheCard();
	}
	public String getName() {
		return name;
	}
	
}
