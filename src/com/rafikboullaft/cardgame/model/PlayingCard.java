package com.rafikboullaft.cardgame.model;

public class PlayingCard {
	private Rank rank;
	private suit suit;
	private boolean faceUp;
	
	public PlayingCard(Rank rank, suit suit) {
		super();
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
	public void flip() {
		faceUp = true;
		
	}
	

}
