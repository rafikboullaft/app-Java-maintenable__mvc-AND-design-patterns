package com.rafikboullaft.cardgame.model;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;

public class Deck {
	ArrayList<PlayingCard> cards;
	public Deck() {
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
	public void shuffle() {
		Random random = new Random();
		for (int i=0;i<cards.size();i++) {
			Collections.swap(cards,i,random.nextInt(cards.size()));
		}
	}
	public PlayingCard rempveTopCard() {
		return cards.remove(0);
	}
	public void returnCardToDeck(PlayingCard card) {
		cards.add(card);
	}
	
	

}
