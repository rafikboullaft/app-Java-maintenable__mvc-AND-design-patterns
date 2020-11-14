package com.rafikboullaft.cardgame.model;

public class WinnerPlayer implements IPlayer{
    IPlayer winner;
	public WinnerPlayer(IPlayer player) {
		winner = player;
	}
	public String getName() {
		return "*****" + winner.getName() + "*****";
		
	}
	@Override
	public void addCard(PlayingCard card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlayingCard getCard(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayingCard returnCard() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
