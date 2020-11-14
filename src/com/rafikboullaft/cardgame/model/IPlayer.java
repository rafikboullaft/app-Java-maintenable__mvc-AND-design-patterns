package com.rafikboullaft.cardgame.model;

public interface IPlayer {
	public void addCard(PlayingCard card) ;
	public PlayingCard getCard(int index);
	public PlayingCard returnCard() ;
	public String getName() ;
	

}
