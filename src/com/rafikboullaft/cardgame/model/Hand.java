package com.rafikboullaft.cardgame.model;

import java.util.ArrayList;

public class Hand {
	ArrayList<PlayingCard> cards;
	public Hand() {
		cards = new ArrayList<>();
	}
	public void addCardToHand(PlayingCard card) {
		cards.add(card);
	}
	public PlayingCard returntheCard() {
		return cards.remove(0);
	}
	public PlayingCard getCard(int index) {
		return cards.get(index);
	}

}
