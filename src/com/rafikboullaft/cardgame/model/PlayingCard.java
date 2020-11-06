package com.rafikboullaft.cardgame.model;

public class PlayingCard {
	 Rank rank;
	 suit suit;
	 boolean faceUp;
	
	public PlayingCard(Rank rank, suit suit) {
		this.rank = rank;
		this.suit = suit;
		this.faceUp = false;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	public Rank getRank() {
		return rank;
	}
	public suit getSuit() {
		return suit;
	}
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
		
	}
	

}
