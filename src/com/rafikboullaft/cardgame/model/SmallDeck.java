package com.rafikboullaft.cardgame.model;

import java.util.ArrayList;

public class SmallDeck extends Deck{
	public SmallDeck() {
		cards = new ArrayList<PlayingCard>();
		for (Rank rank:Rank.values()) {
			for (suit suit1:suit.values()) {
				if(rank.value()>=7) {
				System.out.println("card :("+rank+","+suit1+") created..");
				PlayingCard pc=new PlayingCard(rank,suit1);
				cards.add(pc);
			}
			}
		}
		shuffle();
	}

}
