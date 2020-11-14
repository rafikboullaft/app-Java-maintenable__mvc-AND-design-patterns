package com.rafikboullaft.cardgame.model;

import java.util.ArrayList;

public class NormalDeck extends Deck{
	public NormalDeck() {
		cards = new ArrayList<PlayingCard>();
		for (Rank rank:Rank.values()) {
			for (suit suit1:suit.values()) {
				PlayingCard pc=new PlayingCard(rank,suit1);
				cards.add(pc);
				System.out.println("card :("+rank+","+suit1+") created..");
			}
		}
		shuffle();
	}

}
