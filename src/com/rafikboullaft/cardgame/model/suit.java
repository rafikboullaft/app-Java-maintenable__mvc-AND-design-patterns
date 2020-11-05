package com.rafikboullaft.cardgame.model;

public enum suit {
	DIAMANDS (1),
	HEARTS(2),
	SPADES(3),
	CLUBS(4);
	
	int suit;
	private suit(int value) {
		suit = value;
	}
	public int value() {
		return suit;
	}

}
